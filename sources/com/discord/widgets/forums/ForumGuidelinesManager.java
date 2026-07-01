package com.discord.widgets.forums;

import android.content.SharedPreferences$Editor;
import com.discord.utilities.cache.SharedPreferenceExtensionsKt;
import com.discord.utilities.cache.SharedPreferencesProvider;
import d0.g0.s;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

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
            Long longOrNull = s.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                arrayList.add(longOrNull);
            }
        }
        return u.toMutableSet(arrayList);
    }

    private final void updateCache() {
        Set<Long> set = seenChannelIds;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        Set<String> set2 = u.toSet(arrayList);
        SharedPreferences$Editor sharedPreferences$EditorEdit = SharedPreferencesProvider.INSTANCE.get().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putStringSet("CACHE_KEY_USER_VIEWED_FORUM_GUIDELINES", set2);
        sharedPreferences$EditorEdit.apply();
    }

    public final boolean hasSeenGuidelines(long channelId) {
        return seenChannelIds.contains(Long.valueOf(channelId));
    }

    public final void markGuidelinesSeen(long channelId) {
        seenChannelIds.add(Long.valueOf(channelId));
        updateCache();
    }
}
