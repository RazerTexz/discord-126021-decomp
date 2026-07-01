package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzn;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j5 implements Runnable {
    public final /* synthetic */ zzaq j;
    public final /* synthetic */ zzn k;
    public final /* synthetic */ z4 l;

    public j5(z4 z4Var, zzaq zzaqVar, zzn zznVar) {
        this.l = z4Var;
        this.j = zzaqVar;
        this.k = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzap zzapVar;
        z4 z4Var = this.l;
        zzaq zzaqVar = this.j;
        Objects.requireNonNull(z4Var);
        boolean z2 = false;
        if ("_cmp".equals(zzaqVar.j) && (zzapVar = zzaqVar.k) != null && zzapVar.j.size() != 0) {
            String string = zzaqVar.k.j.getString("_cis");
            if ("referrer broadcast".equals(string) || "referrer API".equals(string)) {
                z2 = true;
            }
        }
        if (z2) {
            z4Var.a.g().l.b("Event has been filtered ", zzaqVar.toString());
            zzaqVar = new zzaq("_cmpx", zzaqVar.k, zzaqVar.l, zzaqVar.m);
        }
        this.l.a.R();
        this.l.a.l(zzaqVar, this.k);
    }
}
