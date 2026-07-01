package org.webrtc;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;

/* JADX INFO: loaded from: classes3.dex */
public class EglRenderer$EglSurfaceCreation implements Runnable {
    private Object surface;
    public final /* synthetic */ EglRenderer this$0;

    private EglRenderer$EglSurfaceCreation(EglRenderer eglRenderer) {
        this.this$0 = eglRenderer;
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        if (this.surface != null && EglRenderer.access$000(this.this$0) != null && !EglRenderer.access$000(this.this$0).hasSurface()) {
            Object obj = this.surface;
            if (obj instanceof Surface) {
                EglRenderer.access$000(this.this$0).createSurface((Surface) this.surface);
            } else {
                if (!(obj instanceof SurfaceTexture)) {
                    throw new IllegalStateException("Invalid surface: " + this.surface);
                }
                EglRenderer.access$000(this.this$0).createSurface((SurfaceTexture) this.surface);
            }
            EglRenderer.access$000(this.this$0).makeCurrent();
            GLES20.glPixelStorei(3317, 1);
        }
    }

    public synchronized void setSurface(Object obj) {
        this.surface = obj;
    }

    public /* synthetic */ EglRenderer$EglSurfaceCreation(EglRenderer eglRenderer, EglRenderer$1 eglRenderer$1) {
        this(eglRenderer);
    }
}
