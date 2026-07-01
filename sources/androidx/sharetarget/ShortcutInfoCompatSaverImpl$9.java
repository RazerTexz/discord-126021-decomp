package androidx.sharetarget;

import androidx.concurrent.futures.ResolvableFuture;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$9 implements Runnable {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl this$0;
    public final /* synthetic */ ResolvableFuture val$result;
    public final /* synthetic */ Runnable val$runnable;

    public ShortcutInfoCompatSaverImpl$9(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, ResolvableFuture resolvableFuture, Runnable runnable) {
        this.this$0 = shortcutInfoCompatSaverImpl;
        this.val$result = resolvableFuture;
        this.val$runnable = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.val$result.isCancelled()) {
            return;
        }
        try {
            this.val$runnable.run();
            this.val$result.set(null);
        } catch (Exception e) {
            this.val$result.setException(e);
        }
    }
}
