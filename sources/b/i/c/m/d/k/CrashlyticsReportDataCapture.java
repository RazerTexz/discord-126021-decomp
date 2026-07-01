package b.i.c.m.d.k;

import android.content.Context;
import b.d.b.a.outline;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import b.i.c.m.d.m.CrashlyticsReport;
import b.i.c.m.d.m.ImmutableList3;
import b.i.c.m.d.t.StackTraceTrimmingStrategy;
import b.i.c.m.d.t.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.c.m.d.k.n0, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsReportDataCapture.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsReportDataCapture {
    public static final String a = String.format(Locale.US, "Crashlytics Android SDK/%s", "17.3.0");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f1691b;
    public final Context c;
    public final IdManager d;
    public final AppData e;
    public final StackTraceTrimmingStrategy f;

    static {
        HashMap map = new HashMap();
        f1691b = map;
        outline.j0(5, map, "armeabi", 6, "armeabi-v7a", 9, "arm64-v8a", 0, "x86");
        map.put("x86_64", 1);
    }

    public CrashlyticsReportDataCapture(Context context, IdManager idManager, AppData appData, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.c = context;
        this.d = idManager;
        this.e = appData;
        this.f = stackTraceTrimmingStrategy;
    }

    public final CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b a(TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) {
        String str = trimmedThrowableData.f1753b;
        String str2 = trimmedThrowableData.a;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.c;
        int i4 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.d;
        if (i3 >= i2) {
            TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2;
            while (trimmedThrowableData3 != null) {
                trimmedThrowableData3 = trimmedThrowableData3.d;
                i4++;
            }
        }
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052bA = null;
        Objects.requireNonNull(str, "Null type");
        ImmutableList3 immutableList3 = new ImmutableList3(b(stackTraceElementArr, i));
        Integer numValueOf = Integer.valueOf(i4);
        if (trimmedThrowableData2 != null && i4 == 0) {
            abstractC0052bA = a(trimmedThrowableData2, i, i2, i3 + 1);
        }
        String str3 = numValueOf == null ? " overflowCount" : "";
        if (str3.isEmpty()) {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(str, str2, immutableList3, abstractC0052bA, numValueOf.intValue(), null);
        }
        throw new IllegalStateException(outline.w("Missing required properties:", str3));
    }

    public final ImmutableList3<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a> b(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.b();
            bVar.e = Integer.valueOf(i);
            long lineNumber = 0;
            long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
            String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
                lineNumber = stackTraceElement.getLineNumber();
            }
            bVar.a = Long.valueOf(jMax);
            Objects.requireNonNull(str, "Null symbol");
            bVar.f1732b = str;
            bVar.c = fileName;
            bVar.d = Long.valueOf(lineNumber);
            arrayList.add(bVar.a());
        }
        return new ImmutableList3<>(arrayList);
    }

    public final CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d c(Thread thread, StackTraceElement[] stackTraceElementArr, int i) {
        String name = thread.getName();
        Objects.requireNonNull(name, "Null name");
        Integer numValueOf = Integer.valueOf(i);
        ImmutableList3 immutableList3 = new ImmutableList3(b(stackTraceElementArr, i));
        String str = numValueOf == null ? " importance" : "";
        if (str.isEmpty()) {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(name, numValueOf.intValue(), immutableList3, null);
        }
        throw new IllegalStateException(outline.w("Missing required properties:", str));
    }
}
