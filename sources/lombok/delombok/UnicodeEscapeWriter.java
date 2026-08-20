package lombok.delombok;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* JADX INFO: loaded from: discord-126021.apk:lombok/delombok/UnicodeEscapeWriter.SCL.lombok */
public class UnicodeEscapeWriter extends Writer {
    private final Writer writer;
    private CharsetEncoder encoder;

    public UnicodeEscapeWriter(Writer writer, Charset charset) {
        this.writer = writer;
        this.encoder = charset.newEncoder();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.writer.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    @Override // java.io.Writer
    public final void write(char[] cbuf, int off, int len) throws IOException {
        int start = off;
        int end = off + len;
        for (int index = start; index < end; index++) {
            if (!this.encoder.canEncode(cbuf[index])) {
                this.writer.write(cbuf, start, index - start);
                writeUnicodeEscape(cbuf[index]);
                start = index + 1;
            }
        }
        if (start < end) {
            this.writer.write(cbuf, start, end - start);
        }
    }

    protected void writeUnicodeEscape(char c) throws IOException {
        this.writer.write(String.format("\\u%04x", Integer.valueOf(c)));
    }
}
