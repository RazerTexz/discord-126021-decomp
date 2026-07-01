package b.i.a.f.i.b;

import android.app.job.JobParameters;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r8 implements Runnable {
    public final p8 j;
    public final q3 k;
    public final JobParameters l;

    public r8(p8 p8Var, q3 q3Var, JobParameters jobParameters) {
        this.j = p8Var;
        this.k = q3Var;
        this.l = jobParameters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p8 p8Var = this.j;
        q3 q3Var = this.k;
        JobParameters jobParameters = this.l;
        Objects.requireNonNull(p8Var);
        q3Var.n.a("AppMeasurementJobService processed last upload request.");
        p8Var.a.a(jobParameters, false);
    }
}
