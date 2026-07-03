package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new C10728a();

    /* JADX INFO: renamed from: k */
    public final String f19971k;

    /* JADX INFO: renamed from: l */
    public final int f19972l;

    /* JADX INFO: renamed from: m */
    public final int f19973m;

    /* JADX INFO: renamed from: n */
    public final long f19974n;

    /* JADX INFO: renamed from: o */
    public final long f19975o;

    /* JADX INFO: renamed from: p */
    public final Id3Frame[] f19976p;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.id3.ChapterFrame$a */
    public class C10728a implements Parcelable.Creator<ChapterFrame> {
        @Override // android.os.Parcelable.Creator
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ChapterFrame[] newArray(int i) {
            return new ChapterFrame[i];
        }
    }

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f19971k = str;
        this.f19972l = i;
        this.f19973m = i2;
        this.f19974n = j;
        this.f19975o = j2;
        this.f19976p = id3FrameArr;
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
        return this.f19972l == chapterFrame.f19972l && this.f19973m == chapterFrame.f19973m && this.f19974n == chapterFrame.f19974n && this.f19975o == chapterFrame.f19975o && C2738e0.m2993a(this.f19971k, chapterFrame.f19971k) && Arrays.equals(this.f19976p, chapterFrame.f19976p);
    }

    public int hashCode() {
        int i = (((((((527 + this.f19972l) * 31) + this.f19973m) * 31) + ((int) this.f19974n)) * 31) + ((int) this.f19975o)) * 31;
        String str = this.f19971k;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19971k);
        parcel.writeInt(this.f19972l);
        parcel.writeInt(this.f19973m);
        parcel.writeLong(this.f19974n);
        parcel.writeLong(this.f19975o);
        parcel.writeInt(this.f19976p.length);
        for (Id3Frame id3Frame : this.f19976p) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterFrame(Parcel parcel) {
        super("CHAP");
        String string = parcel.readString();
        int i = C2738e0.f6708a;
        this.f19971k = string;
        this.f19972l = parcel.readInt();
        this.f19973m = parcel.readInt();
        this.f19974n = parcel.readLong();
        this.f19975o = parcel.readLong();
        int i2 = parcel.readInt();
        this.f19976p = new Id3Frame[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.f19976p[i3] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
