package com.google.android.material.button;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButton$SavedState extends AbsSavedState {
    public static final Parcelable$Creator<MaterialButton$SavedState> CREATOR = new MaterialButton$SavedState$a();
    public boolean j;

    public MaterialButton$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.j ? 1 : 0);
    }

    public MaterialButton$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            MaterialButton$SavedState.class.getClassLoader();
        }
        this.j = parcel.readInt() == 1;
    }
}
