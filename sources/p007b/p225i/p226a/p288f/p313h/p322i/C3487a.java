package p007b.p225i.p226a.p288f.p313h.p322i;

import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.i.a */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3487a extends OutputStream {
    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        Objects.requireNonNull(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr);
    }
}
