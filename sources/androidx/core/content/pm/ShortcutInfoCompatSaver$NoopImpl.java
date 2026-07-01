package androidx.core.content.pm;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY})
public class ShortcutInfoCompatSaver$NoopImpl extends ShortcutInfoCompatSaver<Void> {
    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    public /* bridge */ /* synthetic */ Void addShortcuts(List list) {
        return addShortcuts2((List<ShortcutInfoCompat>) list);
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    /* JADX INFO: renamed from: addShortcuts, reason: avoid collision after fix types in other method */
    public Void addShortcuts2(List<ShortcutInfoCompat> list) {
        return null;
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    public /* bridge */ /* synthetic */ Void removeAllShortcuts() {
        return removeAllShortcuts2();
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    /* JADX INFO: renamed from: removeAllShortcuts, reason: avoid collision after fix types in other method */
    public Void removeAllShortcuts2() {
        return null;
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    public /* bridge */ /* synthetic */ Void removeShortcuts(List list) {
        return removeShortcuts2((List<String>) list);
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    /* JADX INFO: renamed from: removeShortcuts, reason: avoid collision after fix types in other method */
    public Void removeShortcuts2(List<String> list) {
        return null;
    }
}
