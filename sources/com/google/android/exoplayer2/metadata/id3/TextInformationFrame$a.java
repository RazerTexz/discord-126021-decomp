package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class TextInformationFrame$a implements Parcelable$Creator<TextInformationFrame> {
    @Override // android.os.Parcelable$Creator
    public TextInformationFrame createFromParcel(Parcel parcel) {
        return new TextInformationFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public TextInformationFrame[] newArray(int i) {
        return new TextInformationFrame[i];
    }
}
