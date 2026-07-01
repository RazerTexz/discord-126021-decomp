package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class VorbisComment$a implements Parcelable$Creator<VorbisComment> {
    @Override // android.os.Parcelable$Creator
    public VorbisComment createFromParcel(Parcel parcel) {
        return new VorbisComment(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public VorbisComment[] newArray(int i) {
        return new VorbisComment[i];
    }
}
