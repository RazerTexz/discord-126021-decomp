package p007b.p225i.p226a.p288f.p292c.p293a.p296f;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.dynamite.DynamiteModule;
import p007b.p225i.p226a.p288f.p292c.p293a.C3183a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3267b;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3275a;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3197a extends C3267b<GoogleSignInOptions> {

    /* JADX INFO: renamed from: j */
    public static int f9224j = 1;

    public C3197a(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, C3183a.f9208f, googleSignInOptions, new C3275a());
    }

    /* JADX INFO: renamed from: f */
    public final synchronized int m3972f() {
        if (f9224j == 1) {
            Context context = this.f9326a;
            Object obj = GoogleApiAvailability.f20480c;
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.f20481d;
            int iMo4018b = googleApiAvailability.mo4018b(context, 12451000);
            if (iMo4018b == 0) {
                f9224j = 4;
            } else if (googleApiAvailability.mo4017a(context, iMo4018b, null) != null || DynamiteModule.m9042a(context, "com.google.android.gms.auth.api.fallback") == 0) {
                f9224j = 2;
            } else {
                f9224j = 3;
            }
        }
        return f9224j;
    }
}
