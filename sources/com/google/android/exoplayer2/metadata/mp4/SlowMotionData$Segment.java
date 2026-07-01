package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.c.f3.e0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class SlowMotionData$Segment implements Parcelable {
    public static final Parcelable$Creator<SlowMotionData$Segment> CREATOR = new SlowMotionData$Segment$a();
    public final long j;
    public final long k;
    public final int l;

    public SlowMotionData$Segment(long j, long j2, int i) {
        d.j(j < j2);
        this.j = j;
        this.k = j2;
        this.l = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData$Segment.class != obj.getClass()) {
            return false;
        }
        SlowMotionData$Segment slowMotionData$Segment = (SlowMotionData$Segment) obj;
        return this.j == slowMotionData$Segment.j && this.k == slowMotionData$Segment.k && this.l == slowMotionData$Segment.l;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.j), Long.valueOf(this.k), Integer.valueOf(this.l)});
    }

    public String toString() {
        return e0.k("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.j), Long.valueOf(this.k), Integer.valueOf(this.l));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.j);
        parcel.writeLong(this.k);
        parcel.writeInt(this.l);
    }
}
