package com.example.fragment_sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fragment_sample.adapter.ProfileAdapter
import com.example.fragment_sample.databinding.FragmentFirstBinding
import com.example.fragment_sample.model.Profile

class FirstFragment : Fragment() {

    private lateinit var binding:FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    // ビューが作成された直後に呼ばれるメソッド。
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profileList = listOf<Profile>(
            Profile("田中",28,R.drawable.monk),
            Profile("ECC太郎",20,R.drawable.wizard),
            Profile("Comp二郎",18,R.drawable.swordman)
        )

        val adapter = ProfileAdapter(profileList){ selectPlofile ->

        }

        binding.rvProfilelist.adapter = adapter
        binding.rvProfilelist.layoutManager = GridLayoutManager(context,2)


    }
}