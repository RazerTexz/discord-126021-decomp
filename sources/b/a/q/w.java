package b.a.q;

import com.discord.rtcconnection.RtcConnection;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class w extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ String $endpoint;
    public final /* synthetic */ SSLSocketFactory $sslSocketFactory;
    public final /* synthetic */ String $token;
    public final /* synthetic */ RtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(RtcConnection rtcConnection, String str, String str2, SSLSocketFactory sSLSocketFactory) {
        super(0);
        this.this$0 = rtcConnection;
        this.$endpoint = str;
        this.$token = str2;
        this.$sslSocketFactory = sSLSocketFactory;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RtcConnection rtcConnection = this.this$0;
        rtcConnection.connectStartTime = Long.valueOf(rtcConnection.clock.currentTimeMillis());
        RtcConnection rtcConnection2 = this.this$0;
        rtcConnection2.connectCount++;
        rtcConnection2.mediaEnginePrepareSubscription = rtcConnection2.mediaEngine.a().c0(2L, TimeUnit.SECONDS).W(new t(this), new v(this));
        return Unit.a;
    }
}
