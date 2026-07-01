package b.i.c.m.d.k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import b.i.a.b.AutoValue_Event;
import b.i.a.b.Priority3;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.l.LogFileManager;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_CustomAttribute;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Device;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Log;
import b.i.c.m.d.m.CrashlyticsReport;
import b.i.c.m.d.m.ImmutableList3;
import b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8;
import b.i.c.m.d.o.CrashlyticsReportPersistence7;
import b.i.c.m.d.r.DataTransportCrashlyticsReportSender;
import b.i.c.m.d.r.DataTransportCrashlyticsReportSender3;
import b.i.c.m.d.s.SettingsController;
import b.i.c.m.d.t.TrimmedThrowableData;
import b.i.c.p.h.JsonDataEncoderBuilder4;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.c.m.d.k.d1, reason: use source file name */
/* JADX INFO: compiled from: SessionReportingCoordinator.java */
/* JADX INFO: loaded from: classes3.dex */
public class SessionReportingCoordinator3 {
    public final CrashlyticsReportDataCapture a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CrashlyticsReportPersistence7 f1680b;
    public final DataTransportCrashlyticsReportSender3 c;
    public final LogFileManager d;
    public final UserMetadata e;

    public SessionReportingCoordinator3(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence7 crashlyticsReportPersistence7, DataTransportCrashlyticsReportSender3 dataTransportCrashlyticsReportSender3, LogFileManager logFileManager, UserMetadata userMetadata) {
        this.a = crashlyticsReportDataCapture;
        this.f1680b = crashlyticsReportPersistence7;
        this.c = dataTransportCrashlyticsReportSender3;
        this.d = logFileManager;
        this.e = userMetadata;
    }

    public final void a(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j, boolean z2) {
        AutoValue_CrashlyticsReport_Session_Event_Log autoValue_CrashlyticsReport_Session_Event_Log;
        boolean zEquals = str2.equals("crash");
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = this.a;
        int i = crashlyticsReportDataCapture.c.getResources().getConfiguration().orientation;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, crashlyticsReportDataCapture.f);
        Long lValueOf = Long.valueOf(j);
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoI = CommonUtils.i(crashlyticsReportDataCapture.e.d, crashlyticsReportDataCapture.c);
        Boolean boolValueOf = runningAppProcessInfoI != null ? Boolean.valueOf(runningAppProcessInfoI.importance != 100) : null;
        Integer numValueOf = Integer.valueOf(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(crashlyticsReportDataCapture.c(thread, trimmedThrowableData.c, 4));
        if (z2) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(crashlyticsReportDataCapture.c(key, crashlyticsReportDataCapture.f.a(entry.getValue()), 0));
                }
            }
        }
        ImmutableList3 immutableList3 = new ImmutableList3(arrayList);
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052bA = crashlyticsReportDataCapture.a(trimmedThrowableData, 4, 8, 0);
        Long l = 0L;
        String str3 = l == null ? " address" : "";
        if (!str3.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", str3));
        }
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal("0", "0", l.longValue(), null);
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a[] abstractC0051aArr = new CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a[1];
        Long l2 = 0L;
        Long l3 = 0L;
        String str4 = crashlyticsReportDataCapture.e.d;
        Objects.requireNonNull(str4, "Null name");
        String str5 = crashlyticsReportDataCapture.e.f1677b;
        String strW = l2 == null ? " baseAddress" : "";
        if (l3 == null) {
            strW = outline.w(strW, " size");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }
        abstractC0051aArr[0] = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(l2.longValue(), l3.longValue(), str4, str5, null);
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution autoValue_CrashlyticsReport_Session_Event_Application_Execution = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(immutableList3, abstractC0052bA, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal, new ImmutableList3(Arrays.asList(abstractC0051aArr)), null);
        String str6 = numValueOf == null ? " uiOrientation" : "";
        if (!str6.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", str6));
        }
        AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_Application = new AutoValue_CrashlyticsReport_Session_Event_Application(autoValue_CrashlyticsReport_Session_Event_Application_Execution, null, boolValueOf, numValueOf.intValue(), null);
        BatteryState batteryStateA = BatteryState.a(crashlyticsReportDataCapture.c);
        Float f = batteryStateA.a;
        Double dValueOf = f != null ? Double.valueOf(f.doubleValue()) : null;
        int iB = batteryStateA.b();
        boolean zM = CommonUtils.m(crashlyticsReportDataCapture.c);
        long jP = CommonUtils.p();
        Context context = crashlyticsReportDataCapture.c;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        long j2 = jP - memoryInfo.availMem;
        long jA = CommonUtils.a(Environment.getDataDirectory().getPath());
        AutoValue_CrashlyticsReport_Session_Event_Device.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Device.b();
        bVar.a = dValueOf;
        bVar.f1734b = Integer.valueOf(iB);
        bVar.c = Boolean.valueOf(zM);
        bVar.d = Integer.valueOf(i);
        bVar.e = Long.valueOf(j2);
        bVar.f = Long.valueOf(jA);
        CrashlyticsReport.d.AbstractC0049d.b bVarA = bVar.a();
        String str7 = lValueOf == null ? " timestamp" : "";
        if (!str7.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", str7));
        }
        Long lValueOf2 = Long.valueOf(lValueOf.longValue());
        String strB = this.d.d.b();
        if (strB != null) {
            autoValue_CrashlyticsReport_Session_Event_Log = new AutoValue_CrashlyticsReport_Session_Event_Log(strB, null);
        } else {
            Logger3.a.b("No log data to include with this event.");
            autoValue_CrashlyticsReport_Session_Event_Log = null;
        }
        Map<String, String> mapA = this.e.a();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.ensureCapacity(mapA.size());
        for (Map.Entry<String, String> entry2 : mapA.entrySet()) {
            String key2 = entry2.getKey();
            Objects.requireNonNull(key2, "Null key");
            String value = entry2.getValue();
            Objects.requireNonNull(value, "Null value");
            arrayList2.add(new AutoValue_CrashlyticsReport_CustomAttribute(key2, value, null));
        }
        Collections.sort(arrayList2, new Comparator() { // from class: b.i.c.m.d.k.c1
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                return ((CrashlyticsReport.b) obj).a().compareTo(((CrashlyticsReport.b) obj2).a());
            }
        });
        CrashlyticsReport.d.AbstractC0049d.a aVarA = autoValue_CrashlyticsReport_Session_Event_Application;
        if (!arrayList2.isEmpty()) {
            AutoValue_CrashlyticsReport_Session_Event_Application.b bVar2 = (AutoValue_CrashlyticsReport_Session_Event_Application.b) autoValue_CrashlyticsReport_Session_Event_Application.e();
            bVar2.f1725b = new ImmutableList3<>(arrayList2);
            aVarA = bVar2.a();
        }
        CrashlyticsReport.d.AbstractC0049d.a aVar = aVarA;
        CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = this.f1680b;
        String str8 = lValueOf2 != null ? "" : " timestamp";
        if (!str8.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", str8));
        }
        AutoValue_CrashlyticsReport_Session_Event autoValue_CrashlyticsReport_Session_Event = new AutoValue_CrashlyticsReport_Session_Event(lValueOf2.longValue(), str2, aVar, bVarA, autoValue_CrashlyticsReport_Session_Event_Log, null);
        int i2 = ((SettingsController) crashlyticsReportPersistence7.k).c().b().a;
        File fileH = crashlyticsReportPersistence7.h(str);
        Objects.requireNonNull(CrashlyticsReportPersistence7.c);
        try {
            CrashlyticsReportPersistence7.l(new File(fileH, outline.y("event", String.format(Locale.US, "%010d", Integer.valueOf(crashlyticsReportPersistence7.f.getAndIncrement())), zEquals ? "_" : "")), ((JsonDataEncoderBuilder4) CrashlyticsReportJsonTransform8.a).a(autoValue_CrashlyticsReport_Session_Event));
        } catch (IOException e) {
            Logger3.a.c("Could not persist event for session " + str, e);
        }
        List<File> listG = CrashlyticsReportPersistence7.g(fileH, new FilenameFilter() { // from class: b.i.c.m.d.o.c
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str9) {
                Charset charset = CrashlyticsReportPersistence7.a;
                return str9.startsWith("event") && !str9.endsWith("_");
            }
        });
        Collections.sort(listG, new Comparator() { // from class: b.i.c.m.d.o.d
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                Charset charset = CrashlyticsReportPersistence7.a;
                String name = ((File) obj).getName();
                int i3 = CrashlyticsReportPersistence7.f1738b;
                return name.substring(0, i3).compareTo(((File) obj2).getName().substring(0, i3));
            }
        });
        int size = listG.size();
        for (File file : listG) {
            if (size <= i2) {
                return;
            }
            CrashlyticsReportPersistence7.k(file);
            size--;
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/concurrent/Executor;Ljava/lang/Object;)Lcom/google/android/gms/tasks/Task<Ljava/lang/Void;>; */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public Task b(@NonNull Executor executor, @NonNull int i) {
        if (i == 1) {
            Logger3.a.b("Send via DataTransport disabled. Removing DataTransport reports.");
            this.f1680b.b();
            return b.i.a.f.e.o.f.Z(null);
        }
        CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = this.f1680b;
        List<File> listE = crashlyticsReportPersistence7.e();
        ArrayList<CrashlyticsReportWithSessionId> arrayList = new ArrayList();
        arrayList.ensureCapacity(((ArrayList) listE).size());
        for (File file : (ArrayList) crashlyticsReportPersistence7.e()) {
            try {
                arrayList.add(new AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReportPersistence7.c.f(CrashlyticsReportPersistence7.j(file)), file.getName()));
            } catch (IOException e) {
                Logger3.a.c("Could not load report file " + file + "; deleting", e);
                file.delete();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (CrashlyticsReportWithSessionId crashlyticsReportWithSessionId : arrayList) {
            CrashlyticsReport crashlyticsReportA = crashlyticsReportWithSessionId.a();
            if ((crashlyticsReportA.h() != null ? (char) 2 : crashlyticsReportA.e() != null ? (char) 3 : (char) 1) != 3 || i == 3) {
                DataTransportCrashlyticsReportSender3 dataTransportCrashlyticsReportSender3 = this.c;
                Objects.requireNonNull(dataTransportCrashlyticsReportSender3);
                CrashlyticsReport crashlyticsReportA2 = crashlyticsReportWithSessionId.a();
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                dataTransportCrashlyticsReportSender3.e.b(new AutoValue_Event(null, crashlyticsReportA2, Priority3.HIGHEST), new DataTransportCrashlyticsReportSender(taskCompletionSource, crashlyticsReportWithSessionId));
                arrayList2.add(taskCompletionSource.a.i(executor, (b.i.a.f.n.a<TResult, TContinuationResult>) new b.i.a.f.n.a(this) { // from class: b.i.c.m.d.k.b1
                    public final SessionReportingCoordinator3 a;

                    {
                        this.a = this;
                    }

                    @Override // b.i.a.f.n.a
                    public Object a(Task task) {
                        boolean z2;
                        SessionReportingCoordinator3 sessionReportingCoordinator3 = this.a;
                        Objects.requireNonNull(sessionReportingCoordinator3);
                        if (task.p()) {
                            CrashlyticsReportWithSessionId crashlyticsReportWithSessionId2 = (CrashlyticsReportWithSessionId) task.l();
                            Logger3 logger3 = Logger3.a;
                            StringBuilder sbU = outline.U("Crashlytics report successfully enqueued to DataTransport: ");
                            sbU.append(crashlyticsReportWithSessionId2.b());
                            logger3.b(sbU.toString());
                            sessionReportingCoordinator3.f1680b.c(crashlyticsReportWithSessionId2.b());
                            z2 = true;
                        } else {
                            Logger3 logger4 = Logger3.a;
                            Exception excK = task.k();
                            if (logger4.a(3)) {
                                Log.d("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", excK);
                            }
                            z2 = false;
                        }
                        return Boolean.valueOf(z2);
                    }
                }));
            } else {
                Logger3.a.b("Send native reports via DataTransport disabled. Removing DataTransport reports.");
                this.f1680b.c(crashlyticsReportWithSessionId.b());
            }
        }
        return b.i.a.f.e.o.f.B1(arrayList2);
    }
}
