package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.c.MediaMetadata;
import b.i.a.c.f3.Util2;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new a();
    public final String k;

    @Nullable
    public final String l;
    public final int m;
    public final byte[] n;

    public class a implements Parcelable.Creator<ApicFrame> {
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
        this.k = str;
        this.l = str2;
        this.m = i;
        this.n = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.m == apicFrame.m && Util2.a(this.k, apicFrame.k) && Util2.a(this.l, apicFrame.l) && Arrays.equals(this.n, apicFrame.n);
    }

    public int hashCode() {
        int i = (527 + this.m) * 31;
        String str = this.k;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.l;
        return Arrays.hashCode(this.n) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, com.google.android.exoplayer2.metadata.Metadata.Entry
    public void n(MediaMetadata.b bVar) {
        bVar.b(this.n, this.m);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.j;
        String str2 = this.k;
        String str3 = this.l;
        StringBuilder sbS = outline.S(outline.b(str3, outline.b(str2, outline.b(str, 25))), str, ": mimeType=", str2, ", description=");
        sbS.append(str3);
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeInt(this.m);
        parcel.writeByteArray(this.n);
    }

    public ApicFrame(Parcel parcel) {
        super("APIC");
        String string = parcel.readString();
        int i = Util2.a;
        this.k = string;
        this.l = parcel.readString();
        this.m = parcel.readInt();
        this.n = parcel.createByteArray();
    }
}
