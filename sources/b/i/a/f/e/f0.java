package b.i.a.f.e;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends g0 {
    public final Callable<String> e;

    public /* synthetic */ f0(Callable callable) {
        super(false, null, null);
        this.e = callable;
    }

    @Override // b.i.a.f.e.g0
    public final String a() {
        try {
            return this.e.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
