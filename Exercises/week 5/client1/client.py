import requests
import json

#Lấy thông tin tất cả sinh viên
getListStudents = requests.get('http://localhost:9999/api/student')
students = getListStudents.json()

print("Danh sách sinh viên: ")
for student in students['data']:
    print("+, Student " + student["mssv"])
    print(student["fullName"],"|" , student["birthDay"],"|" , student["university"],"|" , student["major"],"|" , student["email"],"|" , student["gender"])

#Lấy thông tin sinh viên theo mssv
getStudent = requests.get('http://localhost:9999/api/student?mssv=18021001')
student = getStudent.json()
student = student['data'][0]
print("Lấy sinh viên theo mssv")
print("+, Student " + student["mssv"])
print(student["fullName"],"|" , student["birthDay"],"|" , student["university"],"|" , student["major"],"|" , student["email"],"|" , student["gender"])