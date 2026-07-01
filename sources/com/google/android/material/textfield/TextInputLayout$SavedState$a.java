package com.google.android.material.textfield;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout$SavedState$a implements Parcelable$ClassLoaderCreator<TextInputLayout$SavedState> {
    @Override // android.os.Parcelable$ClassLoaderCreator
    @NonNull
    public TextInputLayout$SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
        return new TextInputLayout$SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object[] newArray(int i) {
        return new TextInputLayout$SavedState[i];
    }

    @Override // android.os.Parcelable$Creator
    @Nullable
    public Object createFromParcel(@NonNull Parcel parcel) {
        return new TextInputLayout$SavedState(parcel, null);
    }
}
