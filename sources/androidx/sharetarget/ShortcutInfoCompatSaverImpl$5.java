package androidx.sharetarget;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$5 implements Callable<ShortcutsInfoSerialization$ShortcutContainer> {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl this$0;
    public final /* synthetic */ String val$shortcutId;

    public ShortcutInfoCompatSaverImpl$5(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, String str) {
        this.this$0 = shortcutInfoCompatSaverImpl;
        this.val$shortcutId = str;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ ShortcutsInfoSerialization$ShortcutContainer call() throws Exception {
        return call();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public ShortcutsInfoSerialization$ShortcutContainer call() {
        return this.this$0.mShortcutsMap.get(this.val$shortcutId);
    }
}
