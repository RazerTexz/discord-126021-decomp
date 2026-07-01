package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.c.k1.b.ReflectJavaAnnotationArguments;
import d0.e0.p.d.m0.e.a.k0.annotationArguments3;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.h, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotationArguments3 extends ReflectJavaAnnotationArguments implements annotationArguments3 {
    public final Object[] c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationArguments3(Name name, Object[] objArr) {
        super(name);
        Intrinsics3.checkNotNullParameter(objArr, "values");
        this.c = objArr;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.annotationArguments3
    public List<ReflectJavaAnnotationArguments> getElements() {
        Object[] objArr = this.c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            ReflectJavaAnnotationArguments.a aVar = ReflectJavaAnnotationArguments.a;
            Intrinsics3.checkNotNull(obj);
            arrayList.add(aVar.create(obj, null));
        }
        return arrayList;
    }
}
