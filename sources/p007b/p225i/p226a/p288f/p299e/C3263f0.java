package p007b.p225i.p226a.p288f.p299e;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.a.f.e.f0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3263f0 extends C3265g0 {

    /* JADX INFO: renamed from: e */
    public final Callable<String> f9316e;

    public /* synthetic */ C3263f0(Callable callable) {
        super(false, null, null);
        this.f9316e = callable;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.C3265g0
    /* JADX INFO: renamed from: a */
    public final String mo4025a() {
        try {
            return this.f9316e.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
