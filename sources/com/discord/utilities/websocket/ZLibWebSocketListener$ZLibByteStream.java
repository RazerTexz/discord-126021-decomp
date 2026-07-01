package com.discord.utilities.websocket;

import com.adjust.sdk.Constants;
import d0.z.d.m;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;
import okio.ByteString;

/* JADX INFO: compiled from: ZLibWebSocketListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ZLibWebSocketListener$ZLibByteStream extends ByteArrayOutputStream {
    private static final int INFLATE_BUFFER_SIZE = 4096;
    private static final int INITIAL_BUFFER_SIZE_MULTIPLIER = 2;
    public static final ZLibWebSocketListener$ZLibByteStream$Companion Companion = new ZLibWebSocketListener$ZLibByteStream$Companion(null);
    private static final CharsetDecoder UTF8_DECODER = Charset.forName(Constants.ENCODING).newDecoder();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZLibWebSocketListener$ZLibByteStream(ByteString byteString, Inflater inflater) throws IOException {
        super(byteString.j() * 2);
        m.checkNotNullParameter(byteString, "bytes");
        m.checkNotNullParameter(inflater, "inflater");
        InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(this, inflater, 4096);
        byteString.r(inflaterOutputStream);
        inflaterOutputStream.flush();
    }

    public final InputStreamReader toReader() {
        return new InputStreamReader(new ByteArrayInputStream(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count), UTF8_DECODER);
    }
}
