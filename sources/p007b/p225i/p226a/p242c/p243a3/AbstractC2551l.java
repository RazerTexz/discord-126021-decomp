package p007b.p225i.p226a.p242c.p243a3;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.AbstractC2832o2;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;

/* JADX INFO: renamed from: b.i.a.c.a3.l */
/* JADX INFO: compiled from: BaseMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2551l implements InterfaceC2530a0 {

    /* JADX INFO: renamed from: a */
    public final ArrayList<InterfaceC2530a0.b> f5633a = new ArrayList<>(1);

    /* JADX INFO: renamed from: b */
    public final HashSet<InterfaceC2530a0.b> f5634b = new HashSet<>(1);

    /* JADX INFO: renamed from: c */
    public final InterfaceC2532b0.a f5635c = new InterfaceC2532b0.a();

    /* JADX INFO: renamed from: d */
    public final InterfaceC2988s.a f5636d = new InterfaceC2988s.a();

    /* JADX INFO: renamed from: e */
    @Nullable
    public Looper f5637e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public AbstractC2832o2 f5638f;

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: a */
    public final void mo2446a(InterfaceC2530a0.b bVar) {
        this.f5633a.remove(bVar);
        if (!this.f5633a.isEmpty()) {
            mo2449d(bVar);
            return;
        }
        this.f5637e = null;
        this.f5638f = null;
        this.f5634b.clear();
        mo2510s();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: b */
    public final void mo2447b(Handler handler, InterfaceC2532b0 interfaceC2532b0) {
        InterfaceC2532b0.a aVar = this.f5635c;
        Objects.requireNonNull(aVar);
        aVar.f5483c.add(new InterfaceC2532b0.a.C13222a(handler, interfaceC2532b0));
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: c */
    public final void mo2448c(InterfaceC2532b0 interfaceC2532b0) {
        InterfaceC2532b0.a aVar = this.f5635c;
        for (InterfaceC2532b0.a.C13222a c13222a : aVar.f5483c) {
            if (c13222a.f5486b == interfaceC2532b0) {
                aVar.f5483c.remove(c13222a);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: d */
    public final void mo2449d(InterfaceC2530a0.b bVar) {
        boolean z2 = !this.f5634b.isEmpty();
        this.f5634b.remove(bVar);
        if (z2 && this.f5634b.isEmpty()) {
            mo2551o();
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: f */
    public final void mo2451f(Handler handler, InterfaceC2988s interfaceC2988s) {
        InterfaceC2988s.a aVar = this.f5636d;
        Objects.requireNonNull(aVar);
        aVar.f8014c.add(new InterfaceC2988s.a.C13226a(handler, interfaceC2988s));
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: g */
    public final void mo2452g(InterfaceC2988s interfaceC2988s) {
        InterfaceC2988s.a aVar = this.f5636d;
        for (InterfaceC2988s.a.C13226a c13226a : aVar.f8014c) {
            if (c13226a.f8016b == interfaceC2988s) {
                aVar.f8014c.remove(c13226a);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: i */
    public /* synthetic */ boolean mo2454i() {
        return C2572z.m2595b(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: k */
    public /* synthetic */ AbstractC2832o2 mo2456k() {
        return C2572z.m2594a(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: l */
    public final void mo2457l(InterfaceC2530a0.b bVar, @Nullable InterfaceC2680a0 interfaceC2680a0) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f5637e;
        C1460d.m531j(looper == null || looper == looperMyLooper);
        AbstractC2832o2 abstractC2832o2 = this.f5638f;
        this.f5633a.add(bVar);
        if (this.f5637e == null) {
            this.f5637e = looperMyLooper;
            this.f5634b.add(bVar);
            mo2509q(interfaceC2680a0);
        } else if (abstractC2832o2 != null) {
            mo2458m(bVar);
            bVar.mo2445a(this, abstractC2832o2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: m */
    public final void mo2458m(InterfaceC2530a0.b bVar) {
        Objects.requireNonNull(this.f5637e);
        boolean zIsEmpty = this.f5634b.isEmpty();
        this.f5634b.add(bVar);
        if (zIsEmpty) {
            mo2552p();
        }
    }

    /* JADX INFO: renamed from: o */
    public void mo2551o() {
    }

    /* JADX INFO: renamed from: p */
    public void mo2552p() {
    }

    /* JADX INFO: renamed from: q */
    public abstract void mo2509q(@Nullable InterfaceC2680a0 interfaceC2680a0);

    /* JADX INFO: renamed from: r */
    public final void m2553r(AbstractC2832o2 abstractC2832o2) {
        this.f5638f = abstractC2832o2;
        Iterator<InterfaceC2530a0.b> it = this.f5633a.iterator();
        while (it.hasNext()) {
            it.next().mo2445a(this, abstractC2832o2);
        }
    }

    /* JADX INFO: renamed from: s */
    public abstract void mo2510s();
}
