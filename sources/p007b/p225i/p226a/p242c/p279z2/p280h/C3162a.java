package p007b.p225i.p226a.p242c.p279z2.p280h;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p279z2.AbstractC3161g;
import p007b.p225i.p226a.p242c.p279z2.C3158d;
import p007b.p225i.p355b.p356a.C4483c;

/* JADX INFO: renamed from: b.i.a.c.z2.h.a */
/* JADX INFO: compiled from: AppInfoTableDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3162a extends AbstractC3161g {
    @Override // p007b.p225i.p226a.p242c.p279z2.AbstractC3161g
    @Nullable
    /* JADX INFO: renamed from: b */
    public Metadata mo3899b(C3158d c3158d, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            C2756w c2756w = new C2756w(byteBuffer.array(), byteBuffer.limit());
            c2756w.m3073m(12);
            int iM3064d = (c2756w.m3064d() + c2756w.m3067g(12)) - 4;
            c2756w.m3073m(44);
            c2756w.m3074n(c2756w.m3067g(12));
            c2756w.m3073m(16);
            ArrayList arrayList = new ArrayList();
            while (c2756w.m3064d() < iM3064d) {
                c2756w.m3073m(48);
                int iM3067g = c2756w.m3067g(8);
                c2756w.m3073m(4);
                int iM3064d2 = c2756w.m3064d() + c2756w.m3067g(12);
                String str = null;
                String str2 = null;
                while (c2756w.m3064d() < iM3064d2) {
                    int iM3067g2 = c2756w.m3067g(8);
                    int iM3067g3 = c2756w.m3067g(8);
                    int iM3064d3 = c2756w.m3064d() + iM3067g3;
                    if (iM3067g2 == 2) {
                        int iM3067g4 = c2756w.m3067g(16);
                        c2756w.m3073m(8);
                        if (iM3067g4 == 3) {
                            while (c2756w.m3064d() < iM3064d3) {
                                int iM3067g5 = c2756w.m3067g(8);
                                Charset charset = C4483c.f11943a;
                                byte[] bArr = new byte[iM3067g5];
                                c2756w.m3069i(bArr, 0, iM3067g5);
                                str = new String(bArr, charset);
                                int iM3067g6 = c2756w.m3067g(8);
                                for (int i = 0; i < iM3067g6; i++) {
                                    c2756w.m3074n(c2756w.m3067g(8));
                                }
                            }
                        }
                    } else if (iM3067g2 == 21) {
                        Charset charset2 = C4483c.f11943a;
                        byte[] bArr2 = new byte[iM3067g3];
                        c2756w.m3069i(bArr2, 0, iM3067g3);
                        str2 = new String(bArr2, charset2);
                    }
                    c2756w.m3071k(iM3064d3 * 8);
                }
                c2756w.m3071k(iM3064d2 * 8);
                if (str != null && str2 != null) {
                    arrayList.add(new AppInfoTable(iM3067g, str2.length() != 0 ? str.concat(str2) : new String(str)));
                }
            }
            if (!arrayList.isEmpty()) {
                return new Metadata(arrayList);
            }
        }
        return null;
    }
}
