package ru.monnae.supinout.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private final String SERVER_DIRECTORY;
    private final String SUPINOUT_STORE_FOLDER;
    private final String PLAYERS_FOLDER;

    public FileManager() {
        SERVER_DIRECTORY = new File(".").getAbsolutePath();
        SUPINOUT_STORE_FOLDER = "supinout_store";
        PLAYERS_FOLDER = "users";

        File plaersDirectoryPath = new File(getPlayersDirectoryPath());
        if (!plaersDirectoryPath.exists()) plaersDirectoryPath.mkdirs();
    }

    public String getPlayersDirectoryPath() {
        return SERVER_DIRECTORY
                + File.separator
                + SUPINOUT_STORE_FOLDER
                + File.separator
                + PLAYERS_FOLDER;
    }

    public List<String> getFilesNames(String filesDirectoryPath) {
        ArrayList<String> filesNames = new ArrayList<String>();
        File[] files = new File(filesDirectoryPath).listFiles();
        for (File file : files) {
            filesNames.add(file.getName());
        }
        return filesNames;
    }

    public Object readFile(String fileDirectoryPath, String fileName) {
        String filePath = fileDirectoryPath
                + File.separator
                + fileName;
        byte[] fileData = null;
        try {
            fileData = Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(fileData);
        Object o = null;
        try (ObjectInput in = new ObjectInputStream(bis)) {
            o = in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

    public void writeFile(String fileDirectoryPath, String fileName, Object object) {
        String filePath = fileDirectoryPath
                + File.separator
                + fileName;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] data = bos.toByteArray();

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
