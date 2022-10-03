package org.catalog.repository.file;

import org.catalog.model.Student;
import org.catalog.model.Subject;
import org.catalog.repository.SubjectRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class SubjectFileRepository implements SubjectRepository {

    private final File repo = new File("src/main/resources/Subjects.csv");
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
    public void add(Subject subject) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(repo, true))) {
            subject.setId(currentId);
            currentId++;
            bw.write(subject.serialize());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader(repo)); BufferedWriter bw = new BufferedWriter(new FileWriter("Sub_tmp.csv", true))) {
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
        Path from = Paths.get("Sub_tmp.csv"); //convert from String to Path
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(from);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Subject subject) {
        try (BufferedReader br = new BufferedReader(new FileReader(repo)); BufferedWriter bw = new BufferedWriter(new FileWriter("Sub_tmp.csv", true))) {
            String line;
            while ((line = br.readLine()) != null) {
                int currentId = Integer.parseInt(line.split(",")[0]);
                if (subject.getId() != currentId) {
                    bw.write(line + "\n");
                } else {
                    bw.write(subject.serialize());
                }
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path to = repo.toPath(); //convert from File to Path
        Path from = Paths.get("Sub_tmp.csv"); //convert from String to Path
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(from);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Subject> read() {
        List<Subject> subjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(repo))) {
            String line;
            while ((line = br.readLine()) != null) {
                subjects.add(Subject.deserialize(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return subjects;
    }

    @Override
    public Subject readById(int id) {
        List<Subject> subjects = read();
        for (Subject sub : subjects) {
            if (sub.getId() == id) {
                return sub;
            }
        }
        return null;
    }
}
