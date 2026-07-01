package i0;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: i0.k, reason: use source file name */
/* JADX INFO: compiled from: Invocation.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Invocation {
    public final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<?> f3743b;

    public Invocation(Method method, List<?> list) {
        this.a = method;
        this.f3743b = Collections.unmodifiableList(list);
    }

    public String toString() {
        return String.format("%s.%s() %s", this.a.getDeclaringClass().getName(), this.a.getName(), this.f3743b);
    }
}
