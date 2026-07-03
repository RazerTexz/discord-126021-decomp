package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new C10726a();

    /* JADX INFO: renamed from: k */
    public final String f19966k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final String f19967l;

    /* JADX INFO: renamed from: m */
    public final int f19968m;

    /* JADX INFO: renamed from: n */
    public final byte[] f19969n;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.id3.ApicFrame$a */
    public class C10726a implements Parcelable.Creator<ApicFrame> {
        @Override // android.os.Parcelable.Creator
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ApicFrame[] newArray(int i) {
            return new ApicFrame[i];
        }
    }

    public ApicFrame(String str, @Nullable String str2, int i, byte[] bArr) {
        super("APIC");
        this.f19966k = str;
        this.f19967l = str2;
        this.f19968m = i;
        this.f19969n = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.f19968m == apicFrame.f19968m && C2738e0.m2993a(this.f19966k, apicFrame.f19966k) && C2738e0.m2993a(this.f19967l, apicFrame.f19967l) && Arrays.equals(this.f19969n, apicFrame.f19969n);
    }

    public int hashCode() {
        int i = (527 + this.f19968m) * 31;
        String str = this.f19966k;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f19967l;
        return Arrays.hashCode(this.f19969n) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: n */
    public void mo8878n(C2835p1.b bVar) {
        bVar.m3346b(this.f19969n, this.f19968m);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f19989j;
        String str2 = this.f19966k;
        String str3 = this.f19967l;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str3, C1643a.m841b(str2, C1643a.m841b(str, 25))), str, ": mimeType=", str2, ", description=");
        sbM831S.append(str3);
        return sbM831S.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19966k);
        parcel.writeString(this.f19967l);
        parcel.writeInt(this.f19968m);
        parcel.writeByteArray(this.f19969n);
    }

    public ApicFrame(Parcel parcel) {
        super("APIC");
        String string = parcel.readString();
        int i = C2738e0.f6708a;
        this.f19966k = string;
        this.f19967l = parcel.readString();
        this.f19968m = parcel.readInt();
        this.f19969n = parcel.createByteArray();
    }
}
