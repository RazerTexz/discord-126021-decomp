package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidVideoDecoder$1 extends Thread {
    public final /* synthetic */ AndroidVideoDecoder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidVideoDecoder$1(AndroidVideoDecoder androidVideoDecoder, String str) {
        super(str);
        this.this$0 = androidVideoDecoder;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        AndroidVideoDecoder.access$002(this.this$0, new ThreadUtils$ThreadChecker());
        while (AndroidVideoDecoder.access$100(this.this$0)) {
            this.this$0.deliverDecodedFrame();
        }
        AndroidVideoDecoder.access$200(this.this$0);
    }
}
