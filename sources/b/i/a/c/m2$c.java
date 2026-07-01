package b.i.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: StreamVolumeManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m2$c extends BroadcastReceiver {
    public final /* synthetic */ m2 a;

    public m2$c(m2 m2Var, m2$a m2_a) {
        this.a = m2Var;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        m2 m2Var = this.a;
        m2Var.f1033b.post(new p0(m2Var));
    }
}
