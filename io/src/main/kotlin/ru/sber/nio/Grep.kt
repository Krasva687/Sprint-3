package ru.sber.nio

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.readLines
import kotlin.io.path.readText
import kotlin.io.path.useLines

/**
 * Реализовать простой аналог утилиты grep с использованием калссов из пакета java.nio.
 */
class Grep {
    /**
     * Метод должен выполнить поиск подстроки subString во всех файлах каталога logs.
     * Каталог logs размещен в данном проекте (io/logs) и внутри содержит другие каталоги.
     * Результатом работы метода должен быть файл в каталоге io(на том же уровне, что и каталог logs), с названием result.txt.
     * Формат содержимого файла result.txt следующий:
     * имя файла, в котором найдена подстрока : номер строки в файле : содержимое найденной строки
     * Результирующий файл должен содержать данные о найденной подстроке во всех файлах.
     * Пример для подстроки "22/Jan/2001:14:27:46":
     * 22-01-2001-1.log : 3 : 192.168.1.1 - - [22/Jan/2001:14:27:46 +0000] "POST /files HTTP/1.1" 200 - "-"
     */
    fun find(subString: String) {
        //Определяем директорию поиска
        val file = File("io/logs")
        val path2 = file.toPath()
        //создаем пер для хранения совпадений и добавочной информации
        var result = ""
        //создаем переменную с путями к файлам и заносим их
        var fi: ArrayList<Path> = ArrayList()
        Files.find(path2, 4, { p, _ -> p.toString().endsWith(".log") }).forEach { fi.add(it) }
        //начинаем цикл для прохождения по файлам
        for (i in fi) {
            var cnt = 0
            var lineNum = 1
            //считываем файл по строчкам
            var filetext = i.readLines()
            //проверяем условия для каждой строчки есди выполняется, пишем название файла и порядковый номер строки и строку
            for( j in filetext.indices){
                if(filetext[j].contains(subString) && result.length > 0 ){
                    result = result + "\n" + i.fileName.toString() + " : " + lineNum.toString() + " : " + filetext[j]
                }else if (filetext[j].contains(subString) && result.length == 0){
                    result = i.fileName.toString() + " : " + lineNum.toString() + " : " + filetext[j]
                }
                lineNum++
            }
        }
        //создаем файл в диерктории io и записываем в него информацию
        var storePath = File("io/result.txt")
        storePath.createNewFile()
        storePath.writeText(result)
        print(result)
    }
}

fun main(){
    Grep().find("22/Jan/2001:14:27:46")
}