package androidx.sharetarget;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$8 implements Runnable {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl this$0;
    public final /* synthetic */ Bitmap val$bitmap;
    public final /* synthetic */ String val$path;

    public ShortcutInfoCompatSaverImpl$8(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, Bitmap bitmap, String str) {
        this.this$0 = shortcutInfoCompatSaverImpl;
        this.val$bitmap = bitmap;
        this.val$path = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.saveBitmap(this.val$bitmap, this.val$path);
    }
}
