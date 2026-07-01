package h0.c;

import java.nio.ByteBuffer;
import org.webrtc.JniCommon;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j0 implements Runnable {
    public final /* synthetic */ ByteBuffer j;

    public /* synthetic */ j0(ByteBuffer byteBuffer) {
        this.j = byteBuffer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JniCommon.nativeFreeByteBuffer(this.j);
    }
}
