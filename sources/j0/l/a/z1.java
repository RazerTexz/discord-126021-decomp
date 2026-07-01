package j0.l.a;

import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public class z1 implements Action0 {
    public final /* synthetic */ y1$c j;

    public z1(y1$c y1_c) {
        this.j = y1_c;
    }

    @Override // rx.functions.Action0
    public void call() {
        y1$c y1_c = this.j;
        synchronized (y1_c) {
            y1_c.f3783s = null;
        }
    }
}
