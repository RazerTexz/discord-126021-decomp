package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class ChapterTocFrame$a implements Parcelable$Creator<ChapterTocFrame> {
    @Override // android.os.Parcelable$Creator
    public ChapterTocFrame createFromParcel(Parcel parcel) {
        return new ChapterTocFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public ChapterTocFrame[] newArray(int i) {
        return new ChapterTocFrame[i];
    }
}
