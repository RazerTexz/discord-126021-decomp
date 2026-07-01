package com.discord.gateway;

import d0.z.d.m;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$SizeRecordingInputStreamReader extends Reader {
    private int size;
    private final InputStreamReader source;

    public GatewaySocket$SizeRecordingInputStreamReader(InputStreamReader inputStreamReader, int i) {
        m.checkNotNullParameter(inputStreamReader, "source");
        this.source = inputStreamReader;
        this.size = i;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final int getSize() {
        return this.size;
    }

    public final InputStreamReader getSource() {
        return this.source;
    }

    @Override // java.io.Reader
    public int read(char[] buffer, int offset, int len) throws IOException {
        m.checkNotNullParameter(buffer, "buffer");
        int i = this.source.read(buffer, offset, len);
        if (i != -1) {
            this.size += i;
        }
        return i;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public /* synthetic */ GatewaySocket$SizeRecordingInputStreamReader(InputStreamReader inputStreamReader, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputStreamReader, (i2 & 2) != 0 ? 0 : i);
    }
}
