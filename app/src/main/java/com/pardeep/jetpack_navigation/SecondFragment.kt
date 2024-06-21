package com.pardeep.jetpack_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.pardeep.jetpack_navigation.databinding.FragmentSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding : FragmentSecondBinding? = null

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
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding?.root
       // return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // autoForward
        binding?.firstBtn?.doOnTextChanged { text, start, before, count ->
            var firstenteredText = binding?.firstBtn?.text?.toString()
            if (firstenteredText?.length==1){
                binding?.secondBtn?.requestFocus()
            }
        }
        binding?.secondBtn?.doOnTextChanged { text, start, before, count ->
            var secondenteredText = binding?.secondBtn?.text?.toString()
            if (secondenteredText?.length == 1) {
                binding?.thirdBtn?.requestFocus()
            }
        }

        binding?.thirdBtn?.doOnTextChanged { text, start, before, count ->
            var thirdenteredText = binding?.thirdBtn?.text?.toString()
            if (thirdenteredText?.length == 1) {
                binding?.fourBtn?.requestFocus()
            }
        }

            binding?.fourBtn?.doOnTextChanged { text, start, before, count ->
                var fourenteredText = binding?.fourBtn?.text?.toString()
                if (fourenteredText?.length == 1) {
                    binding?.fourBtn?.requestFocus()
                }
            }

        // autoBack
        binding?.fourBtn?.doOnTextChanged { text, start, before, count ->
            var firstenteredText = binding?.fourBtn?.text?.toString()
            if (firstenteredText?.length == 0) {
                binding?.thirdBtn?.requestFocus()
            }
        }
        binding?.thirdBtn?.doOnTextChanged { text, start, before, count ->
            var firstenteredText = binding?.thirdBtn?.text?.toString()
            if (firstenteredText?.length == 0) {
                binding?.secondBtn?.requestFocus()
            }
        }
        binding?.secondBtn?.doOnTextChanged { text, start, before, count ->
            var firstenteredText = binding?.secondBtn?.text?.toString()
            if (firstenteredText?.length == 0) {
                binding?.firstBtn?.requestFocus()
            }
        }
        binding?.firstBtn?.doOnTextChanged { text, start, before, count ->
            var firstenteredText = binding?.firstBtn?.text?.toString()
            if (firstenteredText?.length == 0) {
                binding?.firstBtn?.requestFocus()
            }
        }



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}