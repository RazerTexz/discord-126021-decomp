package b.i.a.f.c.a.f;

import android.content.Context;
import androidx.annotation.NonNull;
import b.i.a.f.e.h.b;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a extends b<GoogleSignInOptions> {
    public static int j = 1;

    public a(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, b.i.a.f.c.a.a.f, googleSignInOptions, new b.i.a.f.e.h.j.a());
    }

    public final synchronized int f() {
        if (j == 1) {
            Context context = this.a;
            Object obj = GoogleApiAvailability.c;
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.d;
            int iB = googleApiAvailability.b(context, 12451000);
            if (iB == 0) {
                j = 4;
            } else if (googleApiAvailability.a(context, iB, null) != null || DynamiteModule.a(context, "com.google.android.gms.auth.api.fallback") == 0) {
                j = 2;
            } else {
                j = 3;
            }
        }
        return j;
    }
}
