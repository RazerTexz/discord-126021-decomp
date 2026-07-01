package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import b.i.a.c.f3.ParsableByteArray;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new a();
    public final long j;
    public final long k;

    public class a implements Parcelable.Creator<TimeSignalCommand> {
        @Override // android.os.Parcelable.Creator
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        public TimeSignalCommand[] newArray(int i) {
            return new TimeSignalCommand[i];
        }
    }

    public TimeSignalCommand(long j, long j2) {
        this.j = j;
        this.k = j2;
    }

    public static long a(ParsableByteArray parsableByteArray, long j) {
        long jT = parsableByteArray.t();
        if ((128 & jT) != 0) {
            return 8589934591L & ((((jT & 1) << 32) | parsableByteArray.u()) + j);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.j);
        parcel.writeLong(this.k);
    }

    public TimeSignalCommand(long j, long j2, a aVar) {
        this.j = j;
        this.k = j2;
    }
}
