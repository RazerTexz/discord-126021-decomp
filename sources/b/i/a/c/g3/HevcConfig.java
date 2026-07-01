package b.i.a.c.g3;

import androidx.annotation.Nullable;
import b.i.a.c.f3.CodecSpecificDataUtil;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.g3.q, reason: use source file name */
/* JADX INFO: compiled from: HevcConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class HevcConfig {
    public final List<byte[]> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f989b;
    public final float c;

    @Nullable
    public final String d;

    public HevcConfig(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.a = list;
        this.f989b = i;
        this.c = f;
        this.d = str;
    }

    public static HevcConfig a(ParsableByteArray parsableByteArray) throws ParserException {
        try {
            parsableByteArray.F(21);
            int iT = parsableByteArray.t() & 3;
            int iT2 = parsableByteArray.t();
            int i = parsableByteArray.f984b;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < iT2; i4++) {
                parsableByteArray.F(1);
                int iY = parsableByteArray.y();
                for (int i5 = 0; i5 < iY; i5++) {
                    int iY2 = parsableByteArray.y();
                    i3 += iY2 + 4;
                    parsableByteArray.F(iY2);
                }
            }
            parsableByteArray.E(i);
            byte[] bArr = new byte[i3];
            String strB = null;
            int i6 = 0;
            int i7 = 0;
            int i8 = -1;
            int i9 = -1;
            float f = 1.0f;
            while (i6 < iT2) {
                int iT3 = parsableByteArray.t() & Opcodes.LAND;
                int iY3 = parsableByteArray.y();
                int i10 = 0;
                while (i10 < iY3) {
                    int iY4 = parsableByteArray.y();
                    byte[] bArr2 = NalUnitUtil.a;
                    int i11 = iT2;
                    System.arraycopy(bArr2, i2, bArr, i7, bArr2.length);
                    int length = i7 + bArr2.length;
                    System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, length, iY4);
                    if (iT3 == 33 && i10 == 0) {
                        NalUnitUtil.a aVarC = NalUnitUtil.c(bArr, length, length + iY4);
                        int i12 = aVarC.g;
                        i9 = aVarC.h;
                        f = aVarC.i;
                        i8 = i12;
                        strB = CodecSpecificDataUtil.b(aVarC.a, aVarC.f979b, aVarC.c, aVarC.d, aVarC.e, aVarC.f);
                    }
                    i7 = length + iY4;
                    parsableByteArray.F(iY4);
                    i10++;
                    iT2 = i11;
                    iT3 = iT3;
                    iY3 = iY3;
                    i2 = 0;
                }
                i6++;
                i2 = 0;
            }
            return new HevcConfig(i3 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iT + 1, i8, i9, f, strB);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.a("Error parsing HEVC config", e);
        }
    }
}
