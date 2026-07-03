package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import java.util.Objects;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.p279z2.C3155a;

/* JADX INFO: loaded from: classes3.dex */
public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new C10725a();

    /* JADX INFO: renamed from: j */
    public final byte[] f19963j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public final String f19964k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final String f19965l;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.icy.IcyInfo$a */
    public class C10725a implements Parcelable.Creator<IcyInfo> {
        @Override // android.os.Parcelable.Creator
        public IcyInfo createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IcyInfo[] newArray(int i) {
            return new IcyInfo[i];
        }
    }

    public IcyInfo(byte[] bArr, @Nullable String str, @Nullable String str2) {
        this.f19963j = bArr;
        this.f19964k = str;
        this.f19965l = str2;
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
        return Arrays.equals(this.f19963j, ((IcyInfo) obj).f19963j);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f19963j);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: n */
    public void mo8878n(C2835p1.b bVar) {
        String str = this.f19964k;
        if (str != null) {
            bVar.f7407a = str;
        }
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: o0 */
    public /* synthetic */ byte[] mo8879o0() {
        return C3155a.m3892a(this);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f19964k, this.f19965l, Integer.valueOf(this.f19963j.length));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.f19963j);
        parcel.writeString(this.f19964k);
        parcel.writeString(this.f19965l);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: y */
    public /* synthetic */ C2811j1 mo8880y() {
        return C3155a.m3893b(this);
    }

    public IcyInfo(Parcel parcel) {
        byte[] bArrCreateByteArray = parcel.createByteArray();
        Objects.requireNonNull(bArrCreateByteArray);
        this.f19963j = bArrCreateByteArray;
        this.f19964k = parcel.readString();
        this.f19965l = parcel.readString();
    }
}
