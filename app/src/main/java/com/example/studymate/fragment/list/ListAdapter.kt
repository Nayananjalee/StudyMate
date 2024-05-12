package com.example.studymate.fragment.list
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.studymate.R
import com.example.studymate.model.Todo
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale



class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder> (){

    private var todoList = emptyList<Todo>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val todoTextView: TextView = itemView.findViewById(R.id.todo)
        val dateTextView: TextView = itemView.findViewById(R.id.date)
        val statusTextView: TextView = itemView.findViewById(R.id.status)
        val rowTextView: ConstraintLayout = itemView.findViewById(R.id.rowLayout)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun getItemCount(): Int {
       return todoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = todoList[position]

        holder.todoTextView.text = currentItem.text
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        holder.dateTextView.text = dateFormat.format(Date(currentItem.createDate))
        holder.statusTextView.text = if (currentItem.isDone) "Done" else "Not Done"

        holder.rowTextView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }
    fun setData(todo: List<Todo>){
        this.todoList = todo
        notifyDataSetChanged()
    }
}