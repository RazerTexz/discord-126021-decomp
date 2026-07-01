package b.i.c.m.d.k;

import android.app.ActivityManager;
import android.app.ActivityManager$MemoryInfo;
import android.app.ActivityManager$RunningAppProcessInfo;
import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import b.i.c.m.d.m.k$b;
import b.i.c.m.d.m.r$b;
import b.i.c.m.d.m.v$d$d$a;
import b.i.c.m.d.m.v$d$d$a$b$a;
import b.i.c.m.d.m.v$d$d$a$b$b;
import b.i.c.m.d.m.v$d$d$b;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SessionReportingCoordinator.java */
/* JADX INFO: loaded from: classes3.dex */
public class d1 {
    public final n0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.c.m.d.o.g f1680b;
    public final b.i.c.m.d.r.c c;
    public final b.i.c.m.d.l.b d;
    public final f1 e;

    public d1(n0 n0Var, b.i.c.m.d.o.g gVar, b.i.c.m.d.r.c cVar, b.i.c.m.d.l.b bVar, f1 f1Var) {
        this.a = n0Var;
        this.f1680b = gVar;
        this.c = cVar;
        this.d = bVar;
        this.e = f1Var;
    }

    public final void a(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j, boolean z2) {
        b.i.c.m.d.m.s sVar;
        boolean zEquals = str2.equals("crash");
        n0 n0Var = this.a;
        int i = n0Var.c.getResources().getConfiguration().orientation;
        b.i.c.m.d.t.e eVar = new b.i.c.m.d.t.e(th, n0Var.f);
        Long lValueOf = Long.valueOf(j);
        ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfoI = h.i(n0Var.e.d, n0Var.c);
        Boolean boolValueOf = activityManager$RunningAppProcessInfoI != null ? Boolean.valueOf(activityManager$RunningAppProcessInfoI.importance != 100) : null;
        Integer numValueOf = Integer.valueOf(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(n0Var.c(thread, eVar.c, 4));
        if (z2) {
            for (Map$Entry<Thread, StackTraceElement[]> map$Entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = map$Entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(n0Var.c(key, n0Var.f.a(map$Entry.getValue()), 0));
                }
            }
        }
        b.i.c.m.d.m.w wVar = new b.i.c.m.d.m.w(arrayList);
        v$d$d$a$b$b v_d_d_a_b_bA = n0Var.a(eVar, 4, 8, 0);
        Long l = 0L;
        String str3 = l == null ? " address" : "";
        if (!str3.isEmpty()) {
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", str3));
        }
        b.i.c.m.d.m.o oVar = new b.i.c.m.d.m.o("0", "0", l.longValue(), null);
        v$d$d$a$b$a[] v_d_d_a_b_aArr = new v$d$d$a$b$a[1];
        Long l2 = 0L;
        Long l3 = 0L;
        String str4 = n0Var.e.d;
        Objects.requireNonNull(str4, "Null name");
        String str5 = n0Var.e.f1677b;
        String strW = l2 == null ? " baseAddress" : "";
        if (l3 == null) {
            strW = b.d.b.a.a.w(strW, " size");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }
        v_d_d_a_b_aArr[0] = new b.i.c.m.d.m.m(l2.longValue(), l3.longValue(), str4, str5, null);
        b.i.c.m.d.m.l lVar = new b.i.c.m.d.m.l(wVar, v_d_d_a_b_bA, oVar, new b.i.c.m.d.m.w(Arrays.asList(v_d_d_a_b_aArr)), null);
        String str6 = numValueOf == null ? " uiOrientation" : "";
        if (!str6.isEmpty()) {
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", str6));
        }
        b.i.c.m.d.m.k kVar = new b.i.c.m.d.m.k(lVar, null, boolValueOf, numValueOf.intValue(), null);
        e eVarA = e.a(n0Var.c);
        Float f = eVarA.a;
        Double dValueOf = f != null ? Double.valueOf(f.doubleValue()) : null;
        int iB = eVarA.b();
        boolean zM = h.m(n0Var.c);
        long jP = h.p();
        Context context = n0Var.c;
        ActivityManager$MemoryInfo activityManager$MemoryInfo = new ActivityManager$MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(activityManager$MemoryInfo);
        long j2 = jP - activityManager$MemoryInfo.availMem;
        long jA = h.a(Environment.getDataDirectory().getPath());
        r$b r_b = new r$b();
        r_b.a = dValueOf;
        r_b.f1734b = Integer.valueOf(iB);
        r_b.c = Boolean.valueOf(zM);
        r_b.d = Integer.valueOf(i);
        r_b.e = Long.valueOf(j2);
        r_b.f = Long.valueOf(jA);
        v$d$d$b v_d_d_bA = r_b.a();
        String str7 = lValueOf == null ? " timestamp" : "";
        if (!str7.isEmpty()) {
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", str7));
        }
        Long lValueOf2 = Long.valueOf(lValueOf.longValue());
        String strB = this.d.d.b();
        if (strB != null) {
            sVar = new b.i.c.m.d.m.s(strB, null);
        } else {
            b.i.c.m.d.b.a.b("No log data to include with this event.");
            sVar = null;
        }
        Map<String, String> mapA = this.e.a();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.ensureCapacity(mapA.size());
        for (Map$Entry<String, String> map$Entry2 : mapA.entrySet()) {
            String key2 = map$Entry2.getKey();
            Objects.requireNonNull(key2, "Null key");
            String value = map$Entry2.getValue();
            Objects.requireNonNull(value, "Null value");
            arrayList2.add(new b.i.c.m.d.m.c(key2, value, null));
        }
        Collections.sort(arrayList2, c1.j);
        v$d$d$a v_d_d_aA = kVar;
        if (!arrayList2.isEmpty()) {
            k$b k_b = (k$b) kVar.e();
            k_b.f1725b = new b.i.c.m.d.m.w<>(arrayList2);
            v_d_d_aA = k_b.a();
        }
        v$d$d$a v_d_d_a = v_d_d_aA;
        b.i.c.m.d.o.g gVar = this.f1680b;
        String str8 = lValueOf2 != null ? "" : " timestamp";
        if (!str8.isEmpty()) {
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", str8));
        }
        b.i.c.m.d.m.j jVar = new b.i.c.m.d.m.j(lValueOf2.longValue(), str2, v_d_d_a, v_d_d_bA, sVar, null);
        int i2 = ((b.i.c.m.d.s.c) gVar.k).c().b().a;
        File fileH = gVar.h(str);
        Objects.requireNonNull(b.i.c.m.d.o.g.c);
        try {
            b.i.c.m.d.o.g.l(new File(fileH, b.d.b.a.a.y("event", String.format(Locale.US, "%010d", Integer.valueOf(gVar.f.getAndIncrement())), zEquals ? "_" : "")), ((b.i.c.p.h.d) b.i.c.m.d.m.x.h.a).a(jVar));
        } catch (IOException e) {
            b.i.c.m.d.b.a.c("Could not persist event for session " + str, e);
        }
        List<File> listG = b.i.c.m.d.o.g.g(fileH, b.i.c.m.d.o.c.a);
        Collections.sort(listG, b.i.c.m.d.o.d.j);
        int size = listG.size();
        for (File file : listG) {
            if (size <= i2) {
                return;
            }
            b.i.c.m.d.o.g.k(file);
            size--;
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/concurrent/Executor;Ljava/lang/Object;)Lcom/google/android/gms/tasks/Task<Ljava/lang/Void;>; */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public Task b(@NonNull Executor executor, @NonNull int i) {
        if (i == 1) {
            b.i.c.m.d.b.a.b("Send via DataTransport disabled. Removing DataTransport reports.");
            this.f1680b.b();
            return b.i.a.f.e.o.f.Z(null);
        }
        b.i.c.m.d.o.g gVar = this.f1680b;
        List<File> listE = gVar.e();
        ArrayList<o0> arrayList = new ArrayList();
        arrayList.ensureCapacity(((ArrayList) listE).size());
        for (File file : (ArrayList) gVar.e()) {
            try {
                arrayList.add(new c(b.i.c.m.d.o.g.c.f(b.i.c.m.d.o.g.j(file)), file.getName()));
            } catch (IOException e) {
                b.i.c.m.d.b.a.c("Could not load report file " + file + "; deleting", e);
                file.delete();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (o0 o0Var : arrayList) {
            b.i.c.m.d.m.v vVarA = o0Var.a();
            if ((vVarA.h() != null ? (char) 2 : vVarA.e() != null ? (char) 3 : (char) 1) != 3 || i == 3) {
                b.i.c.m.d.r.c cVar = this.c;
                Objects.requireNonNull(cVar);
                b.i.c.m.d.m.v vVarA2 = o0Var.a();
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                cVar.e.b(new b.i.a.b.a(null, vVarA2, b.i.a.b.d.HIGHEST), new b.i.c.m.d.r.a(taskCompletionSource, o0Var));
                arrayList2.add(taskCompletionSource.a.i(executor, new b1(this)));
            } else {
                b.i.c.m.d.b.a.b("Send native reports via DataTransport disabled. Removing DataTransport reports.");
                this.f1680b.c(o0Var.b());
            }
        }
        return b.i.a.f.e.o.f.B1(arrayList2);
    }
}
