package androidx.sharetarget;

import androidx.concurrent.futures.ResolvableFuture;
import b.i.b.d.a.a;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$3 implements Runnable {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl this$0;
    public final /* synthetic */ ResolvableFuture val$result;

    public ShortcutInfoCompatSaverImpl$3(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, ResolvableFuture resolvableFuture) {
        this.this$0 = shortcutInfoCompatSaverImpl;
        this.val$result = resolvableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.mShortcutsMap.clear();
        Iterator<a<?>> it = this.this$0.mScheduledBitmapTasks.values().iterator();
        while (it.hasNext()) {
            it.next().cancel(false);
        }
        this.this$0.mScheduledBitmapTasks.clear();
        this.this$0.scheduleSyncCurrentState(this.val$result);
    }
}
