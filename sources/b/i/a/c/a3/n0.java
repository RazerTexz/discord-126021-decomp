package b.i.a.c.a3;

import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.w0;
import java.util.Arrays;

/* JADX INFO: compiled from: TrackGroup.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements w0 {
    public static final /* synthetic */ int j = 0;
    public final int k;
    public final j1[] l;
    public int m;

    public n0(j1... j1VarArr) {
        int i = 1;
        b.c.a.a0.d.j(j1VarArr.length > 0);
        this.l = j1VarArr;
        this.k = j1VarArr.length;
        String str = j1VarArr[0].n;
        str = (str == null || str.equals("und")) ? "" : str;
        int i2 = j1VarArr[0].p | 16384;
        while (true) {
            j1[] j1VarArr2 = this.l;
            if (i >= j1VarArr2.length) {
                return;
            }
            String str2 = j1VarArr2[i].n;
            if (!str.equals((str2 == null || str2.equals("und")) ? "" : str2)) {
                j1[] j1VarArr3 = this.l;
                a("languages", j1VarArr3[0].n, j1VarArr3[i].n, i);
                return;
            } else {
                j1[] j1VarArr4 = this.l;
                if (i2 != (j1VarArr4[i].p | 16384)) {
                    a("role flags", Integer.toBinaryString(j1VarArr4[0].p), Integer.toBinaryString(this.l[i].p), i);
                    return;
                }
                i++;
            }
        }
    }

    public static void a(String str, @Nullable String str2, @Nullable String str3, int i) {
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str3, b.d.b.a.a.b(str2, str.length() + 78)), "Different ", str, " combined in one TrackGroup: '", str2);
        sbS.append("' (track 0) and '");
        sbS.append(str3);
        sbS.append("' (track ");
        sbS.append(i);
        sbS.append(")");
        b.i.a.c.f3.q.b("TrackGroup", "", new IllegalStateException(sbS.toString()));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n0.class != obj.getClass()) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return this.k == n0Var.k && Arrays.equals(this.l, n0Var.l);
    }

    public int hashCode() {
        if (this.m == 0) {
            this.m = 527 + Arrays.hashCode(this.l);
        }
        return this.m;
    }
}
