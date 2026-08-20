package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import com.discord.api.permission.Permission;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.x2.a */
/* JADX INFO: compiled from: BinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2999a {

    /* JADX INFO: renamed from: a */
    public final a f8030a;

    /* JADX INFO: renamed from: b */
    public final f f8031b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public c f8032c;

    /* JADX INFO: renamed from: d */
    public final int f8033d;

    /* JADX INFO: renamed from: b.i.a.c.x2.a$a */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public static class a implements InterfaceC3119t {

        /* JADX INFO: renamed from: a */
        public final d f8034a;

        /* JADX INFO: renamed from: b */
        public final long f8035b;

        /* JADX INFO: renamed from: c */
        public final long f8036c;

        /* JADX INFO: renamed from: d */
        public final long f8037d;

        /* JADX INFO: renamed from: e */
        public final long f8038e;

        /* JADX INFO: renamed from: f */
        public final long f8039f;

        /* JADX INFO: renamed from: g */
        public final long f8040g;

        public a(d dVar, long j, long j2, long j3, long j4, long j5, long j6) {
            this.f8034a = dVar;
            this.f8035b = j;
            this.f8036c = j2;
            this.f8037d = j3;
            this.f8038e = j4;
            this.f8039f = j5;
            this.f8040g = j6;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: c */
        public boolean mo3619c() {
            return true;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: h */
        public InterfaceC3119t.a mo3620h(long j) {
            return new InterfaceC3119t.a(new C3120u(j, c.m3623a(this.f8034a.mo3622a(j), this.f8036c, this.f8037d, this.f8038e, this.f8039f, this.f8040g)));
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: i */
        public long mo3621i() {
            return this.f8035b;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.a$b */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public static final class b implements d {
        @Override // p007b.p225i.p226a.p242c.p267x2.AbstractC2999a.d
        /* JADX INFO: renamed from: a */
        public long mo3622a(long j) {
            return j;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.a$c */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public static class c {

        /* JADX INFO: renamed from: a */
        public final long f8041a;

        /* JADX INFO: renamed from: b */
        public final long f8042b;

        /* JADX INFO: renamed from: c */
        public final long f8043c;

        /* JADX INFO: renamed from: d */
        public long f8044d;

        /* JADX INFO: renamed from: e */
        public long f8045e;

        /* JADX INFO: renamed from: f */
        public long f8046f;

        /* JADX INFO: renamed from: g */
        public long f8047g;

        /* JADX INFO: renamed from: h */
        public long f8048h;

        public c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f8041a = j;
            this.f8042b = j2;
            this.f8044d = j3;
            this.f8045e = j4;
            this.f8046f = j5;
            this.f8047g = j6;
            this.f8043c = j7;
            this.f8048h = m3623a(j2, j3, j4, j5, j6, j7);
        }

        /* JADX INFO: renamed from: a */
        public static long m3623a(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
            return C2738e0.m3001i(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.a$d */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public interface d {
        /* JADX INFO: renamed from: a */
        long mo3622a(long j);
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.a$e */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public static final class e {

        /* JADX INFO: renamed from: a */
        public static final e f8049a = new e(-3, -9223372036854775807L, -1);

        /* JADX INFO: renamed from: b */
        public final int f8050b;

        /* JADX INFO: renamed from: c */
        public final long f8051c;

        /* JADX INFO: renamed from: d */
        public final long f8052d;

        public e(int i, long j, long j2) {
            this.f8050b = i;
            this.f8051c = j;
            this.f8052d = j2;
        }

        /* JADX INFO: renamed from: a */
        public static e m3624a(long j, long j2) {
            return new e(-1, j, j2);
        }

        /* JADX INFO: renamed from: b */
        public static e m3625b(long j) {
            return new e(0, -9223372036854775807L, j);
        }

        /* JADX INFO: renamed from: c */
        public static e m3626c(long j, long j2) {
            return new e(-2, j, j2);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.a$f */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public interface f {
        /* JADX INFO: renamed from: a */
        void mo3627a();

        /* JADX INFO: renamed from: b */
        e mo3628b(InterfaceC3041i interfaceC3041i, long j) throws IOException;
    }

    public AbstractC2999a(d dVar, f fVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.f8031b = fVar;
        this.f8033d = i;
        this.f8030a = new a(dVar, j, j2, j3, j4, j5, j6);
    }

    /* JADX INFO: renamed from: a */
    public int m3613a(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        while (true) {
            c cVar = this.f8032c;
            C1460d.m438H(cVar);
            long j = cVar.f8046f;
            long j2 = cVar.f8047g;
            long j3 = cVar.f8048h;
            if (j2 - j <= this.f8033d) {
                m3615c(false, j);
                return m3616d(interfaceC3041i, j, c3118s);
            }
            if (!m3618f(interfaceC3041i, j3)) {
                return m3616d(interfaceC3041i, j3, c3118s);
            }
            interfaceC3041i.mo3649k();
            e eVarMo3628b = this.f8031b.mo3628b(interfaceC3041i, cVar.f8042b);
            int i = eVarMo3628b.f8050b;
            if (i == -3) {
                m3615c(false, j3);
                return m3616d(interfaceC3041i, j3, c3118s);
            }
            if (i == -2) {
                long j4 = eVarMo3628b.f8051c;
                long j5 = eVarMo3628b.f8052d;
                cVar.f8044d = j4;
                cVar.f8046f = j5;
                cVar.f8048h = c.m3623a(cVar.f8042b, j4, cVar.f8045e, j5, cVar.f8047g, cVar.f8043c);
            } else {
                if (i != -1) {
                    if (i != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    m3618f(interfaceC3041i, eVarMo3628b.f8052d);
                    m3615c(true, eVarMo3628b.f8052d);
                    return m3616d(interfaceC3041i, eVarMo3628b.f8052d, c3118s);
                }
                long j6 = eVarMo3628b.f8051c;
                long j7 = eVarMo3628b.f8052d;
                cVar.f8045e = j6;
                cVar.f8047g = j7;
                cVar.f8048h = c.m3623a(cVar.f8042b, cVar.f8044d, j6, cVar.f8046f, j7, cVar.f8043c);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3614b() {
        return this.f8032c != null;
    }

    /* JADX INFO: renamed from: c */
    public final void m3615c(boolean z2, long j) {
        this.f8032c = null;
        this.f8031b.mo3627a();
    }

    /* JADX INFO: renamed from: d */
    public final int m3616d(InterfaceC3041i interfaceC3041i, long j, C3118s c3118s) {
        if (j == interfaceC3041i.getPosition()) {
            return 0;
        }
        c3118s.f8992a = j;
        return 1;
    }

    /* JADX INFO: renamed from: e */
    public final void m3617e(long j) {
        c cVar = this.f8032c;
        if (cVar == null || cVar.f8041a != j) {
            long jMo3622a = this.f8030a.f8034a.mo3622a(j);
            a aVar = this.f8030a;
            this.f8032c = new c(j, jMo3622a, aVar.f8036c, aVar.f8037d, aVar.f8038e, aVar.f8039f, aVar.f8040g);
        }
    }

    /* JADX INFO: renamed from: f */
    public final boolean m3618f(InterfaceC3041i interfaceC3041i, long j) throws IOException {
        long position = j - interfaceC3041i.getPosition();
        if (position < 0 || position > Permission.USE_EXTERNAL_EMOJIS) {
            return false;
        }
        interfaceC3041i.mo3650l((int) position);
        return true;
    }
}
