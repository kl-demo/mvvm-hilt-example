package kldemo.mvvmhiltexample.presentation.langs.adapter

import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguage

interface ProgrammingLanguageListener {
    fun onProgrammingLanguageDetailsClicked(programmingLanguage: ProgrammingLanguage)
}