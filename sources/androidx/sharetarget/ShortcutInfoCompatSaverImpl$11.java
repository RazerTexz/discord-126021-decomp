package androidx.sharetarget;

import androidx.concurrent.futures.ResolvableFuture;
import b.i.b.d.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$11 implements Runnable {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl this$0;
    public final /* synthetic */ a val$future;
    public final /* synthetic */ ResolvableFuture val$output;

    public ShortcutInfoCompatSaverImpl$11(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, a aVar, ResolvableFuture resolvableFuture) {
        this.this$0 = shortcutInfoCompatSaverImpl;
        this.val$future = aVar;
        this.val$output = resolvableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.val$future.get();
            this.val$output.set(null);
        } catch (Exception e) {
            this.val$output.setException(e);
        }
    }
}
