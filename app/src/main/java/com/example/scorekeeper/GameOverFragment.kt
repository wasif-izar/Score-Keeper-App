package com.example.scorekeeper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.scorekeeper.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {
    private lateinit var binding : FragmentGameOverBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_game_over, container, false)
        binding = FragmentGameOverBinding.inflate(inflater)

        //get data
        val args = GameOverFragmentArgs.fromBundle(requireArguments())
        binding.gameoverfragTvTeam1Score.text = "${args.team1Name} Scored ${args.team1Score} Points"
        binding.gameoverfragTvTeam2Score.text = "${args.team2Name} Scored ${args.team2Score} Points"

        when {
            args.team1Score.toInt() > args.team2Score.toInt() -> {
                binding.gameoverfragTvWinner.text = "${args.team1Name} Wins!!"
                binding.gameoverfragTvWinner.setTextColor(ContextCompat.getColor(requireContext().applicationContext, R.color.team1))
            }
            args.team1Score.toInt() < args.team2Score.toInt() -> {
                binding.gameoverfragTvWinner.text = "${args.team2Name} Wins!!"
                binding.gameoverfragTvWinner.setTextColor(ContextCompat.getColor(requireContext().applicationContext, R.color.team2))
            }
            else -> {
                binding.gameoverfragTvWinner.text = "Match Draw"
            }
        }
        binding.gameoverfragBtNewGame.setOnClickListener {
            findNavController().navigate(GameOverFragmentDirections.actionGameOverFragmentToTitleFragment())
        }


        return binding.root
    }
}