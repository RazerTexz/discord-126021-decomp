package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0;

import java.util.List;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k0.r */
/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11585r extends InterfaceC11584q, InterfaceC11593z {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k0.r$a */
    /* JADX INFO: compiled from: javaElements.kt */
    public static final class a {
        public static boolean getHasAnnotationParameterDefaultValue(InterfaceC11585r interfaceC11585r) {
            C12238m.checkNotNullParameter(interfaceC11585r, "this");
            return interfaceC11585r.getAnnotationParameterDefaultValue() != null;
        }
    }

    InterfaceC11566b getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    InterfaceC11591x getReturnType();

    List<InterfaceC11565a0> getValueParameters();
}
