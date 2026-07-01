package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class MotionPhotoMetadata$a implements Parcelable$Creator<MotionPhotoMetadata> {
    @Override // android.os.Parcelable$Creator
    public MotionPhotoMetadata createFromParcel(Parcel parcel) {
        return new MotionPhotoMetadata(parcel, null);
    }

    @Override // android.os.Parcelable$Creator
    public MotionPhotoMetadata[] newArray(int i) {
        return new MotionPhotoMetadata[i];
    }
}
