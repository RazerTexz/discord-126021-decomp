package b.o.b.d;

import android.opengl.GLES20;
import b.d.b.a.outline;
import b.o.b.a.Egloo;
import b.o.b.c.gl;
import d0.UInt;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: b.o.b.d.c, reason: use source file name */
/* JADX INFO: compiled from: GlShader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GlShader2 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1966b;

    /* JADX INFO: renamed from: b.o.b.d.c$a */
    /* JADX INFO: compiled from: GlShader.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public GlShader2(int i, String str) {
        Intrinsics3.checkNotNullParameter(str, "source");
        int iM105constructorimpl = UInt.m105constructorimpl(GLES20.glCreateShader(UInt.m105constructorimpl(i)));
        Egloo.b(Intrinsics3.stringPlus("glCreateShader type=", Integer.valueOf(i)));
        GLES20.glShaderSource(iM105constructorimpl, str);
        GLES20.glCompileShader(iM105constructorimpl);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iM105constructorimpl, gl.l, iArr, 0);
        if (iArr[0] != 0) {
            this.f1966b = iM105constructorimpl;
            return;
        }
        StringBuilder sbV = outline.V("Could not compile shader ", i, ": '");
        sbV.append((Object) GLES20.glGetShaderInfoLog(iM105constructorimpl));
        sbV.append("' source: ");
        sbV.append(str);
        String string = sbV.toString();
        GLES20.glDeleteShader(iM105constructorimpl);
        throw new RuntimeException(string);
    }
}
