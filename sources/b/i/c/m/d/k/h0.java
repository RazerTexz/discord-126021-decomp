package b.i.c.m.d.k;

import android.content.Context;
import androidx.annotation.NonNull;
import b.i.c.m.d.q.ReportUploader;
import b.i.c.m.d.q.d.CompositeCreateReportSpiCall;
import b.i.c.m.d.q.d.DefaultCreateReportSpiCall;
import b.i.c.m.d.q.d.NativeCreateReportSpiCall;
import b.i.c.m.d.s.h.AppSettingsData;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class h0 implements ReportUploader.b {
    public final /* synthetic */ x a;

    public h0(x xVar) {
        this.a = xVar;
    }

    public ReportUploader a(@NonNull AppSettingsData appSettingsData) {
        String str = appSettingsData.c;
        String str2 = appSettingsData.d;
        String str3 = appSettingsData.e;
        x xVar = this.a;
        Context context = xVar.i;
        int iN = CommonUtils.n(context, "com.crashlytics.ApiEndpoint", "string");
        String string = iN > 0 ? context.getString(iN) : "";
        CompositeCreateReportSpiCall compositeCreateReportSpiCall = new CompositeCreateReportSpiCall(new DefaultCreateReportSpiCall(string, str, xVar.n, "17.3.0"), new NativeCreateReportSpiCall(string, str2, xVar.n, "17.3.0"));
        String str4 = this.a.q.a;
        int iM = b.c.a.y.b.m(appSettingsData);
        x xVar2 = this.a;
        return new ReportUploader(str3, str4, iM, xVar2.u, compositeCreateReportSpiCall, xVar2.v);
    }
}
