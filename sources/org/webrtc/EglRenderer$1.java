package org.webrtc;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class EglRenderer$1 implements Runnable {
    public final /* synthetic */ EglRenderer this$0;

    public EglRenderer$1(EglRenderer eglRenderer) {
        this.this$0 = eglRenderer;
    }

    @Override // java.lang.Runnable
    public void run() {
        EglRenderer.access$100(this.this$0);
        synchronized (EglRenderer.access$200(this.this$0)) {
            if (EglRenderer.access$300(this.this$0) != null) {
                EglRenderer.access$300(this.this$0).removeCallbacks(EglRenderer.access$400(this.this$0));
                EglRenderer.access$300(this.this$0).postDelayed(EglRenderer.access$400(this.this$0), TimeUnit.SECONDS.toMillis(4L));
            }
        }
    }
}
