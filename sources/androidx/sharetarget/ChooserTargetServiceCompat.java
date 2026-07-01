package androidx.sharetarget;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.service.chooser.ChooserTarget;
import android.service.chooser.ChooserTargetService;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.sharetarget.ShareTargetCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ChooserTargetServiceCompat extends ChooserTargetService {
    public static final String TAG = "ChooserServiceCompat";

    public static class ShortcutHolder implements Comparable<ShortcutHolder> {
        private final ShortcutInfoCompat mShortcut;
        private final ComponentName mTargetClass;

        public ShortcutHolder(ShortcutInfoCompat shortcutInfoCompat, ComponentName componentName) {
            this.mShortcut = shortcutInfoCompat;
            this.mTargetClass = componentName;
        }

        public ShortcutInfoCompat getShortcut() {
            return this.mShortcut;
        }

        public ComponentName getTargetClass() {
            return this.mTargetClass;
        }

        @Override // java.lang.Comparable
        public int compareTo(ShortcutHolder shortcutHolder) {
            return getShortcut().getRank() - shortcutHolder.getShortcut().getRank();
        }
    }

    @NonNull
    @VisibleForTesting
    public static List<ChooserTarget> convertShortcutsToChooserTargets(@NonNull ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, @NonNull List<ShortcutHolder> list) {
        IconCompat shortcutIcon;
        if (list.isEmpty()) {
            return new ArrayList();
        }
        Collections.sort(list);
        ArrayList arrayList = new ArrayList();
        float f = 1.0f;
        int rank = list.get(0).getShortcut().getRank();
        for (ShortcutHolder shortcutHolder : list) {
            ShortcutInfoCompat shortcut = shortcutHolder.getShortcut();
            Icon icon = null;
            try {
                shortcutIcon = shortcutInfoCompatSaverImpl.getShortcutIcon(shortcut.getId());
            } catch (Exception e) {
                Log.e(TAG, "Failed to retrieve shortcut icon: ", e);
                shortcutIcon = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString(ShortcutManagerCompat.EXTRA_SHORTCUT_ID, shortcut.getId());
            if (rank != shortcut.getRank()) {
                f -= 0.01f;
                rank = shortcut.getRank();
            }
            CharSequence shortLabel = shortcut.getShortLabel();
            if (shortcutIcon != null) {
                icon = shortcutIcon.toIcon();
            }
            arrayList.add(new ChooserTarget(shortLabel, icon, f, shortcutHolder.getTargetClass(), bundle));
        }
        return arrayList;
    }

    @Override // android.service.chooser.ChooserTargetService
    public List<ChooserTarget> onGetChooserTargets(ComponentName componentName, IntentFilter intentFilter) {
        Context applicationContext = getApplicationContext();
        ArrayList<ShareTargetCompat> shareTargets = ShareTargetXmlParser.getShareTargets(applicationContext);
        ArrayList<ShareTargetCompat> arrayList = new ArrayList();
        for (ShareTargetCompat shareTargetCompat : shareTargets) {
            if (shareTargetCompat.mTargetClass.equals(componentName.getClassName())) {
                for (ShareTargetCompat.TargetData targetData : shareTargetCompat.mTargetData) {
                    if (intentFilter.hasDataType(targetData.mMimeType)) {
                        arrayList.add(shareTargetCompat);
                        break;
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl = ShortcutInfoCompatSaverImpl.getInstance(applicationContext);
        try {
            List<ShortcutInfoCompat> shortcuts = shortcutInfoCompatSaverImpl.getShortcuts();
            if (shortcuts == null || shortcuts.isEmpty()) {
                return Collections.emptyList();
            }
            ArrayList arrayList2 = new ArrayList();
            for (ShortcutInfoCompat shortcutInfoCompat : shortcuts) {
                for (ShareTargetCompat shareTargetCompat2 : arrayList) {
                    if (shortcutInfoCompat.getCategories().containsAll(Arrays.asList(shareTargetCompat2.mCategories))) {
                        arrayList2.add(new ShortcutHolder(shortcutInfoCompat, new ComponentName(applicationContext.getPackageName(), shareTargetCompat2.mTargetClass)));
                        break;
                    }
                }
            }
            return convertShortcutsToChooserTargets(shortcutInfoCompatSaverImpl, arrayList2);
        } catch (Exception e) {
            Log.e(TAG, "Failed to retrieve shortcuts: ", e);
            return Collections.emptyList();
        }
    }
}
