package b.o.a.r;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import b.o.a.o.Filter2;
import b.o.a.o.NoFilter;
import b.o.b.a.Egloo;
import b.o.b.c.gl;
import b.o.b.d.GlShader2;
import b.o.b.f.GlTexture2;
import d0.UInt;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.o.a.r.c, reason: use source file name */
/* JADX INFO: compiled from: GlTextureDrawer.java */
/* JADX INFO: loaded from: classes3.dex */
public class GlTextureDrawer {
    public final GlTexture2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f1950b = (float[]) Egloo.a.clone();

    @NonNull
    public Filter2 c = new NoFilter();
    public Filter2 d = null;
    public int e = -1;

    public GlTextureDrawer(@NonNull GlTexture2 glTexture2) {
        this.a = glTexture2;
    }

    public void a(long j) {
        if (this.d != null) {
            b();
            this.c = this.d;
            this.d = null;
        }
        if (this.e == -1) {
            String strC = this.c.c();
            String strH = this.c.h();
            Intrinsics3.checkNotNullParameter(strC, "vertexShaderSource");
            Intrinsics3.checkNotNullParameter(strH, "fragmentShaderSource");
            GlShader2[] glShader2Arr = {new GlShader2(gl.n, strC), new GlShader2(gl.o, strH)};
            Intrinsics3.checkNotNullParameter(glShader2Arr, "shaders");
            int iM105constructorimpl = UInt.m105constructorimpl(GLES20.glCreateProgram());
            Egloo.b("glCreateProgram");
            if (iM105constructorimpl == 0) {
                throw new RuntimeException("Could not create program");
            }
            for (int i = 0; i < 2; i++) {
                GLES20.glAttachShader(iM105constructorimpl, UInt.m105constructorimpl(glShader2Arr[i].f1966b));
                Egloo.b("glAttachShader");
            }
            GLES20.glLinkProgram(iM105constructorimpl);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iM105constructorimpl, gl.m, iArr, 0);
            int i2 = iArr[0];
            int i3 = gl.a;
            if (i2 != 1) {
                String strStringPlus = Intrinsics3.stringPlus("Could not link program: ", GLES20.glGetProgramInfoLog(iM105constructorimpl));
                GLES20.glDeleteProgram(iM105constructorimpl);
                throw new RuntimeException(strStringPlus);
            }
            this.e = iM105constructorimpl;
            this.c.j(iM105constructorimpl);
            Egloo.b("program creation");
        }
        GLES20.glUseProgram(this.e);
        Egloo.b("glUseProgram(handle)");
        this.a.a();
        this.c.e(j, this.f1950b);
        this.a.b();
        GLES20.glUseProgram(0);
        Egloo.b("glUseProgram(0)");
    }

    public void b() {
        if (this.e == -1) {
            return;
        }
        this.c.f();
        GLES20.glDeleteProgram(this.e);
        this.e = -1;
    }
}
