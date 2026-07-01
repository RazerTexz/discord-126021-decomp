package b.a.q.m0.c;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$a extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ boolean $isUserSpeakingNow;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$a(c cVar, long j, boolean z2) {
        super(0);
        this.this$0 = cVar;
        this.$userId = j;
        this.$isUserSpeakingNow = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        e eVar = this.this$0.a;
        long j = this.$userId;
        boolean z2 = this.$isUserSpeakingNow;
        Integer num = eVar.d.get(Long.valueOf(j));
        eVar.y(new g(j, num != null ? num.intValue() : 0, z2));
        return Unit.a;
    }
}
