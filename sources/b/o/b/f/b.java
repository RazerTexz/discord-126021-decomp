package b.o.b.f;

import android.opengl.GLES20;
import b.o.b.a.d;
import b.o.b.c.f;
import d0.p;
import d0.q;
import d0.z.d.m;

/* JADX INFO: compiled from: GlTexture.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1968b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final int g;

    public b(int i, int i2, Integer num) {
        int iIntValue;
        this.a = i;
        this.f1968b = i2;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        if (num == null) {
            int[] iArrM106constructorimpl = q.m106constructorimpl(1);
            int iM109getSizeimpl = q.m109getSizeimpl(iArrM106constructorimpl);
            int[] iArr = new int[iM109getSizeimpl];
            for (int i3 = 0; i3 < iM109getSizeimpl; i3++) {
                iArr[i3] = q.m108getpVg5ArA(iArrM106constructorimpl, i3);
            }
            GLES20.glGenTextures(1, iArr, 0);
            q.m110setVXSXFK8(iArrM106constructorimpl, 0, p.m105constructorimpl(iArr[0]));
            d.b("glGenTextures");
            iIntValue = q.m108getpVg5ArA(iArrM106constructorimpl, 0);
        } else {
            iIntValue = num.intValue();
        }
        this.g = iIntValue;
        if (num == null) {
            a aVar = new a(this, null);
            m.checkNotNullParameter(this, "<this>");
            m.checkNotNullParameter(aVar, "block");
            a();
            aVar.invoke();
            b();
        }
    }

    public void a() {
        GLES20.glActiveTexture(p.m105constructorimpl(this.a));
        GLES20.glBindTexture(p.m105constructorimpl(this.f1968b), p.m105constructorimpl(this.g));
        d.b("bind");
    }

    public void b() {
        GLES20.glBindTexture(p.m105constructorimpl(this.f1968b), p.m105constructorimpl(0));
        GLES20.glActiveTexture(f.c);
        d.b("unbind");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(int i, int i2, Integer num, int i3) {
        this((i3 & 1) != 0 ? f.c : i, (i3 & 2) != 0 ? f.d : i2, null);
        int i4 = i3 & 4;
    }
}
