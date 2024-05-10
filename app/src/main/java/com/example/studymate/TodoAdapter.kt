import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studymate.R

class TodoAdapter<Todolist>(private val todoList: List<Todolist>) : RecyclerView.Adapter<TodoAdapter<Any?>.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val todoTitle: TextView = itemView.findViewById(R.id.todo_title)
        val todoDate: TextView = itemView.findViewById(R.id.todo_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentItem = todoList[position]
        holder.todoTitle.text = currentItem.todo
        holder.todoDate.text = currentItem.date
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun updateData(newList: List<Todolist>) {
        this.todoList.clear()
        this.todoList.addAll(newList)
        notifyDataSetChanged()
    }
}