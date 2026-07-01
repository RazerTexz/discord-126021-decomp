package okhttp3.internal.http2;

import d0.z.d.Intrinsics3;
import f0.e0.j.ErrorCode2;
import java.io.IOException;

/* JADX INFO: compiled from: StreamResetException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StreamResetException extends IOException {
    public final ErrorCode2 errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(ErrorCode2 errorCode2) {
        super("stream was reset: " + errorCode2);
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
        this.errorCode = errorCode2;
    }
}
