package di

import androidx.lifecycle.viewmodel.compose.viewModel
import data.Ktor
import data.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule = module {
    factory { Repository(Ktor) }
}

