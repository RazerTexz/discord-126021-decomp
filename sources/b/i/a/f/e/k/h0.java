package b.i.a.f.e.k;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends b.i.a.f.h.g.d {
    public final /* synthetic */ b a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(b bVar, Looper looper) {
        super(looper);
        this.a = bVar;
    }

    public static final boolean a(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    /* JADX WARN: Code duplicated, block: B:85:0x0155  */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        TListener tlistener;
        if (this.a.w.get() != message.arg1) {
            if (a(message)) {
                i0 i0Var = (i0) message.obj;
                i0Var.a();
                i0Var.c();
                return;
            }
            return;
        }
        int i = message.what;
        if (i != 1 && i != 7) {
            if (i == 4) {
                Objects.requireNonNull(this.a);
            } else if (i == 5) {
            }
            if (!this.a.e()) {
                i0 i0Var2 = (i0) message.obj;
                i0Var2.a();
                i0Var2.c();
                return;
            }
        } else if (!this.a.e()) {
            i0 i0Var3 = (i0) message.obj;
            i0Var3.a();
            i0Var3.c();
            return;
        }
        int i2 = message.what;
        if (i2 == 4) {
            this.a.t = new ConnectionResult(message.arg2);
            if (b.D(this.a)) {
                b bVar = this.a;
                if (!bVar.u) {
                    bVar.F(3, null);
                    return;
                }
            }
            ConnectionResult connectionResult = this.a.t;
            if (connectionResult == null) {
                connectionResult = new ConnectionResult(8);
            }
            this.a.k.a(connectionResult);
            Objects.requireNonNull(this.a);
            System.currentTimeMillis();
            return;
        }
        if (i2 == 5) {
            ConnectionResult connectionResult2 = this.a.t;
            if (connectionResult2 == null) {
                connectionResult2 = new ConnectionResult(8);
            }
            this.a.k.a(connectionResult2);
            Objects.requireNonNull(this.a);
            System.currentTimeMillis();
            return;
        }
        if (i2 == 3) {
            Object obj = message.obj;
            this.a.k.a(new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
            Objects.requireNonNull(this.a);
            System.currentTimeMillis();
            return;
        }
        if (i2 == 6) {
            this.a.F(5, null);
            b$a b_a = this.a.p;
            if (b_a != null) {
                b_a.c(message.arg2);
            }
            this.a.A(message.arg2);
            b.E(this.a, 5, 1, null);
            return;
        }
        if (i2 == 2 && !this.a.j()) {
            i0 i0Var4 = (i0) message.obj;
            i0Var4.a();
            i0Var4.c();
            return;
        }
        if (!a(message)) {
            Log.wtf("GmsClient", b.d.b.a.a.g(45, "Don't know how to handle message: ", message.what), new Exception());
            return;
        }
        i0 i0Var5 = (i0) message.obj;
        synchronized (i0Var5) {
            tlistener = i0Var5.a;
            if (i0Var5.f1387b) {
                String strValueOf = String.valueOf(i0Var5);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
                sb.append("Callback proxy ");
                sb.append(strValueOf);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (tlistener != 0) {
            try {
                i0Var5.b(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (i0Var5) {
            i0Var5.f1387b = true;
        }
        i0Var5.c();
    }
}
