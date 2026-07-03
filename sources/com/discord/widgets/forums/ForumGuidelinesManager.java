package com.discord.widgets.forums;

import android.content.SharedPreferences;
import com.discord.utilities.cache.SharedPreferenceExtensionsKt;
import com.discord.utilities.cache.SharedPreferencesProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import p507d0.p579g0.C12102s;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ForumGuidelinesManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumGuidelinesManager {
    public static final ForumGuidelinesManager INSTANCE;
    private static final Set<Long> seenChannelIds;

    static {
        ForumGuidelinesManager forumGuidelinesManager = new ForumGuidelinesManager();
        INSTANCE = forumGuidelinesManager;
        seenChannelIds = forumGuidelinesManager.getFromCache();
    }

    private ForumGuidelinesManager() {
    }

    private final Set<Long> getFromCache() {
        Set stringSetNonNull$default = SharedPreferenceExtensionsKt.getStringSetNonNull$default(SharedPreferencesProvider.INSTANCE.get(), "CACHE_KEY_USER_VIEWED_FORUM_GUIDELINES", null, 2, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = stringSetNonNull$default.iterator();
        while (it.hasNext()) {
            Long longOrNull = C12102s.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                arrayList.add(longOrNull);
            }
        }
        return C12163u.toMutableSet(arrayList);
    }

    private final void updateCache() {
        Set<Long> set = seenChannelIds;
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        Set<String> set2 = C12163u.toSet(arrayList);
        SharedPreferences.Editor editorEdit = SharedPreferencesProvider.INSTANCE.get().edit();
        C12238m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putStringSet("CACHE_KEY_USER_VIEWED_FORUM_GUIDELINES", set2);
        editorEdit.apply();
    }

    public final boolean hasSeenGuidelines(long channelId) {
        return seenChannelIds.contains(Long.valueOf(channelId));
    }

    public final void markGuidelinesSeen(long channelId) {
        seenChannelIds.add(Long.valueOf(channelId));
        updateCache();
    }
}
