package p507d0.p513e0.p514p.p515d.p516l0;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.l0.d */
/* JADX INFO: compiled from: Caller.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11272d<M extends Member> {

    /* JADX INFO: renamed from: d0.e0.p.d.l0.d$a */
    /* JADX INFO: compiled from: Caller.kt */
    public static final class a {
        public static <M extends Member> void checkArguments(InterfaceC11272d<? extends M> interfaceC11272d, Object[] objArr) {
            C12238m.checkNotNullParameter(objArr, "args");
            if (C11274f.getArity(interfaceC11272d) == objArr.length) {
                return;
            }
            StringBuilder sbM833U = C1643a.m833U("Callable expects ");
            sbM833U.append(C11274f.getArity(interfaceC11272d));
            sbM833U.append(" arguments, but ");
            throw new IllegalArgumentException(C1643a.m814B(sbM833U, objArr.length, " were provided."));
        }
    }

    Object call(Object[] objArr);

    /* JADX INFO: renamed from: getMember */
    M mo11457getMember();

    List<Type> getParameterTypes();

    Type getReturnType();
}
