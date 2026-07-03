package p007b.p225i.p226a.p288f.p299e.p304k;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.k.j0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class BinderC3362j0 extends AbstractBinderC3344a0 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public AbstractC3345b f9529a;

    /* JADX INFO: renamed from: b */
    public final int f9530b;

    public BinderC3362j0(@NonNull AbstractC3345b abstractC3345b, int i) {
        this.f9529a = abstractC3345b;
        this.f9530b = i;
    }

    @BinderThread
    /* JADX INFO: renamed from: g */
    public final void m4163g(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        C1460d.m595z(this.f9529a, "onPostInitComplete can be called only once per call to getRemoteService");
        AbstractC3345b abstractC3345b = this.f9529a;
        int i2 = this.f9530b;
        Handler handler = abstractC3345b.f9482g;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new C3366l0(abstractC3345b, i, iBinder, bundle)));
        this.f9529a = null;
    }
}
