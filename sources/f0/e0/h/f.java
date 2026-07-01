package f0.e0.h;

import androidx.browser.trusted.sharing.ShareTarget;
import d0.z.d.m;

/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final boolean a(String str) {
        m.checkParameterIsNotNull(str, "method");
        return (m.areEqual(str, ShareTarget.METHOD_GET) || m.areEqual(str, "HEAD")) ? false : true;
    }
}
