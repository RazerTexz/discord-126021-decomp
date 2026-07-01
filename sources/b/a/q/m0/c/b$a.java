package b.a.q.m0.c;

import co.discord.media_engine.StreamParameters;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$a extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ int $ssrc;
    public final /* synthetic */ String $streamIdentifier;
    public final /* synthetic */ StreamParameters[] $streams;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$a(b bVar, long j, int i, String str, StreamParameters[] streamParametersArr) {
        super(0);
        this.this$0 = bVar;
        this.$userId = j;
        this.$ssrc = i;
        this.$streamIdentifier = str;
        this.$streams = streamParametersArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        e eVar = this.this$0.a;
        long j = this.$userId;
        int i = this.$ssrc;
        String str = this.$streamIdentifier;
        StreamParameters[] streamParametersArr = this.$streams;
        eVar.e.put(Long.valueOf(j), Long.valueOf(i));
        eVar.y(new h(eVar, j, str, i, streamParametersArr));
        return Unit.a;
    }
}
