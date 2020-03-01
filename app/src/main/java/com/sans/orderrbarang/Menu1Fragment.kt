package com.sans.orderrbarang


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_menu1.*

/**
 * A simple [Fragment] subclass.
 */
class Menu1Fragment : Fragment() {
    private lateinit var binding: Menu1Fragment
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
        binding.btn_plus.setOnClickListener {
            jumlahString = binding.tv_nilai.text.toString()
            jumlah = jumlahString.toInt() + 1
            binding.tv_nilai.setText(jumlah.toString())

        }

        binding.bt_minus.setOnClickListener {
            if (tv_nilai.text.toString().toInt() > 0) {
                jumlah = binding.tv_nilai.text.toString().toInt() - 1
                binding.tv_nilai.setText(jumlah.toString())
            } else {
                Toast.makeText(this.context, "Tidak Bisa kurang dari 0", Toast.LENGTH_LONG).show()


            }
        }
        harga = 0
        binding.bt_beli.setOnClickListener {
            toopling = 0
            if (binding.cb_icecream.isChecked) {
                toopling += 2000
            }
        }
        if (binding.cb_ceres.isChecked) {
            toopling += 1000
        }

        harga = binding.tv_nilai.text.toString().toInt() * 5000 + toopling

        binding.tv_harga.setText(harga.toString())

        nama = binding.et_pemesan.text.toString()
        binding.et_pembeli.setText(nama)

        if (binding.rb_coklat.isChecked) {
            hasilkue = "Kue Coklat"
            binding.tv_kuee.setText(hasilkue)
        } else
            if (binding.rb_Strawberry.isChecked) {
                hasilkue = "Kue Strawberry "
                binding.tv_kuee.setText(hasilkue)
            }
        return binding.root

    }

}
