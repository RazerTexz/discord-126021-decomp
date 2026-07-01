package g0;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: renamed from: g0.g, reason: use source file name */
/* JADX INFO: compiled from: BufferedSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface BufferedSource extends Source2, ReadableByteChannel {
    void B(Buffer3 buffer3, long j) throws IOException;

    long E(ByteString byteString) throws IOException;

    String G(long j) throws IOException;

    String M(Charset charset) throws IOException;

    String Y() throws IOException;

    byte[] Z(long j) throws IOException;

    Buffer3 g();

    boolean j(long j) throws IOException;

    long k0(Sink sink) throws IOException;

    ByteString o(long j) throws IOException;

    void p0(long j) throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    long s0() throws IOException;

    void skip(long j) throws IOException;

    InputStream u0();

    int v0(Options2 options2) throws IOException;

    boolean w() throws IOException;
}
