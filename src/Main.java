import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
//import java.util.Scanner;

public class Main {
    static String[] Pictures = {"jpg","png","bmp","gif","webp","cr2","nef","psd", "tiff"};
    static String[] Videos = {"mp4","avi","mov","m4v","mkv","mpg","mpeg","wmv","3gp"};
    static String[] Audios = {"mp3","ogg","acc","aac","wav","opus","wma","flac","mpa"};
    static String[] Docs = {"doc","docx","pdf","rtf","cdr","xls","xlsx","pptx","ppt"};
    static String[] Archives = {"rar","zip","7z","tar","arj"};
    static String[] Trashs = {"tmp","thumb0","thumb1","thumb2","thumb3","thumb4","thumb5","thumb6","thumb7","thumb8","thumb9","thumb10"};
    static String[] Folders = {"Pictures", "Videos", "Audios", "Docs", "Archives", "Trashs"};
    private static File directory;
//    private static final File directory = new File("/home/mike/Downloads/Telegram");
//    /home/mike/Downloads/Telegram
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        directory = new File(myFrame.getUserInput());

        newFolders(directory, Folders);
        File[] files = directory.listFiles();
        mySearch(files);
        deleteFoders(directory, Folders);
    }

    public static void mySearch(File[] files) {
        if (files != null && files.length > 0) {
            int count = 0;
            for (File file : files) {
                if (file.isFile()) {
                    String end = endTypes(file);

                    for (String type : Pictures) {
                        if (end.equals(type.toLowerCase())) {
                            System.out.println(count++ +" "+ file.getName());
                            moveFile(file, new File(directory.getParent() + File.separator + "Pictures" + File.separator + file.getName()));
                        }
                    }
//                    for (String type : Videos) {
//                        if (end.equals(type.toLowerCase())) {
//                            System.out.println(count++ +" "+ file.getName());
//                            moveFile(file, new File(directory.getParent() + File.separator + "Videos" + File.separator + file.getName()));
//                        }
//                    }
//                    for (String type : Audios) {
//                        if (end.equals(type.toLowerCase())) {
//                            System.out.println(count++ +" "+ file.getName());
//                            moveFile(file, new File(directory.getParent() + File.separator + "Audios"+ File.separator + file.getName()));
//                        }
//                    }
//                    for (String type : Docs) {
//                        if (end.equals(type.toLowerCase())) {
//                            System.out.println(count++ +" "+ file.getName());
//                            moveFile(file, new File(directory.getParent() + File.separator + "Docs" + File.separator + file.getName()));
//                        }
//                    }
//                    for (String type : Archives) {
//                        if (end.equals(type.toLowerCase())) {
//                            System.out.println(count++ +" "+ file.getName());
//                            moveFile(file, new File(directory.getParent() + File.separator +"Archives" + File.separator + file.getName()));
//                        }
//                    }
//                    for (String type : Trashs) {
//                        if (end.equals(type.toLowerCase())) {
//                            System.out.println(count++ +" "+ file.getName());
//                            moveFile(file, new File(directory.getParent() + File.separator + "Trashs" + File.separator + file.getName()));
//                        }
//                    }
                }
                else if (file.isDirectory()) {
                    File podDirect = new File(file.getPath());
                    File[] podDirectFiles = podDirect.listFiles();
                    mySearch(podDirectFiles);
                }

            }
        }
    }

    public static void newFolders(File directory, String[] folderNames) {
        for (String f : folderNames) {
            File folder = new File(directory.getParent() + File.separator + f);
            if (!folder.exists()) {
                folder.mkdir();
                System.out.println("Створено новий каталог: " + folder.getAbsolutePath());
            } else {
                System.out.println("Каталог вже існує: " + folder.getAbsolutePath());
            }
        }
    }

    public static void deleteFoders(File directory, String[] folderNames) {
        for( String f : folderNames) {
            File folder = new File(directory.getParent() + File.separator + f);
            if (folder.exists()) {
                System.out.println("Каталог видалено: " + folder.getName());
                folder.delete();
            }
            else {
                System.out.println("Каталог: " + folder.getName() +  " не можна видалити, він не порожний.");
            }
        }
    }

    public static void moveFile(File file, File directory) {
        try {
            Files.move(file.toPath(), directory.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String endTypes(File file) {
        String[] extension = file.getName().split("\\.");
        return extension[1].toLowerCase();
    }

}
