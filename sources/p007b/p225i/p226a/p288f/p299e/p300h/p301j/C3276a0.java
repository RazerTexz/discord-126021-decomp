package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.a0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3276a0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    @Nullable
    public Context f9341a;

    /* JADX INFO: renamed from: b */
    public final C3322u0 f9342b;

    public C3276a0(C3322u0 c3322u0) {
        this.f9342b = c3322u0;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m4056a() {
        Context context = this.f9341a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f9341a = null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            C3322u0 c3322u0 = this.f9342b;
            c3322u0.f9457b.f9461k.m4118m();
            if (c3322u0.f9456a.isShowing()) {
                c3322u0.f9456a.dismiss();
            }
            m4056a();
        }
    }
}
