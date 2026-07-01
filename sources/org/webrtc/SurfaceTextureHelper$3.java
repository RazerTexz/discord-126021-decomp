package org.webrtc;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class SurfaceTextureHelper$3 implements Runnable {
    public final /* synthetic */ SurfaceTextureHelper this$0;

    public SurfaceTextureHelper$3(SurfaceTextureHelper surfaceTextureHelper) {
        this.this$0 = surfaceTextureHelper;
    }

    @Override // java.lang.Runnable
    public void run() {
        StringBuilder sbU = a.U("Setting listener to ");
        sbU.append(SurfaceTextureHelper.access$300(this.this$0));
        Logging.d("SurfaceTextureHelper", sbU.toString());
        SurfaceTextureHelper surfaceTextureHelper = this.this$0;
        SurfaceTextureHelper.access$402(surfaceTextureHelper, SurfaceTextureHelper.access$300(surfaceTextureHelper));
        SurfaceTextureHelper.access$302(this.this$0, null);
        if (SurfaceTextureHelper.access$500(this.this$0)) {
            SurfaceTextureHelper.access$600(this.this$0);
            SurfaceTextureHelper.access$502(this.this$0, false);
        }
    }
}
