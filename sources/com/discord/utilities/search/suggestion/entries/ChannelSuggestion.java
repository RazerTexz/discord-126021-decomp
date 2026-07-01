package com.discord.utilities.search.suggestion.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import d0.g0.Strings4;
import d0.g0._Strings;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
            Intrinsics3.checkNotNullParameter(channelName, "channelName");
            Intrinsics3.checkNotNullParameter(currentInput, "currentInput");
            if ((currentInput.length() > 0) && currentInput.charAt(0) == '#') {
                currentInput = _Strings.drop(currentInput, 1);
            }
            return Strings4.contains((CharSequence) channelName, currentInput, true);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChannelSuggestion(String str, long j) {
        Intrinsics3.checkNotNullParameter(str, "channelName");
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
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
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
        return Intrinsics3.areEqual(this.channelName, channelSuggestion.channelName) && this.channelId == channelSuggestion.channelId;
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
        return b.a(this.channelId) + ((str != null ? str.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelSuggestion(channelName=");
        sbU.append(this.channelName);
        sbU.append(", channelId=");
        return outline.C(sbU, this.channelId, ")");
    }
}
