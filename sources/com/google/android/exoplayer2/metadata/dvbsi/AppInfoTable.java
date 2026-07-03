package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Objects;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.p279z2.C3155a;

/* JADX INFO: loaded from: classes3.dex */
public final class AppInfoTable implements Metadata.Entry {
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new C10720a();

    /* JADX INFO: renamed from: j */
    public final int f19937j;

    /* JADX INFO: renamed from: k */
    public final String f19938k;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable$a */
    public class C10720a implements Parcelable.Creator<AppInfoTable> {
        @Override // android.os.Parcelable.Creator
        public AppInfoTable createFromParcel(Parcel parcel) {
            String string = parcel.readString();
            Objects.requireNonNull(string);
            return new AppInfoTable(parcel.readInt(), string);
        }

        @Override // android.os.Parcelable.Creator
        public AppInfoTable[] newArray(int i) {
            return new AppInfoTable[i];
        }
    }

    public AppInfoTable(int i, String str) {
        this.f19937j = i;
        this.f19938k = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
        int i = this.f19937j;
        String str = this.f19938k;
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
        parcel.writeString(this.f19938k);
        parcel.writeInt(this.f19937j);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: y */
    public /* synthetic */ C2811j1 mo8880y() {
        return C3155a.m3893b(this);
    }
}
