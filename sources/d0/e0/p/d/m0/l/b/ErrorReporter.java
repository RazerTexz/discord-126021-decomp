package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.p, reason: use source file name */
/* JADX INFO: compiled from: ErrorReporter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ErrorReporter {
    public static final ErrorReporter a = new a();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.p$a */
    /* JADX INFO: compiled from: ErrorReporter.java */
    public static class a implements ErrorReporter {
        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.l.b.ErrorReporter
        public void reportCannotInferVisibility(CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor != null) {
                return;
            }
            a(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.l.b.ErrorReporter
        public void reportIncompleteHierarchy(ClassDescriptor classDescriptor, List<String> list) {
            if (classDescriptor == null) {
                a(0);
                throw null;
            }
            if (list != null) {
                return;
            }
            a(1);
            throw null;
        }
    }

    void reportCannotInferVisibility(CallableMemberDescriptor callableMemberDescriptor);

    void reportIncompleteHierarchy(ClassDescriptor classDescriptor, List<String> list);
}
