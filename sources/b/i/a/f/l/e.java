package b.i.a.f.l;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.c;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends a.AbstractC0035a<b.i.a.f.l.b.a, a> {
    @Override // b.i.a.f.e.h.a.AbstractC0035a
    public final a.f a(Context context, Looper looper, b.i.a.f.e.k.c cVar, a aVar, c.a aVar2, c.b bVar) {
        a aVar3 = cVar.g;
        Integer num = cVar.h;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", cVar.a);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (aVar3 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        }
        return new b.i.a.f.l.b.a(context, looper, true, cVar, bundle, aVar2, bVar);
    }
}
