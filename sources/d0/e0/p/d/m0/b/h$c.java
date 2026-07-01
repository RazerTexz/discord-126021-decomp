package d0.e0.p.d.m0.b;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: KotlinBuiltIns.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$c implements Function1<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.c.e> {
    public final /* synthetic */ h j;

    public h$c(h hVar) {
        this.j = hVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e invoke(d0.e0.p.d.m0.g.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public d0.e0.p.d.m0.c.e invoke2(d0.e0.p.d.m0.g.e eVar) {
        d0.e0.p.d.m0.c.h contributedClassifier = this.j.getBuiltInsPackageScope().getContributedClassifier(eVar, d0.e0.p.d.m0.d.b.d.FROM_BUILTINS);
        if (contributedClassifier == null) {
            StringBuilder sbU = b.d.b.a.a.U("Built-in class ");
            sbU.append(k.l.child(eVar));
            sbU.append(" is not found");
            throw new AssertionError(sbU.toString());
        }
        if (contributedClassifier instanceof d0.e0.p.d.m0.c.e) {
            return (d0.e0.p.d.m0.c.e) contributedClassifier;
        }
        throw new AssertionError("Must be a class descriptor " + eVar + ", but was " + contributedClassifier);
    }
}
