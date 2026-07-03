package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.k */
/* JADX INFO: compiled from: DeserializationConfiguration.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11875k {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.k$a */
    /* JADX INFO: compiled from: DeserializationConfiguration.kt */
    public static final class a implements InterfaceC11875k {

        /* JADX INFO: renamed from: a */
        public static final a f24658a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k
        public boolean getAllowUnstableDependencies() {
            return b.getAllowUnstableDependencies(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k
        public boolean getPreserveDeclarationsOrdering() {
            return b.getPreserveDeclarationsOrdering(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k
        public boolean getReleaseCoroutines() {
            return b.getReleaseCoroutines(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k
        public boolean getReportErrorsOnPreReleaseDependencies() {
            return b.getReportErrorsOnPreReleaseDependencies(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k
        public boolean getSkipMetadataVersionCheck() {
            return b.getSkipMetadataVersionCheck(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k
        public boolean getSkipPrereleaseCheck() {
            return b.getSkipPrereleaseCheck(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11875k
        public boolean getTypeAliasesAllowed() {
            return b.getTypeAliasesAllowed(this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.k$b */
    /* JADX INFO: compiled from: DeserializationConfiguration.kt */
    public static final class b {
        public static boolean getAllowUnstableDependencies(InterfaceC11875k interfaceC11875k) {
            C12238m.checkNotNullParameter(interfaceC11875k, "this");
            return false;
        }

        public static boolean getPreserveDeclarationsOrdering(InterfaceC11875k interfaceC11875k) {
            C12238m.checkNotNullParameter(interfaceC11875k, "this");
            return false;
        }

        public static boolean getReleaseCoroutines(InterfaceC11875k interfaceC11875k) {
            C12238m.checkNotNullParameter(interfaceC11875k, "this");
            return false;
        }

        public static boolean getReportErrorsOnPreReleaseDependencies(InterfaceC11875k interfaceC11875k) {
            C12238m.checkNotNullParameter(interfaceC11875k, "this");
            return false;
        }

        public static boolean getSkipMetadataVersionCheck(InterfaceC11875k interfaceC11875k) {
            C12238m.checkNotNullParameter(interfaceC11875k, "this");
            return false;
        }

        public static boolean getSkipPrereleaseCheck(InterfaceC11875k interfaceC11875k) {
            C12238m.checkNotNullParameter(interfaceC11875k, "this");
            return false;
        }

        public static boolean getTypeAliasesAllowed(InterfaceC11875k interfaceC11875k) {
            C12238m.checkNotNullParameter(interfaceC11875k, "this");
            return true;
        }
    }

    boolean getAllowUnstableDependencies();

    boolean getPreserveDeclarationsOrdering();

    boolean getReleaseCoroutines();

    boolean getReportErrorsOnPreReleaseDependencies();

    boolean getSkipMetadataVersionCheck();

    boolean getSkipPrereleaseCheck();

    boolean getTypeAliasesAllowed();
}
