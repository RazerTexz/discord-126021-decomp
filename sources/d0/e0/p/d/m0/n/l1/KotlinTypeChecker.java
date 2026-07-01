package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeConstructor;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.f, reason: use source file name */
/* JADX INFO: compiled from: KotlinTypeChecker.java */
/* JADX INFO: loaded from: classes3.dex */
public interface KotlinTypeChecker {
    public static final KotlinTypeChecker a = NewKotlinTypeChecker.f3529b.getDefault();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.f$a */
    /* JADX INFO: compiled from: KotlinTypeChecker.java */
    public interface a {
        boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2);
    }

    boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2);

    boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2);
}
