package b.f.d.e;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import b.d.b.a.outline;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: renamed from: b.f.d.e.a, reason: use source file name */
/* JADX INFO: compiled from: FLog.java */
/* JADX INFO: loaded from: classes.dex */
public class FLog {
    public static final /* synthetic */ int a = 0;

    public static void a(Class<?> cls, String str) {
        Log.println(6, EnvironmentCompat.MEDIA_UNKNOWN + ":" + cls.getSimpleName(), str);
    }

    public static void b(Class<?> cls, String str, Throwable th) {
        String strY = outline.y(EnvironmentCompat.MEDIA_UNKNOWN, ":", cls.getSimpleName());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('\n');
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        sb.append(stringWriter.toString());
        Log.println(6, strY, sb.toString());
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        String simpleName = cls.getSimpleName();
        Log.println(6, EnvironmentCompat.MEDIA_UNKNOWN + ":" + simpleName, g(str, objArr));
    }

    public static void d(Class<?> cls, Throwable th, String str, Object... objArr) {
        String simpleName = cls.getSimpleName();
        String strG = g(str, objArr);
        String strY = outline.y(EnvironmentCompat.MEDIA_UNKNOWN, ":", simpleName);
        StringBuilder sb = new StringBuilder();
        sb.append(strG);
        sb.append('\n');
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        sb.append(stringWriter.toString());
        Log.println(6, strY, sb.toString());
    }

    public static void e(String str, String str2) {
        Log.println(6, EnvironmentCompat.MEDIA_UNKNOWN + ":" + str, str2);
    }

    public static void f(String str, String str2, Throwable th) {
        String string;
        String strY = outline.y(EnvironmentCompat.MEDIA_UNKNOWN, ":", str);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append('\n');
        if (th == null) {
            string = "";
        } else {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        }
        sb.append(string);
        Log.println(6, strY, sb.toString());
    }

    public static String g(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    public static boolean h(int i) {
        return 5 <= i;
    }

    public static void i(Class<?> cls, String str) {
        if (0 != 0) {
            Log.println(2, EnvironmentCompat.MEDIA_UNKNOWN + ":" + cls.getSimpleName(), str);
        }
    }

    public static void j(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (h(2)) {
            i(cls, g(str, obj, obj2, obj3));
        }
    }

    public static void k(Class<?> cls, String str) {
        Log.println(5, EnvironmentCompat.MEDIA_UNKNOWN + ":" + cls.getSimpleName(), str);
    }

    public static void l(Class<?> cls, String str, Throwable th) {
        String string;
        if (1 != 0) {
            String strY = outline.y(EnvironmentCompat.MEDIA_UNKNOWN, ":", cls.getSimpleName());
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('\n');
            if (th == null) {
                string = "";
            } else {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                string = stringWriter.toString();
            }
            sb.append(string);
            Log.println(5, strY, sb.toString());
        }
    }

    public static void m(Class<?> cls, String str, Object... objArr) {
        String simpleName = cls.getSimpleName();
        Log.println(5, EnvironmentCompat.MEDIA_UNKNOWN + ":" + simpleName, g(str, objArr));
    }

    public static void n(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (h(5)) {
            l(cls, g(str, objArr), th);
        }
    }

    public static void o(String str, String str2, Object... objArr) {
        Log.println(5, EnvironmentCompat.MEDIA_UNKNOWN + ":" + str, g(str2, objArr));
    }

    public static void p(String str, String str2, Object... objArr) {
        Log.println(6, EnvironmentCompat.MEDIA_UNKNOWN + ":" + str, g(str2, objArr));
    }
}
