package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.c.x2.t */
/* JADX INFO: compiled from: SeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3119t {

    /* JADX INFO: renamed from: b.i.a.c.x2.t$b */
    /* JADX INFO: compiled from: SeekMap.java */
    public static class b implements InterfaceC3119t {

        /* JADX INFO: renamed from: a */
        public final long f8995a;

        /* JADX INFO: renamed from: b */
        public final a f8996b;

        public b(long j, long j2) {
            this.f8995a = j;
            this.f8996b = new a(j2 == 0 ? C3120u.f8997a : new C3120u(0L, j2));
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: c */
        public boolean mo3619c() {
            return false;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: h */
        public a mo3620h(long j) {
            return this.f8996b;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: i */
        public long mo3621i() {
            return this.f8995a;
        }
    }

    /* JADX INFO: renamed from: c */
    boolean mo3619c();

    /* JADX INFO: renamed from: h */
    a mo3620h(long j);

    /* JADX INFO: renamed from: i */
    long mo3621i();

    /* JADX INFO: renamed from: b.i.a.c.x2.t$a */
    /* JADX INFO: compiled from: SeekMap.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final C3120u f8993a;

        /* JADX INFO: renamed from: b */
        public final C3120u f8994b;

        public a(C3120u c3120u) {
            this.f8993a = c3120u;
            this.f8994b = c3120u;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8993a.equals(aVar.f8993a) && this.f8994b.equals(aVar.f8994b);
        }

        public int hashCode() {
            return this.f8994b.hashCode() + (this.f8993a.hashCode() * 31);
        }

        public String toString() {
            String strM857j;
            String strValueOf = String.valueOf(this.f8993a);
            if (this.f8993a.equals(this.f8994b)) {
                strM857j = "";
            } else {
                String strValueOf2 = String.valueOf(this.f8994b);
                strM857j = C1643a.m857j(strValueOf2.length() + 2, ", ", strValueOf2);
            }
            return C1643a.m861l(C1643a.m841b(strM857j, strValueOf.length() + 2), "[", strValueOf, strM857j, "]");
        }

        public a(C3120u c3120u, C3120u c3120u2) {
            this.f8993a = c3120u;
            this.f8994b = c3120u2;
        }
    }
}
