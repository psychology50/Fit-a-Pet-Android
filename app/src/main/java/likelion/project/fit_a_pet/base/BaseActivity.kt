package likelion.project.fit_a_pet.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable
import likelion.project.fit_a_pet.utils.BackPressUtil

abstract class BaseActivity<B: ViewDataBinding> (
    @LayoutRes val layoutId: Int
) : AppCompatActivity() {
    lateinit var binding: B
    private val compositeDisposable = CompositeDisposable()
    private var backPressHandler: BackPressUtil? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        backPressHandler = BackPressUtil(this)
    }

    protected fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    override fun onBackPressed() {
        backPressHandler!!.onBackPressed()
    }
}