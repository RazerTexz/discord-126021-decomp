package b.i.a.c.a3;

import androidx.annotation.Nullable;
import b.i.a.c.Bundleable;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.a3.o0, reason: use source file name */
/* JADX INFO: compiled from: TrackGroupArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackGroupArray implements Bundleable {
    public static final TrackGroupArray j = new TrackGroupArray(new TrackGroup[0]);
    public final int k;
    public final TrackGroup[] l;
    public int m;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.l = trackGroupArr;
        this.k = trackGroupArr.length;
    }

    public int a(TrackGroup trackGroup) {
        for (int i = 0; i < this.k; i++) {
            if (this.l[i] == trackGroup) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.k == trackGroupArray.k && Arrays.equals(this.l, trackGroupArray.l);
    }

    public int hashCode() {
        if (this.m == 0) {
            this.m = Arrays.hashCode(this.l);
        }
        return this.m;
    }
}
