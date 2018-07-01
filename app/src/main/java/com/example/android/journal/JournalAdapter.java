package com.example.android.journal;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.journal.database.JournalEntry;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by 0xhassan on 7/1/2018.
 */

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalViewHolder> {
    private static final String DATE_FORMAT = "dd/MM/yyy";

    final private ItemClickListener mItemClickListener;

    private List<JournalEntry> mJournalEntry;
    private Context mContext;

    private SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());

    public JournalAdapter(Context context, ItemClickListener listener) {

        mContext = context;
        mItemClickListener = listener;

    }

    @Override
    public JournalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.entry_layout, parent, false);

        return new JournalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JournalViewHolder holder, int position) {
        // Determine the values of the wanted data
        JournalEntry journalEntry = mJournalEntry.get(position);
        String description = journalEntry.getDescription();
        String title = journalEntry.getTitle();
        String date = dateFormat.format(journalEntry.getDate());

        //Set values
        holder.journalDescriptionView.setText(description);
        holder.dateView.setText(date);

        // Programmatically set the text and color for the priority TextView
        holder.titleView.setText(title);

        // Get the appropriate background color based on the priority
        int priorityColor = 3 ;//getPriorityColor(priority);
        //TODO set the title
    }



    @Override
    public int getItemCount() {
        if (mJournalEntry == null) {
            return 0;
        }
        return mJournalEntry.size();
    }

    public void setJournals(List<JournalEntry> taskEntries) {
        mJournalEntry = taskEntries;
        notifyDataSetChanged();
    }

    public interface ItemClickListener {
        void onItemClickListener(int itemId);
    }

    class JournalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView journalDescriptionView;
        TextView dateView;
        TextView titleView;

        public JournalViewHolder(View itemView) {
            super(itemView);

            titleView = itemView.findViewById(R.id.journalTitle);
            journalDescriptionView = itemView.findViewById(R.id.journalDescription);
            dateView = itemView.findViewById(R.id.journalDate);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int elementId = mJournalEntry.get(this.getAdapterPosition()).getId();
            mItemClickListener.onItemClickListener(elementId);
        }
    }

}
