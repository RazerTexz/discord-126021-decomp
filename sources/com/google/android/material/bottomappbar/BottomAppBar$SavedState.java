package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<BottomAppBar$SavedState> CREATOR = new BottomAppBar$SavedState$a();
    public int j;
    public boolean k;

    public BottomAppBar$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k ? 1 : 0);
    }

    public BottomAppBar$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.j = parcel.readInt();
        this.k = parcel.readInt() != 0;
    }
}
