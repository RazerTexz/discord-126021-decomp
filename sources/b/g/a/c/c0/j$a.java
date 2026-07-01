package b.g.a.c.c0;

import java.io.Serializable;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: AnnotatedMethod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j$a implements Serializable {
    private static final long serialVersionUID = 1;
    public Class<?>[] args;
    public Class<?> clazz;
    public String name;

    public j$a(Method method) {
        this.clazz = method.getDeclaringClass();
        this.name = method.getName();
        this.args = method.getParameterTypes();
    }
}
