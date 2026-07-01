package b.i.c.m.d.r;

import b.i.a.b.TransportScheduleCallback;
import b.i.c.m.d.k.CrashlyticsReportWithSessionId;
import b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: b.i.c.m.d.r.a, reason: use source file name */
/* JADX INFO: compiled from: DataTransportCrashlyticsReportSender.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DataTransportCrashlyticsReportSender implements TransportScheduleCallback {
    public final TaskCompletionSource a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CrashlyticsReportWithSessionId f1745b;

    public DataTransportCrashlyticsReportSender(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.a = taskCompletionSource;
        this.f1745b = crashlyticsReportWithSessionId;
    }

    @Override // b.i.a.b.TransportScheduleCallback
    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.a;
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = this.f1745b;
        CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform8 = DataTransportCrashlyticsReportSender3.a;
        if (exc != null) {
            taskCompletionSource.a(exc);
        } else {
            taskCompletionSource.b(crashlyticsReportWithSessionId);
        }
    }
}
