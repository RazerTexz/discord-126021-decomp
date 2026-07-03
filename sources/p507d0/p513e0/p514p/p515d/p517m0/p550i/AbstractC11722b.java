package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.b */
/* JADX INFO: compiled from: AbstractParser.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11722b<MessageType extends InterfaceC11734n> implements InterfaceC11736p<MessageType> {
    static {
        C11725e.getEmptyRegistry();
    }

    /* JADX INFO: renamed from: a */
    public final MessageType m9822a(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw (messagetype instanceof AbstractC11721a ? new UninitializedMessageException((AbstractC11721a) messagetype) : new UninitializedMessageException(messagetype)).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream, C11725e c11725e) throws InvalidProtocolBufferException {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            return (MessageType) parsePartialFrom(new AbstractC11721a.a.C13324a(inputStream, C11724d.readRawVarint32(i, inputStream)), c11725e);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage());
        }
    }

    public MessageType parsePartialFrom(InputStream inputStream, C11725e c11725e) throws InvalidProtocolBufferException {
        C11724d c11724dNewInstance = C11724d.newInstance(inputStream);
        MessageType partialFrom = parsePartialFrom(c11724dNewInstance, c11725e);
        try {
            c11724dNewInstance.checkLastTagWas(0);
            return partialFrom;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(partialFrom);
        }
    }

    /* JADX INFO: renamed from: parseDelimitedFrom, reason: merged with bridge method [inline-methods] */
    public MessageType m11466parseDelimitedFrom(InputStream inputStream, C11725e c11725e) throws InvalidProtocolBufferException {
        MessageType messagetype = (MessageType) parsePartialDelimitedFrom(inputStream, c11725e);
        m9822a(messagetype);
        return messagetype;
    }

    /* JADX INFO: renamed from: parseFrom, reason: merged with bridge method [inline-methods] */
    public MessageType m11467parseFrom(InputStream inputStream, C11725e c11725e) throws InvalidProtocolBufferException {
        MessageType messagetype = (MessageType) parsePartialFrom(inputStream, c11725e);
        m9822a(messagetype);
        return messagetype;
    }
}
