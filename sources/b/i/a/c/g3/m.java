package b.i.a.c.g3;

import androidx.annotation.Nullable;
import b.i.a.c.f3.u$c;
import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AvcConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public final List<byte[]> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f986b;
    public final int c;
    public final int d;
    public final float e;

    @Nullable
    public final String f;

    public m(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.a = list;
        this.f986b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
        this.f = str;
    }

    public static byte[] a(b.i.a.c.f3.x xVar) {
        int iY = xVar.y();
        int i = xVar.f984b;
        xVar.F(iY);
        byte[] bArr = xVar.a;
        byte[] bArr2 = b.i.a.c.f3.h.a;
        byte[] bArr3 = new byte[bArr2.length + iY];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, iY);
        return bArr3;
    }

    public static m b(b.i.a.c.f3.x xVar) throws ParserException {
        String strA;
        int i;
        int i2;
        float f;
        try {
            xVar.F(4);
            int iT = (xVar.t() & 3) + 1;
            if (iT == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iT2 = xVar.t() & 31;
            for (int i3 = 0; i3 < iT2; i3++) {
                arrayList.add(a(xVar));
            }
            int iT3 = xVar.t();
            for (int i4 = 0; i4 < iT3; i4++) {
                arrayList.add(a(xVar));
            }
            if (iT2 > 0) {
                u$c u_cE = b.i.a.c.f3.u.e((byte[]) arrayList.get(0), iT, ((byte[]) arrayList.get(0)).length);
                int i5 = u_cE.e;
                int i6 = u_cE.f;
                float f2 = u_cE.g;
                strA = b.i.a.c.f3.h.a(u_cE.a, u_cE.f981b, u_cE.c);
                i = i5;
                i2 = i6;
                f = f2;
            } else {
                strA = null;
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new m(arrayList, iT, i, i2, f, strA);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.a("Error parsing AVC config", e);
        }
    }
}
