package com.discord.widgets.user.search;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.stores.StoreStream;
import com.discord.utilities.frecency.FrecencyTracker;
import d0.g0.y;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchModel$SearchContext {
    private final String filter;
    private final Collection<Long> frecencyChannels;
    private final boolean hasDiscriminator;
    private final Map<Long, Integer> mentionCounts;
    private final Map<Long, Long> mostRecent;
    private final long prevSelectedChannelId;
    private final List<Long> recentGuildIds;
    private final String sanitizedFilter;
    private final int searchType;
    private final long selectedChannelId;
    private final long selectedVoiceChannelId;

    public WidgetGlobalSearchModel$SearchContext(String str, List<Long> list, long j, long j2, long j3, Map<Long, Long> map, Map<Long, Integer> map2) {
        int i;
        String strSubstring;
        m.checkNotNullParameter(str, "filter");
        m.checkNotNullParameter(list, "recentGuildIds");
        m.checkNotNullParameter(map, "mostRecent");
        m.checkNotNullParameter(map2, "mentionCounts");
        this.filter = str;
        this.recentGuildIds = list;
        this.selectedChannelId = j;
        this.prevSelectedChannelId = j2;
        this.selectedVoiceChannelId = j3;
        this.mostRecent = map;
        this.mentionCounts = map2;
        this.frecencyChannels = FrecencyTracker.getSortedKeys$default(StoreStream.Companion.getChannelsSelected().getFrecency(), 0L, 1, null);
        Character chFirstOrNull = y.firstOrNull(str);
        if (chFirstOrNull != null && chFirstOrNull.charValue() == '@') {
            i = 1;
        } else if (chFirstOrNull != null && chFirstOrNull.charValue() == '#') {
            i = 2;
        } else if (chFirstOrNull != null && chFirstOrNull.charValue() == '!') {
            i = 4;
        } else {
            i = (chFirstOrNull != null && chFirstOrNull.charValue() == '*') ? 3 : 0;
        }
        this.searchType = i;
        if (i != 0) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            strSubstring = str.substring(1);
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        } else {
            strSubstring = str;
        }
        this.sanitizedFilter = strSubstring;
        this.hasDiscriminator = (i == 0 || i == 1) ? WidgetGlobalSearchModel.access$getDISCRIMINATOR_PATTERN$cp().matcher(str).find() : false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalSearchModel$SearchContext copy$default(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext, String str, List list, long j, long j2, long j3, Map map, Map map2, int i, Object obj) {
        return widgetGlobalSearchModel$SearchContext.copy((i & 1) != 0 ? widgetGlobalSearchModel$SearchContext.filter : str, (i & 2) != 0 ? widgetGlobalSearchModel$SearchContext.recentGuildIds : list, (i & 4) != 0 ? widgetGlobalSearchModel$SearchContext.selectedChannelId : j, (i & 8) != 0 ? widgetGlobalSearchModel$SearchContext.prevSelectedChannelId : j2, (i & 16) != 0 ? widgetGlobalSearchModel$SearchContext.selectedVoiceChannelId : j3, (i & 32) != 0 ? widgetGlobalSearchModel$SearchContext.mostRecent : map, (i & 64) != 0 ? widgetGlobalSearchModel$SearchContext.mentionCounts : map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFilter() {
        return this.filter;
    }

    public final List<Long> component2() {
        return this.recentGuildIds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSelectedChannelId() {
        return this.selectedChannelId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getPrevSelectedChannelId() {
        return this.prevSelectedChannelId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    public final Map<Long, Long> component6() {
        return this.mostRecent;
    }

    public final Map<Long, Integer> component7() {
        return this.mentionCounts;
    }

    public final WidgetGlobalSearchModel$SearchContext copy(String filter, List<Long> recentGuildIds, long selectedChannelId, long prevSelectedChannelId, long selectedVoiceChannelId, Map<Long, Long> mostRecent, Map<Long, Integer> mentionCounts) {
        m.checkNotNullParameter(filter, "filter");
        m.checkNotNullParameter(recentGuildIds, "recentGuildIds");
        m.checkNotNullParameter(mostRecent, "mostRecent");
        m.checkNotNullParameter(mentionCounts, "mentionCounts");
        return new WidgetGlobalSearchModel$SearchContext(filter, recentGuildIds, selectedChannelId, prevSelectedChannelId, selectedVoiceChannelId, mostRecent, mentionCounts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchModel$SearchContext)) {
            return false;
        }
        WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext = (WidgetGlobalSearchModel$SearchContext) other;
        return m.areEqual(this.filter, widgetGlobalSearchModel$SearchContext.filter) && m.areEqual(this.recentGuildIds, widgetGlobalSearchModel$SearchContext.recentGuildIds) && this.selectedChannelId == widgetGlobalSearchModel$SearchContext.selectedChannelId && this.prevSelectedChannelId == widgetGlobalSearchModel$SearchContext.prevSelectedChannelId && this.selectedVoiceChannelId == widgetGlobalSearchModel$SearchContext.selectedVoiceChannelId && m.areEqual(this.mostRecent, widgetGlobalSearchModel$SearchContext.mostRecent) && m.areEqual(this.mentionCounts, widgetGlobalSearchModel$SearchContext.mentionCounts);
    }

    public final String getFilter() {
        return this.filter;
    }

    public final Collection<Long> getFrecencyChannels() {
        return this.frecencyChannels;
    }

    public final boolean getHasDiscriminator() {
        return this.hasDiscriminator;
    }

    public final Map<Long, Integer> getMentionCounts() {
        return this.mentionCounts;
    }

    public final Map<Long, Long> getMostRecent() {
        return this.mostRecent;
    }

    public final long getPrevSelectedChannelId() {
        return this.prevSelectedChannelId;
    }

    public final List<Long> getRecentGuildIds() {
        return this.recentGuildIds;
    }

    public final String getSanitizedFilter() {
        return this.sanitizedFilter;
    }

    public final int getSearchType() {
        return this.searchType;
    }

    public final long getSelectedChannelId() {
        return this.selectedChannelId;
    }

    public final long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    public int hashCode() {
        String str = this.filter;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Long> list = this.recentGuildIds;
        int iA = (b.a(this.selectedVoiceChannelId) + ((b.a(this.prevSelectedChannelId) + ((b.a(this.selectedChannelId) + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31)) * 31)) * 31)) * 31;
        Map<Long, Long> map = this.mostRecent;
        int iHashCode2 = (iA + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, Integer> map2 = this.mentionCounts;
        return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SearchContext(filter=");
        sbU.append(this.filter);
        sbU.append(", recentGuildIds=");
        sbU.append(this.recentGuildIds);
        sbU.append(", selectedChannelId=");
        sbU.append(this.selectedChannelId);
        sbU.append(", prevSelectedChannelId=");
        sbU.append(this.prevSelectedChannelId);
        sbU.append(", selectedVoiceChannelId=");
        sbU.append(this.selectedVoiceChannelId);
        sbU.append(", mostRecent=");
        sbU.append(this.mostRecent);
        sbU.append(", mentionCounts=");
        return a.M(sbU, this.mentionCounts, ")");
    }
}
