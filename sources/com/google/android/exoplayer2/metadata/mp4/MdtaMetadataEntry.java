package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.f3.Util2;
import b.i.a.c.z2.Metadata2;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new a();
    public final String j;
    public final byte[] k;
    public final int l;
    public final int m;

    public class a implements Parcelable.Creator<MdtaMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        public MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public MdtaMetadataEntry[] newArray(int i) {
            return new MdtaMetadataEntry[i];
        }
    }

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
        return ((((Arrays.hashCode(this.k) + outline.m(this.j, 527, 31)) * 31) + this.l) * 31) + this.m;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void n(MediaMetadata.b bVar) {
        Metadata2.c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] o0() {
        return Metadata2.a(this);
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

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format2 y() {
        return Metadata2.b(this);
    }

    public MdtaMetadataEntry(Parcel parcel, a aVar) {
        String string = parcel.readString();
        int i = Util2.a;
        this.j = string;
        this.k = parcel.createByteArray();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }
}
