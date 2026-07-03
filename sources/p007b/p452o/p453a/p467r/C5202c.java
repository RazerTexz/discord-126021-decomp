package p007b.p452o.p453a.p467r;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import p007b.p452o.p453a.p464o.C5185c;
import p007b.p452o.p453a.p464o.InterfaceC5184b;
import p007b.p452o.p475b.p476a.C5252d;
import p007b.p452o.p475b.p478c.C5261f;
import p007b.p452o.p475b.p479d.C5264c;
import p007b.p452o.p475b.p481f.C5269b;
import p507d0.C12117p;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.a.r.c */
/* JADX INFO: compiled from: GlTextureDrawer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5202c {

    /* JADX INFO: renamed from: a */
    public final C5269b f14105a;

    /* JADX INFO: renamed from: b */
    public float[] f14106b = (float[]) C5252d.f14263a.clone();

    /* JADX INFO: renamed from: c */
    @NonNull
    public InterfaceC5184b f14107c = new C5185c();

    /* JADX INFO: renamed from: d */
    public InterfaceC5184b f14108d = null;

    /* JADX INFO: renamed from: e */
    public int f14109e = -1;

    public C5202c(@NonNull C5269b c5269b) {
        this.f14105a = c5269b;
    }

    /* JADX INFO: renamed from: a */
    public void m7399a(long j) {
        if (this.f14108d != null) {
            m7400b();
            this.f14107c = this.f14108d;
            this.f14108d = null;
        }
        if (this.f14109e == -1) {
            String strMo7370c = this.f14107c.mo7370c();
            String strMo7375h = this.f14107c.mo7375h();
            C12238m.checkNotNullParameter(strMo7370c, "vertexShaderSource");
            C12238m.checkNotNullParameter(strMo7375h, "fragmentShaderSource");
            C5264c[] c5264cArr = {new C5264c(C5261f.f14304n, strMo7370c), new C5264c(C5261f.f14305o, strMo7375h)};
            C12238m.checkNotNullParameter(c5264cArr, "shaders");
            int iM11482constructorimpl = C12117p.m11482constructorimpl(GLES20.glCreateProgram());
            C5252d.m7457b("glCreateProgram");
            if (iM11482constructorimpl == 0) {
                throw new RuntimeException("Could not create program");
            }
            for (int i = 0; i < 2; i++) {
                GLES20.glAttachShader(iM11482constructorimpl, C12117p.m11482constructorimpl(c5264cArr[i].f14317b));
                C5252d.m7457b("glAttachShader");
            }
            GLES20.glLinkProgram(iM11482constructorimpl);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iM11482constructorimpl, C5261f.f14303m, iArr, 0);
            int i2 = iArr[0];
            int i3 = C5261f.f14291a;
            if (i2 != 1) {
                String strStringPlus = C12238m.stringPlus("Could not link program: ", GLES20.glGetProgramInfoLog(iM11482constructorimpl));
                GLES20.glDeleteProgram(iM11482constructorimpl);
                throw new RuntimeException(strStringPlus);
            }
            this.f14109e = iM11482constructorimpl;
            this.f14107c.mo7373j(iM11482constructorimpl);
            C5252d.m7457b("program creation");
        }
        GLES20.glUseProgram(this.f14109e);
        C5252d.m7457b("glUseProgram(handle)");
        this.f14105a.m7461a();
        this.f14107c.mo7371e(j, this.f14106b);
        this.f14105a.m7462b();
        GLES20.glUseProgram(0);
        C5252d.m7457b("glUseProgram(0)");
    }

    /* JADX INFO: renamed from: b */
    public void m7400b() {
        if (this.f14109e == -1) {
            return;
        }
        this.f14107c.mo7372f();
        GLES20.glDeleteProgram(this.f14109e);
        this.f14109e = -1;
    }
}
