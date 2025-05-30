package kldemo.mvvmhiltexample.presentation.lang_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kldemo.mvvmhiltexample.databinding.FragmentProgrammingLanguageDetailsBinding

private const val ARG_NAME = "name"

@AndroidEntryPoint
class ProgrammingLanguageDetailsFragment : Fragment() {

    private var _binding: FragmentProgrammingLanguageDetailsBinding? = null
    private val binding get() = _binding!!

    private val programmingLanguageDetailsViewModel: ProgrammingLanguageDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getString(ARG_NAME)?.let { name ->
                programmingLanguageDetailsViewModel.setLangName(name)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgrammingLanguageDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationOnClickListener {
            programmingLanguageDetailsViewModel.backClicked()
        }
        programmingLanguageDetailsViewModel.programmingLanguageDetailsViewState.observe(
            viewLifecycleOwner
        ) { programmingLanguageDetailsViewState ->
            with(binding)
            {
                toolbarTitle.text = programmingLanguageDetailsViewState.langName
                progressBar.isVisible = programmingLanguageDetailsViewState.isLoading
                description.isVisible = !programmingLanguageDetailsViewState.isLoading
                description.text =
                    programmingLanguageDetailsViewState.programmingLanguageDetails.description
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {

        fun newInstance(name: String) =
            ProgrammingLanguageDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                }
            }
    }
}