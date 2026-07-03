package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p313h.p325l.C3817r9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3830s9;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3869v9;

/* JADX INFO: renamed from: b.i.a.f.i.b.d9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4014d9 {

    /* JADX INFO: renamed from: a */
    public long f10668a;

    /* JADX INFO: renamed from: b */
    public long f10669b;

    /* JADX INFO: renamed from: c */
    public final AbstractC4064i f10670c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C4228w8 f10671d;

    public C4014d9(C4228w8 c4228w8) {
        this.f10671d = c4228w8;
        this.f10670c = new C4002c9(this, c4228w8.f11202a);
        Objects.requireNonNull((C3401c) c4228w8.f11202a.f11267o);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f10668a = jElapsedRealtime;
        this.f10669b = jElapsedRealtime;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final boolean m5584a(boolean z2, boolean z3, long j) {
        this.f10671d.mo5848b();
        this.f10671d.m5497t();
        if (!C3817r9.m5212b() || !this.f10671d.f11202a.f11260h.m5526o(C4142p.f11094q0) || this.f10671d.f11202a.m5940d()) {
            C4057h4 c4057h4 = this.f10671d.m5867l().f10652v;
            Objects.requireNonNull((C3401c) this.f10671d.f11202a.f11267o);
            c4057h4.m5649b(System.currentTimeMillis());
        }
        long jM5585b = j - this.f10668a;
        if (!z2 && jM5585b < 1000) {
            this.f10671d.mo5726g().f11149n.m5861b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(jM5585b));
            return false;
        }
        if (this.f10671d.f11202a.f11260h.m5526o(C4142p.f11054T) && !z3) {
            if (((InterfaceC3869v9) C3830s9.f10317j.mo4555a()).mo5323a() && this.f10671d.f11202a.f11260h.m5526o(C4142p.f11056V)) {
                jM5585b = j - this.f10669b;
                this.f10669b = j;
            } else {
                jM5585b = m5585b();
            }
        }
        this.f10671d.mo5726g().f11149n.m5861b("Recording user engagement, ms", Long.valueOf(jM5585b));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", jM5585b);
        C4060h7.m5650A(this.f10671d.m5972q().m5656w(!this.f10671d.f11202a.f11260h.m5537z().booleanValue()), bundle, true);
        if (this.f10671d.f11202a.f11260h.m5526o(C4142p.f11054T) && !this.f10671d.f11202a.f11260h.m5526o(C4142p.f11055U) && z3) {
            bundle.putLong("_fr", 1L);
        }
        if (!this.f10671d.f11202a.f11260h.m5526o(C4142p.f11055U) || !z3) {
            this.f10671d.m5969n().m5545H("auto", "_e", bundle);
        }
        this.f10668a = j;
        this.f10670c.m5664c();
        this.f10670c.m5663b(3600000L);
        return true;
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public final long m5585b() {
        Objects.requireNonNull((C3401c) this.f10671d.f11202a.f11267o);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.f10669b;
        this.f10669b = jElapsedRealtime;
        return j;
    }
}
