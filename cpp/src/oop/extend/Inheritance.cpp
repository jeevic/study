/*
 * @Author: jeevi 542561541@qq.com
 * @Date: 2024-08-09 20:31:33
 * @LastEditors: jeevi 542561541@qq.com
 * @LastEditTime: 2024-08-09 20:33:08
 * @FilePath: /cpp/src/oop/extend/Inheritance.cpp
 * @Description: c++ 继承类
 */

#include <iostream>
using namespace std;
// 基类 People
class People
{
public:
    void setname(char *name);
    void setage(int age);
    char *getname();
    int getage();

private:
    char *m_name;
    int m_age;
};
void People::setname(char *name) { m_name = name; }
void People::setage(int age) { m_age = age; }
char *People::getname() { return m_name; }
int People::getage() { return m_age; }
// 派生类 Student
class Student : public People
{
public:
    void setscore(float score);
    float getscore();

private:
    float m_score;
};
void Student::setscore(float score) { m_score = score; }
float Student::getscore() { return m_score; }

int main()
{
    Student stu;
    stu.setname("小明");
    stu.setage(16);
    stu.setscore(95.5f);
    cout << stu.getname() << "的年龄是 " << stu.getage() << "，成绩是 " << stu.getscore() << endl;
    return 0;
}