package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.c9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4002c9 extends AbstractC4064i {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C4014d9 f10617e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4002c9(C4014d9 c4014d9, InterfaceC4192t5 interfaceC4192t5) {
        super(interfaceC4192t5);
        this.f10617e = c4014d9;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4064i
    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final void mo5560a() {
        C4014d9 c4014d9 = this.f10617e;
        c4014d9.f10671d.mo5848b();
        Objects.requireNonNull((C3401c) c4014d9.f10671d.f11202a.f11267o);
        c4014d9.m5584a(false, false, SystemClock.elapsedRealtime());
        C3968a c3968aM5968m = c4014d9.f10671d.m5968m();
        Objects.requireNonNull((C3401c) c4014d9.f10671d.f11202a.f11267o);
        c3968aM5968m.m5440t(SystemClock.elapsedRealtime());
    }
}
