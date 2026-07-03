package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new C10733a();

    /* JADX INFO: renamed from: k */
    public final int f19993k;

    /* JADX INFO: renamed from: l */
    public final int f19994l;

    /* JADX INFO: renamed from: m */
    public final int f19995m;

    /* JADX INFO: renamed from: n */
    public final int[] f19996n;

    /* JADX INFO: renamed from: o */
    public final int[] f19997o;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.id3.MlltFrame$a */
    public class C10733a implements Parcelable.Creator<MlltFrame> {
        @Override // android.os.Parcelable.Creator
        public MlltFrame createFromParcel(Parcel parcel) {
            return new MlltFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MlltFrame[] newArray(int i) {
            return new MlltFrame[i];
        }
    }

    public MlltFrame(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f19993k = i;
        this.f19994l = i2;
        this.f19995m = i3;
        this.f19996n = iArr;
        this.f19997o = iArr2;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MlltFrame.class != obj.getClass()) {
            return false;
        }
        MlltFrame mlltFrame = (MlltFrame) obj;
        return this.f19993k == mlltFrame.f19993k && this.f19994l == mlltFrame.f19994l && this.f19995m == mlltFrame.f19995m && Arrays.equals(this.f19996n, mlltFrame.f19996n) && Arrays.equals(this.f19997o, mlltFrame.f19997o);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f19997o) + ((Arrays.hashCode(this.f19996n) + ((((((527 + this.f19993k) * 31) + this.f19994l) * 31) + this.f19995m) * 31)) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19993k);
        parcel.writeInt(this.f19994l);
        parcel.writeInt(this.f19995m);
        parcel.writeIntArray(this.f19996n);
        parcel.writeIntArray(this.f19997o);
    }

    public MlltFrame(Parcel parcel) {
        super("MLLT");
        this.f19993k = parcel.readInt();
        this.f19994l = parcel.readInt();
        this.f19995m = parcel.readInt();
        int[] iArrCreateIntArray = parcel.createIntArray();
        int i = C2738e0.f6708a;
        this.f19996n = iArrCreateIntArray;
        this.f19997o = parcel.createIntArray();
    }
}
