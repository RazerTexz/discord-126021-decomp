package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.l */
/* JADX INFO: compiled from: ResolutionScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11773l {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.l$a */
    /* JADX INFO: compiled from: ResolutionScope.kt */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection getContributedDescriptors$default(InterfaceC11773l interfaceC11773l, C11765d c11765d, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i & 1) != 0) {
                c11765d = C11765d.f24351m;
            }
            if ((i & 2) != 0) {
                function1 = InterfaceC11770i.f24369a.getALL_NAME_FILTER();
            }
            return interfaceC11773l.getContributedDescriptors(c11765d, function1);
        }
    }

    InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b);

    Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1);
}
