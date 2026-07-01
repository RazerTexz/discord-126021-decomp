package androidx.sharetarget;

import android.util.Log;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$1 implements Runnable {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl this$0;
    public final /* synthetic */ File val$workingDirectory;

    public ShortcutInfoCompatSaverImpl$1(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, File file) {
        this.this$0 = shortcutInfoCompatSaverImpl;
        this.val$workingDirectory = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ShortcutInfoCompatSaverImpl.ensureDir(this.val$workingDirectory);
            ShortcutInfoCompatSaverImpl.ensureDir(this.this$0.mBitmapsDir);
            ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl = this.this$0;
            shortcutInfoCompatSaverImpl.mShortcutsMap.putAll(ShortcutsInfoSerialization.loadFromXml(shortcutInfoCompatSaverImpl.mTargetsXmlFile, shortcutInfoCompatSaverImpl.mContext));
            this.this$0.deleteDanglingBitmaps(new ArrayList(this.this$0.mShortcutsMap.values()));
        } catch (Exception e) {
            Log.w(ShortcutInfoCompatSaverImpl.TAG, "ShortcutInfoCompatSaver started with an exceptions ", e);
        }
    }
}
