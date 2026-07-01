package b.i.a.c.c3;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.i.a.c.a3.n0;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import b.i.b.b.g0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: DefaultTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f898b = new int[0];
    public static final g0<Integer> c = g0.a(c.j);
    public static final g0<Integer> d = g0.a(b.j);
    public final j$b e;
    public final AtomicReference<h$d> f;

    public h(Context context) {
        f$b f_b = new f$b();
        h$d h_d = h$d.I;
        h$d h_dD = new h$e(context).d();
        this.e = f_b;
        this.f = new AtomicReference<>(h_dD);
    }

    public static int c(j1 j1Var, @Nullable String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(j1Var.n)) {
            return 4;
        }
        String strG = g(str);
        String strG2 = g(j1Var.n);
        if (strG2 == null || strG == null) {
            return (z2 && strG2 == null) ? 1 : 0;
        }
        if (strG2.startsWith(strG) || strG.startsWith(strG2)) {
            return 3;
        }
        int i = e0.a;
        return strG2.split("-", 2)[0].equals(strG.split("-", 2)[0]) ? 2 : 0;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0045  */
    public static List<Integer> d(n0 n0Var, int i, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        int i6;
        ArrayList arrayList = new ArrayList(n0Var.k);
        for (int i7 = 0; i7 < n0Var.k; i7++) {
            arrayList.add(Integer.valueOf(i7));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i8 = 0;
            int i9 = Integer.MAX_VALUE;
            while (true) {
                if (i8 >= n0Var.k) {
                    break;
                }
                j1 j1Var = n0Var.l[i8];
                int i10 = j1Var.B;
                if (i10 > 0 && (i4 = j1Var.C) > 0) {
                    if (!z2) {
                        i5 = i;
                        i6 = i2;
                    } else if ((i10 > i4) != (i > i2)) {
                        i6 = i;
                        i5 = i2;
                    } else {
                        i5 = i;
                        i6 = i2;
                    }
                    int i11 = i10 * i6;
                    int i12 = i4 * i5;
                    Point point = i11 >= i12 ? new Point(i5, e0.f(i12, i10)) : new Point(e0.f(i11, i4), i6);
                    int i13 = j1Var.B;
                    int i14 = j1Var.C;
                    int i15 = i13 * i14;
                    if (i13 >= ((int) (point.x * 0.98f)) && i14 >= ((int) (point.y * 0.98f)) && i15 < i9) {
                        i9 = i15;
                    }
                }
                i8++;
            }
            if (i9 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    j1 j1Var2 = n0Var.l[((Integer) arrayList.get(size)).intValue()];
                    int i16 = j1Var2.B;
                    int i17 = (i16 == -1 || (i3 = j1Var2.C) == -1) ? -1 : i16 * i3;
                    if (i17 == -1 || i17 > i9) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean e(int i, boolean z2) {
        int i2 = i & 7;
        return i2 == 4 || (z2 && i2 == 3);
    }

    public static boolean f(j1 j1Var, @Nullable String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if ((j1Var.p & 16384) != 0 || !e(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !e0.a(j1Var.w, str)) {
            return false;
        }
        int i12 = j1Var.B;
        if (i12 != -1 && (i7 > i12 || i12 > i3)) {
            return false;
        }
        int i13 = j1Var.C;
        if (i13 != -1 && (i8 > i13 || i13 > i4)) {
            return false;
        }
        float f = j1Var.D;
        return (f == -1.0f || (((float) i9) <= f && f <= ((float) i5))) && (i11 = j1Var.f1017s) != -1 && i10 <= i11 && i11 <= i6;
    }

    @Nullable
    public static String g(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }
}
