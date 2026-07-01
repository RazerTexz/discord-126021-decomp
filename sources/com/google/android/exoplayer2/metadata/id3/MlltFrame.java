package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class MlltFrame extends Id3Frame {
    public static final Parcelable$Creator<MlltFrame> CREATOR = new MlltFrame$a();
    public final int k;
    public final int l;
    public final int m;
    public final int[] n;
    public final int[] o;

    public MlltFrame(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.k = i;
        this.l = i2;
        this.m = i3;
        this.n = iArr;
        this.o = iArr2;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MlltFrame.class != obj.getClass()) {
            return false;
        }
        MlltFrame mlltFrame = (MlltFrame) obj;
        return this.k == mlltFrame.k && this.l == mlltFrame.l && this.m == mlltFrame.m && Arrays.equals(this.n, mlltFrame.n) && Arrays.equals(this.o, mlltFrame.o);
    }

    public int hashCode() {
        return Arrays.hashCode(this.o) + ((Arrays.hashCode(this.n) + ((((((527 + this.k) * 31) + this.l) * 31) + this.m) * 31)) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeIntArray(this.n);
        parcel.writeIntArray(this.o);
    }

    public MlltFrame(Parcel parcel) {
        super("MLLT");
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        int[] iArrCreateIntArray = parcel.createIntArray();
        int i = e0.a;
        this.n = iArrCreateIntArray;
        this.o = parcel.createIntArray();
    }
}
