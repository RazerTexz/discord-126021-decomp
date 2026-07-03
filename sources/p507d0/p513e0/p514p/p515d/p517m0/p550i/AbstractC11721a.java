package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.a */
/* JADX INFO: compiled from: AbstractMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11721a implements InterfaceC11734n {
    public int memoizedHashCode = 0;

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        int iComputeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(serializedSize) + serializedSize;
        if (iComputeRawVarint32Size > 4096) {
            iComputeRawVarint32Size = 4096;
        }
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputStream, iComputeRawVarint32Size);
        codedOutputStreamNewInstance.writeRawVarint32(serializedSize);
        writeTo(codedOutputStreamNewInstance);
        codedOutputStreamNewInstance.flush();
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.a$a */
    /* JADX INFO: compiled from: AbstractMessageLite.java */
    public static abstract class a<BuilderType extends a> implements InterfaceC11734n.a {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public abstract BuilderType mergeFrom(C11724d c11724d, C11725e c11725e) throws IOException;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractMessageLite.java */
        public static final class C13324a extends FilterInputStream {

            /* JADX INFO: renamed from: j */
            public int f24099j;

            public C13324a(InputStream inputStream, int i) {
                super(inputStream);
                this.f24099j = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f24099j);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f24099j <= 0) {
                    return -1;
                }
                int i = super.read();
                if (i >= 0) {
                    this.f24099j--;
                }
                return i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) throws IOException {
                long jSkip = super.skip(Math.min(j, this.f24099j));
                if (jSkip >= 0) {
                    this.f24099j = (int) (((long) this.f24099j) - jSkip);
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.f24099j;
                if (i3 <= 0) {
                    return -1;
                }
                int i4 = super.read(bArr, i, Math.min(i2, i3));
                if (i4 >= 0) {
                    this.f24099j -= i4;
                }
                return i4;
            }
        }
    }
}
