package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$c$b extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ MediaEngineConnection $connection;
    public final /* synthetic */ k$c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$c$b(k$c k_c, MediaEngineConnection mediaEngineConnection) {
        super(0);
        this.this$0 = k_c;
        this.$connection = mediaEngineConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        k.m(this.this$0.a, this.$connection);
        return Unit.a;
    }
}
