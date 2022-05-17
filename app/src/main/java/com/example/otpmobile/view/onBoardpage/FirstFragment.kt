package com.example.otpmobile.view.onBoardpage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.otpmobile.R
import com.example.otpmobile.databinding.FragmentFirstBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit


class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var storedVerificationId: String
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks : PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser != null){
            findNavController().navigate(R.id.mallSelectPage)
        }

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                startActivity(Intent(context, MallSelectPage::class.java))
                requireActivity().finish()

            }
            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show()
            }
            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                Log.d("TAG","onCodeSent:$verificationId")
                storedVerificationId = verificationId
                resendToken = token
                findNavController().navigate(R.id.action_FirstFragment_to_secondFragment, bundleOf(
                    "phone" to binding.editPhoneNumber.text.toString(), "storedVerificationId"  to storedVerificationId ))
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.arrow.setOnClickListener{ requireActivity().onBackPressed() }
        binding.btnContinues.setOnClickListener {
            login()
        }
    }

    private fun login() {
        var number= binding.editPhoneNumber.text.toString().trim()
        if(number.isNotEmpty()){
            number= "+855 $number"
            sendVerifications(number)
        }else{
            Toast.makeText(context,"Enter mobile number",Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendVerifications(number: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(requireActivity()) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

}

