package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new C10742a();

    /* JADX INFO: renamed from: j */
    public final long f20019j;

    /* JADX INFO: renamed from: k */
    public final long f20020k;

    /* JADX INFO: renamed from: l */
    public final byte[] f20021l;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.scte35.PrivateCommand$a */
    public class C10742a implements Parcelable.Creator<PrivateCommand> {
        @Override // android.os.Parcelable.Creator
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public PrivateCommand[] newArray(int i) {
            return new PrivateCommand[i];
        }
    }

    public PrivateCommand(long j, byte[] bArr, long j2) {
        this.f20019j = j2;
        this.f20020k = j;
        this.f20021l = bArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f20019j);
        parcel.writeLong(this.f20020k);
        parcel.writeByteArray(this.f20021l);
    }

    public PrivateCommand(Parcel parcel, C10742a c10742a) {
        this.f20019j = parcel.readLong();
        this.f20020k = parcel.readLong();
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i = C2738e0.f6708a;
        this.f20021l = bArrCreateByteArray;
    }
}
