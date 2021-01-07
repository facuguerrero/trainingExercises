import sys


class WriterHelper:
    @classmethod
    def write_stdout(cls, message):
        sys.stdout.write(str(message) + "\n")
