package b.a.q.m0.c;

import com.hammerandchisel.libdiscord.Discord$ConnectToServerCallback;
import com.hammerandchisel.libdiscord.Discord$ConnectionInfo;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Discord$ConnectToServerCallback {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // com.hammerandchisel.libdiscord.Discord$ConnectToServerCallback
    public final void onConnectToServer(Discord$ConnectionInfo discord$ConnectionInfo, String str) {
        d0.z.d.m.checkNotNullParameter(discord$ConnectionInfo, "connectionInfo");
        d0.z.d.m.checkNotNullParameter(str, "errorMessage");
        e.x(this.a, new d$a(this, discord$ConnectionInfo, str));
    }
}
