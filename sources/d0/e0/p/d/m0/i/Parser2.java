package d0.e0.p.d.m0.i;

import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.p, reason: use source file name */
/* JADX INFO: compiled from: Parser.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Parser2<MessageType> {
    MessageType parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;
}
