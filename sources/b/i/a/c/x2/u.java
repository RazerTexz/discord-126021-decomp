package b.i.a.c.x2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SeekPoint.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public static final u a = new u(0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1298b;
    public final long c;

    public u(long j, long j2) {
        this.f1298b = j;
        this.c = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.f1298b == uVar.f1298b && this.c == uVar.c;
    }

    public int hashCode() {
        return (((int) this.f1298b) * 31) + ((int) this.c);
    }

    public String toString() {
        long j = this.f1298b;
        return b.d.b.a.a.C(b.d.b.a.a.R(60, "[timeUs=", j, ", position="), this.c, "]");
    }
}
