package b.i.a.c.g3;

import android.content.Context;
import android.opengl.GLSurfaceView;

/* JADX INFO: compiled from: VideoDecoderGLSurfaceView.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends GLSurfaceView implements t {
    public final s$a j;

    public s(Context context) {
        super(context, null);
        s$a s_a = new s$a(this);
        this.j = s_a;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(s_a);
        setRenderMode(0);
    }

    @Deprecated
    public t getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(b.i.a.c.v2.i iVar) {
        s$a s_a = this.j;
        if (s_a.t.getAndSet(iVar) != null) {
            throw null;
        }
        s_a.o.requestRender();
    }
}
