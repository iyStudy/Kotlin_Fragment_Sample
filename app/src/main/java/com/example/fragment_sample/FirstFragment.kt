package com.example.fragment_sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
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

    // ビューが作成された直後に呼ばれるメソッド
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 表示するプロフィールリスト
        val profileList = listOf<Profile>(
            Profile("田中",28,"親思いの格闘家",R.drawable.monk),
            Profile("ECC太郎",20,"筋トレ大好き魔術師",R.drawable.wizard),
            Profile("Comp二郎",18,"本当は魔法使いになりたい剣士",R.drawable.swordman)
        )

        val adapter = ProfileAdapter(profileList) { selectedProfile ->
            parentFragmentManager.setFragmentResult(
                REQUEST_PROFILE_DETAIL,
                bundleOf("SELECTED_PROFILE" to selectedProfile)
            )

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,SecondFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.rvProfilelist.adapter = adapter
        binding.rvProfilelist.layoutManager = GridLayoutManager(context,2)

    }
    companion object{
        val REQUEST_PROFILE_DETAIL = "REQUEST_PROFILE_DETAIL"
    }
}