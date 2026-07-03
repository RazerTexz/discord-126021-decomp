package p007b.p225i.p226a.p288f.p330i.p332b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.y9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4251y9 {

    /* JADX INFO: renamed from: a */
    public final C4202u4 f11386a;

    public C4251y9(C4202u4 c4202u4) {
        this.f11386a = c4202u4;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final void m5965a(String str, Bundle bundle) {
        String string;
        this.f11386a.mo5725f().mo5848b();
        if (this.f11386a.m5940d()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f11386a.m5946o().f10631B.m5695b(string);
        C4057h4 c4057h4 = this.f11386a.m5946o().f10632C;
        Objects.requireNonNull((C3401c) this.f11386a.f11267o);
        c4057h4.m5649b(System.currentTimeMillis());
    }

    /* JADX INFO: renamed from: b */
    public final boolean m5966b() {
        if (!m5967c()) {
            return false;
        }
        Objects.requireNonNull((C3401c) this.f11386a.f11267o);
        return System.currentTimeMillis() - this.f11386a.m5946o().f10632C.m5648a() > this.f11386a.f11260h.m5525n(null, C4142p.f11029E0);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m5967c() {
        return this.f11386a.m5946o().f10632C.m5648a() > 0;
    }
}
