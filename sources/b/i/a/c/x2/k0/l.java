package b.i.a.c.x2.k0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: DefaultTsPayloadReaderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements i0$c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j1> f1264b;

    public l(int i) {
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        b.i.b.b.p<Object> pVar = b.i.b.b.h0.l;
        this.a = i;
        this.f1264b = pVar;
    }

    @Override // b.i.a.c.x2.k0.i0$c
    @Nullable
    public i0 a(int i, i0$b i0_b) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new y(new v(i0_b.f1258b));
            }
            if (i == 21) {
                return new y(new t());
            }
            if (i == 27) {
                if (d(4)) {
                    return null;
                }
                return new y(new r(new e0(c(i0_b)), d(1), d(8)));
            }
            if (i == 36) {
                return new y(new s(new e0(c(i0_b))));
            }
            if (i == 89) {
                return new y(new n(i0_b.c));
            }
            if (i != 138) {
                if (i == 172) {
                    return new y(new i(i0_b.f1258b));
                }
                if (i == 257) {
                    return new d0(new x("application/vnd.dvb.ait"));
                }
                if (i == 134) {
                    if (d(16)) {
                        return null;
                    }
                    return new d0(new x("application/x-scte35"));
                }
                if (i != 135) {
                    switch (i) {
                        case 15:
                            if (d(2)) {
                                return null;
                            }
                            return new y(new k(false, i0_b.f1258b));
                        case 16:
                            return new y(new q(new j0(c(i0_b))));
                        case 17:
                            if (d(2)) {
                                return null;
                            }
                            return new y(new u(i0_b.f1258b));
                        default:
                            switch (i) {
                                case 128:
                                    break;
                                case Opcodes.LOR /* 129 */:
                                    break;
                                case 130:
                                    if (!d(64)) {
                                        return null;
                                    }
                                    break;
                                default:
                                    return null;
                            }
                            break;
                    }
                }
                return new y(new g(i0_b.f1258b));
            }
            return new y(new m(i0_b.f1258b));
        }
        return new y(new p(new j0(c(i0_b))));
    }

    public SparseArray<i0> b() {
        return new SparseArray<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final List<j1> c(i0$b i0_b) {
        String str;
        int i;
        if (d(32)) {
            return this.f1264b;
        }
        byte[] bArr = i0_b.d;
        int length = bArr.length;
        int i2 = 0;
        ArrayList arrayList = this.f1264b;
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
                    String str2 = new String(bArr, i7, 3, b.i.b.a.c.c);
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
                    b.c.a.a0.d.j(i14 >= 0 && i14 <= length);
                    List<byte[]> listSingletonList = null;
                    if (z3) {
                        listSingletonList = Collections.singletonList((b2 & 64) != 0 ? new byte[]{1} : new byte[]{0});
                    }
                    j1$b j1_b = new j1$b();
                    j1_b.k = str;
                    j1_b.c = str2;
                    j1_b.C = i;
                    j1_b.m = listSingletonList;
                    arrayList.add(j1_b.a());
                    i9++;
                    i7 = i14;
                }
            }
            if (i6 < 0 || i6 > length) {
                z2 = false;
            }
            b.c.a.a0.d.j(z2);
            i2 = i6;
            arrayList = arrayList;
        }
        return arrayList;
    }

    public final boolean d(int i) {
        return (i & this.a) != 0;
    }
}
