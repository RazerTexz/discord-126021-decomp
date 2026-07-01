package b.g.a.c.c0;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: AnnotatedConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a implements Serializable {
    private static final long serialVersionUID = 1;
    public Class<?>[] args;
    public Class<?> clazz;

    public e$a(Constructor<?> constructor) {
        this.clazz = constructor.getDeclaringClass();
        this.args = constructor.getParameterTypes();
    }
}
