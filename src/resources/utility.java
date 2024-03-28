package resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class utility {
    public static void clearDatabaseSystem() {
        Path tableFolder = Paths.get("./src/resources/Serialized_Tables");
        deleteAndRecreateFolder(tableFolder);
        Path pagesFolder = Paths.get("./src/resources/Serialized_Pages");
        deleteAndRecreateFolder(pagesFolder);
        Path indicesFolder = Paths.get("./src/resources/Serialized_Indices");
        deleteAndRecreateFolder(indicesFolder);
        recreateMetaDataFile();
    }

    public static void deleteAndRecreateFolder(Path folderPath) {
        try {
            if (Files.exists(folderPath)) {
                Files.walk(folderPath)
                        .sorted((a, b) -> -a.compareTo(b))
                        .forEach(p -> {
                            try {
                                Files.delete(p);
                            } catch (IOException ignored) {
                            }
                        });
            }
            Files.createDirectories(folderPath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void recreateMetaDataFile() {
        String filePath = "metadata.txt";
        File file = new File(filePath);

        if (file.exists()) {
            if (file.delete()) {
            } else {
                return; // Exit if failed to delete
            }
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        clearDatabaseSystem();
    }
}
