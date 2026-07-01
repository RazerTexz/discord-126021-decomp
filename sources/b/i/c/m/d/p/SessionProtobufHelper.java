package b.i.c.m.d.p;

import android.app.ActivityManager;
import b.i.c.m.d.t.TrimmedThrowableData;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.i.c.m.d.p.d, reason: use source file name */
/* JADX INFO: compiled from: SessionProtobufHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class SessionProtobufHelper {
    public static final ByteString2 a = ByteString2.a("0");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString2 f1740b = ByteString2.a("Unity");

    public static int a(ByteString2 byteString2, ByteString2 byteString3) {
        int iB = CodedOutputStream2.b(3, byteString2) + CodedOutputStream2.h(2, 0L) + CodedOutputStream2.h(1, 0L) + 0;
        return byteString3 != null ? iB + CodedOutputStream2.b(4, byteString3) : iB;
    }

    public static int b(String str, String str2) {
        int iB = CodedOutputStream2.b(1, ByteString2.a(str));
        if (str2 == null) {
            str2 = "";
        }
        return CodedOutputStream2.b(2, ByteString2.a(str2)) + iB;
    }

    public static int c(TrimmedThrowableData trimmedThrowableData, int i, int i2) {
        int i3 = 0;
        int iB = CodedOutputStream2.b(1, ByteString2.a(trimmedThrowableData.f1753b)) + 0;
        String str = trimmedThrowableData.a;
        if (str != null) {
            iB += CodedOutputStream2.b(3, ByteString2.a(str));
        }
        for (StackTraceElement stackTraceElement : trimmedThrowableData.c) {
            int iH = h(stackTraceElement, true);
            iB += CodedOutputStream2.d(iH) + CodedOutputStream2.e(4) + iH;
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.d;
        if (trimmedThrowableData2 == null) {
            return iB;
        }
        if (i < i2) {
            int iC = c(trimmedThrowableData2, i + 1, i2);
            return iB + CodedOutputStream2.d(iC) + CodedOutputStream2.e(6) + iC;
        }
        while (trimmedThrowableData2 != null) {
            trimmedThrowableData2 = trimmedThrowableData2.d;
            i3++;
        }
        return iB + CodedOutputStream2.f(7, i3);
    }

    public static int d() {
        ByteString2 byteString2 = a;
        return CodedOutputStream2.h(3, 0L) + CodedOutputStream2.b(2, byteString2) + CodedOutputStream2.b(1, byteString2) + 0;
    }

    public static int e(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString2 byteString2, ByteString2 byteString3) {
        int iE = CodedOutputStream2.e(1);
        int i2 = i(thread, stackTraceElementArr, 4, true);
        int iD = CodedOutputStream2.d(i2) + iE + i2 + 0;
        int length = threadArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i(threadArr[i3], list.get(i3), 0, false);
            iD += CodedOutputStream2.d(i4) + iE + i4;
        }
        int iC = c(trimmedThrowableData, 1, i);
        int iD2 = CodedOutputStream2.d(iC) + CodedOutputStream2.e(2) + iC + iD;
        int iD3 = d();
        int iD4 = CodedOutputStream2.d(iD3) + CodedOutputStream2.e(3) + iD3 + iD2;
        int iA = a(byteString2, byteString3);
        return CodedOutputStream2.d(iA) + CodedOutputStream2.e(3) + iA + iD4;
    }

    public static int f(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString2 byteString2, ByteString2 byteString3, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int iE = e(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString2, byteString3);
        int iD = CodedOutputStream2.d(iE) + CodedOutputStream2.e(1) + iE + 0;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int iB = b(entry.getKey(), entry.getValue());
                iD += CodedOutputStream2.d(iB) + CodedOutputStream2.e(2) + iB;
            }
        }
        if (runningAppProcessInfo != null) {
            iD += CodedOutputStream2.a(3, runningAppProcessInfo.importance != 100);
        }
        return CodedOutputStream2.f(4, i2) + iD;
    }

    public static int g(Float f, int i, boolean z2, int i2, long j, long j2) {
        int iE = 0;
        if (f != null) {
            f.floatValue();
            iE = 0 + CodedOutputStream2.e(1) + 4;
        }
        return CodedOutputStream2.h(6, j2) + CodedOutputStream2.h(5, j) + CodedOutputStream2.f(4, i2) + CodedOutputStream2.a(3, z2) + iE + CodedOutputStream2.d((i >> 31) ^ (i << 1)) + CodedOutputStream2.e(2);
    }

    public static int h(StackTraceElement stackTraceElement, boolean z2) {
        int iB = CodedOutputStream2.b(2, ByteString2.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) + (stackTraceElement.isNativeMethod() ? CodedOutputStream2.h(1, Math.max(stackTraceElement.getLineNumber(), 0)) : CodedOutputStream2.h(1, 0L)) + 0;
        if (stackTraceElement.getFileName() != null) {
            iB += CodedOutputStream2.b(3, ByteString2.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            iB += CodedOutputStream2.h(4, stackTraceElement.getLineNumber());
        }
        return CodedOutputStream2.f(5, z2 ? 2 : 0) + iB;
    }

    public static int i(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z2) {
        int iF = CodedOutputStream2.f(2, i) + CodedOutputStream2.b(1, ByteString2.a(thread.getName()));
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int iH = h(stackTraceElement, z2);
            iF += CodedOutputStream2.d(iH) + CodedOutputStream2.e(3) + iH;
        }
        return iF;
    }

    public static ByteString2 j(String str) {
        if (str == null) {
            return null;
        }
        return ByteString2.a(str);
    }

    public static void k(CodedOutputStream2 codedOutputStream2, int i, StackTraceElement stackTraceElement, boolean z2) throws Exception {
        codedOutputStream2.o((i << 3) | 2);
        codedOutputStream2.o(h(stackTraceElement, z2));
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream2.t(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            codedOutputStream2.t(1, 0L);
        }
        codedOutputStream2.l(2, ByteString2.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream2.l(3, ByteString2.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream2.t(4, stackTraceElement.getLineNumber());
        }
        codedOutputStream2.s(5, z2 ? 4 : 0);
    }

    public static void l(CodedOutputStream2 codedOutputStream2, TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) throws Exception {
        codedOutputStream2.o((i3 << 3) | 2);
        codedOutputStream2.o(c(trimmedThrowableData, 1, i2));
        codedOutputStream2.l(1, ByteString2.a(trimmedThrowableData.f1753b));
        String str = trimmedThrowableData.a;
        if (str != null) {
            codedOutputStream2.l(3, ByteString2.a(str));
        }
        int i4 = 0;
        for (StackTraceElement stackTraceElement : trimmedThrowableData.c) {
            k(codedOutputStream2, 4, stackTraceElement, true);
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.d;
        if (trimmedThrowableData2 != null) {
            if (i < i2) {
                l(codedOutputStream2, trimmedThrowableData2, i + 1, i2, 6);
                return;
            }
            while (trimmedThrowableData2 != null) {
                trimmedThrowableData2 = trimmedThrowableData2.d;
                i4++;
            }
            codedOutputStream2.s(7, i4);
        }
    }

    public static void m(CodedOutputStream2 codedOutputStream2, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z2) throws Exception {
        codedOutputStream2.r(1, 2);
        codedOutputStream2.o(i(thread, stackTraceElementArr, i, z2));
        codedOutputStream2.l(1, ByteString2.a(thread.getName()));
        codedOutputStream2.s(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            k(codedOutputStream2, 3, stackTraceElement, z2);
        }
    }
}
