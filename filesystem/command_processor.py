import sys
from filesystem.directory import Directory
from filesystem.writer_helper import WriterHelper


class CommandProcessor:
    BACK_DIRECTORY = ".."
    RECURSIVE_OPTION = "-r"
    END_OF_LINE = "\n"

    def __init__(self):
        root = Directory("root")
        # All the directories created
        self.directories = root
        # Stack of accessed directories
        self.accessed_directories = [root]

    def process(self):
        for line in sys.stdin:
            splited_line = line.lower().split()
            method_name = self.get_parsed_parameter(splited_line, 0)
            method_param = self.get_parsed_parameter(splited_line, 1)
            method = self.map_input_with_method(method_name, method_param)
            if method(): break

    def map_input_with_method(self, method_name, method_param=None):
        switcher = {
            "quit": lambda: self.quit(),
            "pwd": lambda: self.pwd(),
            "ls": lambda: self.ls(method_param),
            "mkdir": lambda: self.mkdir(method_param),
            "cd": lambda: self.cd(method_param),
            "touch": lambda: self.touch(method_param),
        }
        return switcher.get(method_name, self.unrecognized_command)

    @staticmethod
    def quit():
        return True

    def pwd(self):
        full_path = ""
        for directory in self.accessed_directories:
            full_path += "/" + directory.name
        WriterHelper().write_stdout(full_path)

    def ls(self, recursive):
        if self.is_recursive(recursive):
            self.pwd()
            self.get_last_directory().recursive_ls()
        else:
            self.get_last_directory().ls()

    def mkdir(self, dir_name):
        if not self.check_dir_name_error(dir_name):
            self.get_last_directory().mkdir(dir_name)

    def cd(self, dir_name):
        if self.check_dir_name_error(dir_name): return
        if dir_name == self.BACK_DIRECTORY and len(self.accessed_directories) > 1:
            self.accessed_directories.pop()
            return
        self.get_last_directory().cd(dir_name, self.append_directory)

    def touch(self, file_name):
        if not self.check_dir_name_error(file_name):
            self.get_last_directory().touch(file_name)

    def append_directory(self, directory):
        self.accessed_directories.append(directory)

    def get_last_directory(self):
        # It will never be empty due to root directory cannot be deleted
        return self.accessed_directories[-1]

    def check_if_actual_directory_is_no_root(self):
        return len(self.accessed_directories) > 1

    def is_recursive(self, recursive):
        return recursive == self.RECURSIVE_OPTION

    @staticmethod
    def unrecognized_command():
        WriterHelper().write_stdout("Unrecognized command error")

    @staticmethod
    def get_parsed_parameter(parameters_list, index):
        return parameters_list[index] if len(parameters_list) > index else None

    @staticmethod
    def check_dir_name_error(dir_name):
        return not dir_name or len(dir_name) > 100


if __name__ == '__main__':
    CommandProcessor().process()
