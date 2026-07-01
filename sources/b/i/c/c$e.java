package b.i.c;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FirebaseApp.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(24)
public class c$e extends BroadcastReceiver {
    public static AtomicReference<c$e> a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1654b;

    public c$e(Context context) {
        this.f1654b = context;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object obj = c.a;
        synchronized (c.a) {
            Iterator<c> it = c.c.values().iterator();
            while (it.hasNext()) {
                it.next().d();
            }
        }
        this.f1654b.unregisterReceiver(this);
    }
}
