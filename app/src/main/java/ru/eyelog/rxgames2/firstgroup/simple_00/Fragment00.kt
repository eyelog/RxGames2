package ru.eyelog.rxgames2.firstgroup.simple_00

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import ru.eyelog.rxgames2.R
import ru.eyelog.rxgames2.adapter.RVAdapter
import ru.eyelog.rxgames2.firstgroup.simple_00.di.DaggerComponent00
import javax.inject.Inject


class Fragment00: Fragment() {

    @Inject
    lateinit var viewModel: ViewModel00

    @Inject
    lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerComponent00
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
            adapter = this@Fragment00.adapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = null
        }

        viewModel.sampleLiveData.observe(viewLifecycleOwner, {
            adapter.setData(it)
            adapter.notifyDataSetChanged()
        })

        btFirst.text = resources.getString(R.string.subjects)
        btFirst.setOnClickListener {
            viewModel.cleanList()
            viewModel.startThread()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.add(Menu.NONE, MENU0, 0,  resources.getString(R.string.subjects_publish))
        menu.add(Menu.NONE, MENU1, 1,  resources.getString(R.string.subjects_replay))
        menu.add(Menu.NONE, MENU2, 2,  resources.getString(R.string.subjects_behavior))
        menu.add(Menu.NONE, MENU3, 3,  resources.getString(R.string.subjects_async))

        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            MENU0 -> {btFirst.text = resources.getString(R.string.subjects_publish)}
            MENU1 -> {btFirst.text = resources.getString(R.string.subjects_replay)}
            MENU2 -> {btFirst.text = resources.getString(R.string.subjects_behavior)}
            MENU3 -> {btFirst.text = resources.getString(R.string.subjects_async)}
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val MENU0 = 0
        private const val MENU1 = 1
        private const val MENU2 = 2
        private const val MENU3 = 3
    }
}
