package b.i.a.c;

import b.i.a.c.f3.p$a;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a0 implements p$a {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y1$f f805b;
    public final /* synthetic */ y1$f c;

    public /* synthetic */ a0(int i, y1$f y1_f, y1$f y1_f2) {
        this.a = i;
        this.f805b = y1_f;
        this.c = y1_f2;
    }

    @Override // b.i.a.c.f3.p$a
    public final void invoke(Object obj) {
        int i = this.a;
        y1$f y1_f = this.f805b;
        y1$f y1_f2 = this.c;
        y1$c y1_c = (y1$c) obj;
        y1_c.j(i);
        y1_c.g(y1_f, y1_f2, i);
    }
}
