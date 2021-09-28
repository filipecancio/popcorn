package dev.cancio.popcorn.ui.vh

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.cancio.popcorn.data.model.dataclass.Person
import dev.cancio.popcorn.databinding.CastItemBinding

class CastItemViewHolder(
    private val castItemBinding: CastItemBinding
) : RecyclerView.ViewHolder(castItemBinding.root)  {

    private lateinit var person: Person

    fun bind(person: Person) {
        this.person = person
        castItemBinding.apply {
            Glide.with(this.root).load(person.avatar).into(imageViewPoster)
        }
    }
}