package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.x0 */
/* JADX INFO: compiled from: SupertypeLoopChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11473x0 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.x0$a */
    /* JADX INFO: compiled from: SupertypeLoopChecker.kt */
    public static final class a implements InterfaceC11473x0 {

        /* JADX INFO: renamed from: a */
        public static final a f23103a = new a();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11473x0
        public Collection<AbstractC11913c0> findLoopsInSupertypesAndDisconnect(InterfaceC12008u0 interfaceC12008u0, Collection<? extends AbstractC11913c0> collection, Function1<? super InterfaceC12008u0, ? extends Iterable<? extends AbstractC11913c0>> function1, Function1<? super AbstractC11913c0, Unit> function2) {
            C12238m.checkNotNullParameter(interfaceC12008u0, "currentTypeConstructor");
            C12238m.checkNotNullParameter(collection, "superTypes");
            C12238m.checkNotNullParameter(function1, "neighbors");
            C12238m.checkNotNullParameter(function2, "reportLoop");
            return collection;
        }
    }

    Collection<AbstractC11913c0> findLoopsInSupertypesAndDisconnect(InterfaceC12008u0 interfaceC12008u0, Collection<? extends AbstractC11913c0> collection, Function1<? super InterfaceC12008u0, ? extends Iterable<? extends AbstractC11913c0>> function1, Function1<? super AbstractC11913c0, Unit> function2);
}
