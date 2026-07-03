package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new C10729a();

    /* JADX INFO: renamed from: k */
    public final String f19977k;

    /* JADX INFO: renamed from: l */
    public final boolean f19978l;

    /* JADX INFO: renamed from: m */
    public final boolean f19979m;

    /* JADX INFO: renamed from: n */
    public final String[] f19980n;

    /* JADX INFO: renamed from: o */
    public final Id3Frame[] f19981o;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.id3.ChapterTocFrame$a */
    public class C10729a implements Parcelable.Creator<ChapterTocFrame> {
        @Override // android.os.Parcelable.Creator
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ChapterTocFrame[] newArray(int i) {
            return new ChapterTocFrame[i];
        }
    }

    public ChapterTocFrame(String str, boolean z2, boolean z3, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f19977k = str;
        this.f19978l = z2;
        this.f19979m = z3;
        this.f19980n = strArr;
        this.f19981o = id3FrameArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        return this.f19978l == chapterTocFrame.f19978l && this.f19979m == chapterTocFrame.f19979m && C2738e0.m2993a(this.f19977k, chapterTocFrame.f19977k) && Arrays.equals(this.f19980n, chapterTocFrame.f19980n) && Arrays.equals(this.f19981o, chapterTocFrame.f19981o);
    }

    public int hashCode() {
        int i = (((527 + (this.f19978l ? 1 : 0)) * 31) + (this.f19979m ? 1 : 0)) * 31;
        String str = this.f19977k;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19977k);
        parcel.writeByte(this.f19978l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f19979m ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f19980n);
        parcel.writeInt(this.f19981o.length);
        for (Id3Frame id3Frame : this.f19981o) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        String string = parcel.readString();
        int i = C2738e0.f6708a;
        this.f19977k = string;
        this.f19978l = parcel.readByte() != 0;
        this.f19979m = parcel.readByte() != 0;
        this.f19980n = parcel.createStringArray();
        int i2 = parcel.readInt();
        this.f19981o = new Id3Frame[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.f19981o[i3] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
