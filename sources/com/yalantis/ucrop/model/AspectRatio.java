package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class AspectRatio implements Parcelable {
    public static final Parcelable$Creator<AspectRatio> CREATOR = new AspectRatio$a();

    @Nullable
    public final String j;
    public final float k;
    public final float l;

    public AspectRatio(@Nullable String str, float f, float f2) {
        this.j = str;
        this.k = f;
        this.l = f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeFloat(this.k);
        parcel.writeFloat(this.l);
    }

    public AspectRatio(Parcel parcel) {
        this.j = parcel.readString();
        this.k = parcel.readFloat();
        this.l = parcel.readFloat();
    }
}
