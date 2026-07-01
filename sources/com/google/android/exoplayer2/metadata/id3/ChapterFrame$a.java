package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class ChapterFrame$a implements Parcelable$Creator<ChapterFrame> {
    @Override // android.os.Parcelable$Creator
    public ChapterFrame createFromParcel(Parcel parcel) {
        return new ChapterFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public ChapterFrame[] newArray(int i) {
        return new ChapterFrame[i];
    }
}
