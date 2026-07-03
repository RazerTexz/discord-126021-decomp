package okhttp3.internal.http2;

import java.io.IOException;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.p608j.EnumC12307a;

/* JADX INFO: compiled from: StreamResetException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StreamResetException extends IOException {
    public final EnumC12307a errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(EnumC12307a enumC12307a) {
        super("stream was reset: " + enumC12307a);
        C12238m.checkParameterIsNotNull(enumC12307a, "errorCode");
        this.errorCode = enumC12307a;
    }
}
