package b.i.a.c.z2.h;

import androidx.annotation.Nullable;
import b.i.a.c.f3.w;
import b.i.a.c.z2.d;
import b.i.a.c.z2.g;
import b.i.b.a.c;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: compiled from: AppInfoTableDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends g {
    @Override // b.i.a.c.z2.g
    @Nullable
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            w wVar = new w(byteBuffer.array(), byteBuffer.limit());
            wVar.m(12);
            int iD = (wVar.d() + wVar.g(12)) - 4;
            wVar.m(44);
            wVar.n(wVar.g(12));
            wVar.m(16);
            ArrayList arrayList = new ArrayList();
            while (wVar.d() < iD) {
                wVar.m(48);
                int iG = wVar.g(8);
                wVar.m(4);
                int iD2 = wVar.d() + wVar.g(12);
                String str = null;
                String str2 = null;
                while (wVar.d() < iD2) {
                    int iG2 = wVar.g(8);
                    int iG3 = wVar.g(8);
                    int iD3 = wVar.d() + iG3;
                    if (iG2 == 2) {
                        int iG4 = wVar.g(16);
                        wVar.m(8);
                        if (iG4 == 3) {
                            while (wVar.d() < iD3) {
                                int iG5 = wVar.g(8);
                                Charset charset = c.a;
                                byte[] bArr = new byte[iG5];
                                wVar.i(bArr, 0, iG5);
                                str = new String(bArr, charset);
                                int iG6 = wVar.g(8);
                                for (int i = 0; i < iG6; i++) {
                                    wVar.n(wVar.g(8));
                                }
                            }
                        }
                    } else if (iG2 == 21) {
                        Charset charset2 = c.a;
                        byte[] bArr2 = new byte[iG3];
                        wVar.i(bArr2, 0, iG3);
                        str2 = new String(bArr2, charset2);
                    }
                    wVar.k(iD3 * 8);
                }
                wVar.k(iD2 * 8);
                if (str != null && str2 != null) {
                    arrayList.add(new AppInfoTable(iG, str2.length() != 0 ? str.concat(str2) : new String(str)));
                }
            }
            if (!arrayList.isEmpty()) {
                return new Metadata(arrayList);
            }
        }
        return null;
    }
}
