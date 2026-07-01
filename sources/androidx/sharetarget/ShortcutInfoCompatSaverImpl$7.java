package androidx.sharetarget;

import android.graphics.Bitmap;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.pm.ShortcutInfoCompat;
import b.i.b.d.a.a;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$7 implements Runnable {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl this$0;
    public final /* synthetic */ List val$copy;
    public final /* synthetic */ ResolvableFuture val$result;

    public ShortcutInfoCompatSaverImpl$7(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, List list, ResolvableFuture resolvableFuture) {
        this.this$0 = shortcutInfoCompatSaverImpl;
        this.val$copy = list;
        this.val$result = resolvableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (ShortcutInfoCompat shortcutInfoCompat : this.val$copy) {
            Set<String> categories = shortcutInfoCompat.getCategories();
            if (categories != null && !categories.isEmpty()) {
                ShortcutsInfoSerialization$ShortcutContainer shortcutsInfoSerialization$ShortcutContainerContainerFrom = this.this$0.containerFrom(shortcutInfoCompat);
                Bitmap bitmap = shortcutsInfoSerialization$ShortcutContainerContainerFrom.mBitmapPath != null ? shortcutInfoCompat.getIcon().getBitmap() : null;
                String id2 = shortcutInfoCompat.getId();
                this.this$0.mShortcutsMap.put(id2, shortcutsInfoSerialization$ShortcutContainerContainerFrom);
                if (bitmap != null) {
                    a<Void> aVarScheduleBitmapSaving = this.this$0.scheduleBitmapSaving(bitmap, shortcutsInfoSerialization$ShortcutContainerContainerFrom.mBitmapPath);
                    a<?> aVarPut = this.this$0.mScheduledBitmapTasks.put(id2, aVarScheduleBitmapSaving);
                    if (aVarPut != null) {
                        aVarPut.cancel(false);
                    }
                    aVarScheduleBitmapSaving.addListener(new ShortcutInfoCompatSaverImpl$7$1(this, id2, aVarScheduleBitmapSaving), this.this$0.mCacheUpdateService);
                }
            }
        }
        this.this$0.scheduleSyncCurrentState(this.val$result);
    }
}
