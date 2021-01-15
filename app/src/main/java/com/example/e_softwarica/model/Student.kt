package com.example.e_softwarica.model

import java.io.Serializable

data class Student(
    val name: String? = null,
    val age: Int? = null,
    val gender: String? = null,
    val address: String? = null
) : Serializable {


    companion object {
        @JvmStatic
        private var lstStudent = arrayListOf<Student>();

        @JvmStatic
        public fun getStudent(): ArrayList<Student> {
            return lstStudent;
        }

        @JvmStatic
        public fun setStudent(lstStudent: ArrayList<Student>) {
            this.lstStudent = lstStudent;
        }
    }
}
