package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class UrlLinkFrame$a implements Parcelable$Creator<UrlLinkFrame> {
    @Override // android.os.Parcelable$Creator
    public UrlLinkFrame createFromParcel(Parcel parcel) {
        return new UrlLinkFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public UrlLinkFrame[] newArray(int i) {
        return new UrlLinkFrame[i];
    }
}
