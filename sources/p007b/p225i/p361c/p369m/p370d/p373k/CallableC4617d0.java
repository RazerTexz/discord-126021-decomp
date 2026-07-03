package p007b.p225i.p361c.p369m.p370d.p373k;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p379p.C4717b;
import p007b.p225i.p361c.p369m.p370d.p379p.C4718c;
import p007b.p225i.p361c.p369m.p370d.p384s.C4735c;
import p007b.p225i.p361c.p369m.p370d.p384s.InterfaceC4736d;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.InterfaceC4744e;

/* JADX INFO: renamed from: b.i.c.m.d.k.d0 */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC4617d0 implements Callable<Task<Void>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Date f12273j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Throwable f12274k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Thread f12275l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ InterfaceC4736d f12276m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C4663x f12277n;

    public CallableC4617d0(C4663x c4663x, Date date, Throwable th, Thread thread, InterfaceC4736d interfaceC4736d) {
        this.f12277n = c4663x;
        this.f12273j = date;
        this.f12274k = th;
        this.f12275l = thread;
        this.f12276m = interfaceC4736d;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        C4717b c4717b;
        C4718c c4718cM6646i;
        long time = this.f12273j.getTime() / 1000;
        String strM6474i = this.f12277n.m6474i();
        C4718c c4718c = null;
        if (strM6474i == null) {
            C4592b.f12227a.m6373d("Tried to write a fatal exception while no session was open.");
            return C3404f.m4264Z(null);
        }
        this.f12277n.f12431k.m6444a();
        C4618d1 c4618d1 = this.f12277n.f12422A;
        Throwable th = this.f12274k;
        Thread thread = this.f12275l;
        String strReplaceAll = strM6474i.replaceAll("-", "");
        Objects.requireNonNull(c4618d1);
        C1643a.m868o0("Persisting fatal event for session ", strReplaceAll, C4592b.f12227a);
        c4618d1.m6399a(th, thread, strReplaceAll, "crash", time, true);
        C4663x c4663x = this.f12277n;
        Thread thread2 = this.f12275l;
        Throwable th2 = this.f12274k;
        Objects.requireNonNull(c4663x);
        try {
            c4717b = new C4717b(c4663x.m6476l(), strM6474i + "SessionCrash");
            try {
                c4718cM6646i = C4718c.m6646i(c4717b);
                try {
                    try {
                        c4663x.m6485y(c4718cM6646i, thread2, th2, time, "crash", true);
                    } catch (Exception e) {
                        e = e;
                        if (C4592b.f12227a.m6370a(6)) {
                            Log.e("FirebaseCrashlytics", "An error occurred in the fatal exception logger", e);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    c4718c = c4718cM6646i;
                    C4628h.m6414h(c4718c, "Failed to flush to session begin file.");
                    C4628h.m6409c(c4717b, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                c4718cM6646i = null;
            } catch (Throwable th4) {
                th = th4;
                C4628h.m6414h(c4718c, "Failed to flush to session begin file.");
                C4628h.m6409c(c4717b, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            c4718cM6646i = null;
            c4717b = null;
        } catch (Throwable th5) {
            th = th5;
            c4717b = null;
        }
        C4628h.m6414h(c4718cM6646i, "Failed to flush to session begin file.");
        C4628h.m6409c(c4717b, "Failed to close fatal exception file output stream.");
        this.f12277n.m6472g(this.f12273j.getTime());
        InterfaceC4744e interfaceC4744eM6685c = ((C4735c) this.f12276m).m6685c();
        int i = interfaceC4744eM6685c.mo6690b().f12758a;
        Objects.requireNonNull(interfaceC4744eM6685c.mo6690b());
        this.f12277n.m6471f(i, false);
        C4663x.m6461a(this.f12277n);
        C4663x c4663x2 = this.f12277n;
        File fileM6477m = c4663x2.m6477m();
        File fileM6475k = c4663x2.m6475k();
        Comparator<File> comparator = C4663x.f12418d;
        FilenameFilter filenameFilter = C4630h1.f12313a;
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = fileM6477m.listFiles();
        FilenameFilter filenameFilter2 = C4630h1.f12313a;
        File[] fileArrListFiles2 = fileM6475k.listFiles(filenameFilter2);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        if (fileArrListFiles2 == null) {
            fileArrListFiles2 = new File[0];
        }
        arrayList.addAll(Arrays.asList(fileArrListFiles));
        arrayList.addAll(Arrays.asList(fileArrListFiles2));
        int iM6434c = 4 - C4630h1.m6434c(arrayList, 4, comparator);
        C4630h1.m6433b(c4663x2.m6476l(), C4663x.f12416b, iM6434c - C4630h1.m6433b(c4663x2.m6478n(), filenameFilter2, iM6434c, comparator), comparator);
        if (!this.f12277n.f12430j.m6450b()) {
            return C3404f.m4264Z(null);
        }
        Executor executor = this.f12277n.f12433m.f12315a;
        return ((C4735c) this.f12276m).m6683a().mo6023r(executor, new C4614c0(this, executor));
    }
}
