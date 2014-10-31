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

import android.graphics.Bitmap;
import android.net.Uri;

public class CropConfig {

	public static final String CROP_TYPE = "image/*";
	public static final String OUTPUT_FORMAT = Bitmap.CompressFormat.JPEG
			.toString();

	public static final int DEFAULT_ASPECT = 1;
	public static final int DEFAULT_OUTPUT = 300;

	public Uri uri;

	public String type;
	public String outputFormat;
	public String crop;

	public boolean scale;
	public boolean returnData;
	public boolean noFaceDetection;
	public boolean scaleUpIfNeeded;

	public int aspectX;
	public int aspectY;

	public int outputX;
	public int outputY;

	public CropConfig() {
		uri = CropUtils.buildUri();
		type = CROP_TYPE;
		outputFormat = OUTPUT_FORMAT;
		crop = "true";
		scale = true;
		returnData = false;
		noFaceDetection = true;
		scaleUpIfNeeded = true;
		aspectX = DEFAULT_ASPECT;
		aspectY = DEFAULT_ASPECT;
		outputX = DEFAULT_OUTPUT;
		outputY = DEFAULT_OUTPUT;
	}
}
