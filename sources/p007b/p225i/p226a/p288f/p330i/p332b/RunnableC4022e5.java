package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.i.b.e5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4022e5 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzz f10686j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ BinderC4257z4 f10687k;

    public RunnableC4022e5(BinderC4257z4 binderC4257z4, zzz zzzVar) {
        this.f10687k = binderC4257z4;
        this.f10686j = zzzVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.f10687k.f11390a.m5717R();
        if (this.f10686j.f20702l.m9117w0() == null) {
            C4097k9 c4097k9 = this.f10687k.f11390a;
            zzz zzzVar = this.f10686j;
            Objects.requireNonNull(c4097k9);
            zzn zznVarM5744y = c4097k9.m5744y(zzzVar.f20700j);
            if (zznVarM5744y != null) {
                c4097k9.m5705F(zzzVar, zznVarM5744y);
                return;
            }
            return;
        }
        C4097k9 c4097k10 = this.f10687k.f11390a;
        zzz zzzVar2 = this.f10686j;
        Objects.requireNonNull(c4097k10);
        zzn zznVarM5744y2 = c4097k10.m5744y(zzzVar2.f20700j);
        if (zznVarM5744y2 != null) {
            c4097k10.m5736q(zzzVar2, zznVarM5744y2);
        }
    }
}
