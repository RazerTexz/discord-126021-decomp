package b.i.a.c.g3;

import androidx.annotation.Nullable;
import b.i.a.c.f3.u$a;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: HevcConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public final List<byte[]> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f989b;
    public final float c;

    @Nullable
    public final String d;

    public q(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.a = list;
        this.f989b = i;
        this.c = f;
        this.d = str;
    }

    public static q a(b.i.a.c.f3.x xVar) throws ParserException {
        try {
            xVar.F(21);
            int iT = xVar.t() & 3;
            int iT2 = xVar.t();
            int i = xVar.f984b;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < iT2; i4++) {
                xVar.F(1);
                int iY = xVar.y();
                for (int i5 = 0; i5 < iY; i5++) {
                    int iY2 = xVar.y();
                    i3 += iY2 + 4;
                    xVar.F(iY2);
                }
            }
            xVar.E(i);
            byte[] bArr = new byte[i3];
            String strB = null;
            int i6 = 0;
            int i7 = 0;
            int i8 = -1;
            int i9 = -1;
            float f = 1.0f;
            while (i6 < iT2) {
                int iT3 = xVar.t() & Opcodes.LAND;
                int iY3 = xVar.y();
                int i10 = 0;
                while (i10 < iY3) {
                    int iY4 = xVar.y();
                    byte[] bArr2 = b.i.a.c.f3.u.a;
                    int i11 = iT2;
                    System.arraycopy(bArr2, i2, bArr, i7, bArr2.length);
                    int length = i7 + bArr2.length;
                    System.arraycopy(xVar.a, xVar.f984b, bArr, length, iY4);
                    if (iT3 == 33 && i10 == 0) {
                        u$a u_aC = b.i.a.c.f3.u.c(bArr, length, length + iY4);
                        int i12 = u_aC.g;
                        i9 = u_aC.h;
                        f = u_aC.i;
                        i8 = i12;
                        strB = b.i.a.c.f3.h.b(u_aC.a, u_aC.f979b, u_aC.c, u_aC.d, u_aC.e, u_aC.f);
                    }
                    i7 = length + iY4;
                    xVar.F(iY4);
                    i10++;
                    iT2 = i11;
                    iT3 = iT3;
                    iY3 = iY3;
                    i2 = 0;
                }
                i6++;
                i2 = 0;
            }
            return new q(i3 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iT + 1, i8, i9, f, strB);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.a("Error parsing HEVC config", e);
        }
    }
}
