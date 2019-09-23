package com.example.infinityapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

class CustomListAdapterUpdateRows extends BaseAdapter {


    Context c;
    ArrayList<UserModel> users;

    public CustomListAdapterUpdateRows(Context c, ArrayList<UserModel> users) {
        this.c = c;
        this.users = users;
    }

    @Override
    public int getCount() {

        return users.size();
    }

    @Override
    public Object getItem(int i) {

        return users.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(c).inflate(R.layout.listviewupdate_row,viewGroup,false);
        }

        final EditText meditText1 = (EditText) view.findViewById(R.id.editText1);
        final EditText meditText2 = (EditText) view.findViewById(R.id.editText2);
        final EditText meditText3 = (EditText) view.findViewById(R.id.editText3);
        Button updateBtn = (Button) view.findViewById(R.id.updateBtn);

        final UserModel user= (UserModel) this.getItem(i);
        meditText1.setText(user.getUsername());
        meditText2.setText(user.getUserphone());
        meditText3.setText(user.getUseremail());

        updateBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final Context context=v.getContext();

                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(true);
                builder.setTitle("Are you sure ?");
                builder.setMessage("Please confirm that you really need to edit");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String col1value = meditText1.getText().toString();
                        String col2value = meditText2.getText().toString();
                        String col3value = meditText3.getText().toString();
                        UsersDatabaseAdapter.updateEntry(user.getID(),col1value,col2value,col3value);


                    }
                });
                builder.create();
                builder.show();

            }
        });

        return view;
    }
}
