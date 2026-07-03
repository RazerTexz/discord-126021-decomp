package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p279z2.C3155a;

/* JADX INFO: loaded from: classes3.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new C10737a();

    /* JADX INFO: renamed from: j */
    public final String f20004j;

    /* JADX INFO: renamed from: k */
    public final byte[] f20005k;

    /* JADX INFO: renamed from: l */
    public final int f20006l;

    /* JADX INFO: renamed from: m */
    public final int f20007m;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry$a */
    public class C10737a implements Parcelable.Creator<MdtaMetadataEntry> {
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
        this.f20004j = str;
        this.f20005k = bArr;
        this.f20006l = i;
        this.f20007m = i2;
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
        return this.f20004j.equals(mdtaMetadataEntry.f20004j) && Arrays.equals(this.f20005k, mdtaMetadataEntry.f20005k) && this.f20006l == mdtaMetadataEntry.f20006l && this.f20007m == mdtaMetadataEntry.f20007m;
    }

    public int hashCode() {
        return ((((Arrays.hashCode(this.f20005k) + C1643a.m863m(this.f20004j, 527, 31)) * 31) + this.f20006l) * 31) + this.f20007m;
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
        String strValueOf = String.valueOf(this.f20004j);
        return strValueOf.length() != 0 ? "mdta: key=".concat(strValueOf) : new String("mdta: key=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f20004j);
        parcel.writeByteArray(this.f20005k);
        parcel.writeInt(this.f20006l);
        parcel.writeInt(this.f20007m);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: y */
    public /* synthetic */ C2811j1 mo8880y() {
        return C3155a.m3893b(this);
    }

    public MdtaMetadataEntry(Parcel parcel, C10737a c10737a) {
        String string = parcel.readString();
        int i = C2738e0.f6708a;
        this.f20004j = string;
        this.f20005k = parcel.createByteArray();
        this.f20006l = parcel.readInt();
        this.f20007m = parcel.readInt();
    }
}
