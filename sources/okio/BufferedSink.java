package okio;

import g0.e;
import g0.v;
import g0.x;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: BufferedSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface BufferedSink extends v, WritableByteChannel {
    BufferedSink F() throws IOException;

    BufferedSink K(String string) throws IOException;

    long P(x source) throws IOException;

    BufferedSink Q(long v) throws IOException;

    BufferedSink e0(ByteString byteString) throws IOException;

    @Override // g0.v, java.io.Flushable
    void flush() throws IOException;

    e g();

    BufferedSink p() throws IOException;

    BufferedSink q0(long v) throws IOException;

    BufferedSink write(byte[] source) throws IOException;

    BufferedSink write(byte[] source, int offset, int byteCount) throws IOException;

    BufferedSink writeByte(int b2) throws IOException;

    BufferedSink writeInt(int i) throws IOException;

    BufferedSink writeShort(int s2) throws IOException;
}
