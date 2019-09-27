package com.example.infinityapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class InsertMovieImage_tharik extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private Button mBtnChooseImage;
    private Button mBtnUpload;
    private TextView mTextViewShowUploads;
    private EditText mEditTextFilename;
    private ImageView mImageView;
    private ProgressBar mprogressBar;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    private StorageTask mUploadTask;

    private Uri mImageUri;
    private  String Key ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_movie_image_tharik);
        Key = getIntent().getStringExtra("insertedKey");

        mBtnChooseImage  = (Button) findViewById(R.id.button_choose_image_insertImage);
        mBtnUpload  = (Button) findViewById(R.id.button_upload_insertImage);
      mEditTextFilename = (EditText)findViewById(R.id.edit_text_file_name_insertImage);
      mTextViewShowUploads = (TextView)findViewById(R.id.text_view_show_uploads_insertImages);
      mImageView = (ImageView)findViewById(R.id.image_view_insertImage);
      mprogressBar = (ProgressBar)findViewById(R.id.progress_bar);

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Movies");

      mBtnChooseImage.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              openFileChooser();
              Toast.makeText(InsertMovieImage_tharik.this, Key, Toast.LENGTH_SHORT).show();
          }
      });
      mBtnUpload.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (mUploadTask != null && mUploadTask.isInProgress()) {
                  Toast.makeText(InsertMovieImage_tharik.this, "Upload in progress", Toast.LENGTH_SHORT).show();
              } else {
                  uploadFile();
              }
          }
      });
      mTextViewShowUploads.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

          }
      });




    }
    public  void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            mImageUri = data.getData();

            Picasso.with(this).load(mImageUri).into(mImageView);
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile() {
        if (mImageUri != null) {
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(mImageUri));

            mUploadTask = fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mprogressBar.setProgress(0);
                                }
                            }, 500);

                            Toast.makeText(InsertMovieImage_tharik.this, "Upload successful", Toast.LENGTH_LONG).show();
                            Upload upload = new Upload(mEditTextFilename.getText().toString().trim(),
                                    mStorageRef.getDownloadUrl().toString());
                            String uploadId = mDatabaseRef.push().getKey();
                            uploadId = Key;
                            mDatabaseRef.child(uploadId).child("mImageName").setValue(upload.getmImageName());
                            mDatabaseRef.child(uploadId).child("mImageUrl").setValue(upload.getmImageUrl());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(InsertMovieImage_tharik.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mprogressBar.setProgress((int) progress);
                        }
                    });
        } else {
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
        }
    }
}

