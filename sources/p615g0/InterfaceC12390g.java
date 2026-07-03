package p615g0;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: renamed from: g0.g */
/* JADX INFO: compiled from: BufferedSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC12390g extends InterfaceC12407x, ReadableByteChannel {
    /* JADX INFO: renamed from: B */
    void mo10428B(C12388e c12388e, long j) throws IOException;

    /* JADX INFO: renamed from: E */
    long mo10430E(ByteString byteString) throws IOException;

    /* JADX INFO: renamed from: G */
    String mo10432G(long j) throws IOException;

    /* JADX INFO: renamed from: M */
    String mo10437M(Charset charset) throws IOException;

    /* JADX INFO: renamed from: Y */
    String mo10449Y() throws IOException;

    /* JADX INFO: renamed from: Z */
    byte[] mo10450Z(long j) throws IOException;

    /* JADX INFO: renamed from: g */
    C12388e mo10457g();

    /* JADX INFO: renamed from: j */
    boolean mo10458j(long j) throws IOException;

    /* JADX INFO: renamed from: k0 */
    long mo10459k0(InterfaceC12405v interfaceC12405v) throws IOException;

    /* JADX INFO: renamed from: o */
    ByteString mo10461o(long j) throws IOException;

    /* JADX INFO: renamed from: p0 */
    void mo10463p0(long j) throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    /* JADX INFO: renamed from: s0 */
    long mo10467s0() throws IOException;

    void skip(long j) throws IOException;

    /* JADX INFO: renamed from: u0 */
    InputStream mo10470u0();

    /* JADX INFO: renamed from: v0 */
    int mo10471v0(C12398o c12398o) throws IOException;

    /* JADX INFO: renamed from: w */
    boolean mo10472w() throws IOException;
}
