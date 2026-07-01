package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class HardwareVideoEncoder$1 extends Thread {
    public final /* synthetic */ HardwareVideoEncoder this$0;

    public HardwareVideoEncoder$1(HardwareVideoEncoder hardwareVideoEncoder) {
        this.this$0 = hardwareVideoEncoder;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (HardwareVideoEncoder.access$100(this.this$0)) {
            this.this$0.deliverEncodedImage();
        }
        HardwareVideoEncoder.access$200(this.this$0);
    }
}
