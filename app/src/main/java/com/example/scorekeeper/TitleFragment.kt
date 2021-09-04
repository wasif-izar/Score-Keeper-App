package com.example.scorekeeper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.scorekeeper.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private lateinit var binding : FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_title, container, false)
        binding = FragmentTitleBinding.inflate(inflater)

        //set click listeners
        binding.titlefragBtStart.setOnClickListener { nextFrag() }
        return binding.root
    }
    private fun nextFrag(){
        val team1 = binding.titlefragEtTeam1Name.text.toString()
        val team2 = binding.titlefragEtTeam2Name.text.toString()
        findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment(team1,team2))
    }
}