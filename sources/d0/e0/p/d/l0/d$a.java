package d0.e0.p.d.l0;

import d0.z.d.m;
import java.lang.reflect.Member;

/* JADX INFO: compiled from: Caller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a {
    public static <M extends Member> void checkArguments(d<? extends M> dVar, Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        if (f.getArity(dVar) == objArr.length) {
            return;
        }
        StringBuilder sbU = b.d.b.a.a.U("Callable expects ");
        sbU.append(f.getArity(dVar));
        sbU.append(" arguments, but ");
        throw new IllegalArgumentException(b.d.b.a.a.B(sbU, objArr.length, " were provided."));
    }
}
