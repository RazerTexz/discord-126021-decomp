package p630i0;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: i0.k */
/* JADX INFO: compiled from: Invocation.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12557k {

    /* JADX INFO: renamed from: a */
    public final Method f26547a;

    /* JADX INFO: renamed from: b */
    public final List<?> f26548b;

    public C12557k(Method method, List<?> list) {
        this.f26547a = method;
        this.f26548b = Collections.unmodifiableList(list);
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f26547a.getDeclaringClass().getName(), this.f26547a.getName(), this.f26548b);
    }
}
