package androidx.sharetarget;

import androidx.concurrent.futures.ResolvableFuture;
import b.i.b.d.a.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$2 implements Runnable {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl this$0;
    public final /* synthetic */ List val$idList;
    public final /* synthetic */ ResolvableFuture val$result;

    public ShortcutInfoCompatSaverImpl$2(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, List list, ResolvableFuture resolvableFuture) {
        this.this$0 = shortcutInfoCompatSaverImpl;
        this.val$idList = list;
        this.val$result = resolvableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (String str : this.val$idList) {
            this.this$0.mShortcutsMap.remove(str);
            a<?> aVarRemove = this.this$0.mScheduledBitmapTasks.remove(str);
            if (aVarRemove != null) {
                aVarRemove.cancel(false);
            }
        }
        this.this$0.scheduleSyncCurrentState(this.val$result);
    }
}
