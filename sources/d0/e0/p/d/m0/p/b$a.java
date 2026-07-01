package d0.e0.p.d.m0.p;

import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [N] */
/* JADX INFO: compiled from: DFS.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a<N> extends b$b<N, Boolean> {
    public final /* synthetic */ Function1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean[] f3561b;

    public b$a(Function1 function1, boolean[] zArr) {
        this.a = function1;
        this.f3561b = zArr;
    }

    @Override // d0.e0.p.d.m0.p.b$d
    public boolean beforeChildren(N n) {
        if (((Boolean) this.a.invoke(n)).booleanValue()) {
            this.f3561b[0] = true;
        }
        return !this.f3561b[0];
    }

    @Override // d0.e0.p.d.m0.p.b$d
    public /* bridge */ /* synthetic */ Object result() {
        return result();
    }

    @Override // d0.e0.p.d.m0.p.b$d
    public Boolean result() {
        return Boolean.valueOf(this.f3561b[0]);
    }
}
