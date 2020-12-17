package com.Sokah.library;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Book> booksArray = new ArrayList();
    private Context mContext;

    public BookRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setBooksArray(ArrayList<Book> booksArray) {
        this.booksArray = booksArray;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bookName.setText(booksArray.get(position).getName());
        holder.author.setText(booksArray.get(position).getAuthor());
        holder.shortDescription.setText(booksArray.get(position).getShortDescription());

        Glide.with(mContext)
                .asBitmap().
                load(booksArray.get(position).getImageUrl())
                .into(holder.imageBook);

        holder.parent.setOnClickListener(
                (v)->{


                    Intent intent = new Intent(mContext,BookActivity.class);
                    mContext.startActivity(intent);

                }
        );

        if(booksArray.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedLayout.setVisibility(View.VISIBLE);
            holder.arrowDown.setVisibility(View.INVISIBLE);

        }else{
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedLayout.setVisibility(View.GONE);
            holder.arrowDown.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return booksArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView parent;
        private ImageView imageBook;
        private TextView bookName;
        private TextView author;
        private TextView shortDescription;
        private ImageView arrowUp,arrowDown;
        private ConstraintLayout expandedLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imageBook = itemView.findViewById(R.id.imageBook);
            bookName = itemView.findViewById(R.id.bookName);
            author = itemView.findViewById(R.id.author);
            shortDescription = itemView.findViewById(R.id.shortDescription);
            arrowDown = itemView.findViewById(R.id.btnExpand);
            arrowUp= itemView.findViewById(R.id.btnCollapse);
            expandedLayout=itemView.findViewById(R.id.expandedConstraintLayout);

            arrowDown.setOnClickListener(
                    (v)->{

                        Book book = booksArray.get(getAdapterPosition());
                        book.setExpanded(!book.isExpanded());
                        notifyItemChanged(getAdapterPosition());
                    }
            );

            arrowUp.setOnClickListener(
                    (v)->{
                        Book book = booksArray.get(getAdapterPosition());
                        book.setExpanded(!book.isExpanded());
                        notifyItemChanged(getAdapterPosition());
                    }
            );
        }
    }
}
