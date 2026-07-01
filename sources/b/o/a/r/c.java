package b.o.a.r;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import d0.p;
import d0.z.d.m;

/* JADX INFO: compiled from: GlTextureDrawer.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public final b.o.b.f.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f1950b = (float[]) b.o.b.a.d.a.clone();

    @NonNull
    public b.o.a.o.b c = new b.o.a.o.c();
    public b.o.a.o.b d = null;
    public int e = -1;

    public c(@NonNull b.o.b.f.b bVar) {
        this.a = bVar;
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
            m.checkNotNullParameter(strC, "vertexShaderSource");
            m.checkNotNullParameter(strH, "fragmentShaderSource");
            b.o.b.d.c[] cVarArr = {new b.o.b.d.c(b.o.b.c.f.n, strC), new b.o.b.d.c(b.o.b.c.f.o, strH)};
            m.checkNotNullParameter(cVarArr, "shaders");
            int iM105constructorimpl = p.m105constructorimpl(GLES20.glCreateProgram());
            b.o.b.a.d.b("glCreateProgram");
            if (iM105constructorimpl == 0) {
                throw new RuntimeException("Could not create program");
            }
            for (int i = 0; i < 2; i++) {
                GLES20.glAttachShader(iM105constructorimpl, p.m105constructorimpl(cVarArr[i].f1966b));
                b.o.b.a.d.b("glAttachShader");
            }
            GLES20.glLinkProgram(iM105constructorimpl);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iM105constructorimpl, b.o.b.c.f.m, iArr, 0);
            int i2 = iArr[0];
            int i3 = b.o.b.c.f.a;
            if (i2 != 1) {
                String strStringPlus = m.stringPlus("Could not link program: ", GLES20.glGetProgramInfoLog(iM105constructorimpl));
                GLES20.glDeleteProgram(iM105constructorimpl);
                throw new RuntimeException(strStringPlus);
            }
            this.e = iM105constructorimpl;
            this.c.j(iM105constructorimpl);
            b.o.b.a.d.b("program creation");
        }
        GLES20.glUseProgram(this.e);
        b.o.b.a.d.b("glUseProgram(handle)");
        this.a.a();
        this.c.e(j, this.f1950b);
        this.a.b();
        GLES20.glUseProgram(0);
        b.o.b.a.d.b("glUseProgram(0)");
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
