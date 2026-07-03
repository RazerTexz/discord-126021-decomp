package p007b.p225i.p226a.p242c.p245b3.p250r;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.c.b3.r.b */
/* JADX INFO: compiled from: SsaDialogueFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2606b {

    /* JADX INFO: renamed from: a */
    public final int f5992a;

    /* JADX INFO: renamed from: b */
    public final int f5993b;

    /* JADX INFO: renamed from: c */
    public final int f5994c;

    /* JADX INFO: renamed from: d */
    public final int f5995d;

    /* JADX INFO: renamed from: e */
    public final int f5996e;

    public C2606b(int i, int i2, int i3, int i4, int i5) {
        this.f5992a = i;
        this.f5993b = i2;
        this.f5994c = i3;
        this.f5995d = i4;
        this.f5996e = i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    @Nullable
    /* JADX INFO: renamed from: a */
    public static C2606b m2672a(String str) {
        byte b2;
        C1460d.m531j(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
            String strM4349u1 = C3404f.m4349u1(strArrSplit[i5].trim());
            strM4349u1.hashCode();
            switch (strM4349u1) {
                case "end":
                    b2 = 0;
                    break;
                case "text":
                    b2 = 1;
                    break;
                case "start":
                    b2 = 2;
                    break;
                case "style":
                    b2 = 3;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                i2 = i5;
            } else if (b2 == 1) {
                i4 = i5;
            } else if (b2 == 2) {
                i = i5;
            } else if (b2 == 3) {
                i3 = i5;
            }
        }
        if (i == -1 || i2 == -1 || i4 == -1) {
            return null;
        }
        return new C2606b(i, i2, i3, i4, strArrSplit.length);
    }
}
