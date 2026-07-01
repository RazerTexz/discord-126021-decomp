package b.i.a.f.h.l;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import b.i.a.f.h.l.g;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends g.a {
    public final /* synthetic */ String n;
    public final /* synthetic */ String o;
    public final /* synthetic */ Context p;
    public final /* synthetic */ Bundle q;
    public final /* synthetic */ g r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, String str, String str2, Context context, Bundle bundle) {
        super(true);
        this.r = gVar;
        this.n = str;
        this.o = str2;
        this.p = context;
        this.q = bundle;
    }

    @Override // b.i.a.f.h.l.g.a
    public final void a() {
        String str;
        String str2;
        String str3;
        boolean z2;
        int iMax;
        try {
            ec ecVarAsInterface = null;
            if (g.e(this.n, this.o)) {
                str3 = this.o;
                str2 = this.n;
                str = this.r.c;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            g.d(this.p);
            boolean z3 = g.f1442b.booleanValue() || str2 != null;
            g gVar = this.r;
            Context context = this.p;
            Objects.requireNonNull(gVar);
            try {
                ecVarAsInterface = dc.asInterface(DynamiteModule.c(context, z3 ? DynamiteModule.c : DynamiteModule.a, ModuleDescriptor.MODULE_ID).b("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
            } catch (DynamiteModule.LoadingException e) {
                gVar.b(e, true, false);
            }
            gVar.j = ecVarAsInterface;
            if (this.r.j == null) {
                Log.w(this.r.c, "Failed to connect to measurement client.");
                return;
            }
            int iA = DynamiteModule.a(this.p, ModuleDescriptor.MODULE_ID);
            int iD = DynamiteModule.d(this.p, ModuleDescriptor.MODULE_ID, false);
            if (z3) {
                iMax = Math.max(iA, iD);
                z2 = iD < iA;
            } else {
                if (iA > 0) {
                    iD = iA;
                }
                z2 = iA > 0;
                iMax = iD;
            }
            this.r.j.initialize(new b.i.a.f.f.b(this.p), new zzae(33025L, iMax, z2, str, str2, str3, this.q), this.j);
        } catch (Exception e2) {
            this.r.b(e2, true, false);
        }
    }
}
