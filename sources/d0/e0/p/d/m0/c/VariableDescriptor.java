package d0.e0.p.d.m0.c;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.d1, reason: use source file name */
/* JADX INFO: compiled from: VariableDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface VariableDescriptor extends ValueDescriptor2 {
    d0.e0.p.d.m0.k.v.g<?> getCompileTimeInitializer();

    boolean isConst();

    boolean isLateInit();

    boolean isVar();
}
