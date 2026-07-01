package j0.l.a;

import j0.l.a.OperatorSwitch2;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.z1, reason: use source file name */
/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorSwitch3 implements Action0 {
    public final /* synthetic */ OperatorSwitch2.c j;

    public OperatorSwitch3(OperatorSwitch2.c cVar) {
        this.j = cVar;
    }

    @Override // rx.functions.Action0
    public void call() {
        OperatorSwitch2.c cVar = this.j;
        synchronized (cVar) {
            cVar.f3783s = null;
        }
    }
}
