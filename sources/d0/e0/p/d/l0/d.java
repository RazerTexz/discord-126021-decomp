package d0.e0.p.d.l0;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: Caller.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface d<M extends Member> {
    Object call(Object[] objArr);

    /* JADX INFO: renamed from: getMember */
    M mo80getMember();

    List<Type> getParameterTypes();

    Type getReturnType();
}
