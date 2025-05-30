package kldemo.mvvmhiltexample.presentation.langs

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguage
import kldemo.mvvmhiltexample.databinding.FragmentProgrammingLanguagesBinding
import kldemo.mvvmhiltexample.presentation.langs.adapter.ProgrammingLanguageListener
import kldemo.mvvmhiltexample.presentation.langs.adapter.ProgrammingLanguagesAdapter


@AndroidEntryPoint
class ProgrammingLanguagesFragment : Fragment() {

    private var _binding: FragmentProgrammingLanguagesBinding? = null
    private val binding get() = _binding!!

    private val programmingLanguagesViewModel: ProgrammingLanguagesViewModel by viewModels()
    private lateinit var programmingLanguagesAdapter: ProgrammingLanguagesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgrammingLanguagesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding)
        {
            programmingLanguagesAdapter =
                ProgrammingLanguagesAdapter(object : ProgrammingLanguageListener {
                    override fun onProgrammingLanguageDetailsClicked(programmingLanguage: ProgrammingLanguage) {
                        programmingLanguagesViewModel.detailsClicked(programmingLanguage.name)
                    }
                })
            programmingLanguages.adapter = programmingLanguagesAdapter
            programmingLanguages.layoutManager = LinearLayoutManager(context)
        }
        programmingLanguagesViewModel.programmingLanguagesViewState.observe(viewLifecycleOwner) { programmingLanguagesViewState ->
            with(binding)
            {
                progressBar.isVisible = programmingLanguagesViewState.isLoading
                programmingLanguages.isVisible = !programmingLanguagesViewState.isLoading
                if (!programmingLanguagesViewState.isLoading &&
                    programmingLanguagesAdapter.itemCount == 0
                ) {
                    programmingLanguagesAdapter.addAll(programmingLanguagesViewState.programmingLanguages)
                    programmingLanguagesAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = ProgrammingLanguagesFragment()
    }
}