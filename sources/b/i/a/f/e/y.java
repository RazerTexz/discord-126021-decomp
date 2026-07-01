package b.i.a.f.e;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends x {
    public final byte[] c;

    public y(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.c = bArr;
    }

    @Override // b.i.a.f.e.x
    public final byte[] g() {
        return this.c;
    }
}
