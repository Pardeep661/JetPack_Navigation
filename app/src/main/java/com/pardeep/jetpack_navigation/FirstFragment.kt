package com.pardeep.jetpack_navigation

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pardeep.jetpack_navigation.databinding.FragmentFirstBinding
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding : FragmentFirstBinding? = null
    private  val TAG = "FirstFragment"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return  binding?.root
       // return inflater.inflate(R.layout.fragment_first2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.confirmButton?.setOnClickListener {
            if (binding?.etEmail?.text?.isNullOrEmpty() == true) {
                binding?.etEmail?.error = "Please enter the username"
            } else {
                checkValidation()
                if (checkValidation()) {
                    randomCode()
                    findNavController().navigate(R.id.secondFragment)
                }
            }
        }
    }

    private fun randomCode() {
        val LENGTH = 4
        var rad_val =""
        for(i in 1..LENGTH){
            rad_val += Random.nextInt(0,9)
        }
        Log.d(TAG, rad_val)
    }

    private fun checkValidation(): Boolean {
        var username = binding?.etEmail?.text?.trim().toString()
        if (Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            Toast.makeText(requireContext(), "Email Verified !", Toast.LENGTH_SHORT).show()
            return true
        }else{
            Toast.makeText(requireContext(), "Enter valid email address!", Toast.LENGTH_SHORT).show()
            return false
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}