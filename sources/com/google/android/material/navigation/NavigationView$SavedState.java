package com.google.android.material.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationView$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<NavigationView$SavedState> CREATOR = new NavigationView$SavedState$a();

    @Nullable
    public Bundle menuState;

    public NavigationView$SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        super(parcel, classLoader);
        this.menuState = parcel.readBundle(classLoader);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.menuState);
    }

    public NavigationView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
