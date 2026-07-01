package f0;

import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: f0.o, reason: use source file name */
/* JADX INFO: compiled from: CookieJar.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CookieJar implements CookieJar2 {
    @Override // f0.CookieJar2
    public void a(HttpUrl httpUrl, List<Cookie> list) {
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics3.checkParameterIsNotNull(list, "cookies");
    }

    @Override // f0.CookieJar2
    public List<Cookie> b(HttpUrl httpUrl) {
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        return Collections2.emptyList();
    }
}
