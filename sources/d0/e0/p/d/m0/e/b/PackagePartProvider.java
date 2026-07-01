package d0.e0.p.d.m0.e.b;

import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.v, reason: use source file name */
/* JADX INFO: compiled from: PackagePartProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface PackagePartProvider {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.v$a */
    /* JADX INFO: compiled from: PackagePartProvider.kt */
    public static final class a implements PackagePartProvider {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.e.b.PackagePartProvider
        public List<String> findPackageParts(String str) {
            Intrinsics3.checkNotNullParameter(str, "packageFqName");
            return Collections2.emptyList();
        }
    }

    List<String> findPackageParts(String str);
}
