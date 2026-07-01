package d0.e0.p.d.m0.i;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.n, reason: use source file name */
/* JADX INFO: compiled from: MessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.n$a */
    /* JADX INFO: compiled from: MessageLite.java */
    public interface a extends Cloneable, MessageLiteOrBuilder {
        MessageLite build();

        a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;
    }

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
