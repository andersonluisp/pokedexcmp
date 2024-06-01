import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ui.viewmodel.MainViewModel

actual val viewModelModule = module {
    singleOf(::MainViewModel)
}