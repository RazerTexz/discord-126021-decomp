package b.i.a.c.c3;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AdaptiveTrackSelection.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f$a {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f896b;

    public f$a(long j, long j2) {
        this.a = j;
        this.f896b = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f$a)) {
            return false;
        }
        f$a f_a = (f$a) obj;
        return this.a == f_a.a && this.f896b == f_a.f896b;
    }

    public int hashCode() {
        return (((int) this.a) * 31) + ((int) this.f896b);
    }
}
