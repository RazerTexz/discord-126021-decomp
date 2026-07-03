package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new C10749a();

    /* JADX INFO: renamed from: j */
    public final long f20052j;

    /* JADX INFO: renamed from: k */
    public final long f20053k;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand$a */
    public class C10749a implements Parcelable.Creator<TimeSignalCommand> {
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
        this.f20052j = j;
        this.f20053k = j2;
    }

    /* JADX INFO: renamed from: a */
    public static long m8883a(C2757x c2757x, long j) {
        long jM3100t = c2757x.m3100t();
        if ((128 & jM3100t) != 0) {
            return 8589934591L & ((((jM3100t & 1) << 32) | c2757x.m3101u()) + j);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f20052j);
        parcel.writeLong(this.f20053k);
    }

    public TimeSignalCommand(long j, long j2, C10749a c10749a) {
        this.f20052j = j;
        this.f20053k = j2;
    }
}
