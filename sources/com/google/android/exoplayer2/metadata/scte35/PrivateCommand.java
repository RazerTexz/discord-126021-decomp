package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.i.a.c.f3.e0;

/* JADX INFO: loaded from: classes3.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable$Creator<PrivateCommand> CREATOR = new PrivateCommand$a();
    public final long j;
    public final long k;
    public final byte[] l;

    public PrivateCommand(long j, byte[] bArr, long j2) {
        this.j = j2;
        this.k = j;
        this.l = bArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.j);
        parcel.writeLong(this.k);
        parcel.writeByteArray(this.l);
    }

    public PrivateCommand(Parcel parcel, PrivateCommand$a privateCommand$a) {
        this.j = parcel.readLong();
        this.k = parcel.readLong();
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i = e0.a;
        this.l = bArrCreateByteArray;
    }
}
