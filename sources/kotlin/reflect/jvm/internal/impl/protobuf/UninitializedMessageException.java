package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;

/* JADX INFO: loaded from: classes3.dex */
public class UninitializedMessageException extends RuntimeException {
    private final List<String> missingFields;

    public UninitializedMessageException(InterfaceC11734n interfaceC11734n) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
