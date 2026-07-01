package d0.e0.p.d.m0.i;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;

/* JADX INFO: compiled from: MessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public interface n extends o {
    int getSerializedSize();

    n$a newBuilderForType();

    n$a toBuilder();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
