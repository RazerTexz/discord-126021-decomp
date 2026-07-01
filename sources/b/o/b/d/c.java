package b.o.b.d;

import android.opengl.GLES20;
import b.o.b.c.f;
import d0.p;
import d0.z.d.m;

/* JADX INFO: compiled from: GlShader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final c$a a = new c$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1966b;

    public c(int i, String str) {
        m.checkNotNullParameter(str, "source");
        int iM105constructorimpl = p.m105constructorimpl(GLES20.glCreateShader(p.m105constructorimpl(i)));
        b.o.b.a.d.b(m.stringPlus("glCreateShader type=", Integer.valueOf(i)));
        GLES20.glShaderSource(iM105constructorimpl, str);
        GLES20.glCompileShader(iM105constructorimpl);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iM105constructorimpl, f.l, iArr, 0);
        if (iArr[0] != 0) {
            this.f1966b = iM105constructorimpl;
            return;
        }
        StringBuilder sbV = b.d.b.a.a.V("Could not compile shader ", i, ": '");
        sbV.append((Object) GLES20.glGetShaderInfoLog(iM105constructorimpl));
        sbV.append("' source: ");
        sbV.append(str);
        String string = sbV.toString();
        GLES20.glDeleteShader(iM105constructorimpl);
        throw new RuntimeException(string);
    }
}
