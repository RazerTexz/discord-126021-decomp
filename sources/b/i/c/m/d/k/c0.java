package b.i.c.m.d.k;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.x;
import b.i.c.m.d.q.ReportUploader;
import b.i.c.m.d.q.c.SessionReport;
import b.i.c.m.d.s.h.AppSettingsData;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0 implements b.i.a.f.n.f<AppSettingsData, Void> {
    public final /* synthetic */ Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f1679b;

    public c0(d0 d0Var, Executor executor) {
        this.f1679b = d0Var;
        this.a = executor;
    }

    @Override // b.i.a.f.n.f
    @NonNull
    public Task<Void> a(@Nullable AppSettingsData appSettingsData) throws Exception {
        AppSettingsData appSettingsData2 = appSettingsData;
        if (appSettingsData2 == null) {
            Logger3.a.g("Received null app settings, cannot send reports at crash time.");
            return b.i.a.f.e.o.f.Z(null);
        }
        x xVar = this.f1679b.n;
        Context context = xVar.i;
        ReportUploader reportUploaderA = ((h0) xVar.r).a(appSettingsData2);
        for (File file : xVar.q()) {
            x.c(appSettingsData2.e, file);
            SessionReport sessionReport = new SessionReport(file, x.f);
            CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = xVar.m;
            crashlyticsBackgroundWorker.b(new CrashlyticsBackgroundWorker2(crashlyticsBackgroundWorker, new x.m(context, sessionReport, reportUploaderA, true)));
        }
        return b.i.a.f.e.o.f.B1(Arrays.asList(x.b(this.f1679b.n), this.f1679b.n.A.b(this.a, b.c.a.y.b.m(appSettingsData2))));
    }
}
