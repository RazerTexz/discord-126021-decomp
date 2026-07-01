package androidx.sharetarget;

import androidx.annotation.AnyThread;
import androidx.core.content.pm.ShortcutInfoCompat;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutsInfoSerialization$ShortcutContainer {
    public final String mBitmapPath;
    public final String mResourceName;
    public final ShortcutInfoCompat mShortcutInfo;

    @AnyThread
    public ShortcutsInfoSerialization$ShortcutContainer(ShortcutInfoCompat shortcutInfoCompat, String str, String str2) {
        this.mShortcutInfo = shortcutInfoCompat;
        this.mResourceName = str;
        this.mBitmapPath = str2;
    }
}
