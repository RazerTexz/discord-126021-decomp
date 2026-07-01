package b.i.a.c.e3;

import androidx.core.view.PointerIconCompat;
import b.i.a.c.a3.a0$a;
import b.i.a.c.s2.g1;
import b.i.a.c.s2.g1$a;
import b.i.a.c.s2.h1;
import b.i.a.c.s2.h1$a;
import b.i.a.c.s2.s0;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ f$a$a$a j;
    public final /* synthetic */ int k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    public /* synthetic */ a(f$a$a$a f_a_a_a, int i, long j, long j2) {
        this.j = f_a_a_a;
        this.k = i;
        this.l = j;
        this.m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a0$a next;
        a0$a a0_a;
        a0$a a0_a2;
        f$a$a$a f_a_a_a = this.j;
        int i = this.k;
        long j = this.l;
        long j2 = this.m;
        g1 g1Var = (g1) f_a_a_a.f940b;
        g1$a g1_a = g1Var.m;
        if (g1_a.f1081b.isEmpty()) {
            a0_a2 = null;
        } else {
            b.i.b.b.p<a0$a> pVar = g1_a.f1081b;
            if (!(pVar instanceof List)) {
                Iterator<a0$a> it = pVar.iterator();
                do {
                    next = it.next();
                } while (it.hasNext());
                a0_a = next;
            } else {
                if (pVar.isEmpty()) {
                    throw new NoSuchElementException();
                }
                a0_a = pVar.get(pVar.size() - 1);
            }
            a0_a2 = a0_a;
        }
        h1$a h1_aM0 = g1Var.m0(a0_a2);
        s0 s0Var = new s0(h1_aM0, i, j, j2);
        g1Var.n.put(PointerIconCompat.TYPE_CELL, h1_aM0);
        b.i.a.c.f3.p<h1> pVar2 = g1Var.o;
        pVar2.b(PointerIconCompat.TYPE_CELL, s0Var);
        pVar2.a();
    }
}
