package p007b.p452o.p475b.p479d;

import android.opengl.GLES20;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p452o.p475b.p476a.C5252d;
import p007b.p452o.p475b.p478c.C5261f;
import p507d0.C12117p;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.b.d.c */
/* JADX INFO: compiled from: GlShader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5264c {

    /* JADX INFO: renamed from: a */
    public static final a f14316a = new a(null);

    /* JADX INFO: renamed from: b */
    public final int f14317b;

    /* JADX INFO: renamed from: b.o.b.d.c$a */
    /* JADX INFO: compiled from: GlShader.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public C5264c(int i, String str) {
        C12238m.checkNotNullParameter(str, "source");
        int iM11482constructorimpl = C12117p.m11482constructorimpl(GLES20.glCreateShader(C12117p.m11482constructorimpl(i)));
        C5252d.m7457b(C12238m.stringPlus("glCreateShader type=", Integer.valueOf(i)));
        GLES20.glShaderSource(iM11482constructorimpl, str);
        GLES20.glCompileShader(iM11482constructorimpl);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iM11482constructorimpl, C5261f.f14302l, iArr, 0);
        if (iArr[0] != 0) {
            this.f14317b = iM11482constructorimpl;
            return;
        }
        StringBuilder sbM834V = C1643a.m834V("Could not compile shader ", i, ": '");
        sbM834V.append((Object) GLES20.glGetShaderInfoLog(iM11482constructorimpl));
        sbM834V.append("' source: ");
        sbM834V.append(str);
        String string = sbM834V.toString();
        GLES20.glDeleteShader(iM11482constructorimpl);
        throw new RuntimeException(string);
    }
}
