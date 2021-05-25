package ru.eyelog.rxgames2.firstgroup.simple_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import ru.eyelog.rxgames2.R
import ru.eyelog.rxgames2.adapter.RVAdapter
import ru.eyelog.rxgames2.firstgroup.simple_02.di.DaggerComponent02
import ru.eyelog.rxgames2.firstgroup.simple_03.di.DaggerComponent03
import javax.inject.Inject

class Fragment03: Fragment() {

    @Inject
    lateinit var viewModel: ViewModel03

    @Inject
    lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerComponent03
            .builder()
            .withFragment(this)
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMainList.apply {
            adapter = this@Fragment03.adapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = null
        }

        viewModel.sampleLiveData.observe(viewLifecycleOwner, {
            adapter.setData(it)
            adapter.notifyDataSetChanged()
        })

        btFirst.text = resources.getString(R.string.simple_00)
        btFirst.setOnClickListener {
            viewModel.cleanList()
            viewModel.startThread()
        }
    }
}
