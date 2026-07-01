package b.i.c.m.d.r;

import b.i.a.b.h;
import b.i.c.m.d.k.o0;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: DataTransportCrashlyticsReportSender.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements h {
    public final TaskCompletionSource a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f1745b;

    public a(TaskCompletionSource taskCompletionSource, o0 o0Var) {
        this.a = taskCompletionSource;
        this.f1745b = o0Var;
    }

    @Override // b.i.a.b.h
    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.a;
        o0 o0Var = this.f1745b;
        b.i.c.m.d.m.x.h hVar = c.a;
        if (exc != null) {
            taskCompletionSource.a(exc);
        } else {
            taskCompletionSource.b(o0Var);
        }
    }
}
