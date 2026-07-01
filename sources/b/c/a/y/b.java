package b.c.a.y;

import android.graphics.Paint;
import androidx.browser.trusted.sharing.ShareTarget;
import b.i.c.m.d.s.h.AppSettingsData;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class b {
    public static /* synthetic */ int[] A;
    public static /* synthetic */ int[] B;
    public static /* synthetic */ int[] C;
    public static /* synthetic */ int[] D;
    public static /* synthetic */ int[] E;
    public static /* synthetic */ int[] F;
    public static /* synthetic */ int[] G;
    public static /* synthetic */ int[] H;
    public static /* synthetic */ int[] I;
    public static /* synthetic */ int[] J;
    public static /* synthetic */ int[] K;
    public static /* synthetic */ int[] L;
    public static /* synthetic */ int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static /* synthetic */ int[] f400b;
    public static /* synthetic */ int[] c;
    public static /* synthetic */ int[] d;
    public static /* synthetic */ int[] e;
    public static /* synthetic */ int[] f;
    public static /* synthetic */ int[] g;
    public static /* synthetic */ int[] h;
    public static /* synthetic */ int[] i;
    public static /* synthetic */ int[] j;
    public static /* synthetic */ int[] k;
    public static /* synthetic */ int[] l;
    public static /* synthetic */ int[] m;
    public static /* synthetic */ int[] n;
    public static /* synthetic */ int[] o;
    public static /* synthetic */ int[] p;
    public static /* synthetic */ int[] q;
    public static /* synthetic */ int[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static /* synthetic */ int[] f401s;
    public static /* synthetic */ int[] t;
    public static /* synthetic */ int[] u;
    public static /* synthetic */ int[] v;
    public static /* synthetic */ int[] w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static /* synthetic */ int[] f402x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static /* synthetic */ int[] f403y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static /* synthetic */ int[] f404z;

    public static synchronized /* synthetic */ int[] a() {
        if (a == null) {
            a = i(3);
        }
        return a;
    }

    public static synchronized /* synthetic */ int[] b() {
        if (d == null) {
            d = i(3);
        }
        return d;
    }

    public static synchronized /* synthetic */ int[] c() {
        if (e == null) {
            e = i(3);
        }
        return e;
    }

    public static int[] com$airbnb$lottie$model$DocumentData$Justification$s$values() {
        return (int[]) a().clone();
    }

    public static int[] com$airbnb$lottie$model$content$ShapeStroke$LineCapType$s$values() {
        return (int[]) b().clone();
    }

    public static int[] com$airbnb$lottie$model$content$ShapeStroke$LineJoinType$s$values() {
        return (int[]) c().clone();
    }

    public static int[] com$airbnb$lottie$model$layer$Layer$MatteType$s$values() {
        return (int[]) d().clone();
    }

    public static int[] com$fasterxml$jackson$databind$cfg$CoercionInputShape$s$values() {
        return (int[]) e().clone();
    }

    public static int[] com$fasterxml$jackson$databind$type$LogicalType$s$values() {
        return (int[]) f().clone();
    }

    public static synchronized /* synthetic */ int[] d() {
        if (g == null) {
            g = i(4);
        }
        return g;
    }

    public static synchronized /* synthetic */ int[] e() {
        if (v == null) {
            v = i(10);
        }
        return v;
    }

    public static synchronized /* synthetic */ int[] f() {
        if (w == null) {
            w = i(13);
        }
        return w;
    }

    public static /* synthetic */ boolean g(int i2, int i3) {
        if (i2 != 0) {
            return i2 == i3;
        }
        throw null;
    }

    public static /* synthetic */ int h(int i2) {
        if (i2 != 0) {
            return i2 - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] i(int i2) {
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            iArr[i3] = i4;
            i3 = i4;
        }
        return iArr;
    }

    public static /* synthetic */ void j(int i2) {
        if (i2 == 0) {
            throw null;
        }
    }

    public static Paint.Cap k(int i2) {
        int iH = h(i2);
        if (iH != 0) {
            return iH != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
        }
        return Paint.Cap.BUTT;
    }

    public static Paint.Join l(int i2) {
        int iH = h(i2);
        if (iH == 0) {
            return Paint.Join.MITER;
        }
        if (iH == 1) {
            return Paint.Join.ROUND;
        }
        if (iH != 2) {
            return null;
        }
        return Paint.Join.BEVEL;
    }

    public static int m(AppSettingsData appSettingsData) {
        boolean z2 = appSettingsData.g == 2;
        boolean z3 = appSettingsData.h == 2;
        if (z2) {
            return !z3 ? 2 : 3;
        }
        return 1;
    }

    public static /* synthetic */ String n(int i2) {
        if (i2 == 1) {
            return ShareTarget.METHOD_GET;
        }
        if (i2 == 2) {
            return ShareTarget.METHOD_POST;
        }
        if (i2 == 3) {
            return "PUT";
        }
        if (i2 == 4) {
            return "DELETE";
        }
        throw null;
    }
}
