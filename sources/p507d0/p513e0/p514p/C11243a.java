package p507d0.p513e0.p514p;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.KType;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p513e0.InterfaceC11231d;
import p507d0.p513e0.InterfaceC11235h;
import p507d0.p513e0.p514p.p515d.C11247a0;
import p507d0.p513e0.p514p.p515d.C12058x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.a */
/* JADX INFO: compiled from: KTypesJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11243a {
    public static final InterfaceC11230c<?> getJvmErasure(KType kType) {
        InterfaceC11230c<?> jvmErasure;
        C12238m.checkNotNullParameter(kType, "$this$jvmErasure");
        InterfaceC11231d classifier = kType.getClassifier();
        if (classifier != null && (jvmErasure = getJvmErasure(classifier)) != null) {
            return jvmErasure;
        }
        throw new C11247a0("Cannot calculate JVM erasure for type: " + kType);
    }

    public static final InterfaceC11230c<?> getJvmErasure(InterfaceC11231d interfaceC11231d) {
        Object obj;
        InterfaceC11230c<?> jvmErasure;
        C12238m.checkNotNullParameter(interfaceC11231d, "$this$jvmErasure");
        if (interfaceC11231d instanceof InterfaceC11230c) {
            return (InterfaceC11230c) interfaceC11231d;
        }
        if (!(interfaceC11231d instanceof InterfaceC11235h)) {
            throw new C11247a0("Cannot calculate JVM erasure for type: " + interfaceC11231d);
        }
        List<KType> upperBounds = ((InterfaceC11235h) interfaceC11231d).getUpperBounds();
        Iterator<T> it = upperBounds.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            KType kType = (KType) next;
            Objects.requireNonNull(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            InterfaceC11352h declarationDescriptor = ((C12058x) kType).getType().getConstructor().getDeclarationDescriptor();
            InterfaceC11330e interfaceC11330e = (InterfaceC11330e) (declarationDescriptor instanceof InterfaceC11330e ? declarationDescriptor : null);
            if ((interfaceC11330e == null || interfaceC11330e.getKind() == EnumC11333f.INTERFACE || interfaceC11330e.getKind() == EnumC11333f.ANNOTATION_CLASS) ? false : true) {
                obj = next;
                break;
            }
        }
        KType kType2 = (KType) obj;
        if (kType2 == null) {
            kType2 = (KType) C12163u.firstOrNull((List) upperBounds);
        }
        return (kType2 == null || (jvmErasure = getJvmErasure(kType2)) == null) ? C12216a0.getOrCreateKotlinClass(Object.class) : jvmErasure;
    }
}
