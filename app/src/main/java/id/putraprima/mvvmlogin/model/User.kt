package id.putraprima.mvvmlogin.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import id.putraprima.mvvmlogin.BR

class User : BaseObservable(){
    @Bindable
    var email: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }
    get() = field

    @Bindable
    var password: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.password)
        }
    get() =  field
}