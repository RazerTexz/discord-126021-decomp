package b.f.d.g;

import b.c.a.a0.AnimatableValueParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: renamed from: b.f.d.g.j, reason: use source file name */
/* JADX INFO: compiled from: PooledByteStreams.java */
/* JADX INFO: loaded from: classes.dex */
public class PooledByteStreams {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteArrayPool f472b;

    public PooledByteStreams(ByteArrayPool byteArrayPool) {
        AnimatableValueParser.i(true);
        this.a = 16384;
        this.f472b = byteArrayPool;
    }

    public long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = this.f472b.get(this.a);
        long j = 0;
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, this.a);
                if (i == -1) {
                    this.f472b.release(bArr);
                    return j;
                }
                outputStream.write(bArr, 0, i);
                j += (long) i;
            } catch (Throwable th) {
                this.f472b.release(bArr);
                throw th;
            }
        }
    }
}
