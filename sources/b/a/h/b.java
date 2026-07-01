package b.a.h;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CustomTabsPackages.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends o implements Function1<String, Boolean> {
    public static final b j = new b();

    public b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(String str) {
        m.checkNotNullParameter(str, "it");
        return Boolean.TRUE;
    }
}
