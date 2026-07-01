package okio;

import g0.Buffer3;
import g0.Sink;
import g0.Source2;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: BufferedSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    BufferedSink F() throws IOException;

    BufferedSink K(String string) throws IOException;

    long P(Source2 source) throws IOException;

    BufferedSink Q(long v) throws IOException;

    BufferedSink e0(ByteString byteString) throws IOException;

    @Override // g0.Sink, java.io.Flushable
    void flush() throws IOException;

    Buffer3 g();

    BufferedSink p() throws IOException;

    BufferedSink q0(long v) throws IOException;

    BufferedSink write(byte[] source) throws IOException;

    BufferedSink write(byte[] source, int offset, int byteCount) throws IOException;

    BufferedSink writeByte(int b2) throws IOException;

    BufferedSink writeInt(int i) throws IOException;

    BufferedSink writeShort(int s2) throws IOException;
}
