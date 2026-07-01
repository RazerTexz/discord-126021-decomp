package androidx.sharetarget;

import b.i.b.d.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$7$1 implements Runnable {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl$7 this$1;
    public final /* synthetic */ a val$future;
    public final /* synthetic */ String val$id;

    public ShortcutInfoCompatSaverImpl$7$1(ShortcutInfoCompatSaverImpl$7 shortcutInfoCompatSaverImpl$7, String str, a aVar) {
        this.this$1 = shortcutInfoCompatSaverImpl$7;
        this.val$id = str;
        this.val$future = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.this$0.mScheduledBitmapTasks.remove(this.val$id);
        if (this.val$future.isCancelled()) {
            return;
        }
        try {
            this.val$future.get();
        } catch (Exception e) {
            this.this$1.val$result.setException(e);
        }
    }
}
