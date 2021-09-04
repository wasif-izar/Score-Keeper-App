package com.example.scorekeeper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.scorekeeper.databinding.FragmentGameBinding
import kotlin.math.round

class GameFragment : Fragment() {
    private lateinit var binding : FragmentGameBinding
    //count vars
    var team1TotalShots = 0
    var team1MadeShots = 0

    var team2TotalShots = 0
    var team2MadeShots = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_game, container, false)
        binding = FragmentGameBinding.inflate(inflater)

        val args = GameFragmentArgs.fromBundle(requireArguments())
        binding.gamefragTvTeam1Name.text = args.team1Name
        binding.gamefragTvTeam2Name.text = args.team2Name

        binding.gamefragBtTeam1Freethrow.setOnClickListener { team1Shoot(1) }
        binding.gamefragBtTeam12pt.setOnClickListener { team1Shoot(2) }
        binding.gamefragBtTeam13pt.setOnClickListener { team1Shoot(3) }
        binding.gamefragBtTeam1Miss.setOnClickListener { team1Shoot(0) }

        binding.gamefragBtTeam2Freethrow.setOnClickListener { team2Shoot(1) }
        binding.gamefragBtTeam22pt.setOnClickListener { team2Shoot(2) }
        binding.gamefragBtTeam23pt.setOnClickListener { team2Shoot(3) }
        binding.gamefragBtTeam2Miss.setOnClickListener { team2Shoot(0) }

        binding.gamefragBtEnd.setOnClickListener { nextFrag() }

        return binding.root
    }
    private fun team1Shoot(pointValue : Int){
        if (pointValue != 0){
            team1MadeShots++

            val newScore = binding.gamefragTvTeam1Score.text.toString().toInt() + pointValue
            binding.gamefragTvTeam1Score.text = newScore.toString()

            when{
                binding.gamefragRvQ1.isChecked ->{
                    val quarterScore = binding.gamefragTvTeam1Q1.text.toString().toInt() + pointValue
                    binding.gamefragTvTeam1Q1.text = quarterScore.toString()
                }
                binding.gamefragRvQ2.isChecked ->{
                    val quarterScore = binding.gamefragTvTeam1Q2.text.toString().toInt() + pointValue
                    binding.gamefragTvTeam1Q2.text = quarterScore.toString()
                }
                binding.gamefragRvQ3.isChecked ->{
                    val quarterScore = binding.gamefragTvTeam1Q3.text.toString().toInt() + pointValue
                    binding.gamefragTvTeam1Q3.text = quarterScore.toString()
                }
                else ->{
                    val quarterScore = binding.gamefragTvTeam1Q4.text.toString().toInt() + pointValue
                    binding.gamefragTvTeam1Q4.text = quarterScore.toString()
                }
            }
        }
        //increment shots
        team1TotalShots++
        val shootingPercent = round(team1MadeShots.toFloat()/team1TotalShots*10000)/100
        val t1 = "$shootingPercent %"
        binding.gamefragTvTeam1Percent.text = t1
    }
    private fun team2Shoot(pointValue : Int){
        if (pointValue != 0){
            team2MadeShots++

            val newScore = binding.gamefragTvTeam2Score.text.toString().toInt() + pointValue
            binding.gamefragTvTeam2Score.text = newScore.toString()

            when{
                binding.gamefragRvQ1.isChecked ->{
                    val quarterScore = binding.gamefragTvTeam2Q1.text.toString().toInt() + pointValue
                    binding.gamefragTvTeam2Q1.text = quarterScore.toString()
                }
                binding.gamefragRvQ2.isChecked ->{
                    val quarterScore = binding.gamefragTvTeam2Q2.text.toString().toInt() + pointValue
                    binding.gamefragTvTeam2Q2.text = quarterScore.toString()
                }
                binding.gamefragRvQ3.isChecked ->{
                    val quarterScore = binding.gamefragTvTeam2Q3.text.toString().toInt() + pointValue
                    binding.gamefragTvTeam2Q3.text = quarterScore.toString()
                }
                else ->{
                    val quarterScore = binding.gamefragTvTeam2Q4.text.toString().toInt() + pointValue
                    binding.gamefragTvTeam2Q4.text = quarterScore.toString()
                }
            }
        }
        //increment shots
        team2TotalShots++
        val shootingPercent = round(team2MadeShots.toFloat()/team2TotalShots*10000)/100
        val t2 = "$shootingPercent %"
        binding.gamefragTvTeam2Percent.text = t2

    }
    private fun nextFrag(){
        val team1 = binding.gamefragTvTeam1Name.text.toString()
        val score1 = binding.gamefragTvTeam1Score.text.toString()
        val team2 = binding.gamefragTvTeam2Name.text.toString()
        val score2 = binding.gamefragTvTeam2Score.text.toString()

        findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment2(team1,score1,team2,score2))
    }
}