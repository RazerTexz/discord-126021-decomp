package b.i.a.c.x2;

import androidx.annotation.Nullable;
import b.i.a.c.z2.k.b$a;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: Id3Peeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public final b.i.a.c.f3.x a = new b.i.a.c.f3.x(10);

    @Nullable
    public Metadata a(i iVar, @Nullable b$a b_a) throws IOException {
        Metadata metadataD = null;
        int i = 0;
        while (true) {
            try {
                iVar.o(this.a.a, 0, 10);
                this.a.E(0);
                if (this.a.v() != 4801587) {
                    break;
                }
                this.a.F(3);
                int iS = this.a.s();
                int i2 = iS + 10;
                if (metadataD == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.a.a, 0, bArr, 0, 10);
                    iVar.o(bArr, 10, iS);
                    metadataD = new b.i.a.c.z2.k.b(b_a).d(bArr, i2);
                } else {
                    iVar.g(iS);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        iVar.k();
        iVar.g(i);
        return metadataD;
    }
}
