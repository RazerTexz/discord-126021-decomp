package d0.e0.p.d.m0.k.a0;

import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a {
    public d$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final int access$nextMask(d$a d_a) {
        Objects.requireNonNull(d_a);
        int iAccess$getNextMaskValue$cp = d.access$getNextMaskValue$cp();
        d.access$setNextMaskValue$cp(d.access$getNextMaskValue$cp() << 1);
        return iAccess$getNextMaskValue$cp;
    }

    public final int getALL_KINDS_MASK() {
        return d.access$getALL_KINDS_MASK$cp();
    }

    public final int getCALLABLES_MASK() {
        return d.access$getCALLABLES_MASK$cp();
    }

    public final int getCLASSIFIERS_MASK() {
        return d.access$getCLASSIFIERS_MASK$cp();
    }

    public final int getFUNCTIONS_MASK() {
        return d.access$getFUNCTIONS_MASK$cp();
    }

    public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
        return d.access$getNON_SINGLETON_CLASSIFIERS_MASK$cp();
    }

    public final int getPACKAGES_MASK() {
        return d.access$getPACKAGES_MASK$cp();
    }

    public final int getSINGLETON_CLASSIFIERS_MASK() {
        return d.access$getSINGLETON_CLASSIFIERS_MASK$cp();
    }

    public final int getTYPE_ALIASES_MASK() {
        return d.access$getTYPE_ALIASES_MASK$cp();
    }

    public final int getVALUES_MASK() {
        return d.access$getVALUES_MASK$cp();
    }

    public final int getVARIABLES_MASK() {
        return d.access$getVARIABLES_MASK$cp();
    }
}
