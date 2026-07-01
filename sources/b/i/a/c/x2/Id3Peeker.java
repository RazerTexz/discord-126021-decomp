package b.i.a.c.x2;

import androidx.annotation.Nullable;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.z2.k.Id3Decoder;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.q, reason: use source file name */
/* JADX INFO: compiled from: Id3Peeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Id3Peeker {
    public final ParsableByteArray a = new ParsableByteArray(10);

    @Nullable
    public Metadata a(ExtractorInput extractorInput, @Nullable Id3Decoder.a aVar) throws IOException {
        Metadata metadataD = null;
        int i = 0;
        while (true) {
            try {
                extractorInput.o(this.a.a, 0, 10);
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
                    extractorInput.o(bArr, 10, iS);
                    metadataD = new Id3Decoder(aVar).d(bArr, i2);
                } else {
                    extractorInput.g(iS);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        extractorInput.k();
        extractorInput.g(i);
        return metadataD;
    }
}
