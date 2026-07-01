package androidx.core.content.pm;

import android.content.pm.ShortcutInfo;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(25)
public class ShortcutManagerCompat$Api25Impl {
    private ShortcutManagerCompat$Api25Impl() {
    }

    public static String getShortcutInfoWithLowestRank(@NonNull List<ShortcutInfo> list) {
        int rank = -1;
        String id2 = null;
        for (ShortcutInfo shortcutInfo : list) {
            if (shortcutInfo.getRank() > rank) {
                id2 = shortcutInfo.getId();
                rank = shortcutInfo.getRank();
            }
        }
        return id2;
    }
}
