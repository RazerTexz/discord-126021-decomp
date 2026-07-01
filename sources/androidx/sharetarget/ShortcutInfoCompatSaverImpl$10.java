package androidx.sharetarget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$10 implements Runnable {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl this$0;
    public final /* synthetic */ List val$containers;

    public ShortcutInfoCompatSaverImpl$10(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, List list) {
        this.this$0 = shortcutInfoCompatSaverImpl;
        this.val$containers = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.deleteDanglingBitmaps(this.val$containers);
        ShortcutsInfoSerialization.saveAsXml(this.val$containers, this.this$0.mTargetsXmlFile);
    }
}
