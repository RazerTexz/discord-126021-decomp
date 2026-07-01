package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.i.a.c.f3.x;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable$Creator<TimeSignalCommand> CREATOR = new TimeSignalCommand$a();
    public final long j;
    public final long k;

    public TimeSignalCommand(long j, long j2) {
        this.j = j;
        this.k = j2;
    }

    public static long a(x xVar, long j) {
        long jT = xVar.t();
        if ((128 & jT) != 0) {
            return 8589934591L & ((((jT & 1) << 32) | xVar.u()) + j);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.j);
        parcel.writeLong(this.k);
    }

    public TimeSignalCommand(long j, long j2, TimeSignalCommand$a timeSignalCommand$a) {
        this.j = j;
        this.k = j2;
    }
}
