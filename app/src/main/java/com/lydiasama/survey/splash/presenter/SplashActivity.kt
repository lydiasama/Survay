package com.lydiasama.survey.splash.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lydiasama.survey.R
import com.lydiasama.survey.core.ui.EventObserver
import com.lydiasama.survey.core.util.dialog.DialogUtil
import com.lydiasama.survey.main.MainActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class SplashActivity : AppCompatActivity() {
    private val viewModel by lifecycleScope.viewModel<SplashViewModel>(this)
    private val dialogUtil by inject<DialogUtil>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
        viewModel.login()
    }

    private fun observeViewModel() {
        viewModel.navigateToMainActivityEvent.observe(this,
                EventObserver {
                    startActivity(MainActivity.getStartIntent(this))
                    finish()
                })

        viewModel.closeAppEvent.observe(this,
                EventObserver {
                    dialogUtil.showDialog(
                            context = this,
                            positiveText = getString(R.string.dialog_btn_ok),
                            onPositive = {
                                finish()
                            }
                    )
                })
    }
}
