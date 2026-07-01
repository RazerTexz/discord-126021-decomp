package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new a();

    @Nullable
    public final String j;
    public final float k;
    public final float l;

    public static class a implements Parcelable.Creator<AspectRatio> {
        @Override // android.os.Parcelable.Creator
        public AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AspectRatio[] newArray(int i) {
            return new AspectRatio[i];
        }
    }

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
