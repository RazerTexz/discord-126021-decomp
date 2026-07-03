package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new C11202a();

    /* JADX INFO: renamed from: j */
    @Nullable
    public final String f22200j;

    /* JADX INFO: renamed from: k */
    public final float f22201k;

    /* JADX INFO: renamed from: l */
    public final float f22202l;

    /* JADX INFO: renamed from: com.yalantis.ucrop.model.AspectRatio$a */
    public static class C11202a implements Parcelable.Creator<AspectRatio> {
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
        this.f22200j = str;
        this.f22201k = f;
        this.f22202l = f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22200j);
        parcel.writeFloat(this.f22201k);
        parcel.writeFloat(this.f22202l);
    }

    public AspectRatio(Parcel parcel) {
        this.f22200j = parcel.readString();
        this.f22201k = parcel.readFloat();
        this.f22202l = parcel.readFloat();
    }
}
