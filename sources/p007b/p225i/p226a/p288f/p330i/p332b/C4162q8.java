package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;

/* JADX INFO: renamed from: b.i.a.f.i.b.q8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4162q8 extends AbstractC4074i9 {

    /* JADX INFO: renamed from: d */
    public String f11160d;

    /* JADX INFO: renamed from: e */
    public boolean f11161e;

    /* JADX INFO: renamed from: f */
    public long f11162f;

    public C4162q8(C4097k9 c4097k9) {
        super(c4097k9);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4074i9
    /* JADX INFO: renamed from: p */
    public final boolean mo5515p() {
        return false;
    }

    @NonNull
    @WorkerThread
    /* JADX INFO: renamed from: s */
    public final Pair<String, Boolean> m5815s(String str, C4004d c4004d) {
        return (C3842t8.m5293b() && this.f11202a.f11260h.m5526o(C4142p.f11039J0) && !c4004d.m5571j()) ? new Pair<>("", Boolean.FALSE) : m5817u(str);
    }

    @WorkerThread
    @Deprecated
    /* JADX INFO: renamed from: t */
    public final String m5816t(String str) {
        mo5848b();
        String str2 = (String) m5817u(str).first;
        MessageDigest messageDigestM5889x0 = C4196t9.m5889x0();
        if (messageDigestM5889x0 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestM5889x0.digest(str2.getBytes())));
    }

    @NonNull
    @WorkerThread
    @Deprecated
    /* JADX INFO: renamed from: u */
    public final Pair<String, Boolean> m5817u(String str) {
        mo5848b();
        Objects.requireNonNull((C3401c) this.f11202a.f11267o);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f11160d != null && jElapsedRealtime < this.f11162f) {
            return new Pair<>(this.f11160d, Boolean.valueOf(this.f11161e));
        }
        C3992c c3992c = this.f11202a.f11260h;
        Objects.requireNonNull(c3992c);
        this.f11162f = jElapsedRealtime + c3992c.m5525n(str, C4142p.f11063b);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f11202a.f11254b);
            if (advertisingIdInfo != null) {
                this.f11160d = advertisingIdInfo.getId();
                this.f11161e = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.f11160d == null) {
                this.f11160d = "";
            }
        } catch (Exception e) {
            mo5726g().f11148m.m5861b("Unable to get advertising id", e);
            this.f11160d = "";
        }
        return new Pair<>(this.f11160d, Boolean.valueOf(this.f11161e));
    }
}
