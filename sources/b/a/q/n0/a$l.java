package b.a.q.n0;

import com.discord.utilities.rest.SendUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.WebSocket;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$l extends o implements Function1<WebSocket, Unit> {
    public static final a$l j = new a$l();

    public a$l() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(WebSocket webSocket) {
        WebSocket webSocket2 = webSocket;
        m.checkNotNullParameter(webSocket2, "it");
        webSocket2.e(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, "reconnecting");
        return Unit.a;
    }
}
