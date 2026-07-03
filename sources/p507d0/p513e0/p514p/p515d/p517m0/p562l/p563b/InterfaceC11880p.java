package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.p */
/* JADX INFO: compiled from: ErrorReporter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11880p {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC11880p f24676a = new a();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.p$a */
    /* JADX INFO: compiled from: ErrorReporter.java */
    public static class a implements InterfaceC11880p {
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9967a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11880p
        public void reportCannotInferVisibility(InterfaceC11321b interfaceC11321b) {
            if (interfaceC11321b != null) {
                return;
            }
            m9967a(2);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11880p
        public void reportIncompleteHierarchy(InterfaceC11330e interfaceC11330e, List<String> list) {
            if (interfaceC11330e == null) {
                m9967a(0);
                throw null;
            }
            if (list != null) {
                return;
            }
            m9967a(1);
            throw null;
        }
    }

    void reportCannotInferVisibility(InterfaceC11321b interfaceC11321b);

    void reportIncompleteHierarchy(InterfaceC11330e interfaceC11330e, List<String> list);
}
