package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.a1 */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11908a1 {
    public static final AbstractC11934j0 asSimpleType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        AbstractC11934j0 abstractC11934j0 = abstractC11932i1Unwrap instanceof AbstractC11934j0 ? (AbstractC11934j0) abstractC11932i1Unwrap : null;
        if (abstractC11934j0 != null) {
            return abstractC11934j0;
        }
        throw new IllegalStateException(C12238m.stringPlus("This is should be simple type: ", abstractC11913c0).toString());
    }

    public static final AbstractC11913c0 replace(AbstractC11913c0 abstractC11913c0, List<? extends InterfaceC12012w0> list, InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        C12238m.checkNotNullParameter(list, "newArguments");
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return replace$default(abstractC11913c0, list, interfaceC11344g, null, 4, null);
    }

    public static final AbstractC11913c0 replace(AbstractC11913c0 abstractC11913c0, List<? extends InterfaceC12012w0> list, InterfaceC11344g interfaceC11344g, List<? extends InterfaceC12012w0> list2) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        C12238m.checkNotNullParameter(list, "newArguments");
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        C12238m.checkNotNullParameter(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == abstractC11913c0.getArguments()) && interfaceC11344g == abstractC11913c0.getAnnotations()) {
            return abstractC11913c0;
        }
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        if (abstractC11932i1Unwrap instanceof AbstractC12009v) {
            C11916d0 c11916d0 = C11916d0.f24748a;
            AbstractC12009v abstractC12009v = (AbstractC12009v) abstractC11932i1Unwrap;
            return C11916d0.flexibleType(replace(abstractC12009v.getLowerBound(), list, interfaceC11344g), replace(abstractC12009v.getUpperBound(), list2, interfaceC11344g));
        }
        if (abstractC11932i1Unwrap instanceof AbstractC11934j0) {
            return replace((AbstractC11934j0) abstractC11932i1Unwrap, list, interfaceC11344g);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ AbstractC11913c0 replace$default(AbstractC11913c0 abstractC11913c0, List list, InterfaceC11344g interfaceC11344g, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = abstractC11913c0.getArguments();
        }
        if ((i & 2) != 0) {
            interfaceC11344g = abstractC11913c0.getAnnotations();
        }
        if ((i & 4) != 0) {
            list2 = list;
        }
        return replace(abstractC11913c0, list, interfaceC11344g, list2);
    }

    public static /* synthetic */ AbstractC11934j0 replace$default(AbstractC11934j0 abstractC11934j0, List list, InterfaceC11344g interfaceC11344g, int i, Object obj) {
        if ((i & 1) != 0) {
            list = abstractC11934j0.getArguments();
        }
        if ((i & 2) != 0) {
            interfaceC11344g = abstractC11934j0.getAnnotations();
        }
        return replace(abstractC11934j0, (List<? extends InterfaceC12012w0>) list, interfaceC11344g);
    }

    public static final AbstractC11934j0 replace(AbstractC11934j0 abstractC11934j0, List<? extends InterfaceC12012w0> list, InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(abstractC11934j0, "<this>");
        C12238m.checkNotNullParameter(list, "newArguments");
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        if (list.isEmpty() && interfaceC11344g == abstractC11934j0.getAnnotations()) {
            return abstractC11934j0;
        }
        if (list.isEmpty()) {
            return abstractC11934j0.replaceAnnotations(interfaceC11344g);
        }
        C11916d0 c11916d0 = C11916d0.f24748a;
        return C11916d0.simpleType$default(interfaceC11344g, abstractC11934j0.getConstructor(), list, abstractC11934j0.isMarkedNullable(), null, 16, null);
    }
}
