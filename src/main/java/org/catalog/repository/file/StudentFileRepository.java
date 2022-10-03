package org.catalog.repository.file;

import org.catalog.model.Student;
import org.catalog.repository.StudentRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class StudentFileRepository implements StudentRepository {

    private final File repo = new File("src/main/resources/Students.csv");
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
    public void add(Student student) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(repo, true))) {
            student.setId(currentId);
            currentId++;
            bw.write(student.serialize());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
//        List<Student> students = read();
//        int i = 0;
//        while (i < students.size()) {
//            if (students.get(i).getId() == id) {
//                students.remove(students.get(i));
//                break;
//            }
//            i++;
//        }
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(repo))) {
//            for (Student s : students) {
//                bw.write(s.serialize());
//            }
//            bw.flush();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try (BufferedReader br = new BufferedReader(new FileReader(repo)); BufferedWriter bw = new BufferedWriter(new FileWriter("S_tmp.csv", true))) {
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
        Path from = Paths.get("S_tmp.csv"); //convert from String to Path
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(from);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Student student) {
        try (BufferedReader br = new BufferedReader(new FileReader(repo)); BufferedWriter bw = new BufferedWriter(new FileWriter("S_tmp.csv", true))) {
            String line;
            while ((line = br.readLine()) != null) {
                int currentId = Integer.parseInt(line.split(",")[0]);
                if (student.getId() != currentId) {
                    bw.write(line+"\n");
                } else {
                    bw.write(student.serialize());
                }
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path to = repo.toPath(); //convert from File to Path
        Path from = Paths.get("S_tmp.csv"); //convert from String to Path
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(from);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> read() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(repo))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.deserialize(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Student readById(int id) {
        List<Student> students = read();
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}