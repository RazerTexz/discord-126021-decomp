package com.discord.widgets.chat.managereactions;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.databinding.WidgetManageReactionsResultErrorBinding;
import com.discord.databinding.WidgetManageReactionsResultUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsResultsAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    private static final int VIEW_TYPE_ERROR = 2;
    private static final int VIEW_TYPE_LOADING = 1;
    private static final int VIEW_TYPE_USER = 0;

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final class ErrorItem implements MGRecyclerDataPayload {
        private final long channelId;
        private final MessageReactionEmoji emoji;
        private final String key;
        private final long messageId;
        private final int type;

        public ErrorItem(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
            C12238m.checkNotNullParameter(messageReactionEmoji, "emoji");
            this.channelId = j;
            this.messageId = j2;
            this.emoji = messageReactionEmoji;
            this.type = 2;
            this.key = String.valueOf(getType());
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final MessageReactionEmoji getEmoji() {
            return this.emoji;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final class ErrorViewHolder extends MGRecyclerViewHolder<ManageReactionsResultsAdapter, MGRecyclerDataPayload> {
        private final WidgetManageReactionsResultErrorBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorViewHolder(ManageReactionsResultsAdapter manageReactionsResultsAdapter) {
            super(C5419R.layout.widget_manage_reactions_result_error, manageReactionsResultsAdapter);
            C12238m.checkNotNullParameter(manageReactionsResultsAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.manage_reactions_result_error_img;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.manage_reactions_result_error_img);
            if (imageView != null) {
                i = C5419R.id.manage_reactions_result_error_text;
                TextView textView = (TextView) view.findViewById(C5419R.id.manage_reactions_result_error_text);
                if (textView != null) {
                    WidgetManageReactionsResultErrorBinding widgetManageReactionsResultErrorBinding = new WidgetManageReactionsResultErrorBinding((RelativeLayout) view, imageView, textView);
                    C12238m.checkNotNullExpressionValue(widgetManageReactionsResultErrorBinding, "WidgetManageReactionsRes…rorBinding.bind(itemView)");
                    this.binding = widgetManageReactionsResultErrorBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final MGRecyclerDataPayload data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.binding.f17223b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter$ErrorViewHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MGRecyclerDataPayload mGRecyclerDataPayload = data;
                    Objects.requireNonNull(mGRecyclerDataPayload, "null cannot be cast to non-null type com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter.ErrorItem");
                    ManageReactionsResultsAdapter.ErrorItem errorItem = (ManageReactionsResultsAdapter.ErrorItem) mGRecyclerDataPayload;
                    StoreStream.INSTANCE.getMessageReactions().forceRetryFetchReactions(errorItem.getChannelId(), errorItem.getMessageId(), errorItem.getEmoji());
                }
            });
        }
    }

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final class LoadingItem implements MGRecyclerDataPayload {
        private final int type = 1;
        private final String key = String.valueOf(getType());

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final class LoadingViewHolder extends MGRecyclerViewHolder<ManageReactionsResultsAdapter, MGRecyclerDataPayload> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingViewHolder(ManageReactionsResultsAdapter manageReactionsResultsAdapter) {
            super(C5419R.layout.widget_manage_reactions_result_loading, manageReactionsResultsAdapter);
            C12238m.checkNotNullParameter(manageReactionsResultsAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final /* data */ class ReactionUserItem implements MGRecyclerDataPayload {
        private final boolean canDelete;
        private final long channelId;
        private final MessageReactionEmoji emoji;
        private final GuildMember guildMember;
        private final String key;
        private final long messageId;
        private final int type;
        private final User user;

        public ReactionUserItem(User user, long j, long j2, MessageReactionEmoji messageReactionEmoji, boolean z2, GuildMember guildMember) {
            C12238m.checkNotNullParameter(user, "user");
            C12238m.checkNotNullParameter(messageReactionEmoji, "emoji");
            this.user = user;
            this.channelId = j;
            this.messageId = j2;
            this.emoji = messageReactionEmoji;
            this.canDelete = z2;
            this.guildMember = guildMember;
            this.key = String.valueOf(user.getId());
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final MessageReactionEmoji getEmoji() {
            return this.emoji;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final ReactionUserItem copy(User user, long channelId, long messageId, MessageReactionEmoji emoji, boolean canDelete, GuildMember guildMember) {
            C12238m.checkNotNullParameter(user, "user");
            C12238m.checkNotNullParameter(emoji, "emoji");
            return new ReactionUserItem(user, channelId, messageId, emoji, canDelete, guildMember);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReactionUserItem)) {
                return false;
            }
            ReactionUserItem reactionUserItem = (ReactionUserItem) other;
            return C12238m.areEqual(this.user, reactionUserItem.user) && this.channelId == reactionUserItem.channelId && this.messageId == reactionUserItem.messageId && C12238m.areEqual(this.emoji, reactionUserItem.emoji) && this.canDelete == reactionUserItem.canDelete && C12238m.areEqual(this.guildMember, reactionUserItem.guildMember);
        }

        public final boolean getCanDelete() {
            return this.canDelete;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final MessageReactionEmoji getEmoji() {
            return this.emoji;
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v8, types: [int] */
        public int hashCode() {
            User user = this.user;
            int iM3a = (C0002b.m3a(this.messageId) + ((C0002b.m3a(this.channelId) + ((user != null ? user.hashCode() : 0) * 31)) * 31)) * 31;
            MessageReactionEmoji messageReactionEmoji = this.emoji;
            int iHashCode = (iM3a + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0)) * 31;
            boolean z2 = this.canDelete;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            GuildMember guildMember = this.guildMember;
            return i + (guildMember != null ? guildMember.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ReactionUserItem(user=");
            sbM833U.append(this.user);
            sbM833U.append(", channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", messageId=");
            sbM833U.append(this.messageId);
            sbM833U.append(", emoji=");
            sbM833U.append(this.emoji);
            sbM833U.append(", canDelete=");
            sbM833U.append(this.canDelete);
            sbM833U.append(", guildMember=");
            sbM833U.append(this.guildMember);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
    public static final class ReactionUserViewHolder extends MGRecyclerViewHolder<ManageReactionsResultsAdapter, MGRecyclerDataPayload> {
        private final WidgetManageReactionsResultUserBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReactionUserViewHolder(ManageReactionsResultsAdapter manageReactionsResultsAdapter) {
            super(C5419R.layout.widget_manage_reactions_result_user, manageReactionsResultsAdapter);
            C12238m.checkNotNullParameter(manageReactionsResultsAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.manage_reactions_result_remove_reaction;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.manage_reactions_result_remove_reaction);
            if (imageView != null) {
                i = C5419R.id.manage_reactions_result_user_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.manage_reactions_result_user_avatar);
                if (simpleDraweeView != null) {
                    i = C5419R.id.manage_reactions_result_user_name;
                    TextView textView = (TextView) view.findViewById(C5419R.id.manage_reactions_result_user_name);
                    if (textView != null) {
                        WidgetManageReactionsResultUserBinding widgetManageReactionsResultUserBinding = new WidgetManageReactionsResultUserBinding((RelativeLayout) view, imageView, simpleDraweeView, textView);
                        C12238m.checkNotNullExpressionValue(widgetManageReactionsResultUserBinding, "WidgetManageReactionsRes…serBinding.bind(itemView)");
                        this.binding = widgetManageReactionsResultUserBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final MGRecyclerDataPayload data) {
            String username;
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data instanceof ReactionUserItem) {
                TextView textView = this.binding.f17227d;
                C12238m.checkNotNullExpressionValue(textView, "binding.manageReactionsResultUserName");
                ReactionUserItem reactionUserItem = (ReactionUserItem) data;
                GuildMember guildMember = reactionUserItem.getGuildMember();
                if (guildMember == null || (username = guildMember.getNick()) == null) {
                    username = reactionUserItem.getUser().getUsername();
                }
                textView.setText(username);
                SimpleDraweeView simpleDraweeView = this.binding.f17226c;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.manageReactionsResultUserAvatar");
                IconUtils.setIcon$default(simpleDraweeView, reactionUserItem.getUser(), C5419R.dimen.avatar_size_standard, null, null, reactionUserItem.getGuildMember(), 24, null);
                ImageView imageView = this.binding.f17225b;
                C12238m.checkNotNullExpressionValue(imageView, "binding.manageReactionsResultRemoveReaction");
                imageView.setVisibility(reactionUserItem.getCanDelete() ? 0 : 8);
                this.binding.f17225b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter$ReactionUserViewHolder$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StoreStream.INSTANCE.getMessageReactions().deleteEmoji(((ManageReactionsResultsAdapter.ReactionUserItem) data).getChannelId(), ((ManageReactionsResultsAdapter.ReactionUserItem) data).getMessageId(), ((ManageReactionsResultsAdapter.ReactionUserItem) data).getEmoji(), ((ManageReactionsResultsAdapter.ReactionUserItem) data).getUser().getId());
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsResultsAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<ManageReactionsResultsAdapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new ReactionUserViewHolder(this);
        }
        if (viewType == 1) {
            return new LoadingViewHolder(this);
        }
        if (viewType == 2) {
            return new ErrorViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
