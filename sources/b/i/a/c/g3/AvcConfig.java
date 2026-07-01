package b.i.a.c.g3;

import androidx.annotation.Nullable;
import b.i.a.c.f3.CodecSpecificDataUtil;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.g3.m, reason: use source file name */
/* JADX INFO: compiled from: AvcConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AvcConfig {
    public final List<byte[]> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f986b;
    public final int c;
    public final int d;
    public final float e;

    @Nullable
    public final String f;

    public AvcConfig(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.a = list;
        this.f986b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
        this.f = str;
    }

    public static byte[] a(ParsableByteArray parsableByteArray) {
        int iY = parsableByteArray.y();
        int i = parsableByteArray.f984b;
        parsableByteArray.F(iY);
        byte[] bArr = parsableByteArray.a;
        byte[] bArr2 = CodecSpecificDataUtil.a;
        byte[] bArr3 = new byte[bArr2.length + iY];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, iY);
        return bArr3;
    }

    public static AvcConfig b(ParsableByteArray parsableByteArray) throws ParserException {
        String strA;
        int i;
        int i2;
        float f;
        try {
            parsableByteArray.F(4);
            int iT = (parsableByteArray.t() & 3) + 1;
            if (iT == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iT2 = parsableByteArray.t() & 31;
            for (int i3 = 0; i3 < iT2; i3++) {
                arrayList.add(a(parsableByteArray));
            }
            int iT3 = parsableByteArray.t();
            for (int i4 = 0; i4 < iT3; i4++) {
                arrayList.add(a(parsableByteArray));
            }
            if (iT2 > 0) {
                NalUnitUtil.c cVarE = NalUnitUtil.e((byte[]) arrayList.get(0), iT, ((byte[]) arrayList.get(0)).length);
                int i5 = cVarE.e;
                int i6 = cVarE.f;
                float f2 = cVarE.g;
                strA = CodecSpecificDataUtil.a(cVarE.a, cVarE.f981b, cVarE.c);
                i = i5;
                i2 = i6;
                f = f2;
            } else {
                strA = null;
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new AvcConfig(arrayList, iT, i, i2, f, strA);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.a("Error parsing AVC config", e);
        }
    }
}
