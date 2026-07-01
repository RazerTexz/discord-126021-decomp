package com.google.android.material.button;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButton$SavedState$a implements Parcelable$ClassLoaderCreator<MaterialButton$SavedState> {
    @Override // android.os.Parcelable$ClassLoaderCreator
    @NonNull
    public MaterialButton$SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
        return new MaterialButton$SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object[] newArray(int i) {
        return new MaterialButton$SavedState[i];
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object createFromParcel(@NonNull Parcel parcel) {
        return new MaterialButton$SavedState(parcel, null);
    }
}
