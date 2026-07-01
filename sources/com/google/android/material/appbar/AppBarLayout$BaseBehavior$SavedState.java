package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout$BaseBehavior$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<AppBarLayout$BaseBehavior$SavedState> CREATOR = new AppBarLayout$BaseBehavior$SavedState$a();
    public boolean firstVisibleChildAtMinimumHeight;
    public int firstVisibleChildIndex;
    public float firstVisibleChildPercentageShown;

    public AppBarLayout$BaseBehavior$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.firstVisibleChildIndex = parcel.readInt();
        this.firstVisibleChildPercentageShown = parcel.readFloat();
        this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.firstVisibleChildIndex);
        parcel.writeFloat(this.firstVisibleChildPercentageShown);
        parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
    }

    public AppBarLayout$BaseBehavior$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
