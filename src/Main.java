import java.io.File;

public class Main {
    public static void main(String[] args) {
        String[] pictures = {"jpg", "png", "bmp", "gif", "webp", "cr2", "nef", "psd", "tiff"};
        String[] video = {"mp4", "avi", "mkv", "mov", "wmv", "flv", "webm"};
        String[] music = {"mp3", "wav", "flac", "ogg", "aac", "wma"};

        String directoryPath = "/home/mike/Downloads/Telegram";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            int pictureCount = 0;
            int videoCount = 0;
            int musicCount = 0;

            if (files != null) {
                for (File file : files) {
                    String[] extension = file.getName().split("\\.");
                    String endType = extension[1];

                    for (String pictureType : pictures) {
                        if (endType.equals(pictureType)) {
                            System.out.println("Знайдено файл: " + file.getName() + " - він pictures.");
                            pictureCount++;
                        }
                    }

                    for (String videoType : video) {
                        if (endType.equals(videoType)) {
                            System.out.println("Знайдено файл: " + file.getName() + " - він video.");
                            videoCount++;
                        }
                    }

                    for (String musicType : music) {
                        if (endType.equals(musicType)) {
                            System.out.println("Знайдено файл: " + file.getName() + " - він music.");
                            musicCount++;
                        }
                    }

                }
                System.out.println("Файлів pictures: " + pictureCount);
                System.out.println("Файлів video: " + videoCount);
                System.out.println("Файлів music: " + musicCount);
            } else {
                System.out.println("Директорія не існує");
            }
        }
    }
}