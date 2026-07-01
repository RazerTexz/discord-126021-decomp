package b.i.a.c.g3;

import androidx.annotation.Nullable;
import b.i.a.c.f3.ParsableByteArray;

/* JADX INFO: renamed from: b.i.a.c.g3.o, reason: use source file name */
/* JADX INFO: compiled from: DolbyVisionConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DolbyVisionConfig {
    public final String a;

    public DolbyVisionConfig(int i, int i2, String str) {
        this.a = str;
    }

    @Nullable
    public static DolbyVisionConfig a(ParsableByteArray parsableByteArray) {
        String str;
        parsableByteArray.F(2);
        int iT = parsableByteArray.t();
        int i = iT >> 1;
        int iT2 = ((parsableByteArray.t() >> 3) & 31) | ((iT & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        String str2 = iT2 < 10 ? ".0" : ".";
        StringBuilder sb = new StringBuilder(str2.length() + str.length() + 24);
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(str2);
        sb.append(iT2);
        return new DolbyVisionConfig(i, iT2, sb.toString());
    }
}
