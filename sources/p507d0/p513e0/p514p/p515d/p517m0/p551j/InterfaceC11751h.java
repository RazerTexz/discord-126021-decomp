package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.h */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11751h {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.h$a */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class a {
        public static boolean getIncludeAnnotationArguments(InterfaceC11751h interfaceC11751h) {
            C12238m.checkNotNullParameter(interfaceC11751h, "this");
            return interfaceC11751h.getAnnotationArgumentsRenderingPolicy().getIncludeAnnotationArguments();
        }

        public static boolean getIncludeEmptyAnnotationArguments(InterfaceC11751h interfaceC11751h) {
            C12238m.checkNotNullParameter(interfaceC11751h, "this");
            return interfaceC11751h.getAnnotationArgumentsRenderingPolicy().getIncludeEmptyAnnotationArguments();
        }
    }

    EnumC11744a getAnnotationArgumentsRenderingPolicy();

    boolean getDebugMode();

    boolean getEnhancedTypes();

    Set<C11713b> getExcludedTypeAnnotationClasses();

    void setAnnotationArgumentsRenderingPolicy(EnumC11744a enumC11744a);

    void setClassifierNamePolicy(InterfaceC11745b interfaceC11745b);

    void setDebugMode(boolean z2);

    void setExcludedTypeAnnotationClasses(Set<C11713b> set);

    void setModifiers(Set<? extends EnumC11750g> set);

    void setParameterNameRenderingPolicy(EnumC11757n enumC11757n);

    void setReceiverAfterName(boolean z2);

    void setRenderCompanionObjectName(boolean z2);

    void setStartFromName(boolean z2);

    void setTextFormat(EnumC11759p enumC11759p);

    void setWithDefinedIn(boolean z2);

    void setWithoutSuperTypes(boolean z2);

    void setWithoutTypeParameters(boolean z2);
}
