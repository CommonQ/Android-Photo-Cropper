# AndroidPhotoCropper

he optimized approach to crop image from camera or gallery to appropriate scaled size images especially for large size images. This approach can help you avoid OOM exception




## Usage

### Step 1


Firstly you need instantiate  a  ``CropConfig`` and  use ``CropUtils`` to handle the activity results for cropping images.

### Step 2

Override these methods:

```java
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
```

### Step 3

Launch a request to crop photos.

#### Crop from camera

```java
Intent intent = CropUtils.buildCaptureIntent(CropUtils.buildUri());
startActivityForResult(intent, CropUtils.REQUEST_CAMERA);
```

#### Crop from gallery

```java
Intent intent_gallery = CropUtils.buildCropFromGalleryIntent(mCropParams);
startActivityForResult(intent_gallery, CropUtils.REQUEST_CROP);
```


## LICENSE


Copyright 2014 CommonQ
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

