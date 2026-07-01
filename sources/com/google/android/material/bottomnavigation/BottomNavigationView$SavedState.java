package com.google.android.material.bottomnavigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes3.dex */
public class BottomNavigationView$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<BottomNavigationView$SavedState> CREATOR = new BottomNavigationView$SavedState$a();

    @Nullable
    public Bundle j;

    public BottomNavigationView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.j);
    }

    public BottomNavigationView$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.j = parcel.readBundle(classLoader == null ? BottomNavigationView$SavedState.class.getClassLoader() : classLoader);
    }
}
