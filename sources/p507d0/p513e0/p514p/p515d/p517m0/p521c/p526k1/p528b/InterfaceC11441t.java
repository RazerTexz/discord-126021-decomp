package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.Modifier;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11335f1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11332e1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p525j1.C11403a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p525j1.C11404b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p525j1.C11405c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.t */
/* JADX INFO: compiled from: ReflectJavaModifierListOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11441t extends InterfaceC11586s {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.t$a */
    /* JADX INFO: compiled from: ReflectJavaModifierListOwner.kt */
    public static final class a {
        public static AbstractC11335f1 getVisibility(InterfaceC11441t interfaceC11441t) {
            C12238m.checkNotNullParameter(interfaceC11441t, "this");
            int modifiers = interfaceC11441t.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                return C11332e1.h.f22703c;
            }
            if (Modifier.isPrivate(modifiers)) {
                return C11332e1.e.f22700c;
            }
            if (Modifier.isProtected(modifiers)) {
                return Modifier.isStatic(modifiers) ? C11405c.f23008c : C11404b.f23007c;
            }
            return C11403a.f23006c;
        }

        public static boolean isAbstract(InterfaceC11441t interfaceC11441t) {
            C12238m.checkNotNullParameter(interfaceC11441t, "this");
            return Modifier.isAbstract(interfaceC11441t.getModifiers());
        }

        public static boolean isFinal(InterfaceC11441t interfaceC11441t) {
            C12238m.checkNotNullParameter(interfaceC11441t, "this");
            return Modifier.isFinal(interfaceC11441t.getModifiers());
        }

        public static boolean isStatic(InterfaceC11441t interfaceC11441t) {
            C12238m.checkNotNullParameter(interfaceC11441t, "this");
            return Modifier.isStatic(interfaceC11441t.getModifiers());
        }
    }

    int getModifiers();
}
