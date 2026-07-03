package p007b.p225i.p226a.p288f.p330i.p332b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.adjust.sdk.Constants;

/* JADX INFO: renamed from: b.i.a.f.i.b.f6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4035f6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C3999c6 f10721j;

    public RunnableC4035f6(C3999c6 c3999c6) {
        this.f10721j = c3999c6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4251y9 c4251y9 = this.f10721j.f10605n;
        c4251y9.f11386a.mo5725f().mo5848b();
        if (c4251y9.m5967c()) {
            if (c4251y9.m5966b()) {
                c4251y9.f11386a.m5946o().f10631B.m5695b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString(Constants.MEDIUM, "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                c4251y9.f11386a.m5948s().m5545H("auto", "_cmpx", bundle);
            } else {
                String strM5694a = c4251y9.f11386a.m5946o().f10631B.m5694a();
                if (TextUtils.isEmpty(strM5694a)) {
                    c4251y9.f11386a.mo5726g().f11142g.m5860a("Cache still valid but referrer not found");
                } else {
                    long jM5648a = ((c4251y9.f11386a.m5946o().f10632C.m5648a() / 3600000) - 1) * 3600000;
                    Uri uri = Uri.parse(strM5694a);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", jM5648a);
                    c4251y9.f11386a.m5948s().m5545H((String) pair.first, "_cmp", (Bundle) pair.second);
                }
                c4251y9.f11386a.m5946o().f10631B.m5695b(null);
            }
            c4251y9.f11386a.m5946o().f10632C.m5649b(0L);
        }
    }
}
