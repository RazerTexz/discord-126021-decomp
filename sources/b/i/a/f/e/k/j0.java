package b.i.a.f.e.k;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends a0 {

    @Nullable
    public b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1389b;

    public j0(@NonNull b bVar, int i) {
        this.a = bVar;
        this.f1389b = i;
    }

    @BinderThread
    public final void g(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        b.c.a.a0.d.z(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
        b bVar = this.a;
        int i2 = this.f1389b;
        Handler handler = bVar.g;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new l0(bVar, i, iBinder, bundle)));
        this.a = null;
    }
}
