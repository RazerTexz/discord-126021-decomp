package b.a.q.m0.c;

import co.discord.media_engine.Connection;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.q.m0.c.c, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnectionLegacy3 implements Connection.UserSpeakingStatusChangedCallback {
    public final /* synthetic */ MediaEngineConnectionLegacy5 a;

    /* JADX INFO: renamed from: b.a.q.m0.c.c$a */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isUserSpeakingNow;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, boolean z2) {
            super(0);
            this.$userId = j;
            this.$isUserSpeakingNow = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5 = MediaEngineConnectionLegacy3.this.a;
            long j = this.$userId;
            boolean z2 = this.$isUserSpeakingNow;
            Integer num = mediaEngineConnectionLegacy5.d.get(Long.valueOf(j));
            mediaEngineConnectionLegacy5.y(new MediaEngineConnectionLegacy7(j, num != null ? num.intValue() : 0, z2));
            return Unit.a;
        }
    }

    public MediaEngineConnectionLegacy3(MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5) {
        this.a = mediaEngineConnectionLegacy5;
    }

    @Override // co.discord.media_engine.Connection.UserSpeakingStatusChangedCallback
    public void onUserSpeakingStatusChanged(long j, boolean z2, boolean z3) {
        MediaEngineConnectionLegacy5.x(this.a, new a(j, z2));
    }
}
