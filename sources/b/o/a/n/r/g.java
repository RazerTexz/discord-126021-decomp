package b.o.a.n.r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: MeterAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class g extends b.o.a.n.o.d {
    public static final b.o.a.b e = new b.o.a.b(g.class.getSimpleName());
    public List<a> f;
    public b.o.a.n.o.e g;
    public final b.o.a.t.b h;
    public final b.o.a.n.i i;
    public final boolean j;

    public g(@NonNull b.o.a.n.i iVar, @Nullable b.o.a.t.b bVar, boolean z2) {
        this.h = bVar;
        this.i = iVar;
        this.j = z2;
    }

    @Override // b.o.a.n.o.d, b.o.a.n.o.e
    public void j(@NonNull b.o.a.n.o.c cVar) {
        b.o.a.b bVar = e;
        bVar.a(2, "onStart:", "initializing.");
        n(cVar);
        bVar.a(2, "onStart:", "initialized.");
        super.j(cVar);
    }

    @Override // b.o.a.n.o.d
    @NonNull
    public b.o.a.n.o.e m() {
        return this.g;
    }

    public final void n(@NonNull b.o.a.n.o.c cVar) {
        List arrayList = new ArrayList();
        if (this.h != null) {
            b.o.a.n.d dVar = (b.o.a.n.d) cVar;
            b.o.a.n.s.b bVar = new b.o.a.n.s.b(this.i.e(), this.i.z().l(), this.i.C(b.o.a.n.t.b.VIEW), this.i.z().d, dVar.f1919g0, dVar.f1921i0);
            arrayList = this.h.c(bVar).b(Integer.MAX_VALUE, bVar);
        }
        c cVar2 = new c(arrayList, this.j);
        e eVar = new e(arrayList, this.j);
        i iVar = new i(arrayList, this.j);
        this.f = Arrays.asList(cVar2, eVar, iVar);
        this.g = b.i.a.f.e.o.f.x1(cVar2, eVar, iVar);
    }
}
