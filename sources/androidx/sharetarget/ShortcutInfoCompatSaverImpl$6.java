package androidx.sharetarget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$6 implements Callable<Bitmap> {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl this$0;
    public final /* synthetic */ ShortcutsInfoSerialization$ShortcutContainer val$container;

    public ShortcutInfoCompatSaverImpl$6(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, ShortcutsInfoSerialization$ShortcutContainer shortcutsInfoSerialization$ShortcutContainer) {
        this.this$0 = shortcutInfoCompatSaverImpl;
        this.val$container = shortcutsInfoSerialization$ShortcutContainer;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Bitmap call() throws Exception {
        return call();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Bitmap call() {
        return BitmapFactory.decodeFile(this.val$container.mBitmapPath);
    }
}
