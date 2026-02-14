package com.v2ray.ang.ui

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView
import com.google.android.material.color.MaterialColors
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.EdgeTreatment
import com.google.android.material.shape.RelativeCornerSize
import com.google.android.material.shape.RoundedCornerTreatment
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.shape.ShapePath
import com.v2ray.ang.R

class MainNewActivity : BaseActivity() {

    private lateinit var connectButton : ImageButton
    private lateinit var statusText: TextView
    private var isConnected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewNoToolbar(R.layout.activity_new_main)



        initViews()

    }
    private fun initViews(){
        connectButton = findViewById(R.id.btnToggleVpnState)
        statusText = findViewById(R.id.txt_view_view)
        setUpClickListener()
    }
    private fun setUpClickListener(){
        connectButton.setOnClickListener {
            toggleVpnState()
//            toggleConnection()
        }

    }

    // برای حالت گل (Flower) با ۸ پر (۲ پر در هر ضلع)

    private fun toggleVpnState() {
        connectButton.isSelected = !connectButton.isSelected
//        animateClick()

    }

    private fun startPulseAnimation() {
        // Ø§Ù†ÛŒÙ…ÛŒØ´Ù† Ù†Ø¨Ø¶ Ù…Ù„Ø§ÛŒÙ… Ø¨Ø±Ø§ÛŒ Ø­Ø§Ù„Øª Ù…ØªØµÙ„
        connectButton.animate()
            .scaleX(1.05f)
            .scaleY(1.05f)
            .setDuration(1000)
            .withEndAction {
                if (isConnected) {
                    connectButton.animate().scaleX(1f).scaleY(1f).setDuration(1000).withEndAction {
                        startPulseAnimation()
                    }.start()
                }
            }.start()
    }
    private fun animateClick() {
        connectButton.animate()
            .scaleX(0.9f)
            .scaleY(0.9f)
            .setDuration(150)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .withEndAction {
                connectButton.animate().scaleX(1f).scaleY(1f).start()
            }.start()
    }


}