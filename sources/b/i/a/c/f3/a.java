package b.i.a.c.f3;

import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet j;
    public final /* synthetic */ int k;
    public final /* synthetic */ p$a l;

    public /* synthetic */ a(CopyOnWriteArraySet copyOnWriteArraySet, int i, p$a p_a) {
        this.j = copyOnWriteArraySet;
        this.k = i;
        this.l = p_a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CopyOnWriteArraySet<p$c> copyOnWriteArraySet = this.j;
        int i = this.k;
        p$a p_a = this.l;
        for (p$c p_c : copyOnWriteArraySet) {
            if (!p_c.d) {
                if (i != -1) {
                    n$b n_b = p_c.f974b;
                    b.c.a.a0.d.D(!n_b.f972b);
                    n_b.a.append(i, true);
                }
                p_c.c = true;
                p_a.invoke(p_c.a);
            }
        }
    }
}
