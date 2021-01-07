
class HashMap:
    @staticmethod
    def solution(queryType, query):
        hm = {}
        count = 0
        for i in range(len(queryType)):
            type = queryType[i]
            value = query[i]
            count += HashMap.execute_query(type, value, hm, count)
        return count

    @staticmethod
    def execute_query(type, value, hm, count):
        switcher = {
            "insert": lambda: HashMap.execute_insert(value, hm),
            "addToValue": lambda: HashMap.add_to_value(value, hm),
            "addToKey": lambda: HashMap.add_to_key(value, hm),
            "get": lambda: HashMap.get(value, hm)
        }
        method = switcher.get(type)
        return method()

    @staticmethod
    def execute_insert(value, hm):
        hm[value[0]] = value[1]
        return 0

    @staticmethod
    def add_to_value(value, hm):
        for key, actual_value in hm.items():
            hm[key] = actual_value + value[0]
        return 0

    @staticmethod
    def add_to_key(value, hm):
        back_up = dict(hm)
        hm.clear()
        for key in list(back_up.keys()):
            hm[key + value[0]] = back_up[key]
        return 0

    @staticmethod
    def get(value, hm):
        return hm.get(value[0], 0)