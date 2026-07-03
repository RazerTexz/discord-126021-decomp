package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.util.ArrayList;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11425d;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11572e;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.h */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11429h extends AbstractC11425d implements InterfaceC11572e {

    /* JADX INFO: renamed from: c */
    public final Object[] f23042c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11429h(C11716e c11716e, Object[] objArr) {
        super(c11716e);
        C12238m.checkNotNullParameter(objArr, "values");
        this.f23042c = objArr;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11572e
    public List<AbstractC11425d> getElements() {
        Object[] objArr = this.f23042c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            AbstractC11425d.a aVar = AbstractC11425d.f23039a;
            C12238m.checkNotNull(obj);
            arrayList.add(aVar.create(obj, null));
        }
        return arrayList;
    }
}
