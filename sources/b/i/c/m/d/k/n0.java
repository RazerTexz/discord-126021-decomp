package b.i.c.m.d.k;

import android.content.Context;
import b.i.c.m.d.m.q$b;
import b.i.c.m.d.m.v$d$d$a$b$b;
import b.i.c.m.d.m.v$d$d$a$b$d;
import b.i.c.m.d.m.v$d$d$a$b$d$a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: CrashlyticsReportDataCapture.java */
/* JADX INFO: loaded from: classes3.dex */
public class n0 {
    public static final String a = String.format(Locale.US, "Crashlytics Android SDK/%s", "17.3.0");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f1691b;
    public final Context c;
    public final v0 d;
    public final b e;
    public final b.i.c.m.d.t.d f;

    static {
        HashMap map = new HashMap();
        f1691b = map;
        b.d.b.a.a.j0(5, map, "armeabi", 6, "armeabi-v7a", 9, "arm64-v8a", 0, "x86");
        map.put("x86_64", 1);
    }

    public n0(Context context, v0 v0Var, b bVar, b.i.c.m.d.t.d dVar) {
        this.c = context;
        this.d = v0Var;
        this.e = bVar;
        this.f = dVar;
    }

    public final v$d$d$a$b$b a(b.i.c.m.d.t.e eVar, int i, int i2, int i3) {
        String str = eVar.f1753b;
        String str2 = eVar.a;
        StackTraceElement[] stackTraceElementArr = eVar.c;
        int i4 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        b.i.c.m.d.t.e eVar2 = eVar.d;
        if (i3 >= i2) {
            b.i.c.m.d.t.e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.d;
                i4++;
            }
        }
        v$d$d$a$b$b v_d_d_a_b_bA = null;
        Objects.requireNonNull(str, "Null type");
        b.i.c.m.d.m.w wVar = new b.i.c.m.d.m.w(b(stackTraceElementArr, i));
        Integer numValueOf = Integer.valueOf(i4);
        if (eVar2 != null && i4 == 0) {
            v_d_d_a_b_bA = a(eVar2, i, i2, i3 + 1);
        }
        String str3 = numValueOf == null ? " overflowCount" : "";
        if (str3.isEmpty()) {
            return new b.i.c.m.d.m.n(str, str2, wVar, v_d_d_a_b_bA, numValueOf.intValue(), null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", str3));
    }

    public final b.i.c.m.d.m.w<v$d$d$a$b$d$a> b(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            q$b q_b = new q$b();
            q_b.e = Integer.valueOf(i);
            long lineNumber = 0;
            long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
            String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
                lineNumber = stackTraceElement.getLineNumber();
            }
            q_b.a = Long.valueOf(jMax);
            Objects.requireNonNull(str, "Null symbol");
            q_b.f1732b = str;
            q_b.c = fileName;
            q_b.d = Long.valueOf(lineNumber);
            arrayList.add(q_b.a());
        }
        return new b.i.c.m.d.m.w<>(arrayList);
    }

    public final v$d$d$a$b$d c(Thread thread, StackTraceElement[] stackTraceElementArr, int i) {
        String name = thread.getName();
        Objects.requireNonNull(name, "Null name");
        Integer numValueOf = Integer.valueOf(i);
        b.i.c.m.d.m.w wVar = new b.i.c.m.d.m.w(b(stackTraceElementArr, i));
        String str = numValueOf == null ? " importance" : "";
        if (str.isEmpty()) {
            return new b.i.c.m.d.m.p(name, numValueOf.intValue(), wVar, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", str));
    }
}
