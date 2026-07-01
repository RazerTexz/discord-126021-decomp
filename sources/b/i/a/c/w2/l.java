package b.i.a.c.w2;

import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ s$a j;
    public final /* synthetic */ s k;
    public final /* synthetic */ int l;

    public /* synthetic */ l(s$a s_a, s sVar, int i) {
        this.j = s_a;
        this.k = sVar;
        this.l = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s$a s_a = this.j;
        s sVar = this.k;
        int i = this.l;
        Objects.requireNonNull(s_a);
        Objects.requireNonNull(sVar);
        sVar.c0(s_a.a, s_a.f1156b, i);
    }
}
