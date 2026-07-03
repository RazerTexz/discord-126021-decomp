package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.e */
/* JADX INFO: compiled from: ProtoBufUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11706e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends AbstractC11727g.d<M>, T> T getExtensionOrNull(AbstractC11727g.d<M> dVar, AbstractC11727g.f<M, T> fVar) {
        C12238m.checkNotNullParameter(dVar, "<this>");
        C12238m.checkNotNullParameter(fVar, "extension");
        if (dVar.hasExtension(fVar)) {
            return (T) dVar.getExtension(fVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends AbstractC11727g.d<M>, T> T getExtensionOrNull(AbstractC11727g.d<M> dVar, AbstractC11727g.f<M, List<T>> fVar, int i) {
        C12238m.checkNotNullParameter(dVar, "<this>");
        C12238m.checkNotNullParameter(fVar, "extension");
        if (i < dVar.getExtensionCount(fVar)) {
            return (T) dVar.getExtension(fVar, i);
        }
        return null;
    }
}
