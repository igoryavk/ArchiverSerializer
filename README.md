# ArchiverSerializer

English language:

Description:
This application presents archiver-packer that can pack a list of files 
into one file - output.arch. The principal of operation of the application is 
based on the creation of an item collection and it's serialization later. Item 
presents a POJO that has a "name" property(String data type) and a "buffer" property
(an array of bytes storing all information from the source file). For dearchiving, you
need to pass the address of the packed file to the application, and the application 
will deserialize it into item collection and than create files identical to the source
files in the directory from which the application was called.

Install:
For compilation use shadow/shadowJar task in the Gradle.
Then, for archiving, pass the -a option and the list of files to the app.jar.
For dearchiving, pass the -d option and the packing file name(output.arch).

Deutsche Sprache:

Beschreibung:
Diese Anwendung ist ein Archiver-Packer, der eine Liste von Dateien in eine Datei 
packen kann - output.arch. Das Funktionsprinzip der Anwendung basiert auf der Erstellung
einer Sammlung von Elementen und ihrer anschliessend Serialisirung. Das Element ist 
ein POJO mit einer Name-Eigenschaft(String-Datatyp) und einer Buffer-Eigenschaft
(ein Byte-Array, in dem alle Informationen aus der Quelldatei gespeichert hat).
Zum Entpackung müssen Sie die Adresse der gepacken Datei an die Anwendung übergeben 
und die Anwendung deserialisiert sie in eine Sammlung von Elementen und erstellt dann
Dateien, die mit Quelldateien identisch sind.

Installierung:
Verwenden Sie zum Kompilieren den Befehl shadow/shadowJar in Gradle. Übergeben Sie dann 
zur Archivierung die Option -a und die Liste der Dateien an app.jar.

Русский язык:

Описание:
Это приложение представляет собой архиватор-упаковщик, который может упаковать список файлов
в файл - output.arch. Принцип работы приложения основан на создании коллекции элементов и ее 
последующей сериализации. Элемент представляет собой POJO у которого есть свойство name(строкового
типа) и свойство buffer(байтовый массив, хранящий всю информацию из исходного файла). Для 
деархивации, необходимо передать адрес упакованного файла приложению, и приложение десериализует 
его в коллекцию элементов и затем создаст файлы идентичные исходным файлам в каталоге из которого
вызывается приложение.

Установка:
Для компиляции используйте задачу shadow/shadowJar в Gradle.
Затем, для архивации, передайте опцию -a и список файлов в app.jar.
Для деархивации, передайте опцию -d и имя упакованного файла(output.arch). 
