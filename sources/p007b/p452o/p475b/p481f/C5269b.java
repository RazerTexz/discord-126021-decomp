package p007b.p452o.p475b.p481f;

import android.opengl.GLES20;
import p007b.p452o.p475b.p476a.C5252d;
import p007b.p452o.p475b.p478c.C5261f;
import p507d0.C12117p;
import p507d0.C12118q;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.b.f.b */
/* JADX INFO: compiled from: GlTexture.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5269b {

    /* JADX INFO: renamed from: a */
    public final int f14331a;

    /* JADX INFO: renamed from: b */
    public final int f14332b;

    /* JADX INFO: renamed from: c */
    public final Integer f14333c;

    /* JADX INFO: renamed from: d */
    public final Integer f14334d;

    /* JADX INFO: renamed from: e */
    public final Integer f14335e;

    /* JADX INFO: renamed from: f */
    public final Integer f14336f;

    /* JADX INFO: renamed from: g */
    public final int f14337g;

    public C5269b(int i, int i2, Integer num) {
        int iIntValue;
        this.f14331a = i;
        this.f14332b = i2;
        this.f14333c = null;
        this.f14334d = null;
        this.f14335e = null;
        this.f14336f = null;
        if (num == null) {
            int[] iArrM11483constructorimpl = C12118q.m11483constructorimpl(1);
            int iM11486getSizeimpl = C12118q.m11486getSizeimpl(iArrM11483constructorimpl);
            int[] iArr = new int[iM11486getSizeimpl];
            for (int i3 = 0; i3 < iM11486getSizeimpl; i3++) {
                iArr[i3] = C12118q.m11485getpVg5ArA(iArrM11483constructorimpl, i3);
            }
            GLES20.glGenTextures(1, iArr, 0);
            C12118q.m11487setVXSXFK8(iArrM11483constructorimpl, 0, C12117p.m11482constructorimpl(iArr[0]));
            C5252d.m7457b("glGenTextures");
            iIntValue = C12118q.m11485getpVg5ArA(iArrM11483constructorimpl, 0);
        } else {
            iIntValue = num.intValue();
        }
        this.f14337g = iIntValue;
        if (num == null) {
            C5268a c5268a = new C5268a(this, null);
            C12238m.checkNotNullParameter(this, "<this>");
            C12238m.checkNotNullParameter(c5268a, "block");
            m7461a();
            c5268a.invoke();
            m7462b();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m7461a() {
        GLES20.glActiveTexture(C12117p.m11482constructorimpl(this.f14331a));
        GLES20.glBindTexture(C12117p.m11482constructorimpl(this.f14332b), C12117p.m11482constructorimpl(this.f14337g));
        C5252d.m7457b("bind");
    }

    /* JADX INFO: renamed from: b */
    public void m7462b() {
        GLES20.glBindTexture(C12117p.m11482constructorimpl(this.f14332b), C12117p.m11482constructorimpl(0));
        GLES20.glActiveTexture(C5261f.f14293c);
        C5252d.m7457b("unbind");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C5269b(int i, int i2, Integer num, int i3) {
        this((i3 & 1) != 0 ? C5261f.f14293c : i, (i3 & 2) != 0 ? C5261f.f14294d : i2, null);
        int i4 = i3 & 4;
    }
}
