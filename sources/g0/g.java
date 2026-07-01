package g0;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: compiled from: BufferedSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g extends x, ReadableByteChannel {
    void B(e eVar, long j) throws IOException;

    long E(ByteString byteString) throws IOException;

    String G(long j) throws IOException;

    String M(Charset charset) throws IOException;

    String Y() throws IOException;

    byte[] Z(long j) throws IOException;

    e g();

    boolean j(long j) throws IOException;

    long k0(v vVar) throws IOException;

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

    int v0(o oVar) throws IOException;

    boolean w() throws IOException;
}
