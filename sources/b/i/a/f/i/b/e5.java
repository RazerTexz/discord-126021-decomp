package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e5 implements Runnable {
    public final /* synthetic */ zzz j;
    public final /* synthetic */ z4 k;

    public e5(z4 z4Var, zzz zzzVar) {
        this.k = z4Var;
        this.j = zzzVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.k.a.R();
        if (this.j.l.w0() == null) {
            k9 k9Var = this.k.a;
            zzz zzzVar = this.j;
            Objects.requireNonNull(k9Var);
            zzn zznVarY = k9Var.y(zzzVar.j);
            if (zznVarY != null) {
                k9Var.F(zzzVar, zznVarY);
                return;
            }
            return;
        }
        k9 k9Var2 = this.k.a;
        zzz zzzVar2 = this.j;
        Objects.requireNonNull(k9Var2);
        zzn zznVarY2 = k9Var2.y(zzzVar2.j);
        if (zznVarY2 != null) {
            k9Var2.q(zzzVar2, zznVarY2);
        }
    }
}
