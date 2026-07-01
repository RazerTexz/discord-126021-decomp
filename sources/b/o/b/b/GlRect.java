package b.o.b.b;

import android.opengl.GLES20;
import b.i.a.f.e.o.f;
import b.o.b.a.Egloo;
import b.o.b.c.gl;
import java.nio.FloatBuffer;

/* JADX INFO: renamed from: b.o.b.b.c, reason: use source file name */
/* JADX INFO: compiled from: GlRect.kt */
/* JADX INFO: loaded from: classes3.dex */
public class GlRect extends Gl2dDrawable {

    @Deprecated
    public static final float[] c = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public FloatBuffer d;

    public GlRect() {
        float[] fArr = c;
        FloatBuffer floatBufferX = f.X(fArr.length);
        floatBufferX.put(fArr);
        floatBufferX.clear();
        this.d = floatBufferX;
    }

    @Override // b.o.b.b.GlDrawable
    public void a() {
        Egloo.b("glDrawArrays start");
        GLES20.glDrawArrays(gl.f1963b, 0, this.d.limit() / this.f1960b);
        Egloo.b("glDrawArrays end");
    }

    @Override // b.o.b.b.GlDrawable
    public FloatBuffer b() {
        return this.d;
    }
}
