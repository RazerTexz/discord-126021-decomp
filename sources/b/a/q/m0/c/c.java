package b.a.q.m0.c;

import co.discord.media_engine.Connection$UserSpeakingStatusChangedCallback;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Connection$UserSpeakingStatusChangedCallback {
    public final /* synthetic */ e a;

    public c(e eVar) {
        this.a = eVar;
    }

    @Override // co.discord.media_engine.Connection$UserSpeakingStatusChangedCallback
    public void onUserSpeakingStatusChanged(long j, boolean z2, boolean z3) {
        e.x(this.a, new c$a(this, j, z2));
    }
}
