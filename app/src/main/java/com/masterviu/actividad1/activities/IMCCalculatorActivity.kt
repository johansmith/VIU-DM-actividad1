package com.masterviu.actividad1.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.masterviu.actividad1.R
import java.text.DecimalFormat

class IMCCalculatorActivity : AppCompatActivity() {

    // Variables para validar que género esta seleccionado
    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false

    // Variables para logicas de la altura
    private var currentHeight:Int = 120

    // Variables para logicas del peso
    private var currentWeight:Int = 60

    // Variables para logicas de la edad
    private var currentAge:Int = 30

    // Variables para UI de altura
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider

    // Variables para UI del genero
    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView

    // Variables para UI de peso
    private lateinit var btnSubstractWeight:FloatingActionButton
    private lateinit var btnPlusWeight:FloatingActionButton
    private lateinit var tvWeight:TextView

    // Variables para UI de edad
    private lateinit var btnSubstractAge:FloatingActionButton
    private lateinit var btnPlusAge:FloatingActionButton
    private lateinit var tvAge:TextView

    // Variables para UI calcular
    private lateinit var btnCalculator:Button

    // Creamos un atributo que puede ser accedido desde cualquier clase
    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imccalculator)
        // Componentes que vamos a manipular
        initComponents()
        // Funciones que estan escuchando
        initListeners()
        // Cargar UI inicial
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.TextViewHeight)
        rsHeight = findViewById(R.id.RSHeight)
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubstractAge = findViewById(R.id.btnSubstractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculator = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            // mapeamos el decimal para que no muestre altuas como: 180.2
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = currentHeight.toString() + "cm"
        }

        btnSubstractWeight.setOnClickListener{
            currentWeight --
            setWeight()
        }

        btnPlusWeight.setOnClickListener{
            currentWeight ++
            setWeight()
        }

        btnSubstractAge.setOnClickListener{
            currentAge --
            setAge()
        }

        btnPlusAge.setOnClickListener{
            currentAge ++
            setAge()
        }

        btnCalculator.setOnClickListener {
            navigateToResult(calculateIMC())
        }

    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent:Boolean) : Int {

        val colorReference = if(isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun calculateIMC(): Double {
        // Aquí definimos el format en que queremos formatear el numero ej: 0.00
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        // Obtenemos el número y lo formateamos para que sea vea con el formato deseado
        val result = df.format(imc).toDouble()
        //Log.i("Resultados","El IMC es $result")
        return result
    }

    @SuppressLint("SuspiciousIndentation")
    private fun navigateToResult(result: Double) {
    val intentResultActivity = Intent(this, ResultIMCActivity::class.java)
        intentResultActivity.putExtra(IMC_KEY, result)
        startActivity(intentResultActivity)
    }
}