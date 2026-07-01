package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes3.dex */
public class BottomNavigationPresenter$SavedState implements Parcelable {
    public static final Parcelable$Creator<BottomNavigationPresenter$SavedState> CREATOR = new BottomNavigationPresenter$SavedState$a();
    public int j;

    @Nullable
    public ParcelableSparseArray k;

    public BottomNavigationPresenter$SavedState() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.j);
        parcel.writeParcelable(this.k, 0);
    }

    public BottomNavigationPresenter$SavedState(@NonNull Parcel parcel) {
        this.j = parcel.readInt();
        this.k = (ParcelableSparseArray) parcel.readParcelable(BottomNavigationPresenter$SavedState.class.getClassLoader());
    }
}
