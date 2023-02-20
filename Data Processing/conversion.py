import csv

def convert_txt_to_data(txt_file_path):
    with open(txt_file_path, 'r') as txt_file:
        lines = txt_file.read().split('\n')
        data = [lines[i:i+13] for i in range(0, len(lines), 13)]
        data = [list(map(str.strip, row)) for row in data]
        return data

def write_data_to_csv(data, csv_file_path):
    with open(csv_file_path, 'w', newline='') as csv_file:
        writer = csv.writer(csv_file)
        writer.writerows(data)

txt_file_path = "./output.txt"
csv_file_path = "./output.csv"

data = convert_txt_to_data(txt_file_path)
write_data_to_csv(data, csv_file_path)
