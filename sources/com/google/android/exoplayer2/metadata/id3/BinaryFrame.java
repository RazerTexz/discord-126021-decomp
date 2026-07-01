package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import b.i.a.c.f3.e0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class BinaryFrame extends Id3Frame {
    public static final Parcelable$Creator<BinaryFrame> CREATOR = new BinaryFrame$a();
    public final byte[] k;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.k = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BinaryFrame.class != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        return this.j.equals(binaryFrame.j) && Arrays.equals(this.k, binaryFrame.k);
    }

    public int hashCode() {
        return Arrays.hashCode(this.k) + a.m(this.j, 527, 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeByteArray(this.k);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BinaryFrame(Parcel parcel) {
        String string = parcel.readString();
        int i = e0.a;
        super(string);
        this.k = parcel.createByteArray();
    }
}
