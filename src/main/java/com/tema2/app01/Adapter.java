package com.tema2.app01;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends CursorAdapter {


    public Adapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameView, numberView, emailView, typeofContactView;

        nameView = view.findViewById(R.id.textName);
        emailView = view.findViewById(R.id.textEmail);
        numberView = view.findViewById(R.id.textNumber);
        typeofContactView = view.findViewById(R.id.textTypeofContact);
        /// geting position of views
        int name = cursor.getColumnIndex(Contract.ContactEntry.COLUMN_NAME);
        int email = cursor.getColumnIndex(Contract.ContactEntry.COLUMN_EMAIL);
        int type = cursor.getColumnIndex(Contract.ContactEntry.COLUMN_TYPEOFCONTACT);
        int number = cursor.getColumnIndex(Contract.ContactEntry.COLUMN_PHONENUMBER);

        String contactname = cursor.getString(name);
        String contactemail = cursor.getString(email);
        String contactnumber = cursor.getString(number);
        String typeof = cursor.getString(type);

        nameView.setText(contactname);
        numberView.setText(contactnumber);
        typeofContactView.setText(typeof);
        emailView.setText(contactemail);

    }
}
