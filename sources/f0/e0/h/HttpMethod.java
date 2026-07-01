package f0.e0.h;

import androidx.browser.trusted.sharing.ShareTarget;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: f0.e0.h.f, reason: use source file name */
/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpMethod {
    public static final boolean a(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "method");
        return (Intrinsics3.areEqual(str, ShareTarget.METHOD_GET) || Intrinsics3.areEqual(str, "HEAD")) ? false : true;
    }
}
