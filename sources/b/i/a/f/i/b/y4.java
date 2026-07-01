package b.i.a.f.i.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import b.i.a.f.h.l.a1$a;
import b.i.a.f.h.l.c1$a;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzn;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class y4 implements Runnable {
    public final z4 j;
    public final zzn k;
    public final Bundle l;

    public y4(z4 z4Var, zzn zznVar, Bundle bundle) {
        this.j = z4Var;
        this.k = zznVar;
        this.l = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzap zzapVar;
        z4 z4Var = this.j;
        zzn zznVar = this.k;
        Bundle bundle = this.l;
        g gVarK = z4Var.a.K();
        String str = zznVar.j;
        gVarK.b();
        gVarK.n();
        u4 u4Var = gVarK.a;
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.w("dep");
        TextUtils.isEmpty("");
        if (bundle == null || bundle.isEmpty()) {
            zzapVar = new zzap(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    u4Var.g().f.a("Param name can't be null");
                    it.remove();
                } else {
                    Object objD = u4Var.t().D(next, bundle2.get(next));
                    if (objD == null) {
                        u4Var.g().i.b("Param value can't be null", u4Var.u().x(next));
                        it.remove();
                    } else {
                        u4Var.t().I(bundle2, next, objD);
                    }
                }
            }
            zzapVar = new zzap(bundle2);
        }
        q9 q9VarM = gVarK.m();
        a1$a a1_aM = b.i.a.f.h.l.a1.M();
        if (a1_aM.l) {
            a1_aM.n();
            a1_aM.l = false;
        }
        b.i.a.f.h.l.a1.E((b.i.a.f.h.l.a1) a1_aM.k, 0L);
        for (String str2 : zzapVar.j.keySet()) {
            c1$a c1_aQ = b.i.a.f.h.l.c1.Q();
            c1_aQ.s(str2);
            q9VarM.F(c1_aQ, zzapVar.w0(str2));
            a1_aM.s(c1_aQ);
        }
        byte[] bArrD = ((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) a1_aM.p())).d();
        gVarK.g().n.c("Saving default event parameters, appId, data size", gVarK.d().u(str), Integer.valueOf(bArrD.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrD);
        try {
            if (gVarK.t().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                gVarK.g().f.b("Failed to insert default event parameters (got -1). appId", q3.s(str));
            }
        } catch (SQLiteException e) {
            gVarK.g().f.c("Error storing default event parameters. appId", q3.s(str), e);
        }
    }
}
