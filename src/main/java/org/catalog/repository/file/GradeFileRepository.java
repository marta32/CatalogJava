package org.catalog.repository.file;

import org.catalog.model.Grade;
import org.catalog.model.Student;
import org.catalog.repository.GradeRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class GradeFileRepository implements GradeRepository {

    private final File repo = new File("src/main/resources/Grades.csv");
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
    public void add(Grade grade) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(repo, true))) {
            grade.setId(currentId);
            currentId++;
            bw.write(grade.serialize());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader(repo)); BufferedWriter bw = new BufferedWriter(new FileWriter("G_tmp.csv", true))) {
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
        Path from = Paths.get("G_tmp.csv"); //convert from String to Path
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(from);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Grade grade) {
        try (BufferedReader br = new BufferedReader(new FileReader(repo)); BufferedWriter bw = new BufferedWriter(new FileWriter("G_tmp.csv", true))) {
            String line;
            while ((line = br.readLine()) != null) {
                int currentId = Integer.parseInt(line.split(",")[0]);
                if (grade.getId() != currentId) {
                    bw.write(line + "\n");
                } else {
                    bw.write(grade.serialize());
                }
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path to = repo.toPath(); //convert from File to Path
        Path from = Paths.get("G_tmp.csv"); //convert from String to Path
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(from);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Grade> read() {
        List<Grade> grades = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(repo))) {
            String line;
            while ((line = br.readLine()) != null) {
                grades.add(Grade.deserialize(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return grades;
    }

    @Override
    public Grade readById(int id) {
        List<Grade> grades = read();
        for (Grade g : grades) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }
}
