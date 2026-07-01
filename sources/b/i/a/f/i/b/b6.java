package b.i.a.f.i.b;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b6 implements Runnable {
    public final c6 j;
    public final Bundle k;

    public b6(c6 c6Var, Bundle bundle) {
        this.j = c6Var;
        this.k = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        c6 c6Var = this.j;
        Bundle bundle = this.k;
        Objects.requireNonNull(c6Var);
        if (b.i.a.f.h.l.ea.b() && c6Var.a.h.o(p.z0)) {
            if (bundle == null) {
                c6Var.l().D.b(new Bundle());
                return;
            }
            Bundle bundleA = c6Var.l().D.a();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    c6Var.e();
                    if (t9.W(obj)) {
                        c6Var.e().R(c6Var.p, 27, null, null, 0);
                    }
                    c6Var.g().k.c("Invalid default event parameter type. Name, value", str, obj);
                } else if (t9.r0(str)) {
                    c6Var.g().k.b("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    bundleA.remove(str);
                } else if (c6Var.e().b0("param", str, 100, obj)) {
                    c6Var.e().I(bundleA, str, obj);
                }
            }
            c6Var.e();
            int iT = c6Var.a.h.t();
            if (bundleA.size() > iT) {
                Iterator it = new TreeSet(bundleA.keySet()).iterator();
                int i = 0;
                while (true) {
                    z2 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    i++;
                    if (i > iT) {
                        bundleA.remove(str2);
                    }
                }
            } else {
                z2 = false;
            }
            if (z2) {
                c6Var.e().R(c6Var.p, 26, null, null, 0);
                c6Var.g().k.a("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            c6Var.l().D.b(bundleA);
            q7 q7VarP = c6Var.p();
            q7VarP.b();
            q7VarP.t();
            q7VarP.z(new a8(q7VarP, bundleA, q7VarP.I(false)));
        }
    }
}
