package com.commonq.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.commonq.library.BaseImageCropActivity;
import com.commonq.library.CropConfig;
import com.commonq.library.CropUtils;

public class MainActivity extends BaseImageCropActivity implements
		View.OnClickListener {

	public static final String TAG = "MainActivity";

	ImageView mImageView;

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v(TAG, "--onDestroy--");
	}

	CropConfig mCropParams = new CropConfig();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.v(TAG, "--onCreate--");

		mImageView = (ImageView) findViewById(R.id.image);

		findViewById(R.id.bt_capture).setOnClickListener(this);
		findViewById(R.id.bt_gallery).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_capture:
			Log.v(TAG, "--CropHelper.imageUri--" + CropUtils.buildUri());
			Intent intent = CropUtils.buildCaptureIntent(CropUtils.buildUri());
			startActivityForResult(intent, CropUtils.REQUEST_CAMERA);
			break;
		case R.id.bt_gallery:
			Intent intent_gallery = CropUtils
					.buildCropFromGalleryIntent(mCropParams);

			Log.v(TAG, "intent:" + intent_gallery.getAction());
			startActivityForResult(intent_gallery, CropUtils.REQUEST_CROP);
			break;
		}
	}

	@Override
	public CropConfig getCropConfig() {
		return mCropParams;
	}

	@Override
	public void onImageCropped(Uri uri) {
		Log.d(TAG, "Crop Uri in path: " + uri.getPath());
		Toast.makeText(this, "Photo cropped!", Toast.LENGTH_LONG).show();
		mImageView.setImageBitmap(CropUtils.decodeUriAsBitmap(this, uri));
	}

	@Override
	public void onImageCanceled() {
		Toast.makeText(this, "Crop canceled!", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onImageFailed(String message) {
		Toast.makeText(this, "Crop failed:" + message, Toast.LENGTH_LONG)
				.show();
	}
}
