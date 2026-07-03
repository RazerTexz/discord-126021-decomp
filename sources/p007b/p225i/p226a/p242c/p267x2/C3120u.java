package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.c.x2.u */
/* JADX INFO: compiled from: SeekPoint.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3120u {

    /* JADX INFO: renamed from: a */
    public static final C3120u f8997a = new C3120u(0, 0);

    /* JADX INFO: renamed from: b */
    public final long f8998b;

    /* JADX INFO: renamed from: c */
    public final long f8999c;

    public C3120u(long j, long j2) {
        this.f8998b = j;
        this.f8999c = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3120u.class != obj.getClass()) {
            return false;
        }
        C3120u c3120u = (C3120u) obj;
        return this.f8998b == c3120u.f8998b && this.f8999c == c3120u.f8999c;
    }

    public int hashCode() {
        return (((int) this.f8998b) * 31) + ((int) this.f8999c);
    }

    public String toString() {
        long j = this.f8998b;
        return C1643a.m815C(C1643a.m830R(60, "[timeUs=", j, ", position="), this.f8999c, "]");
    }
}
