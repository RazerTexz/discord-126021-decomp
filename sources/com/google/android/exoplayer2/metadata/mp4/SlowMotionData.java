package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.c.j1;
import b.i.a.c.p1$b;
import b.i.a.c.z2.a;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SlowMotionData implements Metadata$Entry {
    public static final Parcelable$Creator<SlowMotionData> CREATOR = new SlowMotionData$a();
    public final List<SlowMotionData$Segment> j;

    public SlowMotionData(List<SlowMotionData$Segment> list) {
        this.j = list;
        boolean z2 = false;
        if (!list.isEmpty()) {
            long j = list.get(0).k;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).j < j) {
                    z2 = true;
                    break;
                }
                j = list.get(i).k;
            }
        }
        d.j(!z2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.j.equals(((SlowMotionData) obj).j);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ void n(p1$b p1_b) {
        a.c(this, p1_b);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ byte[] o0() {
        return a.a(this);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.j);
        return b.d.b.a.a.j(strValueOf.length() + 21, "SlowMotion: segments=", strValueOf);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.j);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ j1 y() {
        return a.b(this);
    }
}
