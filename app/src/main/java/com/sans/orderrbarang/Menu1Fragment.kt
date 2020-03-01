package com.sans.orderrbarang


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.sans.orderrbarang.databinding.FragmentMenu1Binding
import kotlinx.android.synthetic.main.fragment_menu1.*


/**
 * A simple [Fragment] subclass.
 */
class Menu1Fragment : Fragment() {
    private lateinit var binding: FragmentMenu1Binding
    private var jumlahString: String = ""
    private var jumlah: Int = 0
    private var harga: Int = 0
    private var hasilkue: String = ""
    private var toopling: Int = 0
    private var nama: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentMenu1Binding>(inflater,R.layout.fragment_menu1,container,false)
        binding.btnplus.setOnClickListener {
            jumlahString = binding.tvnilai.text.toString()
            jumlah = jumlahString.toInt() + 1
            binding.tvnilai.setText(jumlah.toString())

        }

        binding.btminus.setOnClickListener {
            if (tvnilai.text.toString().toInt() > 0) {
                jumlah = binding.tvnilai.text.toString().toInt() - 1
                binding.tvnilai.setText(jumlah.toString())
            } else {
                Toast.makeText(this.context, "Tidak Bisa kurang dari 0", Toast.LENGTH_LONG).show()


            }
        }
        harga = 0
        binding.btbeli.setOnClickListener {
            toopling = 0
            if (binding.cbicecream.isChecked) {
                toopling += 2000
            }
        }
        if (binding.cbceres.isChecked) {
            toopling += 1000
        }

        harga = binding.tvnilai.text.toString().toInt() * 5000 + toopling

        binding.tvharga.setText(harga.toString())

        nama = binding.etpemesan.text.toString()
        binding.etpembeli.setText(nama)

        if (binding.rbcoklat.isChecked) {
            hasilkue = "Kue Coklat"
            binding.tvkuee.setText(hasilkue)
        } else
            if (binding.rbStrawberry.isChecked) {
                hasilkue = "Kue Strawberry "
                binding.tvkuee.setText(hasilkue)
            }
        //return binding.root
            return binding.root
        }

}

