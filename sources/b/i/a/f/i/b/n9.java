package b.i.a.f.i.b;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n9 implements v9 {
    public final /* synthetic */ k9 a;

    public n9(k9 k9Var) {
        this.a = k9Var;
    }

    @Override // b.i.a.f.i.b.v9
    public final void a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.a.k.g().f.a("AppId not known when logging error event");
        } else {
            this.a.f().v(new p9(this, str, bundle));
        }
    }
}
