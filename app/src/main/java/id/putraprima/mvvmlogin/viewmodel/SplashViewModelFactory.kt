package id.putraprima.mvvmlogin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.putraprima.mvvmlogin.model.Splash

class SplashViewModelsFactory(private var splash: Splash) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel(splash = splash) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}