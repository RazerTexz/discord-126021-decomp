package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import b.i.a.c.f3.Util2;

/* JADX INFO: loaded from: classes3.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new a();
    public final long j;
    public final long k;
    public final byte[] l;

    public class a implements Parcelable.Creator<PrivateCommand> {
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

    public PrivateCommand(Parcel parcel, a aVar) {
        this.j = parcel.readLong();
        this.k = parcel.readLong();
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i = Util2.a;
        this.l = bArrCreateByteArray;
    }
}
