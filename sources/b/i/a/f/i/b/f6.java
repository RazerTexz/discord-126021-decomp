package b.i.a.f.i.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.adjust.sdk.Constants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f6 implements Runnable {
    public final /* synthetic */ c6 j;

    public f6(c6 c6Var) {
        this.j = c6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y9 y9Var = this.j.n;
        y9Var.a.f().b();
        if (y9Var.c()) {
            if (y9Var.b()) {
                y9Var.a.o().B.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString(Constants.MEDIUM, "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                y9Var.a.s().H("auto", "_cmpx", bundle);
            } else {
                String strA = y9Var.a.o().B.a();
                if (TextUtils.isEmpty(strA)) {
                    y9Var.a.g().g.a("Cache still valid but referrer not found");
                } else {
                    long jA = ((y9Var.a.o().C.a() / 3600000) - 1) * 3600000;
                    Uri uri = Uri.parse(strA);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", jA);
                    y9Var.a.s().H((String) pair.first, "_cmp", (Bundle) pair.second);
                }
                y9Var.a.o().B.b(null);
            }
            y9Var.a.o().C.b(0L);
        }
    }
}
