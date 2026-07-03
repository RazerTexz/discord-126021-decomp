package p007b.p225i.p226a.p242c.p267x2.p269d0;

import com.discord.api.permission.Permission;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.AbstractC2999a;
import p007b.p225i.p226a.p242c.p267x2.C3001b;
import p007b.p225i.p226a.p242c.p267x2.C3112m;
import p007b.p225i.p226a.p242c.p267x2.C3114o;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;

/* JADX INFO: renamed from: b.i.a.c.x2.d0.c */
/* JADX INFO: compiled from: FlacBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3009c extends AbstractC2999a {

    /* JADX INFO: renamed from: b.i.a.c.x2.d0.c$b */
    /* JADX INFO: compiled from: FlacBinarySearchSeeker.java */
    public static final class b implements AbstractC2999a.f {

        /* JADX INFO: renamed from: a */
        public final C3114o f8097a;

        /* JADX INFO: renamed from: b */
        public final int f8098b;

        /* JADX INFO: renamed from: c */
        public final C3112m.a f8099c = new C3112m.a();

        public b(C3114o c3114o, int i, a aVar) {
            this.f8097a = c3114o;
            this.f8098b = i;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.AbstractC2999a.f
        /* JADX INFO: renamed from: a */
        public /* synthetic */ void mo3627a() {
            C3001b.m3629a(this);
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.AbstractC2999a.f
        /* JADX INFO: renamed from: b */
        public AbstractC2999a.e mo3628b(InterfaceC3041i interfaceC3041i, long j) throws IOException {
            long position = interfaceC3041i.getPosition();
            long jM3640c = m3640c(interfaceC3041i);
            long jMo3645f = interfaceC3041i.mo3645f();
            interfaceC3041i.mo3646g(Math.max(6, this.f8097a.f8972c));
            long jM3640c2 = m3640c(interfaceC3041i);
            long jMo3645f2 = interfaceC3041i.mo3645f();
            if (jM3640c > j || jM3640c2 <= j) {
                return jM3640c2 <= j ? AbstractC2999a.e.m3626c(jM3640c2, jMo3645f2) : AbstractC2999a.e.m3624a(jM3640c, position);
            }
            return AbstractC2999a.e.m3625b(jMo3645f);
        }

        /* JADX INFO: renamed from: c */
        public final long m3640c(InterfaceC3041i interfaceC3041i) throws IOException {
            while (interfaceC3041i.mo3645f() < interfaceC3041i.mo3642b() - 6) {
                C3114o c3114o = this.f8097a;
                int i = this.f8098b;
                C3112m.a aVar = this.f8099c;
                long jMo3645f = interfaceC3041i.mo3645f();
                byte[] bArr = new byte[2];
                boolean zM3803b = false;
                interfaceC3041i.mo3652o(bArr, 0, 2);
                if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                    interfaceC3041i.mo3649k();
                    interfaceC3041i.mo3646g((int) (jMo3645f - interfaceC3041i.getPosition()));
                } else {
                    C2757x c2757x = new C2757x(16);
                    System.arraycopy(bArr, 0, c2757x.f6793a, 0, 2);
                    c2757x.m3078D(C1460d.m597z1(interfaceC3041i, c2757x.f6793a, 2, 14));
                    interfaceC3041i.mo3649k();
                    interfaceC3041i.mo3646g((int) (jMo3645f - interfaceC3041i.getPosition()));
                    zM3803b = C3112m.m3803b(c2757x, c3114o, i, aVar);
                }
                if (zM3803b) {
                    break;
                }
                interfaceC3041i.mo3646g(1);
            }
            if (interfaceC3041i.mo3645f() < interfaceC3041i.mo3642b() - 6) {
                return this.f8099c.f8967a;
            }
            interfaceC3041i.mo3646g((int) (interfaceC3041i.mo3642b() - interfaceC3041i.mo3645f()));
            return this.f8097a.f8979j;
        }
    }

    public C3009c(final C3114o c3114o, int i, long j, long j2) {
        long j3;
        long j4;
        Objects.requireNonNull(c3114o);
        AbstractC2999a.d dVar = new AbstractC2999a.d() { // from class: b.i.a.c.x2.d0.b
            @Override // p007b.p225i.p226a.p242c.p267x2.AbstractC2999a.d
            /* JADX INFO: renamed from: a */
            public final long mo3622a(long j5) {
                return c3114o.m3813g(j5);
            }
        };
        b bVar = new b(c3114o, i, null);
        long jM3810d = c3114o.m3810d();
        long j5 = c3114o.f8979j;
        int i2 = c3114o.f8973d;
        if (i2 > 0) {
            j3 = (((long) i2) + ((long) c3114o.f8972c)) / 2;
            j4 = 1;
        } else {
            int i3 = c3114o.f8970a;
            j3 = ((((i3 != c3114o.f8971b || i3 <= 0) ? Permission.SEND_TTS_MESSAGES : i3) * ((long) c3114o.f8976g)) * ((long) c3114o.f8977h)) / 8;
            j4 = 64;
        }
        super(dVar, bVar, jM3810d, 0L, j5, j, j2, j3 + j4, Math.max(6, c3114o.f8972c));
    }
}
