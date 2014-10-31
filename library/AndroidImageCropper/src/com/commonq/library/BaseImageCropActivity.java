/*
 * Copyright 2014 CommonQ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.commonq.library;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class BaseImageCropActivity extends Activity implements CropInterface {

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		CropUtils.handleResult(this, requestCode, resultCode, data);
	}

	@Override
	public void onImageCropped(Uri uri) {
	}

	@Override
	public void onImageCanceled() {
	}

	@Override
	public void onImageFailed(String message) {
	}

	@Override
	public CropConfig getCropConfig() {
		return null;
	}

	@Override
	public Activity getContext() {
		return this;
	}

	@Override
	protected void onDestroy() {

		super.onDestroy();
	}
}
