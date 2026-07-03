package p007b.p225i.p226a.p288f.p337l;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;
import p007b.p225i.p226a.p288f.p337l.p338b.C4336a;

/* JADX INFO: renamed from: b.i.a.f.l.e */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4348e extends C3266a.a<C4336a, C4335a> {
    @Override // p007b.p225i.p226a.p288f.p299e.p300h.C3266a.a
    /* JADX INFO: renamed from: a */
    public final C3266a.f mo3996a(Context context, Looper looper, C3347c c3347c, C4335a c4335a, AbstractC3268c.a aVar, AbstractC3268c.b bVar) {
        C4335a c4335a2 = c3347c.f9507g;
        Integer num = c3347c.f9508h;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c3347c.f9501a);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (c4335a2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        }
        return new C4336a(context, looper, true, c3347c, bundle, aVar, bVar);
    }
}
