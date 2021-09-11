package ru.sber.io

import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream

/**
 * Реализовать методы архивации и разархивации файла.
 * Для реализиации использовать ZipInputStream и ZipOutputStream.
 */
class Archivator {



    /**
     * Метод, который архивирует файл logfile.log в архив logfile.zip.
     * Архив должен располагаться в том же каталоге, что и исходной файл.
     */
    fun zipLogfile() {
        val files: String = "io/logfile.log"
        ZipOutputStream(BufferedOutputStream(FileOutputStream("logfile.zip"))).use { out ->
                FileInputStream(files).use { fi ->
                    BufferedInputStream(fi).use { origin ->
                        val entry = ZipEntry(files)
                        out.putNextEntry(entry)
                        origin.copyTo(out, 2048)
                    }
                }
            }
    }

    /**
     * Метод, который извлекает файл из архива.
     * Извлечь из архива logfile.zip файл и сохарнить его в том же каталоге с именем unzippedLogfile.log
     */
    fun unzipLogfile() {
        var zipFile = ZipFile("io/logfile.zip")
        zipFile.use { zip ->
            zip.entries().asSequence().forEach { entry ->
                zip.getInputStream(entry).use { input ->
                    File("io/unzippedLogfile.log").outputStream().use { output ->
                        input.copyTo(output)
                    }
                }
            }
        }

    }
}