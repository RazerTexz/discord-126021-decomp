package p007b.p225i.p226a.p242c.p260g3;

import androidx.annotation.Nullable;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: renamed from: b.i.a.c.g3.o */
/* JADX INFO: compiled from: DolbyVisionConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2778o {

    /* JADX INFO: renamed from: a */
    public final String f6849a;

    public C2778o(int i, int i2, String str) {
        this.f6849a = str;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C2778o m3126a(C2757x c2757x) {
        String str;
        c2757x.m3080F(2);
        int iM3100t = c2757x.m3100t();
        int i = iM3100t >> 1;
        int iM3100t2 = ((c2757x.m3100t() >> 3) & 31) | ((iM3100t & 1) << 5);
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
        String str2 = iM3100t2 < 10 ? ".0" : ".";
        StringBuilder sb = new StringBuilder(str2.length() + str.length() + 24);
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(str2);
        sb.append(iM3100t2);
        return new C2778o(i, iM3100t2, sb.toString());
    }
}
