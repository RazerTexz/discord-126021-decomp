package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.p1$b;
import b.i.a.c.z2.a;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class IcyInfo implements Metadata$Entry {
    public static final Parcelable$Creator<IcyInfo> CREATOR = new IcyInfo$a();
    public final byte[] j;

    @Nullable
    public final String k;

    @Nullable
    public final String l;

    public IcyInfo(byte[] bArr, @Nullable String str, @Nullable String str2) {
        this.j = bArr;
        this.k = str;
        this.l = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.j, ((IcyInfo) obj).j);
    }

    public int hashCode() {
        return Arrays.hashCode(this.j);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public void n(p1$b p1_b) {
        String str = this.k;
        if (str != null) {
            p1_b.a = str;
        }
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ byte[] o0() {
        return a.a(this);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.k, this.l, Integer.valueOf(this.j.length));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ j1 y() {
        return a.b(this);
    }

    public IcyInfo(Parcel parcel) {
        byte[] bArrCreateByteArray = parcel.createByteArray();
        Objects.requireNonNull(bArrCreateByteArray);
        this.j = bArrCreateByteArray;
        this.k = parcel.readString();
        this.l = parcel.readString();
    }
}
