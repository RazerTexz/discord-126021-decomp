package d0.e0.p.d.m0.c.k1.a;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.l.b.ErrorReporter;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.j, reason: use source file name */
/* JADX INFO: compiled from: RuntimeErrorReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeErrorReporter implements ErrorReporter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RuntimeErrorReporter f3286b = new RuntimeErrorReporter();

    @Override // d0.e0.p.d.m0.l.b.ErrorReporter
    public void reportCannotInferVisibility(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        throw new IllegalStateException(Intrinsics3.stringPlus("Cannot infer visibility for ", callableMemberDescriptor));
    }

    @Override // d0.e0.p.d.m0.l.b.ErrorReporter
    public void reportIncompleteHierarchy(ClassDescriptor classDescriptor, List<String> list) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(list, "unresolvedSuperClasses");
        StringBuilder sbU = outline.U("Incomplete hierarchy for class ");
        sbU.append(classDescriptor.getName());
        sbU.append(", unresolved classes ");
        sbU.append(list);
        throw new IllegalStateException(sbU.toString());
    }
}
