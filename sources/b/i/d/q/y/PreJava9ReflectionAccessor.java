package b.i.d.q.y;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: renamed from: b.i.d.q.y.a, reason: use source file name */
/* JADX INFO: compiled from: PreJava9ReflectionAccessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PreJava9ReflectionAccessor extends ReflectionAccessor {
    @Override // b.i.d.q.y.ReflectionAccessor
    public void a(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}
