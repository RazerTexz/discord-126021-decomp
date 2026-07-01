package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable$Creator<ChapterFrame> CREATOR = new ChapterFrame$a();
    public final String k;
    public final int l;
    public final int m;
    public final long n;
    public final long o;
    public final Id3Frame[] p;

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.k = str;
        this.l = i;
        this.m = i2;
        this.n = j;
        this.o = j2;
        this.p = id3FrameArr;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        return this.l == chapterFrame.l && this.m == chapterFrame.m && this.n == chapterFrame.n && this.o == chapterFrame.o && e0.a(this.k, chapterFrame.k) && Arrays.equals(this.p, chapterFrame.p);
    }

    public int hashCode() {
        int i = (((((((527 + this.l) * 31) + this.m) * 31) + ((int) this.n)) * 31) + ((int) this.o)) * 31;
        String str = this.k;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeLong(this.n);
        parcel.writeLong(this.o);
        parcel.writeInt(this.p.length);
        for (Id3Frame id3Frame : this.p) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterFrame(Parcel parcel) {
        super("CHAP");
        String string = parcel.readString();
        int i = e0.a;
        this.k = string;
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readLong();
        this.o = parcel.readLong();
        int i2 = parcel.readInt();
        this.p = new Id3Frame[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.p[i3] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
