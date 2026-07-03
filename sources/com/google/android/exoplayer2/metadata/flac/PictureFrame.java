package com.google.android.exoplayer2.metadata.flac;

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
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new C10722a();

    /* JADX INFO: renamed from: j */
    public final int f19947j;

    /* JADX INFO: renamed from: k */
    public final String f19948k;

    /* JADX INFO: renamed from: l */
    public final String f19949l;

    /* JADX INFO: renamed from: m */
    public final int f19950m;

    /* JADX INFO: renamed from: n */
    public final int f19951n;

    /* JADX INFO: renamed from: o */
    public final int f19952o;

    /* JADX INFO: renamed from: p */
    public final int f19953p;

    /* JADX INFO: renamed from: q */
    public final byte[] f19954q;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.flac.PictureFrame$a */
    public class C10722a implements Parcelable.Creator<PictureFrame> {
        @Override // android.os.Parcelable.Creator
        public PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PictureFrame[] newArray(int i) {
            return new PictureFrame[i];
        }
    }

    public PictureFrame(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.f19947j = i;
        this.f19948k = str;
        this.f19949l = str2;
        this.f19950m = i2;
        this.f19951n = i3;
        this.f19952o = i4;
        this.f19953p = i5;
        this.f19954q = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PictureFrame.class != obj.getClass()) {
            return false;
        }
        PictureFrame pictureFrame = (PictureFrame) obj;
        return this.f19947j == pictureFrame.f19947j && this.f19948k.equals(pictureFrame.f19948k) && this.f19949l.equals(pictureFrame.f19949l) && this.f19950m == pictureFrame.f19950m && this.f19951n == pictureFrame.f19951n && this.f19952o == pictureFrame.f19952o && this.f19953p == pictureFrame.f19953p && Arrays.equals(this.f19954q, pictureFrame.f19954q);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f19954q) + ((((((((C1643a.m863m(this.f19949l, C1643a.m863m(this.f19948k, (this.f19947j + 527) * 31, 31), 31) + this.f19950m) * 31) + this.f19951n) * 31) + this.f19952o) * 31) + this.f19953p) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: n */
    public void mo8878n(C2835p1.b bVar) {
        bVar.m3346b(this.f19954q, this.f19947j);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: o0 */
    public /* synthetic */ byte[] mo8879o0() {
        return C3155a.m3892a(this);
    }

    public String toString() {
        String str = this.f19948k;
        String str2 = this.f19949l;
        return C1643a.m861l(C1643a.m841b(str2, C1643a.m841b(str, 32)), "Picture: mimeType=", str, ", description=", str2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19947j);
        parcel.writeString(this.f19948k);
        parcel.writeString(this.f19949l);
        parcel.writeInt(this.f19950m);
        parcel.writeInt(this.f19951n);
        parcel.writeInt(this.f19952o);
        parcel.writeInt(this.f19953p);
        parcel.writeByteArray(this.f19954q);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: y */
    public /* synthetic */ C2811j1 mo8880y() {
        return C3155a.m3893b(this);
    }

    public PictureFrame(Parcel parcel) {
        this.f19947j = parcel.readInt();
        String string = parcel.readString();
        int i = C2738e0.f6708a;
        this.f19948k = string;
        this.f19949l = parcel.readString();
        this.f19950m = parcel.readInt();
        this.f19951n = parcel.readInt();
        this.f19952o = parcel.readInt();
        this.f19953p = parcel.readInt();
        this.f19954q = parcel.createByteArray();
    }
}
