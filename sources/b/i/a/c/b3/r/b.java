package b.i.a.c.b3.r;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.i.a.f.e.o.f;

/* JADX INFO: compiled from: SsaDialogueFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f875b;
    public final int c;
    public final int d;
    public final int e;

    public b(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.f875b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    @Nullable
    public static b a(String str) {
        byte b2;
        b.c.a.a0.d.j(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
            String strU1 = f.u1(strArrSplit[i5].trim());
            strU1.hashCode();
            switch (strU1) {
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
        return new b(i, i2, i3, i4, strArrSplit.length);
    }
}
