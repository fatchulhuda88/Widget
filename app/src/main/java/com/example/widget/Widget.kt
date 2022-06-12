package com.example.widget

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

//membuat variable binding
    private lateinit var binding: ActivityWidgetBinding
class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialsi binding
        binding = ActivityWidgetBinding.inflate(layoutInflater)
        //memanggil layout dengan menggunakkan binding.root
        setContentView(binding.root)

        //Button Toast
        binding.btnToast.setOnClickListener {
            Toast.makeText( this,"Ini adalah Toast",Toast.LENGTH_SHORT).show()
        }
        //Button Snacbar
        binding.btnSnackbar.setOnClickListener{
            Snackbar.make(it,"Ini adalah snacbar",Snackbar.LENGTH_SHORT).show()
        }
        //Button alert
        binding.btnAlrt .setOnClickListener{
            AlertDialog.Builder(this).apply {
                setTitle("Mesage")
                setMessage("Ini adalah Alrt")

                setPositiveButton("OK"){dialog,_ ->
                   Toast.makeText(applicationContext,"Anda klik OK",Toast.LENGTH_SHORT).show()
                   dialog.dismiss()

                }
                setNegativeButton("Back"){dialog,_ ->
                    Toast.makeText(applicationContext,"Anda klik Back",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()

                }
            }.show()
        }
        //Button Custom Dialog
            binding.btnCustomDialaog.setOnClickListener {
                Dialog(this).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(false)
                    setContentView(R.layout.custom_dialog)

                    val btnCancel =this.findViewById<Button>(R.id.btnCancel)
                    val btnContinue=this.findViewById<Button>(R.id.btnContinue)

                    btnCancel.setOnClickListener {
                        Toast.makeText(applicationContext,"Anda Klik Cancel",Toast.LENGTH_SHORT).show()
                        this.dismiss()
                    }
                    btnContinue.setOnClickListener {
                        Toast.makeText(applicationContext,"Anda Klik Continue",Toast.LENGTH_SHORT).show()
                        this.dismiss()
                    }
                 }.show()
            }

    }
}