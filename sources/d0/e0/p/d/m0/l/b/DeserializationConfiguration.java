package d0.e0.p.d.m0.l.b;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.k, reason: use source file name */
/* JADX INFO: compiled from: DeserializationConfiguration.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DeserializationConfiguration {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.k$a */
    /* JADX INFO: compiled from: DeserializationConfiguration.kt */
    public static final class a implements DeserializationConfiguration {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.l.b.DeserializationConfiguration
        public boolean getAllowUnstableDependencies() {
            return b.getAllowUnstableDependencies(this);
        }

        @Override // d0.e0.p.d.m0.l.b.DeserializationConfiguration
        public boolean getPreserveDeclarationsOrdering() {
            return b.getPreserveDeclarationsOrdering(this);
        }

        @Override // d0.e0.p.d.m0.l.b.DeserializationConfiguration
        public boolean getReleaseCoroutines() {
            return b.getReleaseCoroutines(this);
        }

        @Override // d0.e0.p.d.m0.l.b.DeserializationConfiguration
        public boolean getReportErrorsOnPreReleaseDependencies() {
            return b.getReportErrorsOnPreReleaseDependencies(this);
        }

        @Override // d0.e0.p.d.m0.l.b.DeserializationConfiguration
        public boolean getSkipMetadataVersionCheck() {
            return b.getSkipMetadataVersionCheck(this);
        }

        @Override // d0.e0.p.d.m0.l.b.DeserializationConfiguration
        public boolean getSkipPrereleaseCheck() {
            return b.getSkipPrereleaseCheck(this);
        }

        @Override // d0.e0.p.d.m0.l.b.DeserializationConfiguration
        public boolean getTypeAliasesAllowed() {
            return b.getTypeAliasesAllowed(this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.k$b */
    /* JADX INFO: compiled from: DeserializationConfiguration.kt */
    public static final class b {
        public static boolean getAllowUnstableDependencies(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getPreserveDeclarationsOrdering(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getReleaseCoroutines(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getReportErrorsOnPreReleaseDependencies(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getSkipMetadataVersionCheck(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getSkipPrereleaseCheck(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getTypeAliasesAllowed(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
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
