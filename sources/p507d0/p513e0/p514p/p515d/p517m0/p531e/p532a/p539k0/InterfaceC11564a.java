package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k0.a */
/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11564a extends InterfaceC11579l {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k0.a$a */
    /* JADX INFO: compiled from: javaElements.kt */
    public static final class a {
        public static boolean isFreshlySupportedTypeUseAnnotation(InterfaceC11564a interfaceC11564a) {
            C12238m.checkNotNullParameter(interfaceC11564a, "this");
            return false;
        }

        public static boolean isIdeExternalAnnotation(InterfaceC11564a interfaceC11564a) {
            C12238m.checkNotNullParameter(interfaceC11564a, "this");
            return false;
        }
    }

    Collection<InterfaceC11566b> getArguments();

    C11712a getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    InterfaceC11574g resolve();
}
