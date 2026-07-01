package b.i.a.c.g3.z;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView$Renderer;
import android.opengl.Matrix;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.VisibleForTesting;
import b.i.a.c.f3.c0;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.GlUtil$a;
import java.nio.Buffer;
import java.util.Objects;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: SphericalGLSurfaceView.java */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public final class k$a implements GLSurfaceView$Renderer, l$a, g$a {
    public final j j;
    public final float[] m;
    public final float[] n;
    public final float[] o;
    public float p;
    public float q;
    public final /* synthetic */ k t;
    public final float[] k = new float[16];
    public final float[] l = new float[16];
    public final float[] r = new float[16];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float[] f1006s = new float[16];

    public k$a(k kVar, j jVar) {
        this.t = kVar;
        float[] fArr = new float[16];
        this.m = fArr;
        float[] fArr2 = new float[16];
        this.n = fArr2;
        float[] fArr3 = new float[16];
        this.o = fArr3;
        this.j = jVar;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setIdentityM(fArr3, 0);
        this.q = 3.1415927f;
    }

    @Override // b.i.a.c.g3.z.g$a
    @BinderThread
    public synchronized void a(float[] fArr, float f) {
        float[] fArr2 = this.m;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        this.q = -f;
        b();
    }

    @AnyThread
    public final void b() {
        Matrix.setRotateM(this.n, 0, -this.p, (float) Math.cos(this.q), (float) Math.sin(this.q), 0.0f);
    }

    @Override // android.opengl.GLSurfaceView$Renderer
    public void onDrawFrame(GL10 gl10) {
        float[] fArr;
        Long lD;
        synchronized (this) {
            Matrix.multiplyMM(this.f1006s, 0, this.m, 0, this.o, 0);
            Matrix.multiplyMM(this.r, 0, this.n, 0, this.f1006s, 0);
        }
        Matrix.multiplyMM(this.l, 0, this.k, 0, this.r, 0);
        j jVar = this.j;
        float[] fArr2 = this.l;
        Objects.requireNonNull(jVar);
        GLES20.glClear(16384);
        GlUtil.a();
        if (jVar.j.compareAndSet(true, false)) {
            SurfaceTexture surfaceTexture = jVar.f1004s;
            Objects.requireNonNull(surfaceTexture);
            surfaceTexture.updateTexImage();
            GlUtil.a();
            if (jVar.k.compareAndSet(true, false)) {
                Matrix.setIdentityM(jVar.p, 0);
            }
            long timestamp = jVar.f1004s.getTimestamp();
            c0<Long> c0Var = jVar.n;
            synchronized (c0Var) {
                lD = c0Var.d(timestamp, false);
            }
            Long l = lD;
            if (l != null) {
                f fVar = jVar.m;
                float[] fArr3 = jVar.p;
                float[] fArrE = fVar.c.e(l.longValue());
                if (fArrE != null) {
                    float[] fArr4 = fVar.f998b;
                    float f = fArrE[0];
                    float f2 = -fArrE[1];
                    float f3 = -fArrE[2];
                    float length = Matrix.length(f, f2, f3);
                    if (length != 0.0f) {
                        Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f / length, f2 / length, f3 / length);
                    } else {
                        Matrix.setIdentityM(fArr4, 0);
                    }
                    if (!fVar.d) {
                        f.a(fVar.a, fVar.f998b);
                        fVar.d = true;
                    }
                    Matrix.multiplyMM(fArr3, 0, fVar.a, 0, fVar.f998b, 0);
                }
            }
            h hVarE = jVar.o.e(timestamp);
            if (hVarE != null) {
                i iVar = jVar.l;
                Objects.requireNonNull(iVar);
                if (i.a(hVarE)) {
                    iVar.h = hVarE.c;
                    i$a i_a = new i$a(hVarE.a.a[0]);
                    iVar.i = i_a;
                    if (!hVarE.d) {
                        i_a = new i$a(hVarE.f1000b.a[0]);
                    }
                    iVar.j = i_a;
                }
            }
        }
        Matrix.multiplyMM(jVar.q, 0, fArr2, 0, jVar.p, 0);
        i iVar2 = jVar.l;
        int i = jVar.r;
        float[] fArr5 = jVar.q;
        i$a i_a2 = iVar2.i;
        if (i_a2 == null) {
            return;
        }
        GlUtil$a glUtil$a = iVar2.k;
        Objects.requireNonNull(glUtil$a);
        glUtil$a.c();
        GlUtil.a();
        GLES20.glEnableVertexAttribArray(iVar2.n);
        GLES20.glEnableVertexAttribArray(iVar2.o);
        GlUtil.a();
        int i2 = iVar2.h;
        if (i2 == 1) {
            fArr = i.d;
        } else {
            fArr = i2 == 2 ? i.f : i.c;
        }
        GLES20.glUniformMatrix3fv(iVar2.m, 1, false, fArr, 0);
        GLES20.glUniformMatrix4fv(iVar2.l, 1, false, fArr5, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(iVar2.p, 0);
        GlUtil.a();
        GLES20.glVertexAttribPointer(iVar2.n, 3, 5126, false, 12, (Buffer) i_a2.f1003b);
        GlUtil.a();
        GLES20.glVertexAttribPointer(iVar2.o, 2, 5126, false, 8, (Buffer) i_a2.c);
        GlUtil.a();
        GLES20.glDrawArrays(i_a2.d, 0, i_a2.a);
        GlUtil.a();
        GLES20.glDisableVertexAttribArray(iVar2.n);
        GLES20.glDisableVertexAttribArray(iVar2.o);
    }

    @Override // android.opengl.GLSurfaceView$Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        float f = i / i2;
        Matrix.perspectiveM(this.k, 0, f > 1.0f ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f))) * 2.0d) : 90.0f, f, 0.1f, 100.0f);
    }

    @Override // android.opengl.GLSurfaceView$Renderer
    public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        k kVar = this.t;
        kVar.n.post(new b(kVar, this.j.b()));
    }
}
