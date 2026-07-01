package b.a.q;

import com.discord.rtcconnection.RtcConnection;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class u extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ Throwable $throwable;
    public final /* synthetic */ v this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v vVar, Throwable th) {
        super(0);
        this.this$0 = vVar;
        this.$throwable = th;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RtcConnection rtcConnection = this.this$0.j.this$0;
        Throwable th = this.$throwable;
        d0.z.d.m.checkNotNullExpressionValue(th, "throwable");
        Objects.requireNonNull(rtcConnection);
        rtcConnection.s(new y(rtcConnection, th));
        return Unit.a;
    }
}
