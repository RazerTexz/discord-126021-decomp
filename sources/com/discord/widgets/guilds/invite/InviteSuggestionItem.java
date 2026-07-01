package com.discord.widgets.guilds.invite;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InviteSuggestionItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InviteSuggestionItem implements MGRecyclerDataPayload {

    /* JADX INFO: renamed from: SearchNoResultsItem, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String key = "SEARCH_NO_RESULTS";
    private final int type;

    /* JADX INFO: compiled from: InviteSuggestionItem.kt */
    public static final /* data */ class ChannelItem extends InviteSuggestionItem {
        private final Channel channel;
        private final boolean hasSent;
        private final String key;
        private final int type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelItem(Channel channel, boolean z2) {
            super(null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.hasSent = z2;
            this.type = 1;
            StringBuilder sbU = outline.U("c");
            sbU.append(String.valueOf(channel.getId()));
            this.key = sbU.toString();
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            if ((i & 2) != 0) {
                z2 = channelItem.hasSent;
            }
            return channelItem.copy(channel, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHasSent() {
            return this.hasSent;
        }

        public final ChannelItem copy(Channel channel, boolean hasSent) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ChannelItem(channel, hasSent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelItem)) {
                return false;
            }
            ChannelItem channelItem = (ChannelItem) other;
            return Intrinsics3.areEqual(this.channel, channelItem.channel) && this.hasSent == channelItem.hasSent;
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

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
        public boolean hasSentInvite() {
            return this.hasSent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.hasSent;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(", hasSent=");
            return outline.O(sbU, this.hasSent, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteSuggestionItem$SearchNoResultsItem, reason: from kotlin metadata */
    /* JADX INFO: compiled from: InviteSuggestionItem.kt */
    public static final class Companion extends InviteSuggestionItem {
        private Companion() {
            super(null);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return InviteSuggestionItem.key;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
        public boolean hasSentInvite() {
            return true;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: InviteSuggestionItem.kt */
    public static final /* data */ class UserItem extends InviteSuggestionItem {
        private final boolean hasSent;
        private final String key;
        private final int type;
        private final User user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserItem(User user, boolean z2) {
            super(null);
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
            this.hasSent = z2;
            StringBuilder sbU = outline.U("u");
            sbU.append(String.valueOf(user.getId()));
            this.key = sbU.toString();
        }

        public static /* synthetic */ UserItem copy$default(UserItem userItem, User user, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = userItem.user;
            }
            if ((i & 2) != 0) {
                z2 = userItem.hasSent;
            }
            return userItem.copy(user, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHasSent() {
            return this.hasSent;
        }

        public final UserItem copy(User user, boolean hasSent) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new UserItem(user, hasSent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserItem)) {
                return false;
            }
            UserItem userItem = (UserItem) other;
            return Intrinsics3.areEqual(this.user, userItem.user) && this.hasSent == userItem.hasSent;
        }

        public final boolean getHasSent() {
            return this.hasSent;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
        public boolean hasSentInvite() {
            return this.hasSent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            boolean z2 = this.hasSent;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("UserItem(user=");
            sbU.append(this.user);
            sbU.append(", hasSent=");
            return outline.O(sbU, this.hasSent, ")");
        }
    }

    private InviteSuggestionItem() {
        this.type = -1;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public abstract boolean hasSentInvite();

    public /* synthetic */ InviteSuggestionItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
