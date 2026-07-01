package b.i.a.f.c.a.f.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Base64;
import androidx.annotation.Nullable;
import b.i.a.f.e.h.c$a;
import b.i.a.f.e.h.c$b;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions$a;
import com.google.android.gms.common.api.Scope;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends b.i.a.f.e.k.d<o> {
    public final GoogleSignInOptions A;

    public f(Context context, Looper looper, b.i.a.f.e.k.c cVar, @Nullable GoogleSignInOptions googleSignInOptions, c$a c_a, c$b c_b) {
        super(context, looper, 91, cVar, c_a, c_b);
        GoogleSignInOptions$a googleSignInOptions$a = googleSignInOptions != null ? new GoogleSignInOptions$a(googleSignInOptions) : new GoogleSignInOptions$a();
        byte[] bArr = new byte[16];
        b.i.a.f.h.c.a.a.nextBytes(bArr);
        googleSignInOptions$a.i = Base64.encodeToString(bArr, 11);
        if (!cVar.c.isEmpty()) {
            Iterator<Scope> it = cVar.c.iterator();
            while (it.hasNext()) {
                googleSignInOptions$a.a.add(it.next());
                googleSignInOptions$a.a.addAll(Arrays.asList(new Scope[0]));
            }
        }
        this.A = googleSignInOptions$a.a();
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a$f
    public final int l() {
        return 12451000;
    }

    @Override // b.i.a.f.e.k.b
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof o ? (o) iInterfaceQueryLocalInterface : new r(iBinder);
    }

    @Override // b.i.a.f.e.k.b
    public final String x() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // b.i.a.f.e.k.b
    public final String y() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }
}
