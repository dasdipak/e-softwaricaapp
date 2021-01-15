package com.example.e_softwarica.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.e_softwarica.R
import com.example.e_softwarica.model.Student

class AddstudentFragment : Fragment() {

    private lateinit var etfullname: EditText
    private lateinit var etage: EditText
    private lateinit var rdogender: RadioGroup
    private lateinit var etaddress: EditText
    private lateinit var rdoMale: RadioButton
    private lateinit var rdoFemale: RadioButton
    private lateinit var rdoOther: RadioButton
    private lateinit var btnsave: Button

    var gender: String = "";

    companion object {
        @JvmStatic
        public var listOfStudents = arrayListOf<Student>();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_addstudent, container, false)


        etfullname = view.findViewById(R.id.etfullname)
        etage = view.findViewById(R.id.etage)
        rdogender = view.findViewById(R.id.rdogender)
        etaddress = view.findViewById(R.id.etaddress)
        btnsave = view.findViewById(R.id.btnsave)
        rdoFemale = view.findViewById(R.id.rdofemale);
        rdoMale = view.findViewById(R.id.rdomale);
        rdoOther = view.findViewById(R.id.rdoothers);

        btnsave.setOnClickListener {

            val student = Student(
                etfullname.text.toString(),
                etage.text.toString().toInt(),
                gender,
                etaddress.text.toString()
            );

//           Student.setStudent(listStudent);
            listOfStudents = Student.getStudent();
            listOfStudents.add(student);


            Toast.makeText(context, "Student Added ${Student.getStudent()}", Toast.LENGTH_SHORT).show();

        }

        rdogender.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.rdomale -> {
                        gender = "Male";
                    }
                    R.id.rdofemale -> {
                        gender = "Female";
                    }
                    R.id.rdoothers -> {
                        gender = "Others";
                    }
                }
            }

        });
        return view
    }
}

