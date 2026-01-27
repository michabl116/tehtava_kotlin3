package org.example

open class Human(var name: String, var age: Int) {

    fun getOlder() {
        age = age + 1
    }
}

class CourseRecord(
    var name: String,
    var yearCompleted: Int,
    var credits: Int,
    var grade: Double
)

class Student(name: String, age: Int) : Human(name, age) {

    var courses = ArrayList<CourseRecord>()

    fun addCourse(course: CourseRecord) {
        courses.add(course)
    }

    fun weightedAverage(): Double {
        var i = 0
        var totalCredits = 0
        var weightedSum = 0.0

        while (i < courses.size) {
            var c = courses[i]
            weightedSum = weightedSum + (c.grade * c.credits)
            totalCredits = totalCredits + c.credits
            i = i + 1
        }

        var avg = 0.0
        if (totalCredits == 0) {
            avg = 0.0
        } else {
            avg = weightedSum / totalCredits
        }

        return avg
    }

    fun weightedAverage(year: Int): Double {
        var i = 0
        var totalCredits = 0
        var weightedSum = 0.0

        while (i < courses.size) {
            var c = courses[i]
            if (c.yearCompleted == year) {
                weightedSum = weightedSum + (c.grade * c.credits)
                totalCredits = totalCredits + c.credits
            }
            i = i + 1
        }

        var avg = 0.0
        if (totalCredits == 0) {
            avg = 0.0
        } else {
            avg = weightedSum / totalCredits
        }

        return avg
    }

    fun minMaxGrades(): Pair<Double, Double> {
        if (courses.size == 0) {
            return Pair(0.0, 0.0)
        }

        var i = 0
        var min = courses[0].grade
        var max = courses[0].grade

        while (i < courses.size) {
            var g = courses[i].grade

            if (g < min) {
                min = g
            }

            if (g > max) {
                max = g
            }

            i = i + 1
        }

        return Pair(min, max)
    }
}

class Major(var name: String) {

    var students = ArrayList<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun stats(): Triple<Double, Double, Double> {
        if (students.size == 0) {
            return Triple(0.0, 0.0, 0.0)
        }

        var i = 0
        var firstAvg = students[0].weightedAverage()
        var min = firstAvg
        var max = firstAvg
        var sum = 0.0

        while (i < students.size) {
            var avg = students[i].weightedAverage()

            if (avg < min) {
                min = avg
            }

            if (avg > max) {
                max = avg
            }

            sum = sum + avg
            i = i + 1
        }

        var averageOfAverages = sum / students.size

        return Triple(min, max, averageOfAverages)
    }

    fun stats(courseName: String): Triple<Double, Double, Double> {
        if (students.size == 0) {
            return Triple(0.0, 0.0, 0.0)
        }

        var i = 0
        var first = true
        var min = 0.0
        var max = 0.0
        var sum = 0.0
        var count = 0

        while (i < students.size) {
            var s = students[i]

            var j = 0
            var found = false
            var grade = 0.0

            while (j < s.courses.size) {
                var c = s.courses[j]
                if (c.name == courseName) {
                    grade = c.grade
                    found = true
                }
                j = j + 1
            }

            if (found == true) {
                if (first == true) {
                    min = grade
                    max = grade
                    first = false
                } else {
                    if (grade < min) {
                        min = grade
                    }
                    if (grade > max) {
                        max = grade
                    }
                }

                sum = sum + grade
                count = count + 1
            }

            i = i + 1
        }

        var avg = 0.0
        if (count == 0) {
            avg = 0.0
        } else {
            avg = sum / count
        }

        return Triple(min, max, avg)
    }
}
