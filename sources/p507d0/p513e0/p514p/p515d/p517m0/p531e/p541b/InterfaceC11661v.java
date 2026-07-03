package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.List;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.v */
/* JADX INFO: compiled from: PackagePartProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11661v {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.v$a */
    /* JADX INFO: compiled from: PackagePartProvider.kt */
    public static final class a implements InterfaceC11661v {

        /* JADX INFO: renamed from: a */
        public static final a f23635a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11661v
        public List<String> findPackageParts(String str) {
            C12238m.checkNotNullParameter(str, "packageFqName");
            return C12147n.emptyList();
        }
    }

    List<String> findPackageParts(String str);
}
