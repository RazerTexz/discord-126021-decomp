package d0.e0.p.d.m0.n;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.c.z0[] f3544b;
    public final w0[] c;
    public final boolean d;

    public /* synthetic */ z(d0.e0.p.d.m0.c.z0[] z0VarArr, w0[] w0VarArr, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z0VarArr, w0VarArr, (i & 4) != 0 ? false : z2);
    }

    @Override // d0.e0.p.d.m0.n.z0
    public boolean approximateContravariantCapturedTypes() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.n.z0
    public w0 get(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "key");
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        d0.e0.p.d.m0.c.z0 z0Var = declarationDescriptor instanceof d0.e0.p.d.m0.c.z0 ? (d0.e0.p.d.m0.c.z0) declarationDescriptor : null;
        if (z0Var == null) {
            return null;
        }
        int index = z0Var.getIndex();
        d0.e0.p.d.m0.c.z0[] z0VarArr = this.f3544b;
        if (index >= z0VarArr.length || !d0.z.d.m.areEqual(z0VarArr[index].getTypeConstructor(), z0Var.getTypeConstructor())) {
            return null;
        }
        return this.c[index];
    }

    public final w0[] getArguments() {
        return this.c;
    }

    public final d0.e0.p.d.m0.c.z0[] getParameters() {
        return this.f3544b;
    }

    @Override // d0.e0.p.d.m0.n.z0
    public boolean isEmpty() {
        return this.c.length == 0;
    }

    public z(d0.e0.p.d.m0.c.z0[] z0VarArr, w0[] w0VarArr, boolean z2) {
        d0.z.d.m.checkNotNullParameter(z0VarArr, "parameters");
        d0.z.d.m.checkNotNullParameter(w0VarArr, "arguments");
        this.f3544b = z0VarArr;
        this.c = w0VarArr;
        this.d = z2;
        int length = z0VarArr.length;
        int length2 = w0VarArr.length;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public z(List<? extends d0.e0.p.d.m0.c.z0> list, List<? extends w0> list2) {
        d0.z.d.m.checkNotNullParameter(list, "parameters");
        d0.z.d.m.checkNotNullParameter(list2, "argumentsList");
        Object[] array = list.toArray(new d0.e0.p.d.m0.c.z0[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        d0.e0.p.d.m0.c.z0[] z0VarArr = (d0.e0.p.d.m0.c.z0[]) array;
        Object[] array2 = list2.toArray(new w0[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        this(z0VarArr, (w0[]) array2, false, 4, null);
    }
}
