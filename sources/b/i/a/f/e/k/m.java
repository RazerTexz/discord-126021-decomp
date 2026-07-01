package b.i.a.f.e.k;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends n {
    public final /* synthetic */ Intent j;
    public final /* synthetic */ Activity k;
    public final /* synthetic */ int l;

    public m(Intent intent, Activity activity, int i) {
        this.j = intent;
        this.k = activity;
        this.l = i;
    }

    @Override // b.i.a.f.e.k.n
    public final void a() {
        Intent intent = this.j;
        if (intent != null) {
            this.k.startActivityForResult(intent, this.l);
        }
    }
}
