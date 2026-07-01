package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayout$LayoutParams$a implements Parcelable$Creator<FlexboxLayout$LayoutParams> {
    @Override // android.os.Parcelable$Creator
    public FlexboxLayout$LayoutParams createFromParcel(Parcel parcel) {
        return new FlexboxLayout$LayoutParams(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public FlexboxLayout$LayoutParams[] newArray(int i) {
        return new FlexboxLayout$LayoutParams[i];
    }
}
