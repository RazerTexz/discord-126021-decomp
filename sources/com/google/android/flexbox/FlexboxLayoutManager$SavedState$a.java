package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayoutManager$SavedState$a implements Parcelable$Creator<FlexboxLayoutManager$SavedState> {
    @Override // android.os.Parcelable$Creator
    public FlexboxLayoutManager$SavedState createFromParcel(Parcel parcel) {
        return new FlexboxLayoutManager$SavedState(parcel, (FlexboxLayoutManager$a) null);
    }

    @Override // android.os.Parcelable$Creator
    public FlexboxLayoutManager$SavedState[] newArray(int i) {
        return new FlexboxLayoutManager$SavedState[i];
    }
}
