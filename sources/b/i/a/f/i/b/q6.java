package b.i.a.f.i.b;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q6 implements v9 {
    public final /* synthetic */ c6 a;

    public q6(c6 c6Var) {
        this.a = c6Var;
    }

    @Override // b.i.a.f.i.b.v9
    public final void a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.a.H("auto", "_err", bundle);
        } else {
            this.a.a.l();
            throw null;
        }
    }
}
