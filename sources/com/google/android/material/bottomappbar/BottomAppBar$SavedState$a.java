package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$SavedState$a implements Parcelable$ClassLoaderCreator<BottomAppBar$SavedState> {
    @Override // android.os.Parcelable$ClassLoaderCreator
    @NonNull
    public BottomAppBar$SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
        return new BottomAppBar$SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object[] newArray(int i) {
        return new BottomAppBar$SavedState[i];
    }

    @Override // android.os.Parcelable$Creator
    @Nullable
    public Object createFromParcel(@NonNull Parcel parcel) {
        return new BottomAppBar$SavedState(parcel, null);
    }
}
