package j0.l.c;

import rx.functions.Action0;

/* JADX INFO: compiled from: TrampolineScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class m$a$a implements Action0 {
    public final /* synthetic */ m$b j;
    public final /* synthetic */ m$a k;

    public m$a$a(m$a m_a, m$b m_b) {
        this.k = m_a;
        this.j = m_b;
    }

    @Override // rx.functions.Action0
    public void call() {
        this.k.k.remove(this.j);
    }
}
