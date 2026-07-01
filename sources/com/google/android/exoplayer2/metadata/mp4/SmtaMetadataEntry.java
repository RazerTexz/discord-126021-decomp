package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.p1$b;
import b.i.a.c.z2.a;
import com.google.android.exoplayer2.metadata.Metadata$Entry;

/* JADX INFO: loaded from: classes3.dex */
public final class SmtaMetadataEntry implements Metadata$Entry {
    public static final Parcelable$Creator<SmtaMetadataEntry> CREATOR = new SmtaMetadataEntry$a();
    public final float j;
    public final int k;

    public SmtaMetadataEntry(float f, int i) {
        this.j = f;
        this.k = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SmtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
        return this.j == smtaMetadataEntry.j && this.k == smtaMetadataEntry.k;
    }

    public int hashCode() {
        return ((527 + Float.valueOf(this.j).hashCode()) * 31) + this.k;
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
        float f = this.j;
        int i = this.k;
        StringBuilder sb = new StringBuilder(73);
        sb.append("smta: captureFrameRate=");
        sb.append(f);
        sb.append(", svcTemporalLayerCount=");
        sb.append(i);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.j);
        parcel.writeInt(this.k);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ j1 y() {
        return a.b(this);
    }

    public SmtaMetadataEntry(Parcel parcel, SmtaMetadataEntry$a smtaMetadataEntry$a) {
        this.j = parcel.readFloat();
        this.k = parcel.readInt();
    }
}
