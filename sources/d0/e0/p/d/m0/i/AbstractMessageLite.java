package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.MessageLite;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMessageLite implements MessageLite {
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
    public static abstract class a<BuilderType extends a> implements MessageLite.a {
        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public abstract BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractMessageLite.java */
        public static final class C0400a extends FilterInputStream {
            public int j;

            public C0400a(InputStream inputStream, int i) {
                super(inputStream);
                this.j = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.j);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.j <= 0) {
                    return -1;
                }
                int i = super.read();
                if (i >= 0) {
                    this.j--;
                }
                return i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) throws IOException {
                long jSkip = super.skip(Math.min(j, this.j));
                if (jSkip >= 0) {
                    this.j = (int) (((long) this.j) - jSkip);
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.j;
                if (i3 <= 0) {
                    return -1;
                }
                int i4 = super.read(bArr, i, Math.min(i2, i3));
                if (i4 >= 0) {
                    this.j -= i4;
                }
                return i4;
            }
        }
    }
}
