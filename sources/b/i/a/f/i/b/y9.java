package b.i.a.f.i.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y9 {
    public final u4 a;

    public y9(u4 u4Var) {
        this.a = u4Var;
    }

    @WorkerThread
    public final void a(String str, Bundle bundle) {
        String string;
        this.a.f().b();
        if (this.a.d()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.a.o().B.b(string);
        h4 h4Var = this.a.o().C;
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
        h4Var.b(System.currentTimeMillis());
    }

    public final boolean b() {
        if (!c()) {
            return false;
        }
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
        return System.currentTimeMillis() - this.a.o().C.a() > this.a.h.n(null, p.E0);
    }

    public final boolean c() {
        return this.a.o().C.a() > 0;
    }
}
