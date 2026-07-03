package com.discord.utilities.search.suggestion.entries;

import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p579g0.C12108y;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelSuggestion implements SearchSuggestion {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SearchSuggestion.Category category;
    private final long channelId;
    private final String channelName;

    /* JADX INFO: compiled from: ChannelSuggestion.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean canComplete(String channelName, CharSequence currentInput) {
            C12238m.checkNotNullParameter(channelName, "channelName");
            C12238m.checkNotNullParameter(currentInput, "currentInput");
            if ((currentInput.length() > 0) && currentInput.charAt(0) == '#') {
                currentInput = C12108y.drop(currentInput, 1);
            }
            return C12106w.contains((CharSequence) channelName, currentInput, true);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChannelSuggestion(String str, long j) {
        C12238m.checkNotNullParameter(str, "channelName");
        this.channelName = str;
        this.channelId = j;
        this.category = SearchSuggestion.Category.IN_CHANNEL;
    }

    public static /* synthetic */ ChannelSuggestion copy$default(ChannelSuggestion channelSuggestion, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelSuggestion.channelName;
        }
        if ((i & 2) != 0) {
            j = channelSuggestion.channelId;
        }
        return channelSuggestion.copy(str, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final ChannelSuggestion copy(String channelName, long channelId) {
        C12238m.checkNotNullParameter(channelName, "channelName");
        return new ChannelSuggestion(channelName, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelSuggestion)) {
            return false;
        }
        ChannelSuggestion channelSuggestion = (ChannelSuggestion) other;
        return C12238m.areEqual(this.channelName, channelSuggestion.channelName) && this.channelId == channelSuggestion.channelId;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
        return this.category;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public int hashCode() {
        String str = this.channelName;
        return C0002b.m3a(this.channelId) + ((str != null ? str.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ChannelSuggestion(channelName=");
        sbM833U.append(this.channelName);
        sbM833U.append(", channelId=");
        return C1643a.m815C(sbM833U, this.channelId, ")");
    }
}
