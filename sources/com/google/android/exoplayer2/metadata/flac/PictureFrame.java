package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.f3.Util2;
import b.i.a.c.z2.Metadata2;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new a();
    public final int j;
    public final String k;
    public final String l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final byte[] q;

    public class a implements Parcelable.Creator<PictureFrame> {
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
        this.j = i;
        this.k = str;
        this.l = str2;
        this.m = i2;
        this.n = i3;
        this.o = i4;
        this.p = i5;
        this.q = bArr;
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
        return this.j == pictureFrame.j && this.k.equals(pictureFrame.k) && this.l.equals(pictureFrame.l) && this.m == pictureFrame.m && this.n == pictureFrame.n && this.o == pictureFrame.o && this.p == pictureFrame.p && Arrays.equals(this.q, pictureFrame.q);
    }

    public int hashCode() {
        return Arrays.hashCode(this.q) + ((((((((outline.m(this.l, outline.m(this.k, (this.j + 527) * 31, 31), 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void n(MediaMetadata.b bVar) {
        bVar.b(this.q, this.j);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] o0() {
        return Metadata2.a(this);
    }

    public String toString() {
        String str = this.k;
        String str2 = this.l;
        return outline.l(outline.b(str2, outline.b(str, 32)), "Picture: mimeType=", str, ", description=", str2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeByteArray(this.q);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format2 y() {
        return Metadata2.b(this);
    }

    public PictureFrame(Parcel parcel) {
        this.j = parcel.readInt();
        String string = parcel.readString();
        int i = Util2.a;
        this.k = string;
        this.l = parcel.readString();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.createByteArray();
    }
}
