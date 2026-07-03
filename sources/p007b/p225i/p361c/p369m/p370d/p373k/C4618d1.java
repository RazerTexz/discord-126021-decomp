package p007b.p225i.p361c.p369m.p370d.p373k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.C2406a;
import p007b.p225i.p226a.p228b.EnumC2409d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p374l.C4670b;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;
import p007b.p225i.p361c.p369m.p370d.p375m.C4676c;
import p007b.p225i.p361c.p369m.p370d.p375m.C4683j;
import p007b.p225i.p361c.p369m.p370d.p375m.C4684k;
import p007b.p225i.p361c.p369m.p370d.p375m.C4685l;
import p007b.p225i.p361c.p369m.p370d.p375m.C4686m;
import p007b.p225i.p361c.p369m.p370d.p375m.C4688o;
import p007b.p225i.p361c.p369m.p370d.p375m.C4691r;
import p007b.p225i.p361c.p369m.p370d.p375m.C4692s;
import p007b.p225i.p361c.p369m.p370d.p375m.C4696w;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.C4704h;
import p007b.p225i.p361c.p369m.p370d.p378o.C4714g;
import p007b.p225i.p361c.p369m.p370d.p383r.C4730a;
import p007b.p225i.p361c.p369m.p370d.p383r.C4732c;
import p007b.p225i.p361c.p369m.p370d.p384s.C4735c;
import p007b.p225i.p361c.p369m.p370d.p387t.C4756e;
import p007b.p225i.p361c.p393p.p395h.C4793d;

/* JADX INFO: renamed from: b.i.c.m.d.k.d1 */
/* JADX INFO: compiled from: SessionReportingCoordinator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4618d1 {

    /* JADX INFO: renamed from: a */
    public final C4644n0 f12278a;

    /* JADX INFO: renamed from: b */
    public final C4714g f12279b;

    /* JADX INFO: renamed from: c */
    public final C4732c f12280c;

    /* JADX INFO: renamed from: d */
    public final C4670b f12281d;

    /* JADX INFO: renamed from: e */
    public final C4624f1 f12282e;

    public C4618d1(C4644n0 c4644n0, C4714g c4714g, C4732c c4732c, C4670b c4670b, C4624f1 c4624f1) {
        this.f12278a = c4644n0;
        this.f12279b = c4714g;
        this.f12280c = c4732c;
        this.f12281d = c4670b;
        this.f12282e = c4624f1;
    }

    /* JADX INFO: renamed from: a */
    public final void m6399a(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j, boolean z2) {
        C4692s c4692s;
        boolean zEquals = str2.equals("crash");
        C4644n0 c4644n0 = this.f12278a;
        int i = c4644n0.f12355c.getResources().getConfiguration().orientation;
        C4756e c4756e = new C4756e(th, c4644n0.f12358f);
        Long lValueOf = Long.valueOf(j);
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoM6415i = C4628h.m6415i(c4644n0.f12357e.f12262d, c4644n0.f12355c);
        Boolean boolValueOf = runningAppProcessInfoM6415i != null ? Boolean.valueOf(runningAppProcessInfoM6415i.importance != 100) : null;
        Integer numValueOf = Integer.valueOf(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(c4644n0.m6448c(thread, c4756e.f12779c, 4));
        if (z2) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(c4644n0.m6448c(key, c4644n0.f12358f.mo6696a(entry.getValue()), 0));
                }
            }
        }
        C4696w c4696w = new C4696w(arrayList);
        AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236bM6446a = c4644n0.m6446a(c4756e, 4, 8, 0);
        Long l = 0L;
        String str3 = l == null ? " address" : "";
        if (!str3.isEmpty()) {
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", str3));
        }
        C4688o c4688o = new C4688o("0", "0", l.longValue(), null);
        AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a[] abstractC13235aArr = new AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a[1];
        Long l2 = 0L;
        Long l3 = 0L;
        String str4 = c4644n0.f12357e.f12262d;
        Objects.requireNonNull(str4, "Null name");
        String str5 = c4644n0.f12357e.f12260b;
        String strM883w = l2 == null ? " baseAddress" : "";
        if (l3 == null) {
            strM883w = C1643a.m883w(strM883w, " size");
        }
        if (!strM883w.isEmpty()) {
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }
        abstractC13235aArr[0] = new C4686m(l2.longValue(), l3.longValue(), str4, str5, null);
        C4685l c4685l = new C4685l(c4696w, abstractC13236bM6446a, c4688o, new C4696w(Arrays.asList(abstractC13235aArr)), null);
        String str6 = numValueOf == null ? " uiOrientation" : "";
        if (!str6.isEmpty()) {
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", str6));
        }
        C4684k c4684k = new C4684k(c4685l, null, boolValueOf, numValueOf.intValue(), null);
        C4619e c4619eM6401a = C4619e.m6401a(c4644n0.f12355c);
        Float f = c4619eM6401a.f12283a;
        Double dValueOf = f != null ? Double.valueOf(f.doubleValue()) : null;
        int iM6402b = c4619eM6401a.m6402b();
        boolean zM6419m = C4628h.m6419m(c4644n0.f12355c);
        long jM6422p = C4628h.m6422p();
        Context context = c4644n0.f12355c;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        long j2 = jM6422p - memoryInfo.availMem;
        long jM6407a = C4628h.m6407a(Environment.getDataDirectory().getPath());
        C4691r.b bVar = new C4691r.b();
        bVar.f12635a = dValueOf;
        bVar.f12636b = Integer.valueOf(iM6402b);
        bVar.f12637c = Boolean.valueOf(zM6419m);
        bVar.f12638d = Integer.valueOf(i);
        bVar.f12639e = Long.valueOf(j2);
        bVar.f12640f = Long.valueOf(jM6407a);
        AbstractC4695v.d.AbstractC13233d.b bVarM6605a = bVar.m6605a();
        String str7 = lValueOf == null ? " timestamp" : "";
        if (!str7.isEmpty()) {
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", str7));
        }
        Long lValueOf2 = Long.valueOf(lValueOf.longValue());
        String strMo6492b = this.f12281d.f12473d.mo6492b();
        if (strMo6492b != null) {
            c4692s = new C4692s(strMo6492b, null);
        } else {
            C4592b.f12227a.m6371b("No log data to include with this event.");
            c4692s = null;
        }
        Map<String, String> mapM6404a = this.f12282e.m6404a();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.ensureCapacity(mapM6404a.size());
        for (Map.Entry<String, String> entry2 : mapM6404a.entrySet()) {
            String key2 = entry2.getKey();
            Objects.requireNonNull(key2, "Null key");
            String value = entry2.getValue();
            Objects.requireNonNull(value, "Null value");
            arrayList2.add(new C4676c(key2, value, null));
        }
        Collections.sort(arrayList2, new Comparator() { // from class: b.i.c.m.d.k.c1
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                return ((AbstractC4695v.b) obj).mo6525a().compareTo(((AbstractC4695v.b) obj2).mo6525a());
            }
        });
        AbstractC4695v.d.AbstractC13233d.a aVarM6573a = c4684k;
        if (!arrayList2.isEmpty()) {
            C4684k.b bVar2 = (C4684k.b) c4684k.m6572e();
            bVar2.f12597b = new C4696w<>(arrayList2);
            aVarM6573a = bVar2.m6573a();
        }
        AbstractC4695v.d.AbstractC13233d.a aVar = aVarM6573a;
        C4714g c4714g = this.f12279b;
        String str8 = lValueOf2 != null ? "" : " timestamp";
        if (!str8.isEmpty()) {
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", str8));
        }
        C4683j c4683j = new C4683j(lValueOf2.longValue(), str2, aVar, bVarM6605a, c4692s, null);
        int i2 = ((C4735c) c4714g.f12682k).m6685c().mo6690b().f12758a;
        File fileM6635h = c4714g.m6635h(str);
        Objects.requireNonNull(C4714g.f12674c);
        try {
            C4714g.m6631l(new File(fileM6635h, C1643a.m886y("event", String.format(Locale.US, "%010d", Integer.valueOf(c4714g.f12677f.getAndIncrement())), zEquals ? "_" : "")), ((C4793d) C4704h.f12656a).m6711a(c4683j));
        } catch (IOException e) {
            C4592b.f12227a.m6372c("Could not persist event for session " + str, e);
        }
        List<File> listM6627g = C4714g.m6627g(fileM6635h, new FilenameFilter() { // from class: b.i.c.m.d.o.c
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str9) {
                Charset charset = C4714g.f12672a;
                return str9.startsWith("event") && !str9.endsWith("_");
            }
        });
        Collections.sort(listM6627g, new Comparator() { // from class: b.i.c.m.d.o.d
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                Charset charset = C4714g.f12672a;
                String name = ((File) obj).getName();
                int i3 = C4714g.f12673b;
                return name.substring(0, i3).compareTo(((File) obj2).getName().substring(0, i3));
            }
        });
        int size = listM6627g.size();
        for (File file : listM6627g) {
            if (size <= i2) {
                return;
            }
            C4714g.m6630k(file);
            size--;
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/concurrent/Executor;Ljava/lang/Object;)Lcom/google/android/gms/tasks/Task<Ljava/lang/Void;>; */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: b */
    public Task m6400b(@NonNull Executor executor, @NonNull int i) {
        if (i == 1) {
            C4592b.f12227a.m6371b("Send via DataTransport disabled. Removing DataTransport reports.");
            this.f12279b.m6632b();
            return C3404f.m4264Z(null);
        }
        C4714g c4714g = this.f12279b;
        List<File> listM6634e = c4714g.m6634e();
        ArrayList<AbstractC4646o0> arrayList = new ArrayList();
        arrayList.ensureCapacity(((ArrayList) listM6634e).size());
        for (File file : (ArrayList) c4714g.m6634e()) {
            try {
                arrayList.add(new C4613c(C4714g.f12674c.m6619f(C4714g.m6629j(file)), file.getName()));
            } catch (IOException e) {
                C4592b.f12227a.m6372c("Could not load report file " + file + "; deleting", e);
                file.delete();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (AbstractC4646o0 abstractC4646o0 : arrayList) {
            AbstractC4695v abstractC4695vMo6396a = abstractC4646o0.mo6396a();
            if ((abstractC4695vMo6396a.mo6522h() != null ? (char) 2 : abstractC4695vMo6396a.mo6519e() != null ? (char) 3 : (char) 1) != 3 || i == 3) {
                C4732c c4732c = this.f12280c;
                Objects.requireNonNull(c4732c);
                AbstractC4695v abstractC4695vMo6396a2 = abstractC4646o0.mo6396a();
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                c4732c.f12727e.mo2290b(new C2406a(null, abstractC4695vMo6396a2, EnumC2409d.HIGHEST), new C4730a(taskCompletionSource, abstractC4646o0));
                arrayList2.add(taskCompletionSource.f20845a.mo6014i(executor, (InterfaceC4353a<TResult, TContinuationResult>) new InterfaceC4353a(this) { // from class: b.i.c.m.d.k.b1

                    /* JADX INFO: renamed from: a */
                    public final C4618d1 f12267a;

                    {
                        this.f12267a = this;
                    }

                    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
                    /* JADX INFO: renamed from: a */
                    public Object mo4012a(Task task) {
                        boolean z2;
                        C4618d1 c4618d1 = this.f12267a;
                        Objects.requireNonNull(c4618d1);
                        if (task.mo6021p()) {
                            AbstractC4646o0 abstractC4646o1 = (AbstractC4646o0) task.mo6017l();
                            C4592b c4592b = C4592b.f12227a;
                            StringBuilder sbM833U = C1643a.m833U("Crashlytics report successfully enqueued to DataTransport: ");
                            sbM833U.append(abstractC4646o1.mo6397b());
                            c4592b.m6371b(sbM833U.toString());
                            c4618d1.f12279b.m6633c(abstractC4646o1.mo6397b());
                            z2 = true;
                        } else {
                            C4592b c4592b2 = C4592b.f12227a;
                            Exception excMo6016k = task.mo6016k();
                            if (c4592b2.m6370a(3)) {
                                Log.d("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", excMo6016k);
                            }
                            z2 = false;
                        }
                        return Boolean.valueOf(z2);
                    }
                }));
            } else {
                C4592b.f12227a.m6371b("Send native reports via DataTransport disabled. Removing DataTransport reports.");
                this.f12279b.m6633c(abstractC4646o0.mo6397b());
            }
        }
        return C3404f.m4194B1(arrayList2);
    }
}
