package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.n;
import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: AbstractParser.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<MessageType extends n> implements p<MessageType> {
    static {
        e.getEmptyRegistry();
    }

    public final MessageType a(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw (messagetype instanceof a ? new UninitializedMessageException((a) messagetype) : new UninitializedMessageException(messagetype)).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    /* JADX INFO: renamed from: parseDelimitedFrom, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m89parseDelimitedFrom(InputStream inputStream, e eVar) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(inputStream, eVar);
    }

    /* JADX INFO: renamed from: parseFrom, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m90parseFrom(InputStream inputStream, e eVar) throws InvalidProtocolBufferException {
        return parseFrom(inputStream, eVar);
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream, e eVar) throws InvalidProtocolBufferException {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            return (MessageType) parsePartialFrom(new a$a$a(inputStream, d.readRawVarint32(i, inputStream)), eVar);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage());
        }
    }

    public MessageType parsePartialFrom(InputStream inputStream, e eVar) throws InvalidProtocolBufferException {
        d dVarNewInstance = d.newInstance(inputStream);
        MessageType partialFrom = parsePartialFrom(dVarNewInstance, eVar);
        try {
            dVarNewInstance.checkLastTagWas(0);
            return partialFrom;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(partialFrom);
        }
    }

    public MessageType parseDelimitedFrom(InputStream inputStream, e eVar) throws InvalidProtocolBufferException {
        MessageType messagetype = (MessageType) parsePartialDelimitedFrom(inputStream, eVar);
        a(messagetype);
        return messagetype;
    }

    public MessageType parseFrom(InputStream inputStream, e eVar) throws InvalidProtocolBufferException {
        MessageType messagetype = (MessageType) parsePartialFrom(inputStream, eVar);
        a(messagetype);
        return messagetype;
    }
}
