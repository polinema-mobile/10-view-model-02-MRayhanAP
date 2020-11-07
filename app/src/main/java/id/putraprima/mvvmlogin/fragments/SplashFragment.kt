package id.putraprima.mvvmlogin.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import id.putraprima.mvvmlogin.R
import id.putraprima.mvvmlogin.databinding.FragmentSplashBinding
import id.putraprima.mvvmlogin.model.Splash
import id.putraprima.mvvmlogin.viewmodel.SplashViewModel
import id.putraprima.mvvmlogin.viewmodel.SplashViewModelsFactory

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private lateinit var viewModel: SplashViewModel
    private lateinit var splash: Splash
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        splash = Splash(imageSplash = R.drawable.aku, textSplash = "WA HA HA HA ")
        viewModel = ViewModelProvider(this, SplashViewModelsFactory(splash = splash)).get(SplashViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }, 3000)
        return binding.root
    }
}