package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p355b.p356a.C4483c;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4508h0;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.l */
/* JADX INFO: compiled from: DefaultTsPayloadReaderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3091l implements InterfaceC3087i0.c {

    /* JADX INFO: renamed from: a */
    public final int f8721a;

    /* JADX INFO: renamed from: b */
    public final List<C2811j1> f8722b;

    public C3091l(int i) {
        AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
        AbstractC4523p<Object> abstractC4523p = C4508h0.f12012l;
        this.f8721a = i;
        this.f8722b = abstractC4523p;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0.c
    @Nullable
    /* JADX INFO: renamed from: a */
    public InterfaceC3087i0 mo3764a(int i, InterfaceC3087i0.b bVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new C3104y(new C3101v(bVar.f8677b));
            }
            if (i == 21) {
                return new C3104y(new C3099t());
            }
            if (i == 27) {
                if (m3777d(4)) {
                    return null;
                }
                return new C3104y(new C3097r(new C3079e0(m3776c(bVar)), m3777d(1), m3777d(8)));
            }
            if (i == 36) {
                return new C3104y(new C3098s(new C3079e0(m3776c(bVar))));
            }
            if (i == 89) {
                return new C3104y(new C3093n(bVar.f8678c));
            }
            if (i != 138) {
                if (i == 172) {
                    return new C3104y(new C3086i(bVar.f8677b));
                }
                if (i == 257) {
                    return new C3077d0(new C3103x("application/vnd.dvb.ait"));
                }
                if (i == 134) {
                    if (m3777d(16)) {
                        return null;
                    }
                    return new C3077d0(new C3103x("application/x-scte35"));
                }
                if (i != 135) {
                    switch (i) {
                        case 15:
                            if (m3777d(2)) {
                                return null;
                            }
                            return new C3104y(new C3090k(false, bVar.f8677b));
                        case 16:
                            return new C3104y(new C3096q(new C3089j0(m3776c(bVar))));
                        case 17:
                            if (m3777d(2)) {
                                return null;
                            }
                            return new C3104y(new C3100u(bVar.f8677b));
                        default:
                            switch (i) {
                                case 128:
                                    break;
                                case Opcodes.LOR /* 129 */:
                                    break;
                                case 130:
                                    if (!m3777d(64)) {
                                        return null;
                                    }
                                    break;
                                default:
                                    return null;
                            }
                            break;
                    }
                }
                return new C3104y(new C3082g(bVar.f8677b));
            }
            return new C3104y(new C3092m(bVar.f8677b));
        }
        return new C3104y(new C3095p(new C3089j0(m3776c(bVar))));
    }

    /* JADX INFO: renamed from: b */
    public SparseArray<InterfaceC3087i0> m3775b() {
        return new SparseArray<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX INFO: renamed from: c */
    public final List<C2811j1> m3776c(InterfaceC3087i0.b bVar) {
        String str;
        int i;
        if (m3777d(32)) {
            return this.f8722b;
        }
        byte[] bArr = bVar.f8679d;
        int length = bArr.length;
        int i2 = 0;
        ArrayList arrayList = this.f8722b;
        while (length - i2 > 0) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            int i5 = i3 + 1;
            int i6 = (bArr[i3] & 255) + i5;
            boolean z2 = true;
            if (i4 == 134) {
                arrayList = new ArrayList();
                int i7 = i5 + 1;
                int i8 = bArr[i5] & 255 & 31;
                int i9 = 0;
                while (i9 < i8) {
                    String str2 = new String(bArr, i7, 3, C4483c.f11945c);
                    int i10 = i7 + 3;
                    int i11 = i10 + 1;
                    int i12 = bArr[i10] & 255;
                    boolean z3 = (i12 & 128) != 0;
                    if (z3) {
                        i = i12 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    int i13 = i11 + 1;
                    byte b2 = (byte) (bArr[i11] & 255);
                    int i14 = i13 + 1;
                    C1460d.m531j(i14 >= 0 && i14 <= length);
                    List<byte[]> listSingletonList = null;
                    if (z3) {
                        listSingletonList = Collections.singletonList((b2 & 64) != 0 ? new byte[]{1} : new byte[]{0});
                    }
                    C2811j1.b bVar2 = new C2811j1.b();
                    bVar2.f7173k = str;
                    bVar2.f7165c = str2;
                    bVar2.f7161C = i;
                    bVar2.f7175m = listSingletonList;
                    arrayList.add(bVar2.m3277a());
                    i9++;
                    i7 = i14;
                }
            }
            if (i6 < 0 || i6 > length) {
                z2 = false;
            }
            C1460d.m531j(z2);
            i2 = i6;
            arrayList = arrayList;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m3777d(int i) {
        return (i & this.f8721a) != 0;
    }
}
