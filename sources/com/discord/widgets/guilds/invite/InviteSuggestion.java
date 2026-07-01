package com.discord.widgets.guilds.invite;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InviteSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InviteSuggestion {

    /* JADX INFO: compiled from: InviteSuggestion.kt */
    public static final /* data */ class ChannelItem extends InviteSuggestion {
        private final Channel channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelItem(Channel channel) {
            super(null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            return channelItem.copy(channel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final ChannelItem copy(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ChannelItem(channel);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ChannelItem) && Intrinsics3.areEqual(this.channel, ((ChannelItem) other).channel);
            }
            return true;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public int hashCode() {
            Channel channel = this.channel;
            if (channel != null) {
                return channel.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: InviteSuggestion.kt */
    public static final /* data */ class UserSuggestion extends InviteSuggestion {
        private final User user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserSuggestion(User user) {
            super(null);
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
        }

        public static /* synthetic */ UserSuggestion copy$default(UserSuggestion userSuggestion, User user, int i, Object obj) {
            if ((i & 1) != 0) {
                user = userSuggestion.user;
            }
            return userSuggestion.copy(user);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final UserSuggestion copy(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new UserSuggestion(user);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UserSuggestion) && Intrinsics3.areEqual(this.user, ((UserSuggestion) other).user);
            }
            return true;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            User user = this.user;
            if (user != null) {
                return user.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("UserSuggestion(user=");
            sbU.append(this.user);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private InviteSuggestion() {
    }

    public /* synthetic */ InviteSuggestion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
