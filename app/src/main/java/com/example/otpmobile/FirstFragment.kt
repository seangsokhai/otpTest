package com.example.otpmobile

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.otpmobile.databinding.FragmentFirstBinding



class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.arrow.setOnClickListener{
            requireActivity().onBackPressed()
        }

        val edtPhone = binding.editPhoneNumber

         binding.btnContinues.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(edtPhone.text.toString())) {
                Toast.makeText(
                    context,
                    "Please enter a valid phone number.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val phone = "+855" + edtPhone.text.toString()
                findNavController().navigate(R.id.action_FirstFragment_to_secondFragment, bundleOf(
                    "phone" to phone
                ))
            }
        })


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}