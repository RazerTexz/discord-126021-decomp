package androidx.sharetarget;

import android.content.ComponentName;
import androidx.core.content.pm.ShortcutInfoCompat;

/* JADX INFO: loaded from: classes.dex */
public class ChooserTargetServiceCompat$ShortcutHolder implements Comparable<ChooserTargetServiceCompat$ShortcutHolder> {
    private final ShortcutInfoCompat mShortcut;
    private final ComponentName mTargetClass;

    public ChooserTargetServiceCompat$ShortcutHolder(ShortcutInfoCompat shortcutInfoCompat, ComponentName componentName) {
        this.mShortcut = shortcutInfoCompat;
        this.mTargetClass = componentName;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ChooserTargetServiceCompat$ShortcutHolder chooserTargetServiceCompat$ShortcutHolder) {
        return compareTo2(chooserTargetServiceCompat$ShortcutHolder);
    }

    public ShortcutInfoCompat getShortcut() {
        return this.mShortcut;
    }

    public ComponentName getTargetClass() {
        return this.mTargetClass;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ChooserTargetServiceCompat$ShortcutHolder chooserTargetServiceCompat$ShortcutHolder) {
        return getShortcut().getRank() - chooserTargetServiceCompat$ShortcutHolder.getShortcut().getRank();
    }
}
