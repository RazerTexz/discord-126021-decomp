package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.p279z2.C3155a;

/* JADX INFO: loaded from: classes3.dex */
public final class SmtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<SmtaMetadataEntry> CREATOR = new C10741a();

    /* JADX INFO: renamed from: j */
    public final float f20017j;

    /* JADX INFO: renamed from: k */
    public final int f20018k;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry$a */
    public class C10741a implements Parcelable.Creator<SmtaMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        public SmtaMetadataEntry createFromParcel(Parcel parcel) {
            return new SmtaMetadataEntry(parcel, (C10741a) null);
        }

        @Override // android.os.Parcelable.Creator
        public SmtaMetadataEntry[] newArray(int i) {
            return new SmtaMetadataEntry[i];
        }
    }

    public SmtaMetadataEntry(float f, int i) {
        this.f20017j = f;
        this.f20018k = i;
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
        return this.f20017j == smtaMetadataEntry.f20017j && this.f20018k == smtaMetadataEntry.f20018k;
    }

    public int hashCode() {
        return ((527 + Float.valueOf(this.f20017j).hashCode()) * 31) + this.f20018k;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: n */
    public /* synthetic */ void mo8878n(C2835p1.b bVar) {
        C3155a.m3894c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: o0 */
    public /* synthetic */ byte[] mo8879o0() {
        return C3155a.m3892a(this);
    }

    public String toString() {
        float f = this.f20017j;
        int i = this.f20018k;
        StringBuilder sb = new StringBuilder(73);
        sb.append("smta: captureFrameRate=");
        sb.append(f);
        sb.append(", svcTemporalLayerCount=");
        sb.append(i);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f20017j);
        parcel.writeInt(this.f20018k);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: y */
    public /* synthetic */ C2811j1 mo8880y() {
        return C3155a.m3893b(this);
    }

    public SmtaMetadataEntry(Parcel parcel, C10741a c10741a) {
        this.f20017j = parcel.readFloat();
        this.f20018k = parcel.readInt();
    }
}
