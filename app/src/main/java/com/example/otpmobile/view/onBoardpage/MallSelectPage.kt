package com.example.otpmobile.view.onBoardpage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.otpmobile.MainTapActivity
import com.example.otpmobile.databinding.FragmentMallSelectPageBinding
import com.google.firebase.auth.FirebaseAuth


class MallSelectPage : Fragment() {

    private var _binding: FragmentMallSelectPageBinding? = null
    private val binding get() = _binding!!
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser == null){
            startActivity(Intent(context, BannerPage::class.java))
            requireActivity().finish()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMallSelectPageBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.arrowHome.setOnClickListener{
            requireActivity().onBackPressed()
        }
        binding.cardMall1.setOnClickListener{
            val i = Intent(context, MainTapActivity::class.java)
            requireActivity().startActivity(i)
        }
        binding.cardMall2.setOnClickListener{
            val i = Intent(context, MainTapActivity::class.java)
            requireActivity().startActivity(i)
        }
        binding.cardMall3.setOnClickListener{
            val i = Intent(context, MainTapActivity::class.java)
            requireActivity().startActivity(i)
        }

    }


}