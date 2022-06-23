package com.example.coil2

import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.RoundedCornersTransformation

class MainActivity : AppCompatActivity() {

    private var shouldApplyTransformation = true
    private val image =
        "https://images.unsplash.com/photo-1655836605189-7b151b60af15?crop=faces%2Cedges&cs=tinysrgb&fit=crop&fm=jpg&ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU1OTY5ODM0&ixlib=rb-1.2.1&q=60&w=1200&auto=format&h=630&mark-w=64&mark-align=top%2Cleft&mark-pad=50&blend-mode=normal&blend-alpha=10&blend-w=1&mark=https%3A%2F%2Fimages.unsplash.com%2Fopengraph%2Flogo.png&blend=000000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCheckbox()
        loadImage()
    }

    /**
     * Regulates if [RoundedCornersTransformation] is applied
     * when loading the image into the ImageView.
     */
    private fun setupCheckbox() {
        with(findViewById<CheckBox>(R.id.checkbox)) {
            this.isChecked = shouldApplyTransformation

            setOnCheckedChangeListener { _, isChecked ->
                shouldApplyTransformation = isChecked
                loadImage()
            }
        }
    }

    /**
     * If the image is loaded with the transformation
     * and the target [ImageView] witdh = match_parent
     * and height = wrap_content the image will not
     * be displayed.
     */
    private fun loadImage() {
        findViewById<ImageView>(R.id.imageView)
            .load(image) {
                if (shouldApplyTransformation) {
                    transformations(RoundedCornersTransformation(100f))
                }
            }
    }
}

