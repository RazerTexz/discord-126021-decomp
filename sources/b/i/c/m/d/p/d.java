package b.i.c.m.d.p;

import android.app.ActivityManager$RunningAppProcessInfo;
import b.i.c.m.d.t.e;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: SessionProtobufHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static final a a = a.a("0");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1740b = a.a("Unity");

    public static int a(a aVar, a aVar2) {
        int iB = c.b(3, aVar) + c.h(2, 0L) + c.h(1, 0L) + 0;
        return aVar2 != null ? iB + c.b(4, aVar2) : iB;
    }

    public static int b(String str, String str2) {
        int iB = c.b(1, a.a(str));
        if (str2 == null) {
            str2 = "";
        }
        return c.b(2, a.a(str2)) + iB;
    }

    public static int c(e eVar, int i, int i2) {
        int i3 = 0;
        int iB = c.b(1, a.a(eVar.f1753b)) + 0;
        String str = eVar.a;
        if (str != null) {
            iB += c.b(3, a.a(str));
        }
        for (StackTraceElement stackTraceElement : eVar.c) {
            int iH = h(stackTraceElement, true);
            iB += c.d(iH) + c.e(4) + iH;
        }
        e eVar2 = eVar.d;
        if (eVar2 == null) {
            return iB;
        }
        if (i < i2) {
            int iC = c(eVar2, i + 1, i2);
            return iB + c.d(iC) + c.e(6) + iC;
        }
        while (eVar2 != null) {
            eVar2 = eVar2.d;
            i3++;
        }
        return iB + c.f(7, i3);
    }

    public static int d() {
        a aVar = a;
        return c.h(3, 0L) + c.b(2, aVar) + c.b(1, aVar) + 0;
    }

    public static int e(e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, a aVar, a aVar2) {
        int iE = c.e(1);
        int i2 = i(thread, stackTraceElementArr, 4, true);
        int iD = c.d(i2) + iE + i2 + 0;
        int length = threadArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i(threadArr[i3], list.get(i3), 0, false);
            iD += c.d(i4) + iE + i4;
        }
        int iC = c(eVar, 1, i);
        int iD2 = c.d(iC) + c.e(2) + iC + iD;
        int iD3 = d();
        int iD4 = c.d(iD3) + c.e(3) + iD3 + iD2;
        int iA = a(aVar, aVar2);
        return c.d(iA) + c.e(3) + iA + iD4;
    }

    public static int f(e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, a aVar, a aVar2, Map<String, String> map, ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfo, int i2) {
        int iE = e(eVar, thread, stackTraceElementArr, threadArr, list, i, aVar, aVar2);
        int iD = c.d(iE) + c.e(1) + iE + 0;
        if (map != null) {
            for (Map$Entry<String, String> map$Entry : map.entrySet()) {
                int iB = b(map$Entry.getKey(), map$Entry.getValue());
                iD += c.d(iB) + c.e(2) + iB;
            }
        }
        if (activityManager$RunningAppProcessInfo != null) {
            iD += c.a(3, activityManager$RunningAppProcessInfo.importance != 100);
        }
        return c.f(4, i2) + iD;
    }

    public static int g(Float f, int i, boolean z2, int i2, long j, long j2) {
        int iE = 0;
        if (f != null) {
            f.floatValue();
            iE = 0 + c.e(1) + 4;
        }
        return c.h(6, j2) + c.h(5, j) + c.f(4, i2) + c.a(3, z2) + iE + c.d((i >> 31) ^ (i << 1)) + c.e(2);
    }

    public static int h(StackTraceElement stackTraceElement, boolean z2) {
        int iB = c.b(2, a.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) + (stackTraceElement.isNativeMethod() ? c.h(1, Math.max(stackTraceElement.getLineNumber(), 0)) : c.h(1, 0L)) + 0;
        if (stackTraceElement.getFileName() != null) {
            iB += c.b(3, a.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            iB += c.h(4, stackTraceElement.getLineNumber());
        }
        return c.f(5, z2 ? 2 : 0) + iB;
    }

    public static int i(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z2) {
        int iF = c.f(2, i) + c.b(1, a.a(thread.getName()));
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int iH = h(stackTraceElement, z2);
            iF += c.d(iH) + c.e(3) + iH;
        }
        return iF;
    }

    public static a j(String str) {
        if (str == null) {
            return null;
        }
        return a.a(str);
    }

    public static void k(c cVar, int i, StackTraceElement stackTraceElement, boolean z2) throws Exception {
        cVar.o((i << 3) | 2);
        cVar.o(h(stackTraceElement, z2));
        if (stackTraceElement.isNativeMethod()) {
            cVar.t(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            cVar.t(1, 0L);
        }
        cVar.l(2, a.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            cVar.l(3, a.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            cVar.t(4, stackTraceElement.getLineNumber());
        }
        cVar.s(5, z2 ? 4 : 0);
    }

    public static void l(c cVar, e eVar, int i, int i2, int i3) throws Exception {
        cVar.o((i3 << 3) | 2);
        cVar.o(c(eVar, 1, i2));
        cVar.l(1, a.a(eVar.f1753b));
        String str = eVar.a;
        if (str != null) {
            cVar.l(3, a.a(str));
        }
        int i4 = 0;
        for (StackTraceElement stackTraceElement : eVar.c) {
            k(cVar, 4, stackTraceElement, true);
        }
        e eVar2 = eVar.d;
        if (eVar2 != null) {
            if (i < i2) {
                l(cVar, eVar2, i + 1, i2, 6);
                return;
            }
            while (eVar2 != null) {
                eVar2 = eVar2.d;
                i4++;
            }
            cVar.s(7, i4);
        }
    }

    public static void m(c cVar, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z2) throws Exception {
        cVar.r(1, 2);
        cVar.o(i(thread, stackTraceElementArr, i, z2));
        cVar.l(1, a.a(thread.getName()));
        cVar.s(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            k(cVar, 3, stackTraceElement, z2);
        }
    }
}
