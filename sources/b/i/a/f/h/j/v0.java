package b.i.a.f.h.j;

import android.app.job.JobParameters;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class v0 implements Runnable {
    public final t0 j;
    public final m0 k;
    public final JobParameters l;

    public v0(t0 t0Var, m0 m0Var, JobParameters jobParameters) {
        this.j = t0Var;
        this.k = m0Var;
        this.l = jobParameters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t0 t0Var = this.j;
        m0 m0Var = this.k;
        JobParameters jobParameters = this.l;
        Objects.requireNonNull(t0Var);
        m0Var.C("AnalyticsJobService processed last dispatch request");
        t0Var.c.a(jobParameters, false);
    }
}
