package com.discord.widgets.guilds.invite;

import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InviteSuggestionItemV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InviteSuggestionItemV2 implements MGRecyclerDataPayload {
    public static final int TYPE_CHANNEL = 3;
    public static final int TYPE_EMPTY_SEARCH_RESULTS = 1;
    public static final int TYPE_USER = 2;

    /* JADX INFO: compiled from: InviteSuggestionItemV2.kt */
    public static final /* data */ class ChannelItem extends InviteSuggestionItemV2 {
        private final Channel channel;
        private final boolean hasSent;
        private final String key;
        private final String searchQuery;
        private final int type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelItem(Channel channel, boolean z2, String str) {
            super(null);
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(str, "searchQuery");
            this.channel = channel;
            this.hasSent = z2;
            this.searchQuery = str;
            this.type = 3;
            StringBuilder sbM833U = C1643a.m833U("c");
            sbM833U.append(String.valueOf(channel.getId()));
            sbM833U.append(str);
            this.key = sbM833U.toString();
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, boolean z2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            if ((i & 2) != 0) {
                z2 = channelItem.hasSent;
            }
            if ((i & 4) != 0) {
                str = channelItem.searchQuery;
            }
            return channelItem.copy(channel, z2, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHasSent() {
            return this.hasSent;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSearchQuery() {
            return this.searchQuery;
        }

        public final ChannelItem copy(Channel channel, boolean hasSent, String searchQuery) {
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(searchQuery, "searchQuery");
            return new ChannelItem(channel, hasSent, searchQuery);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelItem)) {
                return false;
            }
            ChannelItem channelItem = (ChannelItem) other;
            return C12238m.areEqual(this.channel, channelItem.channel) && this.hasSent == channelItem.hasSent && C12238m.areEqual(this.searchQuery, channelItem.searchQuery);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final boolean getHasSent() {
            return this.hasSent;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getSearchQuery() {
            return this.searchQuery;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItemV2
        public boolean hasSentInvite() {
            return this.hasSent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.hasSent;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            String str = this.searchQuery;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ChannelItem(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", hasSent=");
            sbM833U.append(this.hasSent);
            sbM833U.append(", searchQuery=");
            return C1643a.m822J(sbM833U, this.searchQuery, ")");
        }
    }

    /* JADX INFO: compiled from: InviteSuggestionItemV2.kt */
    public static final class SearchNoResultsItem extends InviteSuggestionItemV2 {
        public static final SearchNoResultsItem INSTANCE = new SearchNoResultsItem();
        private static final int type = 1;
        private static final String key = "SEARCH_NO_RESULTS";

        private SearchNoResultsItem() {
            super(null);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return type;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItemV2
        public boolean hasSentInvite() {
            return true;
        }
    }

    /* JADX INFO: compiled from: InviteSuggestionItemV2.kt */
    public static final /* data */ class UserItem extends InviteSuggestionItemV2 {
        private final boolean hasSent;
        private final String key;
        private final String searchQuery;
        private final int type;
        private final User user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserItem(User user, boolean z2, String str) {
            super(null);
            C12238m.checkNotNullParameter(user, "user");
            C12238m.checkNotNullParameter(str, "searchQuery");
            this.user = user;
            this.hasSent = z2;
            this.searchQuery = str;
            this.type = 2;
            StringBuilder sbM833U = C1643a.m833U("u");
            sbM833U.append(String.valueOf(user.getId()));
            sbM833U.append(str);
            this.key = sbM833U.toString();
        }

        public static /* synthetic */ UserItem copy$default(UserItem userItem, User user, boolean z2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                user = userItem.user;
            }
            if ((i & 2) != 0) {
                z2 = userItem.hasSent;
            }
            if ((i & 4) != 0) {
                str = userItem.searchQuery;
            }
            return userItem.copy(user, z2, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHasSent() {
            return this.hasSent;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSearchQuery() {
            return this.searchQuery;
        }

        public final UserItem copy(User user, boolean hasSent, String searchQuery) {
            C12238m.checkNotNullParameter(user, "user");
            C12238m.checkNotNullParameter(searchQuery, "searchQuery");
            return new UserItem(user, hasSent, searchQuery);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserItem)) {
                return false;
            }
            UserItem userItem = (UserItem) other;
            return C12238m.areEqual(this.user, userItem.user) && this.hasSent == userItem.hasSent && C12238m.areEqual(this.searchQuery, userItem.searchQuery);
        }

        public final boolean getHasSent() {
            return this.hasSent;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getSearchQuery() {
            return this.searchQuery;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItemV2
        public boolean hasSentInvite() {
            return this.hasSent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            boolean z2 = this.hasSent;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            String str = this.searchQuery;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UserItem(user=");
            sbM833U.append(this.user);
            sbM833U.append(", hasSent=");
            sbM833U.append(this.hasSent);
            sbM833U.append(", searchQuery=");
            return C1643a.m822J(sbM833U, this.searchQuery, ")");
        }
    }

    private InviteSuggestionItemV2() {
    }

    public abstract boolean hasSentInvite();

    public /* synthetic */ InviteSuggestionItemV2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
