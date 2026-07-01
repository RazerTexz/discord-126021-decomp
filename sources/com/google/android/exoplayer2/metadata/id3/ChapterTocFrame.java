package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable$Creator<ChapterTocFrame> CREATOR = new ChapterTocFrame$a();
    public final String k;
    public final boolean l;
    public final boolean m;
    public final String[] n;
    public final Id3Frame[] o;

    public ChapterTocFrame(String str, boolean z2, boolean z3, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.k = str;
        this.l = z2;
        this.m = z3;
        this.n = strArr;
        this.o = id3FrameArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        return this.l == chapterTocFrame.l && this.m == chapterTocFrame.m && e0.a(this.k, chapterTocFrame.k) && Arrays.equals(this.n, chapterTocFrame.n) && Arrays.equals(this.o, chapterTocFrame.o);
    }

    public int hashCode() {
        int i = (((527 + (this.l ? 1 : 0)) * 31) + (this.m ? 1 : 0)) * 31;
        String str = this.k;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.k);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.n);
        parcel.writeInt(this.o.length);
        for (Id3Frame id3Frame : this.o) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        String string = parcel.readString();
        int i = e0.a;
        this.k = string;
        this.l = parcel.readByte() != 0;
        this.m = parcel.readByte() != 0;
        this.n = parcel.createStringArray();
        int i2 = parcel.readInt();
        this.o = new Id3Frame[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.o[i3] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
