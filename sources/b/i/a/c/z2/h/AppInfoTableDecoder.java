package b.i.a.c.z2.h;

import androidx.annotation.Nullable;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.z2.MetadataInputBuffer;
import b.i.a.c.z2.SimpleMetadataDecoder;
import b.i.b.a.Charsets;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: renamed from: b.i.a.c.z2.h.a, reason: use source file name */
/* JADX INFO: compiled from: AppInfoTableDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AppInfoTableDecoder extends SimpleMetadataDecoder {
    @Override // b.i.a.c.z2.SimpleMetadataDecoder
    @Nullable
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            ParsableBitArray parsableBitArray = new ParsableBitArray(byteBuffer.array(), byteBuffer.limit());
            parsableBitArray.m(12);
            int iD = (parsableBitArray.d() + parsableBitArray.g(12)) - 4;
            parsableBitArray.m(44);
            parsableBitArray.n(parsableBitArray.g(12));
            parsableBitArray.m(16);
            ArrayList arrayList = new ArrayList();
            while (parsableBitArray.d() < iD) {
                parsableBitArray.m(48);
                int iG = parsableBitArray.g(8);
                parsableBitArray.m(4);
                int iD2 = parsableBitArray.d() + parsableBitArray.g(12);
                String str = null;
                String str2 = null;
                while (parsableBitArray.d() < iD2) {
                    int iG2 = parsableBitArray.g(8);
                    int iG3 = parsableBitArray.g(8);
                    int iD3 = parsableBitArray.d() + iG3;
                    if (iG2 == 2) {
                        int iG4 = parsableBitArray.g(16);
                        parsableBitArray.m(8);
                        if (iG4 == 3) {
                            while (parsableBitArray.d() < iD3) {
                                int iG5 = parsableBitArray.g(8);
                                Charset charset = Charsets.a;
                                byte[] bArr = new byte[iG5];
                                parsableBitArray.i(bArr, 0, iG5);
                                str = new String(bArr, charset);
                                int iG6 = parsableBitArray.g(8);
                                for (int i = 0; i < iG6; i++) {
                                    parsableBitArray.n(parsableBitArray.g(8));
                                }
                            }
                        }
                    } else if (iG2 == 21) {
                        Charset charset2 = Charsets.a;
                        byte[] bArr2 = new byte[iG3];
                        parsableBitArray.i(bArr2, 0, iG3);
                        str2 = new String(bArr2, charset2);
                    }
                    parsableBitArray.k(iD3 * 8);
                }
                parsableBitArray.k(iD2 * 8);
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
