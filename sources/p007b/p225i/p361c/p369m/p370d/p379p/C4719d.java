package p007b.p225i.p361c.p369m.p370d.p379p;

import android.app.ActivityManager;
import java.util.List;
import java.util.Map;
import p007b.p225i.p361c.p369m.p370d.p387t.C4756e;

/* JADX INFO: renamed from: b.i.c.m.d.p.d */
/* JADX INFO: compiled from: SessionProtobufHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4719d {

    /* JADX INFO: renamed from: a */
    public static final C4716a f12694a = C4716a.m6637a("0");

    /* JADX INFO: renamed from: b */
    public static final C4716a f12695b = C4716a.m6637a("Unity");

    /* JADX INFO: renamed from: a */
    public static int m6657a(C4716a c4716a, C4716a c4716a2) {
        int iM6640b = C4718c.m6640b(3, c4716a) + C4718c.m6645h(2, 0L) + C4718c.m6645h(1, 0L) + 0;
        return c4716a2 != null ? iM6640b + C4718c.m6640b(4, c4716a2) : iM6640b;
    }

    /* JADX INFO: renamed from: b */
    public static int m6658b(String str, String str2) {
        int iM6640b = C4718c.m6640b(1, C4716a.m6637a(str));
        if (str2 == null) {
            str2 = "";
        }
        return C4718c.m6640b(2, C4716a.m6637a(str2)) + iM6640b;
    }

    /* JADX INFO: renamed from: c */
    public static int m6659c(C4756e c4756e, int i, int i2) {
        int i3 = 0;
        int iM6640b = C4718c.m6640b(1, C4716a.m6637a(c4756e.f12778b)) + 0;
        String str = c4756e.f12777a;
        if (str != null) {
            iM6640b += C4718c.m6640b(3, C4716a.m6637a(str));
        }
        for (StackTraceElement stackTraceElement : c4756e.f12779c) {
            int iM6664h = m6664h(stackTraceElement, true);
            iM6640b += C4718c.m6642d(iM6664h) + C4718c.m6643e(4) + iM6664h;
        }
        C4756e c4756e2 = c4756e.f12780d;
        if (c4756e2 == null) {
            return iM6640b;
        }
        if (i < i2) {
            int iM6659c = m6659c(c4756e2, i + 1, i2);
            return iM6640b + C4718c.m6642d(iM6659c) + C4718c.m6643e(6) + iM6659c;
        }
        while (c4756e2 != null) {
            c4756e2 = c4756e2.f12780d;
            i3++;
        }
        return iM6640b + C4718c.m6644f(7, i3);
    }

    /* JADX INFO: renamed from: d */
    public static int m6660d() {
        C4716a c4716a = f12694a;
        return C4718c.m6645h(3, 0L) + C4718c.m6640b(2, c4716a) + C4718c.m6640b(1, c4716a) + 0;
    }

    /* JADX INFO: renamed from: e */
    public static int m6661e(C4756e c4756e, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C4716a c4716a, C4716a c4716a2) {
        int iM6643e = C4718c.m6643e(1);
        int iM6665i = m6665i(thread, stackTraceElementArr, 4, true);
        int iM6642d = C4718c.m6642d(iM6665i) + iM6643e + iM6665i + 0;
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int iM6665i2 = m6665i(threadArr[i2], list.get(i2), 0, false);
            iM6642d += C4718c.m6642d(iM6665i2) + iM6643e + iM6665i2;
        }
        int iM6659c = m6659c(c4756e, 1, i);
        int iM6642d2 = C4718c.m6642d(iM6659c) + C4718c.m6643e(2) + iM6659c + iM6642d;
        int iM6660d = m6660d();
        int iM6642d3 = C4718c.m6642d(iM6660d) + C4718c.m6643e(3) + iM6660d + iM6642d2;
        int iM6657a = m6657a(c4716a, c4716a2);
        return C4718c.m6642d(iM6657a) + C4718c.m6643e(3) + iM6657a + iM6642d3;
    }

    /* JADX INFO: renamed from: f */
    public static int m6662f(C4756e c4756e, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C4716a c4716a, C4716a c4716a2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int iM6661e = m6661e(c4756e, thread, stackTraceElementArr, threadArr, list, i, c4716a, c4716a2);
        int iM6642d = C4718c.m6642d(iM6661e) + C4718c.m6643e(1) + iM6661e + 0;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int iM6658b = m6658b(entry.getKey(), entry.getValue());
                iM6642d += C4718c.m6642d(iM6658b) + C4718c.m6643e(2) + iM6658b;
            }
        }
        if (runningAppProcessInfo != null) {
            iM6642d += C4718c.m6639a(3, runningAppProcessInfo.importance != 100);
        }
        return C4718c.m6644f(4, i2) + iM6642d;
    }

    /* JADX INFO: renamed from: g */
    public static int m6663g(Float f, int i, boolean z2, int i2, long j, long j2) {
        int iM6643e = 0;
        if (f != null) {
            f.floatValue();
            iM6643e = 0 + C4718c.m6643e(1) + 4;
        }
        return C4718c.m6645h(6, j2) + C4718c.m6645h(5, j) + C4718c.m6644f(4, i2) + C4718c.m6639a(3, z2) + iM6643e + C4718c.m6642d((i >> 31) ^ (i << 1)) + C4718c.m6643e(2);
    }

    /* JADX INFO: renamed from: h */
    public static int m6664h(StackTraceElement stackTraceElement, boolean z2) {
        int iM6640b = C4718c.m6640b(2, C4716a.m6637a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) + (stackTraceElement.isNativeMethod() ? C4718c.m6645h(1, Math.max(stackTraceElement.getLineNumber(), 0)) : C4718c.m6645h(1, 0L)) + 0;
        if (stackTraceElement.getFileName() != null) {
            iM6640b += C4718c.m6640b(3, C4716a.m6637a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            iM6640b += C4718c.m6645h(4, stackTraceElement.getLineNumber());
        }
        return C4718c.m6644f(5, z2 ? 2 : 0) + iM6640b;
    }

    /* JADX INFO: renamed from: i */
    public static int m6665i(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z2) {
        int iM6644f = C4718c.m6644f(2, i) + C4718c.m6640b(1, C4716a.m6637a(thread.getName()));
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int iM6664h = m6664h(stackTraceElement, z2);
            iM6644f += C4718c.m6642d(iM6664h) + C4718c.m6643e(3) + iM6664h;
        }
        return iM6644f;
    }

    /* JADX INFO: renamed from: j */
    public static C4716a m6666j(String str) {
        if (str == null) {
            return null;
        }
        return C4716a.m6637a(str);
    }

    /* JADX INFO: renamed from: k */
    public static void m6667k(C4718c c4718c, int i, StackTraceElement stackTraceElement, boolean z2) throws Exception {
        c4718c.m6652o((i << 3) | 2);
        c4718c.m6652o(m6664h(stackTraceElement, z2));
        if (stackTraceElement.isNativeMethod()) {
            c4718c.m6656t(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            c4718c.m6656t(1, 0L);
        }
        c4718c.m6649l(2, C4716a.m6637a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            c4718c.m6649l(3, C4716a.m6637a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            c4718c.m6656t(4, stackTraceElement.getLineNumber());
        }
        c4718c.m6655s(5, z2 ? 4 : 0);
    }

    /* JADX INFO: renamed from: l */
    public static void m6668l(C4718c c4718c, C4756e c4756e, int i, int i2, int i3) throws Exception {
        c4718c.m6652o((i3 << 3) | 2);
        c4718c.m6652o(m6659c(c4756e, 1, i2));
        c4718c.m6649l(1, C4716a.m6637a(c4756e.f12778b));
        String str = c4756e.f12777a;
        if (str != null) {
            c4718c.m6649l(3, C4716a.m6637a(str));
        }
        int i4 = 0;
        for (StackTraceElement stackTraceElement : c4756e.f12779c) {
            m6667k(c4718c, 4, stackTraceElement, true);
        }
        C4756e c4756e2 = c4756e.f12780d;
        if (c4756e2 != null) {
            if (i < i2) {
                m6668l(c4718c, c4756e2, i + 1, i2, 6);
                return;
            }
            while (c4756e2 != null) {
                c4756e2 = c4756e2.f12780d;
                i4++;
            }
            c4718c.m6655s(7, i4);
        }
    }

    /* JADX INFO: renamed from: m */
    public static void m6669m(C4718c c4718c, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z2) throws Exception {
        c4718c.m6654r(1, 2);
        c4718c.m6652o(m6665i(thread, stackTraceElementArr, i, z2));
        c4718c.m6649l(1, C4716a.m6637a(thread.getName()));
        c4718c.m6655s(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            m6667k(c4718c, 3, stackTraceElement, z2);
        }
    }
}
