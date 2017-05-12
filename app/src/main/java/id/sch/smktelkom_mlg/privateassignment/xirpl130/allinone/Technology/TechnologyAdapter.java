package id.sch.smktelkom_mlg.privateassignment.xirpl130.allinone.Technology;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl130.allinone.R;

/**
 * Created by Nugrahanto on 12/05/2017.
 */

public class TechnologyAdapter extends RecyclerView.Adapter<TechnologyAdapter.ViewHolder> {

    private List<TechnologyListItem> technologyListItems;
    private Context context; //mode default, hanya bisa diakses dengan dipanggil

    public TechnologyAdapter(List<TechnologyListItem> technologyListItems, Context context) {
        this.technologyListItems = technologyListItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.technology_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final TechnologyListItem technologyListItem = technologyListItems.get(position);

//        holder.imageViewOtof.setImageResource(R.drawable.ic_memory_black_24dp);
        holder.textViewHead.setText(technologyListItem.getHead());
        holder.textViewDesc.setText(technologyListItem.getDesc());

//        Glide
//                .with(context)
//                .load(technologyListItem.getImageUrl())
//                .into(holder.imageViewOtof);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Will be released soon", Toast.LENGTH_LONG).show();

//                Intent singleBlogIntent = new Intent(context, TechnologyDetailActivity.class);
//                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //addFLags membuka activity dari fragment
//                singleBlogIntent.putExtra("blog_id", position); //position untuk menentukan posisi di array
//                context.startActivity(singleBlogIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return technologyListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDesc;
        //        public ImageView imageViewOtof;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHeadTech);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDescTech);
//            imageViewOtof= (ImageView) itemView.findViewById(R.id.imageViewOtofTech);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.LinearLayoutTech);
        }
    }

}
