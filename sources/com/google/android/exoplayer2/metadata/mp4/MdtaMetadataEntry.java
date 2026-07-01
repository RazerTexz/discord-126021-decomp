package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import b.i.a.c.p1$b;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class MdtaMetadataEntry implements Metadata$Entry {
    public static final Parcelable$Creator<MdtaMetadataEntry> CREATOR = new MdtaMetadataEntry$a();
    public final String j;
    public final byte[] k;
    public final int l;
    public final int m;

    public MdtaMetadataEntry(String str, byte[] bArr, int i, int i2) {
        this.j = str;
        this.k = bArr;
        this.l = i;
        this.m = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        return this.j.equals(mdtaMetadataEntry.j) && Arrays.equals(this.k, mdtaMetadataEntry.k) && this.l == mdtaMetadataEntry.l && this.m == mdtaMetadataEntry.m;
    }

    public int hashCode() {
        return ((((Arrays.hashCode(this.k) + a.m(this.j, 527, 31)) * 31) + this.l) * 31) + this.m;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ void n(p1$b p1_b) {
        b.i.a.c.z2.a.c(this, p1_b);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ byte[] o0() {
        return b.i.a.c.z2.a.a(this);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.j);
        return strValueOf.length() != 0 ? "mdta: key=".concat(strValueOf) : new String("mdta: key=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeByteArray(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ j1 y() {
        return b.i.a.c.z2.a.b(this);
    }

    public MdtaMetadataEntry(Parcel parcel, MdtaMetadataEntry$a mdtaMetadataEntry$a) {
        String string = parcel.readString();
        int i = e0.a;
        this.j = string;
        this.k = parcel.createByteArray();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }
}
