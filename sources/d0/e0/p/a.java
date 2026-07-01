package d0.e0.p;

import d0.e0.d;
import d0.e0.h;
import d0.e0.p.d.a0;
import d0.e0.p.d.m0.c.e;
import d0.e0.p.d.m0.c.f;
import d0.e0.p.d.x;
import d0.t.u;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: KTypesJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final d0.e0.c<?> getJvmErasure(KType kType) {
        d0.e0.c<?> jvmErasure;
        m.checkNotNullParameter(kType, "$this$jvmErasure");
        d classifier = kType.getClassifier();
        if (classifier != null && (jvmErasure = getJvmErasure(classifier)) != null) {
            return jvmErasure;
        }
        throw new a0("Cannot calculate JVM erasure for type: " + kType);
    }

    public static final d0.e0.c<?> getJvmErasure(d dVar) {
        Object obj;
        d0.e0.c<?> jvmErasure;
        m.checkNotNullParameter(dVar, "$this$jvmErasure");
        if (dVar instanceof d0.e0.c) {
            return (d0.e0.c) dVar;
        }
        if (!(dVar instanceof h)) {
            throw new a0("Cannot calculate JVM erasure for type: " + dVar);
        }
        List<KType> upperBounds = ((h) dVar).getUpperBounds();
        Iterator<T> it = upperBounds.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            KType kType = (KType) next;
            Objects.requireNonNull(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            d0.e0.p.d.m0.c.h declarationDescriptor = ((x) kType).getType().getConstructor().getDeclarationDescriptor();
            e eVar = (e) (declarationDescriptor instanceof e ? declarationDescriptor : null);
            if ((eVar == null || eVar.getKind() == f.INTERFACE || eVar.getKind() == f.ANNOTATION_CLASS) ? false : true) {
                obj = next;
                break;
            }
        }
        KType kType2 = (KType) obj;
        if (kType2 == null) {
            kType2 = (KType) u.firstOrNull((List) upperBounds);
        }
        return (kType2 == null || (jvmErasure = getJvmErasure(kType2)) == null) ? d0.z.d.a0.getOrCreateKotlinClass(Object.class) : jvmErasure;
    }
}
