package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class EglRenderer$2 implements Runnable {
    public final /* synthetic */ EglRenderer this$0;

    public EglRenderer$2(EglRenderer eglRenderer) {
        this.this$0 = eglRenderer;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (EglRenderer.access$200(this.this$0)) {
            EglRenderer.access$302(this.this$0, null);
        }
    }
}
