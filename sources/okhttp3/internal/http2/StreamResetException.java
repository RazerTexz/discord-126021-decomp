package okhttp3.internal.http2;

import d0.z.d.m;
import f0.e0.j.a;
import java.io.IOException;

/* JADX INFO: compiled from: StreamResetException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StreamResetException extends IOException {
    public final a errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(a aVar) {
        super("stream was reset: " + aVar);
        m.checkParameterIsNotNull(aVar, "errorCode");
        this.errorCode = aVar;
    }
}
