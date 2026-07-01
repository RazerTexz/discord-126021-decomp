package b.o.b.f;

import android.opengl.GLES20;
import b.o.b.a.Egloo;
import b.o.b.c.gl;
import d0.UInt;
import d0.UIntArray;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.f.b, reason: use source file name */
/* JADX INFO: compiled from: GlTexture.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GlTexture2 {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1968b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final int g;

    public GlTexture2(int i, int i2, Integer num) {
        int iIntValue;
        this.a = i;
        this.f1968b = i2;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        if (num == null) {
            int[] iArrM106constructorimpl = UIntArray.m106constructorimpl(1);
            int iM109getSizeimpl = UIntArray.m109getSizeimpl(iArrM106constructorimpl);
            int[] iArr = new int[iM109getSizeimpl];
            for (int i3 = 0; i3 < iM109getSizeimpl; i3++) {
                iArr[i3] = UIntArray.m108getpVg5ArA(iArrM106constructorimpl, i3);
            }
            GLES20.glGenTextures(1, iArr, 0);
            UIntArray.m110setVXSXFK8(iArrM106constructorimpl, 0, UInt.m105constructorimpl(iArr[0]));
            Egloo.b("glGenTextures");
            iIntValue = UIntArray.m108getpVg5ArA(iArrM106constructorimpl, 0);
        } else {
            iIntValue = num.intValue();
        }
        this.g = iIntValue;
        if (num == null) {
            GlTexture glTexture = new GlTexture(this, null);
            Intrinsics3.checkNotNullParameter(this, "<this>");
            Intrinsics3.checkNotNullParameter(glTexture, "block");
            a();
            glTexture.invoke();
            b();
        }
    }

    public void a() {
        GLES20.glActiveTexture(UInt.m105constructorimpl(this.a));
        GLES20.glBindTexture(UInt.m105constructorimpl(this.f1968b), UInt.m105constructorimpl(this.g));
        Egloo.b("bind");
    }

    public void b() {
        GLES20.glBindTexture(UInt.m105constructorimpl(this.f1968b), UInt.m105constructorimpl(0));
        GLES20.glActiveTexture(gl.c);
        Egloo.b("unbind");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlTexture2(int i, int i2, Integer num, int i3) {
        this((i3 & 1) != 0 ? gl.c : i, (i3 & 2) != 0 ? gl.d : i2, null);
        int i4 = i3 & 4;
    }
}
