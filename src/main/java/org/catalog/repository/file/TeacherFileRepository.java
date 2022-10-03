package org.catalog.repository.file;

import org.catalog.model.Teacher;
import org.catalog.repository.TeacherRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class TeacherFileRepository implements TeacherRepository {
    private final File repo = new File("src/main/resources/Teachers.csv");
    private int currentId = getMaxId();

    private int getMaxId() {
        int maxId = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(repo))) {
            String line;
            while ((line = br.readLine()) != null) {
                int id = Integer.parseInt(line.split(",")[0]);
                if (id > maxId) {
                    maxId = id;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        maxId++;
        return maxId;
    }

    @Override
    public void add(Teacher teacher) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(repo, true))) {
            teacher.setId(currentId);
            currentId++;
            bw.write(teacher.serialize());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader(repo)); BufferedWriter bw = new BufferedWriter(new FileWriter("T_tmp.csv", true))) {
            String line;
            while ((line = br.readLine()) != null) {
                int currentId = Integer.parseInt(line.split(",")[0]);
                if (id != currentId) {
                    bw.write(line + "\n");
                }
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path to = repo.toPath(); //convert from File to Path
        Path from = Paths.get("T_tmp.csv"); //convert from String to Path
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(from);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Teacher teacher) {
        try (BufferedReader br = new BufferedReader(new FileReader(repo)); BufferedWriter bw = new BufferedWriter(new FileWriter("T_tmp.csv", true))) {
            String line;
            while ((line = br.readLine()) != null) {
                int currentId = Integer.parseInt(line.split(",")[0]);
                if (teacher.getId() != currentId) {
                    bw.write(line + "\n");
                } else {
                    bw.write(teacher.serialize());
                }
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path to = repo.toPath(); //convert from File to Path
        Path from = Paths.get("T_tmp.csv"); //convert from String to Path
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(from);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Teacher> read() {
        List<Teacher> teachers= new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(repo))) {
            String line;
            while ((line = br.readLine()) != null) {
                teachers.add(Teacher.deserialize(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }

    @Override
    public Teacher readById(int id) {
        List<Teacher> teachers = read();
        for (Teacher t : teachers) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}