package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.q.ReportUploader;
import b.i.c.m.d.q.ReportUploader.d;
import b.i.c.m.d.q.c.Report2;
import b.i.c.m.d.s.h.AppSettingsData;
import com.google.android.gms.tasks.Task;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class f0 implements b.i.a.f.n.f<AppSettingsData, Void> {
    public final /* synthetic */ List a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1682b;
    public final /* synthetic */ Executor c;
    public final /* synthetic */ g0 d;

    public f0(g0 g0Var, List list, boolean z2, Executor executor) {
        this.d = g0Var;
        this.a = list;
        this.f1682b = z2;
        this.c = executor;
    }

    @Override // b.i.a.f.n.f
    @NonNull
    public Task<Void> a(@Nullable AppSettingsData appSettingsData) throws Exception {
        AppSettingsData appSettingsData2 = appSettingsData;
        if (appSettingsData2 == null) {
            Logger3.a.g("Received null app settings, cannot send reports during app startup.");
            return b.i.a.f.e.o.f.Z(null);
        }
        for (Report2 report2 : this.a) {
            if (report2.d() == 1) {
                x.c(appSettingsData2.e, report2.c());
            }
        }
        x.b(x.this);
        ReportUploader reportUploaderA = ((h0) x.this.r).a(appSettingsData2);
        List list = this.a;
        boolean z2 = this.f1682b;
        float f = this.d.k.f1704b;
        synchronized (reportUploaderA) {
            if (reportUploaderA.h != null) {
                Logger3.a.b("Report upload has already been started.");
            } else {
                Thread thread = new Thread(reportUploaderA.new d(list, z2, f), "Crashlytics Report Uploader");
                reportUploaderA.h = thread;
                thread.start();
            }
        }
        x.this.A.b(this.c, b.c.a.y.b.m(appSettingsData2));
        x.this.E.b(null);
        return b.i.a.f.e.o.f.Z(null);
    }
}
