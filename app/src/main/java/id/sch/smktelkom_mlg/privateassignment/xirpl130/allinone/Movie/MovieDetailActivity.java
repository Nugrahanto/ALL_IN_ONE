package id.sch.smktelkom_mlg.privateassignment.xirpl130.allinone.Movie;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import id.sch.smktelkom_mlg.privateassignment.xirpl130.allinone.R;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String URL_DATA = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?api-key=b300ba73118449c6be1b3fbb4107e604";
    public TextView textViewHeadet;
    public TextView textViewByet;
    public TextView textViewDateet;
    public TextView textViewDescet;
    public ImageView imageViewDetail;
    private Integer mPostkey = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPostkey = getIntent().getExtras().getInt("blog_id"); //menerima hasil kiriman dari fragment sebelumnya
        loadRecyclerViewData();

        //        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
////                Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
////                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
////                startActivity(intent);
//            }
//        });

        textViewHeadet = (TextView) findViewById(R.id.textViewHead);
        textViewByet = (TextView) findViewById(R.id.textViewBy);
        textViewDateet = (TextView) findViewById(R.id.textViewDate);
        textViewDescet = (TextView) findViewById(R.id.textViewDesc);
//        textViewReview = (TextView) findViewById(R.id.textViewReview);
        imageViewDetail = (ImageView) findViewById(R.id.imageViewDetail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("results");
                            JSONObject o = array.getJSONObject(mPostkey);

                            setTitle("");

                            textViewHeadet.setText(o.getString("display_title"));
                            textViewByet.setText(o.getString("byline"));
                            textViewDateet.setText(o.getString("publication_date"));
                            textViewDescet.setText(o.getString("summary_short"));
//                            url = o.getJSONObject("link").getString("url");

                            Glide
                                    .with(MovieDetailActivity.this)
                                    .load(o.getJSONObject("multimedia").getString("src"))
                                    .into(imageViewDetail);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
