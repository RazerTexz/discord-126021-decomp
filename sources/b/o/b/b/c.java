package b.o.b.b;

import android.opengl.GLES20;
import b.i.a.f.e.o.f;
import b.o.b.a.d;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: GlRect.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c extends a {

    @Deprecated
    public static final float[] c = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public FloatBuffer d;

    public c() {
        float[] fArr = c;
        FloatBuffer floatBufferX = f.X(fArr.length);
        floatBufferX.put(fArr);
        floatBufferX.clear();
        this.d = floatBufferX;
    }

    @Override // b.o.b.b.b
    public void a() {
        d.b("glDrawArrays start");
        GLES20.glDrawArrays(b.o.b.c.f.f1963b, 0, this.d.limit() / this.f1960b);
        d.b("glDrawArrays end");
    }

    @Override // b.o.b.b.b
    public FloatBuffer b() {
        return this.d;
    }
}
