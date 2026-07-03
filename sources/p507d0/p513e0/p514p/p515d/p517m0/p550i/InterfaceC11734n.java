package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.n */
/* JADX INFO: compiled from: MessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11734n extends InterfaceC11735o {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.n$a */
    /* JADX INFO: compiled from: MessageLite.java */
    public interface a extends Cloneable, InterfaceC11735o {
        InterfaceC11734n build();

        a mergeFrom(C11724d c11724d, C11725e c11725e) throws IOException;
    }

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
