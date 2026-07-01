package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.m.f$m;
import java.util.List;

/* JADX INFO: compiled from: NotFoundClasses.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 {
    public final d0.e0.p.d.m0.m.o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f3243b;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.b, e0> c;
    public final d0.e0.p.d.m0.m.h<d0$a, e> d;

    public d0(d0.e0.p.d.m0.m.o oVar, c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        this.a = oVar;
        this.f3243b = c0Var;
        this.c = oVar.createMemoizedFunction(new d0$d(this));
        this.d = oVar.createMemoizedFunction(new d0$c(this));
    }

    public static final /* synthetic */ c0 access$getModule$p(d0 d0Var) {
        return d0Var.f3243b;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.h access$getPackageFragments$p(d0 d0Var) {
        return d0Var.c;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.o access$getStorageManager$p(d0 d0Var) {
        return d0Var.a;
    }

    public final e getClass(d0.e0.p.d.m0.g.a aVar, List<Integer> list) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        d0.z.d.m.checkNotNullParameter(list, "typeParametersCount");
        return (e) ((f$m) this.d).invoke(new d0$a(aVar, list));
    }
}
