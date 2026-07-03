package p007b.p225i.p226a.p242c.p260g3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p242c.p259f3.C2741h;
import p007b.p225i.p226a.p242c.p259f3.C2754u;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: renamed from: b.i.a.c.g3.q */
/* JADX INFO: compiled from: HevcConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2780q {

    /* JADX INFO: renamed from: a */
    public final List<byte[]> f6863a;

    /* JADX INFO: renamed from: b */
    public final int f6864b;

    /* JADX INFO: renamed from: c */
    public final float f6865c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final String f6866d;

    public C2780q(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.f6863a = list;
        this.f6864b = i;
        this.f6865c = f;
        this.f6866d = str;
    }

    /* JADX INFO: renamed from: a */
    public static C2780q m3131a(C2757x c2757x) throws ParserException {
        try {
            c2757x.m3080F(21);
            int iM3100t = c2757x.m3100t() & 3;
            int iM3100t2 = c2757x.m3100t();
            int i = c2757x.f6794b;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < iM3100t2; i4++) {
                c2757x.m3080F(1);
                int iM3105y = c2757x.m3105y();
                for (int i5 = 0; i5 < iM3105y; i5++) {
                    int iM3105y2 = c2757x.m3105y();
                    i3 += iM3105y2 + 4;
                    c2757x.m3080F(iM3105y2);
                }
            }
            c2757x.m3079E(i);
            byte[] bArr = new byte[i3];
            String strM3023b = null;
            int i6 = 0;
            int i7 = 0;
            int i8 = -1;
            int i9 = -1;
            float f = 1.0f;
            while (i6 < iM3100t2) {
                int iM3100t3 = c2757x.m3100t() & Opcodes.LAND;
                int iM3105y3 = c2757x.m3105y();
                int i10 = 0;
                while (i10 < iM3105y3) {
                    int iM3105y4 = c2757x.m3105y();
                    byte[] bArr2 = C2754u.f6753a;
                    int i11 = iM3100t2;
                    System.arraycopy(bArr2, i2, bArr, i7, bArr2.length);
                    int length = i7 + bArr2.length;
                    System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, length, iM3105y4);
                    if (iM3100t3 == 33 && i10 == 0) {
                        C2754u.a aVarM3056c = C2754u.m3056c(bArr, length, length + iM3105y4);
                        int i12 = aVarM3056c.f6763g;
                        i9 = aVarM3056c.f6764h;
                        f = aVarM3056c.f6765i;
                        i8 = i12;
                        strM3023b = C2741h.m3023b(aVarM3056c.f6757a, aVarM3056c.f6758b, aVarM3056c.f6759c, aVarM3056c.f6760d, aVarM3056c.f6761e, aVarM3056c.f6762f);
                    }
                    i7 = length + iM3105y4;
                    c2757x.m3080F(iM3105y4);
                    i10++;
                    iM3100t2 = i11;
                    iM3100t3 = iM3100t3;
                    iM3105y3 = iM3105y3;
                    i2 = 0;
                }
                i6++;
                i2 = 0;
            }
            return new C2780q(i3 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iM3100t + 1, i8, i9, f, strM3023b);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.m8755a("Error parsing HEVC config", e);
        }
    }
}
