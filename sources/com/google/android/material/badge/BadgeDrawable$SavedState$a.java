package com.google.android.material.badge;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class BadgeDrawable$SavedState$a implements Parcelable$Creator<BadgeDrawable$SavedState> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public BadgeDrawable$SavedState createFromParcel(@NonNull Parcel parcel) {
        return new BadgeDrawable$SavedState(parcel);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public BadgeDrawable$SavedState[] newArray(int i) {
        return new BadgeDrawable$SavedState[i];
    }
}
