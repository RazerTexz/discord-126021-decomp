package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new C10727a();

    /* JADX INFO: renamed from: k */
    public final byte[] f19970k;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.id3.BinaryFrame$a */
    public class C10727a implements Parcelable.Creator<BinaryFrame> {
        @Override // android.os.Parcelable.Creator
        public BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BinaryFrame[] newArray(int i) {
            return new BinaryFrame[i];
        }
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f19970k = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BinaryFrame.class != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        return this.f19989j.equals(binaryFrame.f19989j) && Arrays.equals(this.f19970k, binaryFrame.f19970k);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f19970k) + C1643a.m863m(this.f19989j, 527, 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19989j);
        parcel.writeByteArray(this.f19970k);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BinaryFrame(Parcel parcel) {
        String string = parcel.readString();
        int i = C2738e0.f6708a;
        super(string);
        this.f19970k = parcel.createByteArray();
    }
}
