package g0;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends b {
    public final Logger l;
    public final Socket m;

    public w(Socket socket) {
        d0.z.d.m.checkParameterIsNotNull(socket, "socket");
        this.m = socket;
        this.l = Logger.getLogger("okio.Okio");
    }

    @Override // g0.b
    public IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // g0.b
    public void l() {
        try {
            this.m.close();
        } catch (AssertionError e) {
            if (!b.i.a.f.e.o.f.z0(e)) {
                throw e;
            }
            Logger logger = this.l;
            Level level = Level.WARNING;
            StringBuilder sbU = b.d.b.a.a.U("Failed to close timed out socket ");
            sbU.append(this.m);
            logger.log(level, sbU.toString(), (Throwable) e);
        } catch (Exception e2) {
            Logger logger2 = this.l;
            Level level2 = Level.WARNING;
            StringBuilder sbU2 = b.d.b.a.a.U("Failed to close timed out socket ");
            sbU2.append(this.m);
            logger2.log(level2, sbU2.toString(), (Throwable) e2);
        }
    }
}
