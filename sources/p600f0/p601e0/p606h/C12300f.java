package p600f0.p601e0.p606h;

import androidx.browser.trusted.sharing.ShareTarget;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.e0.h.f */
/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12300f {
    /* JADX INFO: renamed from: a */
    public static final boolean m10226a(String str) {
        C12238m.checkParameterIsNotNull(str, "method");
        return (C12238m.areEqual(str, ShareTarget.METHOD_GET) || C12238m.areEqual(str, "HEAD")) ? false : true;
    }
}
