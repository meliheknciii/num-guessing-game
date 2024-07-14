package com.melihekinci.numguessinggame

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.media3.common.util.Log
import com.melihekinci.numguessinggame.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.textTutulan.text = " ? "
        var rastgeleSayi = Random.nextInt(1000,10000)
        var tahminetSayi : Int
        var denemeSayac = 0


        binding.btnCheck.setOnClickListener {
            binding.deneme.visibility = View.VISIBLE
            denemeSayac++
            tahminetSayi = binding.textTahminEt.text.toString().toInt()
            if (rastgeleSayi == tahminetSayi){
                binding.btnCheck.isEnabled = false
                binding.textSonuc.visibility = View.VISIBLE
                binding.textSonuc.text = "Tebrikler. ${denemeSayac} kez deneme yaparak buldunuz"
                binding.textTutulan.text = rastgeleSayi.toString()
            }
            else{
                binding.textSonuc.text = "Tekrar deneyin"
                binding.textSonuc.visibility = View.VISIBLE

            }
            var sayac = 0
            var checkRastgeleBinler : Int = rastgeleSayi / 1000
            var checkRastgeleYuzler : Int = (rastgeleSayi/100)%10
            var checkRastgeleOnlar : Int = (rastgeleSayi%100)/10
            var checkRastgeleBirler : Int = (rastgeleSayi%10)

            var checkTahminBinler : Int = tahminetSayi / 1000
            var checkTahminYuzler : Int = (tahminetSayi/100)%10
            var checkTahminOnlar : Int = (tahminetSayi%100)/10
            var checkTahminBirler : Int = tahminetSayi%10

            if (checkTahminBirler == checkRastgeleBirler){
                sayac++

            }
            if (checkTahminOnlar == checkRastgeleOnlar){
                sayac++

            }
            if (checkTahminYuzler == checkRastgeleYuzler){
                sayac++

            }
            if (checkTahminBinler == checkRastgeleBinler){
                sayac++

            }
            binding.deneme.text = "${sayac} tane doğru var "





        }
        binding.btnRestart.setOnClickListener {
            binding.textTahminEt.text.clear()
            binding.btnCheck.isEnabled = true
            var rastgeleSayi = Random.nextInt(1000,10000)
            binding.textSonuc.visibility = View.INVISIBLE
            binding.deneme.visibility = View.INVISIBLE
            binding.textTutulan.text = rastgeleSayi.toString()
            binding.textTutulan.text = " ? "
        }


    }
}