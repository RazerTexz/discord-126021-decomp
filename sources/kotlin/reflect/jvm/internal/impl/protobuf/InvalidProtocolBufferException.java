package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;

/* JADX INFO: loaded from: classes3.dex */
public class InvalidProtocolBufferException extends IOException {
    private InterfaceC11734n unfinishedMessage;

    public InvalidProtocolBufferException(String str) {
        super(str);
        this.unfinishedMessage = null;
    }

    /* JADX INFO: renamed from: a */
    public static InvalidProtocolBufferException m10895a() {
        return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: renamed from: b */
    public static InvalidProtocolBufferException m10896b() {
        return new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* JADX INFO: renamed from: c */
    public static InvalidProtocolBufferException m10897c() {
        return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public InterfaceC11734n getUnfinishedMessage() {
        return this.unfinishedMessage;
    }

    public InvalidProtocolBufferException setUnfinishedMessage(InterfaceC11734n interfaceC11734n) {
        this.unfinishedMessage = interfaceC11734n;
        return this;
    }
}
