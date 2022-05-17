package com.example.otpmobile.view.onBoardpage

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.otpmobile.R
import com.example.otpmobile.databinding.FragmentSecondBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class SecondFragment : Fragment() {
    lateinit var auth: FirebaseAuth
    private val args: SecondFragmentArgs by navArgs()
    private lateinit var binding : FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backArrowOTPCode.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.gettingNumUser.text = args.phone

        binding.btnContinuesVerify.setOnClickListener{
//            val storedVerificationId = Intent(requireContext(),FirstFragment::class.java)
//            storedVerificationId.getStringExtra("storedVerificationId")

            verify()
        }
    }

    private fun verify(){
        val storedVerificationId = args.storedVerificationId
        val otp = binding.edtOTP.text.trim()
//        val otp= storedVerificationId.trim()
        if(otp.isNotEmpty()){
            val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
            storedVerificationId, binding.edtOTP.text.toString())
            signInWithPhoneAuthCredential(credential)
        }else{
            Toast.makeText(requireContext(),"Enter OTP",Toast.LENGTH_SHORT).show()
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(Activity()) { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.mallSelectPage)
                } else {
                    // Sign in failed, display a message and update the UI
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                        Toast.makeText(requireContext(),"Invalid OTP Check your OTP Code again",Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }
}

