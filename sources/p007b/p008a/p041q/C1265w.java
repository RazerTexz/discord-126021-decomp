package p007b.p008a.p041q;

import com.discord.rtcconnection.RtcConnection;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.w */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1265w extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ String $endpoint;
    public final /* synthetic */ SSLSocketFactory $sslSocketFactory;
    public final /* synthetic */ String $token;
    public final /* synthetic */ RtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1265w(RtcConnection rtcConnection, String str, String str2, SSLSocketFactory sSLSocketFactory) {
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
        rtcConnection2.mediaEnginePrepareSubscription = rtcConnection2.mediaEngine.mo321a().m11104c0(2L, TimeUnit.SECONDS).m11097W(new C1262t(this), new C1264v(this));
        return Unit.f27425a;
    }
}
