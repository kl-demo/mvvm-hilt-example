package kldemo.mvvmhiltexample.presentation.langs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kldemo.mvvmhiltexample.R
import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguage
import kldemo.mvvmhiltexample.databinding.ProgrammingLanguageItemBinding

class ProgrammingLanguagesAdapter(private val listener: ProgrammingLanguageListener) :
    RecyclerView.Adapter<ProgrammingLanguagesAdapter.ViewHolder>() {

    private val programmingLanguages: MutableList<ProgrammingLanguage> = mutableListOf()

    class ViewHolder(val binding: ProgrammingLanguageItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ProgrammingLanguageItemBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val programmingLanguage = programmingLanguages[position]

        with(holder.binding)
        {
            name.text = programmingLanguage.name
            designed.text = holder.itemView.context.getString(R.string.designed_by, programmingLanguage.designed)
            details.setOnClickListener {
                listener.onProgrammingLanguageDetailsClicked(programmingLanguage)
            }
        }

    }

    override fun getItemCount(): Int = programmingLanguages.size

    fun addAll(programmingLanguages: List<ProgrammingLanguage>) {
        this.programmingLanguages.addAll(programmingLanguages)
    }
}