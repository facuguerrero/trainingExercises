from filesystem.file import File
from filesystem.writer_helper import WriterHelper


class Directory:
    def __init__(self, name):
        self.name = name
        self.sub_directories = {}
        self.files = {}

    def ls(self):
        for directory in self.sub_directories.values():
            WriterHelper().write_stdout(directory)
        for file in self.files.values():
            WriterHelper().write_stdout(file)

    def recursive_ls(self):
        self.ls()
        for directory in self.sub_directories.values():
            directory.recursive_ls()

    def mkdir(self, dir_name):
        if not self.check_if_directory_exists(dir_name):
            self.sub_directories[dir_name] = Directory(dir_name)
        else:
            WriterHelper().write_stdout("Directory already exists.")

    def cd(self, dir_name, callback):
        if self.check_if_directory_exists(dir_name):
            callback(self.sub_directories.get(dir_name))
        else:
            WriterHelper().write_stdout("Non existent directory.")

    def touch(self, file_name):
        if not self.check_if_file_exists(file_name):
            self.files[file_name] = File(file_name)
        else:
            WriterHelper().write_stdout("File already exists.")

    def check_if_directory_exists(self, dir_name):
        return dir_name in self.sub_directories

    def check_if_file_exists(self, file_name):
        return file_name in self.files

    def __str__(self):
        return self.name
