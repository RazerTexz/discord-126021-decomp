package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.c.DeclarationDescriptorNonRoot;
import d0.e0.p.d.m0.n.TypeSubstitutor2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.w0, reason: use source file name */
/* JADX INFO: compiled from: Substitutable.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Substitutable<T extends DeclarationDescriptorNonRoot> {
    T substitute(TypeSubstitutor2 typeSubstitutor2);
}
