package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class CommentFrame$a implements Parcelable$Creator<CommentFrame> {
    @Override // android.os.Parcelable$Creator
    public CommentFrame createFromParcel(Parcel parcel) {
        return new CommentFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public CommentFrame[] newArray(int i) {
        return new CommentFrame[i];
    }
}
