package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.c.e1$e;
import d0.e0.p.d.m0.c.e1$h;
import d0.e0.p.d.m0.c.f1;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: ReflectJavaModifierListOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t$a {
    public static f1 getVisibility(t tVar) {
        d0.z.d.m.checkNotNullParameter(tVar, "this");
        int modifiers = tVar.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            return e1$h.c;
        }
        if (Modifier.isPrivate(modifiers)) {
            return e1$e.c;
        }
        if (Modifier.isProtected(modifiers)) {
            return Modifier.isStatic(modifiers) ? d0.e0.p.d.m0.c.j1.c.c : d0.e0.p.d.m0.c.j1.b.c;
        }
        return d0.e0.p.d.m0.c.j1.a.c;
    }

    public static boolean isAbstract(t tVar) {
        d0.z.d.m.checkNotNullParameter(tVar, "this");
        return Modifier.isAbstract(tVar.getModifiers());
    }

    public static boolean isFinal(t tVar) {
        d0.z.d.m.checkNotNullParameter(tVar, "this");
        return Modifier.isFinal(tVar.getModifiers());
    }

    public static boolean isStatic(t tVar) {
        d0.z.d.m.checkNotNullParameter(tVar, "this");
        return Modifier.isStatic(tVar.getModifiers());
    }
}
