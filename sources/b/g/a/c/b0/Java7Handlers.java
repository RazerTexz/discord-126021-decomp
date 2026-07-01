package b.g.a.c.b0;

import b.g.a.c.JsonSerializer;
import b.g.a.c.i0.ClassUtil;

/* JADX INFO: renamed from: b.g.a.c.b0.a, reason: use source file name */
/* JADX INFO: compiled from: Java7Handlers.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Java7Handlers {
    public static final Java7Handlers a;

    static {
        Java7Handlers java7Handlers;
        try {
            java7Handlers = (Java7Handlers) ClassUtil.g(Class.forName("b.g.a.c.b0.b"), false);
        } catch (Throwable unused) {
            java7Handlers = null;
        }
        a = java7Handlers;
    }

    public abstract JsonSerializer<?> a(Class<?> cls);
}
