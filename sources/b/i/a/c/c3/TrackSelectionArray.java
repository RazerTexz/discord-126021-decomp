package b.i.a.c.c3;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.c3.n, reason: use source file name */
/* JADX INFO: compiled from: TrackSelectionArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackSelectionArray {
    public final TrackSelection[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f904b;

    public TrackSelectionArray(TrackSelection... trackSelectionArr) {
        this.a = trackSelectionArr;
        int length = trackSelectionArr.length;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionArray.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((TrackSelectionArray) obj).a);
    }

    public int hashCode() {
        if (this.f904b == 0) {
            this.f904b = 527 + Arrays.hashCode(this.a);
        }
        return this.f904b;
    }
}
