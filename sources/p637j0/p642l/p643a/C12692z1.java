package p637j0.p642l.p643a;

import p637j0.p642l.p643a.C12689y1;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.z1 */
/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12692z1 implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C12689y1.c f27158j;

    public C12692z1(C12689y1.c cVar) {
        this.f27158j = cVar;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        C12689y1.c cVar = this.f27158j;
        synchronized (cVar) {
            cVar.f27138s = null;
        }
    }
}
