package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.io.IOException;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2736d0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.AbstractC2999a;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.f0 */
/* JADX INFO: compiled from: TsBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3081f0 extends AbstractC2999a {

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.f0$a */
    /* JADX INFO: compiled from: TsBinarySearchSeeker.java */
    public static final class a implements AbstractC2999a.f {

        /* JADX INFO: renamed from: a */
        public final C2736d0 f8607a;

        /* JADX INFO: renamed from: b */
        public final C2757x f8608b = new C2757x();

        /* JADX INFO: renamed from: c */
        public final int f8609c;

        /* JADX INFO: renamed from: d */
        public final int f8610d;

        public a(int i, C2736d0 c2736d0, int i2) {
            this.f8609c = i;
            this.f8607a = c2736d0;
            this.f8610d = i2;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.AbstractC2999a.f
        /* JADX INFO: renamed from: a */
        public void mo3627a() {
            this.f8608b.m3076B(C2738e0.f6713f);
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.AbstractC2999a.f
        /* JADX INFO: renamed from: b */
        public AbstractC2999a.e mo3628b(InterfaceC3041i interfaceC3041i, long j) throws IOException {
            long position = interfaceC3041i.getPosition();
            int iMin = (int) Math.min(this.f8610d, interfaceC3041i.mo3642b() - position);
            this.f8608b.m3075A(iMin);
            interfaceC3041i.mo3652o(this.f8608b.f6793a, 0, iMin);
            C2757x c2757x = this.f8608b;
            int i = c2757x.f6795c;
            long j2 = -1;
            long j3 = -1;
            long j4 = -9223372036854775807L;
            while (c2757x.m3081a() >= 188) {
                byte[] bArr = c2757x.f6793a;
                int i2 = c2757x.f6794b;
                while (i2 < i && bArr[i2] != 71) {
                    i2++;
                }
                int i3 = i2 + Opcodes.NEWARRAY;
                if (i3 > i) {
                    break;
                }
                long jM449K1 = C1460d.m449K1(c2757x, i2, this.f8609c);
                if (jM449K1 != -9223372036854775807L) {
                    long jM2973b = this.f8607a.m2973b(jM449K1);
                    if (jM2973b > j) {
                        return j4 == -9223372036854775807L ? AbstractC2999a.e.m3624a(jM2973b, position) : AbstractC2999a.e.m3625b(position + j3);
                    }
                    if (100000 + jM2973b > j) {
                        return AbstractC2999a.e.m3625b(position + ((long) i2));
                    }
                    j4 = jM2973b;
                    j3 = i2;
                }
                c2757x.m3079E(i3);
                j2 = i3;
            }
            return j4 != -9223372036854775807L ? AbstractC2999a.e.m3626c(j4, position + j2) : AbstractC2999a.e.f8049a;
        }
    }

    public C3081f0(C2736d0 c2736d0, long j, long j2, int i, int i2) {
        super(new AbstractC2999a.b(), new a(i, c2736d0, i2), j, 0L, j + 1, 0L, j2, 188L, 940);
    }
}
