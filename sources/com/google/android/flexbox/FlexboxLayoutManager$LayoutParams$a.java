package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayoutManager$LayoutParams$a implements Parcelable$Creator<FlexboxLayoutManager$LayoutParams> {
    @Override // android.os.Parcelable$Creator
    public FlexboxLayoutManager$LayoutParams createFromParcel(Parcel parcel) {
        return new FlexboxLayoutManager$LayoutParams(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public FlexboxLayoutManager$LayoutParams[] newArray(int i) {
        return new FlexboxLayoutManager$LayoutParams[i];
    }
}
