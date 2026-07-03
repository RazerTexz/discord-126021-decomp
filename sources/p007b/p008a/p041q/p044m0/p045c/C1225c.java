package p007b.p008a.p041q.p044m0.p045c;

import co.discord.media_engine.Connection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.m0.c.c */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1225c implements Connection.UserSpeakingStatusChangedCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1227e f1696a;

    /* JADX INFO: renamed from: b.a.q.m0.c.c$a */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends AbstractC12240o implements Function0<Unit> {
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
            C1227e c1227e = C1225c.this.f1696a;
            long j = this.$userId;
            boolean z2 = this.$isUserSpeakingNow;
            Integer num = c1227e.f1701d.get(Long.valueOf(j));
            c1227e.m318y(new C1229g(j, num != null ? num.intValue() : 0, z2));
            return Unit.f27425a;
        }
    }

    public C1225c(C1227e c1227e) {
        this.f1696a = c1227e;
    }

    @Override // co.discord.media_engine.Connection.UserSpeakingStatusChangedCallback
    public void onUserSpeakingStatusChanged(long j, boolean z2, boolean z3) {
        C1227e.m294x(this.f1696a, new a(j, z2));
    }
}
