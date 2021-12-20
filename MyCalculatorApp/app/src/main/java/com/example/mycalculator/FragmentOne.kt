package com.example.mycalculator


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import calculator.CalculateAll
import com.example.mycalculator.databinding.FragmentOneBinding
import com.google.android.material.snackbar.Snackbar



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class FragmentOne : Fragment(R.layout.fragment_one) {
    private var _binding: FragmentOneBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "View was destroyed"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentOneBinding.inflate(inflater, container, false)
            .also { binding ->
                _binding = binding
            }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fun setExpression(string: String) {
            binding.expressionText.append(string)
        }

        /*
        получаем ответ, если в котлиновском калькуляторе выдает ошибку (в моем случае делал не через
        траи кетчи, а просто в результат выводился текст ошибки) то при помощи регулярки находим русские
        буквы, и если находит генерит Snackbar
         */
        fun getResult(expression: String) {
            binding.resultText.text = ""
            binding.expressionText.text = ""
            val result: String = CalculateAll(expression)
            if (result.contains("[а-яА-Я]".toRegex())) {
                Snackbar.make(view, result, Snackbar.LENGTH_SHORT).show()
                binding.resultText.append("Ошибка!")
            } else {
                binding.resultText.append(result)
            }
        }

        /*
        Если минус уже поставлен но он не поставит его вновь
         */
        fun plusOrMinus(expression: String) {
            val tmp: String = expression[expression.length - 1].toString()
            if (!tmp.equals("-")) {
                binding.expressionText.append("-")
            }
        }
        /*
        если пустая строка то берез с результата выражение
         */
        fun operand(operand: String) {
            if (!binding.resultText.text.toString()
                    .equals("Ошибка!") && binding.expressionText.text.toString().isEmpty()
            ) {
                binding.expressionText.append(binding.resultText.text.toString())
                binding.resultText.text = ""
            }
            setExpression(" $operand ")
        }
        binding.zero.setOnClickListener { setExpression("0") }
        binding.one.setOnClickListener { setExpression("1") }
        binding.two.setOnClickListener { setExpression("2") }
        binding.three.setOnClickListener { setExpression("3") }
        binding.four.setOnClickListener { setExpression("4") }
        binding.five.setOnClickListener { setExpression("5") }
        binding.six.setOnClickListener { setExpression("6") }
        binding.seven.setOnClickListener { setExpression("7") }
        binding.eight.setOnClickListener { setExpression("8") }
        binding.nine.setOnClickListener { setExpression("9") }
        binding.dot.setOnClickListener { setExpression(".") }

        binding.plus.setOnClickListener { operand("+") }
        binding.minus.setOnClickListener { operand("-") }
        binding.multiply.setOnClickListener { operand("*") }
        binding.divide.setOnClickListener { operand("/") }

        binding.openBracket.setOnClickListener { setExpression(" ( ") }
        binding.closeBracket.setOnClickListener { setExpression(" ) ") }
        binding.clean.setOnClickListener {
            binding.resultText.setText("")
            binding.expressionText.setText("")
        }
        binding.plusMinus.setOnClickListener { plusOrMinus(binding.expressionText.text.toString()) }
        binding.result.setOnClickListener { getResult(binding.expressionText.text.toString()) }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
