package p007b.p225i.p226a.p288f.p299e.p304k;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b;
import p007b.p225i.p226a.p288f.p313h.p320g.HandlerC3484d;

/* JADX INFO: renamed from: b.i.a.f.e.k.h0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class HandlerC3358h0 extends HandlerC3484d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC3345b f9523a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3358h0(AbstractC3345b abstractC3345b, Looper looper) {
        super(looper);
        this.f9523a = abstractC3345b;
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m4158a(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    /* JADX WARN: Code duplicated, block: B:85:0x0155  */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        TListener tlistener;
        if (this.f9523a.f9498w.get() != message.arg1) {
            if (m4158a(message)) {
                AbstractC3360i0 abstractC3360i0 = (AbstractC3360i0) message.obj;
                abstractC3360i0.mo4159a();
                abstractC3360i0.m4161c();
                return;
            }
            return;
        }
        int i = message.what;
        if (i != 1 && i != 7) {
            if (i == 4) {
                Objects.requireNonNull(this.f9523a);
            } else if (i == 5) {
            }
            if (!this.f9523a.m4130e()) {
                AbstractC3360i0 abstractC3360i1 = (AbstractC3360i0) message.obj;
                abstractC3360i1.mo4159a();
                abstractC3360i1.m4161c();
                return;
            }
        } else if (!this.f9523a.m4130e()) {
            AbstractC3360i0 abstractC3360i2 = (AbstractC3360i0) message.obj;
            abstractC3360i2.mo4159a();
            abstractC3360i2.m4161c();
            return;
        }
        int i2 = message.what;
        if (i2 == 4) {
            this.f9523a.f9495t = new ConnectionResult(message.arg2);
            if (AbstractC3345b.m4123D(this.f9523a)) {
                AbstractC3345b abstractC3345b = this.f9523a;
                if (!abstractC3345b.f9496u) {
                    abstractC3345b.m4127F(3, null);
                    return;
                }
            }
            ConnectionResult connectionResult = this.f9523a.f9495t;
            if (connectionResult == null) {
                connectionResult = new ConnectionResult(8);
            }
            this.f9523a.f9486k.mo4103a(connectionResult);
            Objects.requireNonNull(this.f9523a);
            System.currentTimeMillis();
            return;
        }
        if (i2 == 5) {
            ConnectionResult connectionResult2 = this.f9523a.f9495t;
            if (connectionResult2 == null) {
                connectionResult2 = new ConnectionResult(8);
            }
            this.f9523a.f9486k.mo4103a(connectionResult2);
            Objects.requireNonNull(this.f9523a);
            System.currentTimeMillis();
            return;
        }
        if (i2 == 3) {
            Object obj = message.obj;
            this.f9523a.f9486k.mo4103a(new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
            Objects.requireNonNull(this.f9523a);
            System.currentTimeMillis();
            return;
        }
        if (i2 == 6) {
            this.f9523a.m4127F(5, null);
            AbstractC3345b.a aVar = this.f9523a.f9491p;
            if (aVar != null) {
                aVar.mo4144c(message.arg2);
            }
            this.f9523a.m4125A(message.arg2);
            AbstractC3345b.m4124E(this.f9523a, 5, 1, null);
            return;
        }
        if (i2 == 2 && !this.f9523a.m4134j()) {
            AbstractC3360i0 abstractC3360i3 = (AbstractC3360i0) message.obj;
            abstractC3360i3.mo4159a();
            abstractC3360i3.m4161c();
            return;
        }
        if (!m4158a(message)) {
            Log.wtf("GmsClient", C1643a.m851g(45, "Don't know how to handle message: ", message.what), new Exception());
            return;
        }
        AbstractC3360i0 abstractC3360i4 = (AbstractC3360i0) message.obj;
        synchronized (abstractC3360i4) {
            tlistener = abstractC3360i4.f9524a;
            if (abstractC3360i4.f9525b) {
                String strValueOf = String.valueOf(abstractC3360i4);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
                sb.append("Callback proxy ");
                sb.append(strValueOf);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (tlistener != 0) {
            try {
                abstractC3360i4.mo4160b(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (abstractC3360i4) {
            abstractC3360i4.f9525b = true;
        }
        abstractC3360i4.m4161c();
    }
}
