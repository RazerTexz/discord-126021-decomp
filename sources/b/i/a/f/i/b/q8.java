package b.i.a.f.i.b;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q8 extends i9 {
    public String d;
    public boolean e;
    public long f;

    public q8(k9 k9Var) {
        super(k9Var);
    }

    @Override // b.i.a.f.i.b.i9
    public final boolean p() {
        return false;
    }

    @NonNull
    @WorkerThread
    public final Pair<String, Boolean> s(String str, d dVar) {
        return (b.i.a.f.h.l.t8.b() && this.a.h.o(p.J0) && !dVar.j()) ? new Pair<>("", Boolean.FALSE) : u(str);
    }

    @WorkerThread
    @Deprecated
    public final String t(String str) {
        b();
        String str2 = (String) u(str).first;
        MessageDigest messageDigestX0 = t9.x0();
        if (messageDigestX0 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestX0.digest(str2.getBytes())));
    }

    @NonNull
    @WorkerThread
    @Deprecated
    public final Pair<String, Boolean> u(String str) {
        b();
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.d != null && jElapsedRealtime < this.f) {
            return new Pair<>(this.d, Boolean.valueOf(this.e));
        }
        c cVar = this.a.h;
        Objects.requireNonNull(cVar);
        this.f = jElapsedRealtime + cVar.n(str, p.f1552b);
        try {
            AdvertisingIdClient$Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a.f1570b);
            if (advertisingIdInfo != null) {
                this.d = advertisingIdInfo.getId();
                this.e = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.d == null) {
                this.d = "";
            }
        } catch (Exception e) {
            g().m.b("Unable to get advertising id", e);
            this.d = "";
        }
        return new Pair<>(this.d, Boolean.valueOf(this.e));
    }
}
