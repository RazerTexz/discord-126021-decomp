package b.a.h;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.h.b, reason: use source file name */
/* JADX INFO: compiled from: CustomTabsPackages.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsPackages extends Lambda implements Function1<String, Boolean> {
    public static final CustomTabsPackages j = new CustomTabsPackages();

    public CustomTabsPackages() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        return Boolean.TRUE;
    }
}
