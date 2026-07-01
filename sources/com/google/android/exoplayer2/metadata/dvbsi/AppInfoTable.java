package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.i.a.c.j1;
import b.i.a.c.p1$b;
import b.i.a.c.z2.a;
import com.google.android.exoplayer2.metadata.Metadata$Entry;

/* JADX INFO: loaded from: classes3.dex */
public final class AppInfoTable implements Metadata$Entry {
    public static final Parcelable$Creator<AppInfoTable> CREATOR = new AppInfoTable$a();
    public final int j;
    public final String k;

    public AppInfoTable(int i, String str) {
        this.j = i;
        this.k = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ void n(p1$b p1_b) {
        a.c(this, p1_b);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ byte[] o0() {
        return a.a(this);
    }

    public String toString() {
        int i = this.j;
        String str = this.k;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append("Ait(controlCode=");
        sb.append(i);
        sb.append(",url=");
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.k);
        parcel.writeInt(this.j);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ j1 y() {
        return a.b(this);
    }
}
