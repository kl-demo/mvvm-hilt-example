package kldemo.mvvmhiltexample.presentation.counter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kldemo.mvvmhiltexample.databinding.FragmentCounterBinding

@AndroidEntryPoint
class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!

    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counterViewModel.counterViewState.observe(viewLifecycleOwner) { counterViewState ->
            binding.numberOfClicks.text = counterViewState.numberOfClicks.toString()
            binding.progressBar.isVisible = counterViewState.isLoading
            binding.progressBar.isVisible = counterViewState.isLoading
            binding.numberOfClicks.isVisible = !counterViewState.isLoading
            binding.incrementBtn.isEnabled = !counterViewState.isLoading
        }
        binding.incrementBtn.setOnClickListener {
            counterViewModel.incrementBtnClicked()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}