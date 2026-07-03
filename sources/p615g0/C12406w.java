package p615g0;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.w */
/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12406w extends C12385b {

    /* JADX INFO: renamed from: l */
    public final Logger f26131l;

    /* JADX INFO: renamed from: m */
    public final Socket f26132m;

    public C12406w(Socket socket) {
        C12238m.checkParameterIsNotNull(socket, "socket");
        this.f26132m = socket;
        this.f26131l = Logger.getLogger("okio.Okio");
    }

    @Override // p615g0.C12385b
    /* JADX INFO: renamed from: k */
    public IOException mo10296k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // p615g0.C12385b
    /* JADX INFO: renamed from: l */
    public void mo10191l() {
        try {
            this.f26132m.close();
        } catch (AssertionError e) {
            if (!C3404f.m4367z0(e)) {
                throw e;
            }
            Logger logger = this.f26131l;
            Level level = Level.WARNING;
            StringBuilder sbM833U = C1643a.m833U("Failed to close timed out socket ");
            sbM833U.append(this.f26132m);
            logger.log(level, sbM833U.toString(), (Throwable) e);
        } catch (Exception e2) {
            Logger logger2 = this.f26131l;
            Level level2 = Level.WARNING;
            StringBuilder sbM833U2 = C1643a.m833U("Failed to close timed out socket ");
            sbM833U2.append(this.f26132m);
            logger2.log(level2, sbM833U2.toString(), (Throwable) e2);
        }
    }
}
