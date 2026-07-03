package p007b.p225i.p226a.p242c.p260g3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p242c.p259f3.C2741h;
import p007b.p225i.p226a.p242c.p259f3.C2754u;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: renamed from: b.i.a.c.g3.m */
/* JADX INFO: compiled from: AvcConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2776m {

    /* JADX INFO: renamed from: a */
    public final List<byte[]> f6837a;

    /* JADX INFO: renamed from: b */
    public final int f6838b;

    /* JADX INFO: renamed from: c */
    public final int f6839c;

    /* JADX INFO: renamed from: d */
    public final int f6840d;

    /* JADX INFO: renamed from: e */
    public final float f6841e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final String f6842f;

    public C2776m(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.f6837a = list;
        this.f6838b = i;
        this.f6839c = i2;
        this.f6840d = i3;
        this.f6841e = f;
        this.f6842f = str;
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m3121a(C2757x c2757x) {
        int iM3105y = c2757x.m3105y();
        int i = c2757x.f6794b;
        c2757x.m3080F(iM3105y);
        byte[] bArr = c2757x.f6793a;
        byte[] bArr2 = C2741h.f6721a;
        byte[] bArr3 = new byte[bArr2.length + iM3105y];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, iM3105y);
        return bArr3;
    }

    /* JADX INFO: renamed from: b */
    public static C2776m m3122b(C2757x c2757x) throws ParserException {
        String strM3022a;
        int i;
        int i2;
        float f;
        try {
            c2757x.m3080F(4);
            int iM3100t = (c2757x.m3100t() & 3) + 1;
            if (iM3100t == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iM3100t2 = c2757x.m3100t() & 31;
            for (int i3 = 0; i3 < iM3100t2; i3++) {
                arrayList.add(m3121a(c2757x));
            }
            int iM3100t3 = c2757x.m3100t();
            for (int i4 = 0; i4 < iM3100t3; i4++) {
                arrayList.add(m3121a(c2757x));
            }
            if (iM3100t2 > 0) {
                C2754u.c cVarM3058e = C2754u.m3058e((byte[]) arrayList.get(0), iM3100t, ((byte[]) arrayList.get(0)).length);
                int i5 = cVarM3058e.f6773e;
                int i6 = cVarM3058e.f6774f;
                float f2 = cVarM3058e.f6775g;
                strM3022a = C2741h.m3022a(cVarM3058e.f6769a, cVarM3058e.f6770b, cVarM3058e.f6771c);
                i = i5;
                i2 = i6;
                f = f2;
            } else {
                strM3022a = null;
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new C2776m(arrayList, iM3100t, i, i2, f, strM3022a);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.m8755a("Error parsing AVC config", e);
        }
    }
}
