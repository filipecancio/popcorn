package dev.cancio.popcorn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.popcorn.data.model.dataclass.Person
import dev.cancio.popcorn.databinding.CastItemBinding
import dev.cancio.popcorn.ui.vh.CastItemViewHolder

class CastItemAdapter(
    private val cast: List<Person>
): RecyclerView.Adapter<CastItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastItemViewHolder {
        val binding = CastItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CastItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CastItemViewHolder, position: Int) {
        val person = cast[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int = cast.size
}