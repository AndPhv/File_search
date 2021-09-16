package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class File_Search
{
    public void print()
    {
        ArrayList<File> fileList = new ArrayList<>(); // Создаем список файлов, в который мы будем записывать наши найденные файлы
        searchFiles(new File("D:\\"), fileList); // Где будем искать наш файл
        for (File file: fileList) // Выводим список найденных файлов в консоль
        {
            System.out.println(file.getAbsolutePath());
        }
    }
    private static void searchFiles(File rootFile, List<File> fileList) // Функция с двумя параметрами (1: корневая папка для поиска, 2: это список, в который будут добавляться найденные файлы)
    {
        if (rootFile.isDirectory()) // Проверка корневой папки на то, являтся ли она папкой
        {
            System.out.println("searching at: " + rootFile.getAbsolutePath()); // Вывод в консоль папок, которые перебираются
            File[] directoryFiles = rootFile.listFiles(); // Получим все файлы, которые лежат внутри папки
            if (directoryFiles != null) // Если нам удалось получить эти файлы то...
            {
                for (File file: directoryFiles) // Для каждего файла проверим, что...
                {
                    if (file.isDirectory()) // Если этот файл явлется папкой
                    {
                        searchFiles(file, fileList); // Функция вызывает саму себя
                    } else
                    {
                        if (file.getName().toLowerCase().endsWith(".jpg")) // Если не является папкой, то ищем по тому условию, которое мы зададим
                        {
                            fileList.add(file); // Добавим в список наш файл
                        }
                    }
                }
            }
        }
    }
}
