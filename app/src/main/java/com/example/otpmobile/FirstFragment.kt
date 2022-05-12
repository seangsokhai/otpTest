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
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import java.util.concurrent.TimeUnit


class FirstFragment : Fragment() {
    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
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

        val edtPhone = binding.editPhoneNumber

         binding.btnContinues.setOnClickListener(View.OnClickListener {
            // below line is for checking weather the user
            // has entered his mobile number or not.
            if (TextUtils.isEmpty(edtPhone.text.toString())) {
                // when mobile number text field is empty
                // displaying a toast message.
                Toast.makeText(
                    context,
                    "Please enter a valid phone number.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // if the text field is not empty we are calling our
                // send OTP method for getting OTP from Firebase.
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