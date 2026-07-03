package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p279z2.p283k.C3167b;

/* JADX INFO: renamed from: b.i.a.c.x2.q */
/* JADX INFO: compiled from: Id3Peeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3116q {

    /* JADX INFO: renamed from: a */
    public final C2757x f8987a = new C2757x(10);

    @Nullable
    /* JADX INFO: renamed from: a */
    public Metadata m3816a(InterfaceC3041i interfaceC3041i, @Nullable C3167b.a aVar) throws IOException {
        Metadata metadataM3922d = null;
        int i = 0;
        while (true) {
            try {
                interfaceC3041i.mo3652o(this.f8987a.f6793a, 0, 10);
                this.f8987a.m3079E(0);
                if (this.f8987a.m3102v() != 4801587) {
                    break;
                }
                this.f8987a.m3080F(3);
                int iM3099s = this.f8987a.m3099s();
                int i2 = iM3099s + 10;
                if (metadataM3922d == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f8987a.f6793a, 0, bArr, 0, 10);
                    interfaceC3041i.mo3652o(bArr, 10, iM3099s);
                    metadataM3922d = new C3167b(aVar).m3922d(bArr, i2);
                } else {
                    interfaceC3041i.mo3646g(iM3099s);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        interfaceC3041i.mo3649k();
        interfaceC3041i.mo3646g(i);
        return metadataM3922d;
    }
}
