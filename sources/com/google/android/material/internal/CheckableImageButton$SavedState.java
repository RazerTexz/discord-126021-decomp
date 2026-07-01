package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes3.dex */
public class CheckableImageButton$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<CheckableImageButton$SavedState> CREATOR = new CheckableImageButton$SavedState$a();
    public boolean j;

    public CheckableImageButton$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.j ? 1 : 0);
    }

    public CheckableImageButton$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.j = parcel.readInt() == 1;
    }
}
