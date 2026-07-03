package com.discord.widgets.chat.list.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.LeadingMarginSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.interaction.Interaction;
import com.discord.api.message.LocalAttachment;
import com.discord.api.permission.Permission;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guilds.PublicGuildUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.FailedUploadList;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.chat.list.ChatListItemMessageAccessibilityDelegate;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.discord.widgets.chat.list.utils.EmbeddedMessageParser;
import com.discord.widgets.roles.RoleIconView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage extends WidgetChatListItem {
    private static final int MAX_REPLY_AST_NODES = 50;
    private final View backgroundHighlight;
    private final ImageView communicationDisabledIcon;
    private final FailedUploadList failedUploadList;
    private final View gutterHighlight;
    private final TextView itemAlertText;
    private final ImageView itemAvatar;
    private final TextView itemLoadingText;
    private final TextView itemName;
    private final RoleIconView itemRoleIcon;
    private final TextView itemTag;
    private final SimpleDraweeSpanTextView itemText;
    private final TextView itemTimestamp;
    private final TypingDots loadingDots;
    private final ImageView replyAvatar;
    private final View replyHolder;
    private final ImageView replyIcon;
    private final View replyLeadingViewsHolder;
    private final View replyLinkItem;
    private final TextView replyName;
    private final SimpleDraweeSpanTextView replyText;
    private final ImageView sendError;
    private final ImageView threadEmbedSpine;
    private final View threadStarterMessageHeader;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$getMessageRenderContext$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
    public static final class C81011 extends AbstractC12240o implements Function3<Context, String, String, Unit> {
        public static final C81011 INSTANCE = new C81011();

        public C81011() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
            invoke2(context, str, str2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str, String str2) {
            C12238m.checkNotNullParameter(context, "clickContext");
            C12238m.checkNotNullParameter(str, "url");
            UriHandler.handleOrUntrusted(context, str, str2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$getMessageRenderContext$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
    public static final class C81022 extends AbstractC12240o implements Function1<String, Unit> {
        public C81022() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "url");
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onUrlLongClicked(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$getMessageRenderContext$3 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
    public static final class C81033 extends AbstractC12240o implements Function1<Long, Unit> {
        public C81033() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetChatListAdapter.Data data = WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData();
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onUserMentionClicked(j, data.getChannelId(), data.getGuildId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$getMessageRenderContext$4 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
    public static final class C81044 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81044(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(this.$context, j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$getSpoilerClickHandler$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
    public static final class C81051 extends AbstractC12240o implements Function1<SpoilerNode<?>, Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81051(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            C12238m.checkNotNullParameter(spoilerNode, "spoilerNode");
            StoreStream.INSTANCE.getMessageState().revealSpoiler(this.$message.getId(), spoilerNode.getId());
            WidgetChatListAdapterItemMessage.this.itemView.sendAccessibilityEvent(16);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$onConfigure$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
    public static final class C81072 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81072(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageAuthorLongClicked(this.$message, Long.valueOf(WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData().getGuildId()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$onConfigure$4 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
    public static final class C81094 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ boolean $isThreadStarterMessage;
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81094(Message message, boolean z2) {
            super(1);
            this.$message = message;
            this.$isThreadStarterMessage = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageLongClicked(this.$message, WidgetChatListAdapterItemMessage.this.itemText.getText().subSequence(0, Math.max(WidgetChatListAdapterItemMessage.this.itemText.getText().length() - 1, 0)), this.$isThreadStarterMessage);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$onConfigure$6 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
    public static final class C81116 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81116(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageAuthorLongClicked(this.$message, Long.valueOf(WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData().getGuildId()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessage(@LayoutRes int i, WidgetChatListAdapter widgetChatListAdapter) {
        super(i, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View viewFindViewById = this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text);
        C12238m.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.…t_list_adapter_item_text)");
        this.itemText = (SimpleDraweeSpanTextView) viewFindViewById;
        this.itemAvatar = (ImageView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_avatar);
        this.itemName = (TextView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_name);
        this.itemRoleIcon = (RoleIconView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_role_icon);
        this.itemTag = (TextView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_tag);
        this.replyHolder = this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_decorator);
        this.replyLinkItem = this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_decorator_reply_link_icon);
        this.replyLeadingViewsHolder = this.itemView.findViewById(C5419R.id.chat_list_adapter_item_reply_leading_views);
        this.replyName = (TextView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_decorator_reply_name);
        this.replyIcon = (ImageView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_decorator_reply_icon);
        this.replyAvatar = (ImageView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_decorator_avatar);
        this.replyText = (SimpleDraweeSpanTextView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_reply_content);
        this.itemTimestamp = (TextView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_timestamp);
        this.failedUploadList = (FailedUploadList) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_failed_upload_list);
        this.itemAlertText = (TextView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_alert_text);
        this.itemLoadingText = (TextView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_loading);
        this.backgroundHighlight = this.itemView.findViewById(C5419R.id.chat_list_adapter_item_highlighted_bg);
        this.gutterHighlight = this.itemView.findViewById(C5419R.id.chat_list_adapter_item_gutter_bg);
        this.loadingDots = (TypingDots) this.itemView.findViewById(C5419R.id.chat_overlay_typing_dots);
        this.sendError = (ImageView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_text_error);
        this.threadEmbedSpine = (ImageView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_thread_embed_spine);
        this.threadStarterMessageHeader = this.itemView.findViewById(C5419R.id.thread_starter_message_header);
        this.communicationDisabledIcon = (ImageView) this.itemView.findViewById(C5419R.id.chat_list_adapter_item_communication_disabled_icon);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemMessage.adapter;
    }

    private final void configureCommunicationDisabled(GuildMember guildMember, Long permissionsForChannel) {
        boolean z2 = false;
        boolean zIsCommunicationDisabled = guildMember != null ? guildMember.isCommunicationDisabled() : false;
        boolean z3 = PermissionUtils.can(Permission.MODERATE_MEMBERS, permissionsForChannel) || PermissionUtils.can(8L, permissionsForChannel);
        if (zIsCommunicationDisabled && z3) {
            z2 = true;
        }
        ImageView imageView = this.communicationDisabledIcon;
        if (imageView != null) {
            ViewKt.setVisible(imageView, z2);
        }
        ImageView imageView2 = this.itemAvatar;
        if (imageView2 != null) {
            imageView2.setAlpha(z2 ? 0.5f : 1.0f);
        }
    }

    private final TextView configureInteractionMessage(MessageEntry messageEntry) {
        int themedColor;
        Message message = messageEntry.getMessage();
        boolean zShouldShowInteractionMessage = shouldShowInteractionMessage(message);
        TypingDots typingDots = this.loadingDots;
        if (typingDots != null) {
            ViewKt.setVisible(typingDots, zShouldShowInteractionMessage);
        }
        if (zShouldShowInteractionMessage) {
            TypingDots typingDots2 = this.loadingDots;
            if (typingDots2 != null) {
                int i = TypingDots.f19342j;
                typingDots2.m8619a(false);
            }
        } else {
            TypingDots typingDots3 = this.loadingDots;
            if (typingDots3 != null) {
                typingDots3.m8620c();
            }
        }
        TextView textView = this.itemLoadingText;
        if (textView != null) {
            ViewKt.setVisible(textView, zShouldShowInteractionMessage);
        }
        this.itemText.setVisibility(zShouldShowInteractionMessage ^ true ? 0 : 8);
        ImageView imageView = this.sendError;
        if (imageView != null) {
            ViewKt.setVisible(imageView, false);
        }
        if (!zShouldShowInteractionMessage) {
            return this.itemText;
        }
        TextView textView2 = this.itemTag;
        if (textView2 != null) {
            ViewKt.setVisible(textView2, true);
        }
        if (message.isFailed()) {
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            themedColor = ColorCompat.getThemedColor(view, C5419R.attr.colorError);
        } else {
            View view2 = this.itemView;
            C12238m.checkNotNullExpressionValue(view2, "itemView");
            themedColor = ColorCompat.getThemedColor(view2, C5419R.attr.colorTextMuted);
        }
        TextView textView3 = this.itemLoadingText;
        if (textView3 != null) {
            textView3.setTextColor(themedColor);
        }
        if (message.isLocalApplicationCommand() && message.isLoading()) {
            TextView textView4 = this.itemLoadingText;
            if (textView4 != null) {
                Context context = this.itemText.getContext();
                C12238m.checkNotNullExpressionValue(context, "itemText.context");
                Object[] objArr = new Object[1];
                Map<Long, String> nickOrUsernames = messageEntry.getNickOrUsernames();
                User author = message.getAuthor();
                objArr[0] = nickOrUsernames.get(author != null ? Long.valueOf(author.getId()) : null);
                textView4.setText(C1107b.m210b(context, C5419R.string.application_command_waiting, objArr, (4 & 4) != 0 ? C1107b.b.f1491j : null));
            }
            ImageView imageView2 = this.sendError;
            if (imageView2 != null) {
                ViewKt.setVisible(imageView2, false);
            }
        } else if (message.isLocalApplicationCommand() && message.isFailed()) {
            TextView textView5 = this.itemLoadingText;
            if (textView5 != null) {
                textView5.setText(C5419R.string.application_command_failed);
            }
            ImageView imageView3 = this.sendError;
            if (imageView3 != null) {
                ViewKt.setVisible(imageView3, true);
            }
            TypingDots typingDots4 = this.loadingDots;
            if (typingDots4 != null) {
                ViewKt.setInvisible(typingDots4, true);
            }
            TypingDots typingDots5 = this.loadingDots;
            if (typingDots5 != null) {
                typingDots5.m8620c();
            }
        } else if (message.isLocalApplicationCommand()) {
            TextView textView6 = this.itemLoadingText;
            if (textView6 != null) {
                textView6.setText(C5419R.string.application_command_sending);
            }
            ImageView imageView4 = this.sendError;
            if (imageView4 != null) {
                ViewKt.setVisible(imageView4, false);
            }
        }
        TextView textView7 = this.itemLoadingText;
        return textView7 != null ? textView7 : this.itemText;
    }

    private final void configureItemTag(Message message, boolean isGuildForumPostAuthor) {
        int i;
        if (this.itemTag != null) {
            User author = message.getAuthor();
            C12238m.checkNotNull(author);
            CoreUser coreUser = new CoreUser(author);
            boolean zIsPublicGuildSystemMessage = PublicGuildUtils.INSTANCE.isPublicGuildSystemMessage(message);
            Integer type = message.getType();
            boolean z2 = true;
            boolean z3 = (type == null || type.intValue() != 0 || message.getMessageReference() == null) ? false : true;
            TextView textView = this.itemTag;
            if (!coreUser.getIsBot() && !coreUser.getIsSystemUser() && !zIsPublicGuildSystemMessage && !z3 && !isGuildForumPostAuthor) {
                z2 = false;
            }
            textView.setVisibility(z2 ? 0 : 8);
            TextView textView2 = this.itemTag;
            if (coreUser.getIsSystemUser() || zIsPublicGuildSystemMessage) {
                i = C5419R.string.system_dm_tag_system;
            } else if (z3) {
                i = C5419R.string.bot_tag_server;
            } else {
                i = isGuildForumPostAuthor ? C5419R.string.bot_tag_forum_original_poster : C5419R.string.bot_tag_bot;
            }
            textView2.setText(i);
            this.itemTag.setCompoundDrawablesWithIntrinsicBounds(UserUtils.INSTANCE.isVerifiedBot(coreUser) ? C5419R.drawable.ic_verified_10dp : 0, 0, 0, 0);
        }
    }

    private final void configureReplyAuthor(com.discord.models.user.User replyAuthor, GuildMember replyGuildMember, MessageEntry messageEntry) {
        configureReplyAvatar(replyAuthor, replyGuildMember != null ? replyGuildMember : messageEntry.getAuthor());
        String username = (String) C1643a.m849f(replyAuthor, messageEntry.getNickOrUsernames());
        if (username == null) {
            username = replyAuthor.getUsername();
        }
        boolean z2 = false;
        List<User> mentions = messageEntry.getMessage().getMentions();
        if (mentions != null) {
            Iterator<T> it = mentions.iterator();
            while (it.hasNext()) {
                if (((User) it.next()).getId() == replyAuthor.getId()) {
                    z2 = true;
                }
            }
        }
        configureReplyName(username, getAuthorTextColor(replyGuildMember), z2);
    }

    private final void configureReplyAvatar(com.discord.models.user.User messageAuthor, GuildMember guildMember) {
        ImageView imageView = this.replyIcon;
        if (imageView == null || this.replyAvatar == null) {
            return;
        }
        if (messageAuthor == null) {
            imageView.setVisibility(0);
            this.replyAvatar.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            this.replyAvatar.setVisibility(0);
            IconUtils.setIcon$default(this.replyAvatar, messageAuthor, C5419R.dimen.avatar_size_reply, null, null, guildMember, 24, null);
        }
    }

    private final void configureReplyContentWithResourceId(int stringResourceId) {
        if (this.replyText != null) {
            Context context = this.replyText.getContext();
            C12238m.checkNotNullExpressionValue(context, "replyText.context");
            SpannableString spannableString = new SpannableString(context.getResources().getString(stringResourceId));
            spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            configureReplyText(spannableString, 0.64f);
        }
    }

    private final void configureReplyInteraction(MessageEntry messageEntry) {
        User user;
        final Message message = messageEntry.getMessage();
        Interaction interaction = message.getInteraction();
        if (interaction == null || (user = interaction.getUser()) == null) {
            return;
        }
        GuildMember interactionAuthor = messageEntry.getInteractionAuthor();
        CoreUser coreUser = new CoreUser(user);
        configureReplyAvatar(new CoreUser(user), messageEntry.getAuthor());
        configureReplyAuthor(coreUser, interactionAuthor, messageEntry);
        TextView textView = this.replyName;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage.configureReplyInteraction.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageAuthorAvatarClicked(message, WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData().getGuildId());
                }
            });
        }
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.replyText;
        if (simpleDraweeSpanTextView != null) {
            MovementMethod linkMovementMethod = LinkMovementMethod.getInstance();
            if (linkMovementMethod == null) {
                return;
            } else {
                simpleDraweeSpanTextView.setMovementMethod(linkMovementMethod);
            }
        }
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.replyText;
        CharSequence charSequenceM212d = simpleDraweeSpanTextView2 != null ? C1107b.m212d(simpleDraweeSpanTextView2, C5419R.string.system_message_application_command_reply, new Object[]{interaction.getName()}, new C8099xf0292a2b(this, interaction, message, user)) : null;
        if (charSequenceM212d != null) {
            SpannableString spannableStringValueOf = SpannableString.valueOf(charSequenceM212d);
            C12238m.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
            configureReplyText(spannableStringValueOf, 1.0f);
        }
    }

    private final void configureReplyLayoutDirection() {
        if (this.replyHolder == null || this.replyText == null) {
            return;
        }
        this.replyHolder.setLayoutDirection(BidiFormatter.getInstance().isRtl(this.replyText.getText()) ? 1 : 0);
    }

    @SuppressLint({"SetTextI18n"})
    private final void configureReplyName(String originalAuthorName, int color, boolean didMention) {
        if (this.replyName != null) {
            if (originalAuthorName == null || originalAuthorName.length() == 0) {
                this.replyName.setVisibility(8);
                return;
            }
            String str = didMention ? "@" : "";
            this.replyName.setVisibility(0);
            this.replyName.setText(str + originalAuthorName);
            this.replyName.setTextColor(color);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void configureReplyPreview(MessageEntry messageEntry) {
        Integer type;
        if (this.replyHolder == null || this.replyLinkItem == null) {
            return;
        }
        Message message = messageEntry.getMessage();
        MessageEntry.ReplyData replyData = messageEntry.getReplyData();
        boolean zIsInteraction = message.isInteraction();
        if (!zIsInteraction && (replyData == null || (type = messageEntry.getMessage().getType()) == null || type.intValue() != 19)) {
            this.replyHolder.setVisibility(8);
            this.replyLinkItem.setVisibility(8);
            return;
        }
        this.replyHolder.setVisibility(0);
        this.replyLinkItem.setVisibility(0);
        if (zIsInteraction) {
            configureReplyInteraction(messageEntry);
            return;
        }
        if (replyData == null) {
            return;
        }
        MessageEntry messageEntry2 = replyData.getMessageEntry();
        StoreMessageReplies.MessageState messageState = replyData.getMessageState();
        if (replyData.isRepliedUserBlocked()) {
            configureReplySystemMessage(C5419R.string.reply_quote_message_blocked);
            return;
        }
        if (messageState instanceof StoreMessageReplies.MessageState.Unloaded) {
            configureReplySystemMessage(C5419R.string.reply_quote_message_not_loaded);
            return;
        }
        if (messageState instanceof StoreMessageReplies.MessageState.Deleted) {
            configureReplySystemMessage(C5419R.string.reply_quote_message_deleted);
            return;
        }
        if (!(messageState instanceof StoreMessageReplies.MessageState.Loaded) || messageEntry2 == null) {
            return;
        }
        final Message message2 = messageEntry2.getMessage();
        this.replyHolder.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage.configureReplyPreview.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message2.getChannelId(), message2.getId());
            }
        });
        Integer type2 = message2.getType();
        if (type2 != null && type2.intValue() == 7) {
            configureReplySystemMessageUserJoin(messageEntry2);
            return;
        }
        Integer type3 = message2.getType();
        if (type3 != null && type3.intValue() == 25) {
            configureReplySystemMessageRoleSubscriptionPurchase(messageEntry2);
            return;
        }
        User author = message2.getAuthor();
        C12238m.checkNotNull(author);
        configureReplyAuthor(new CoreUser(author), messageEntry2.getAuthor(), messageEntry2);
        if (this.replyText == null || this.replyLeadingViewsHolder == null) {
            return;
        }
        String content = message2.getContent();
        if (content == null) {
            content = "";
        }
        if (!(content.length() == 0)) {
            Context context = this.replyText.getContext();
            EmbeddedMessageParser embeddedMessageParser = EmbeddedMessageParser.INSTANCE;
            C12238m.checkNotNullExpressionValue(context, "context");
            DraweeSpanStringBuilder draweeSpanStringBuilder = embeddedMessageParser.parse(new EmbeddedMessageParser.ParserData(context, messageEntry2.getRoles(), messageEntry2.getNickOrUsernames(), messageEntry2.getAnimateEmojis(), new StoreMessageState.State(null, null == true ? 1 : 0, 3, null == true ? 1 : 0), 50, message2, (WidgetChatListAdapter) this.adapter));
            draweeSpanStringBuilder.setSpan(getLeadingEdgeSpan(), 0, draweeSpanStringBuilder.length(), 33);
            this.replyText.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
            configureReplyLayoutDirection();
            return;
        }
        if (message2.hasStickers()) {
            configureReplyContentWithResourceId(C5419R.string.reply_quote_sticker_mobile);
            return;
        }
        if (message2.hasAttachments() || message2.shouldShowReplyPreviewAsAttachment() || message2.hasEmbeds()) {
            configureReplyContentWithResourceId(C5419R.string.reply_quote_no_text_content_mobile);
            return;
        }
        Logger.e$default(AppLog.f14950g, "Unhandled reply preview: " + messageEntry2, null, null, 6, null);
    }

    private final void configureReplySystemMessage(int stringResourceId) {
        configureReplyAvatar(null, null);
        configureReplyName("", 0, false);
        configureReplyContentWithResourceId(stringResourceId);
    }

    private final void configureReplySystemMessageRoleSubscriptionPurchase(MessageEntry repliedMessageEntry) {
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.replyText;
        if (simpleDraweeSpanTextView == null) {
            return;
        }
        Context context = simpleDraweeSpanTextView.getContext();
        configureReplyAvatar(null, null);
        configureReplyName("", 0, false);
        MessageUtils messageUtils = MessageUtils.INSTANCE;
        C12238m.checkNotNullExpressionValue(context, "context");
        Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(((WidgetChatListAdapter) this.adapter).getData().getGuildId());
        String name = guild != null ? guild.getName() : null;
        Map<Long, String> nickOrUsernames = repliedMessageEntry.getNickOrUsernames();
        User author = repliedMessageEntry.getMessage().getAuthor();
        configureReplyText(new SpannableString(MessageUtils.getSystemMessageRoleSubscriptionPurchase$default(messageUtils, context, name, nickOrUsernames.get(author != null ? Long.valueOf(author.getId()) : null), repliedMessageEntry.getMessage().getRoleSubscriptionData(), null, 8, null).toString()), 0.64f);
    }

    private final void configureReplySystemMessageUserJoin(MessageEntry repliedMessageEntry) {
        ImageView imageView = this.replyIcon;
        if (imageView == null || this.replyAvatar == null || this.replyText == null) {
            return;
        }
        imageView.setVisibility(8);
        this.replyAvatar.setVisibility(0);
        this.replyAvatar.setImageResource(C5419R.drawable.ic_group_join);
        configureReplyName("", 0, false);
        Context context = this.replyText.getContext();
        Map<Long, String> nickOrUsernames = repliedMessageEntry.getNickOrUsernames();
        User author = repliedMessageEntry.getMessage().getAuthor();
        String str = nickOrUsernames.get(author != null ? Long.valueOf(author.getId()) : null);
        C12238m.checkNotNullExpressionValue(context, "context");
        configureReplyText(new SpannableString(C1107b.m210b(context, MessageUtils.INSTANCE.getSystemMessageUserJoin(context, repliedMessageEntry.getMessage().getId()), new Object[]{str}, (4 & 4) != 0 ? C1107b.b.f1491j : null).toString()), 0.64f);
    }

    private final void configureReplyText(Spannable content, float alpha) {
        if (this.replyText == null || this.replyLeadingViewsHolder == null) {
            return;
        }
        content.setSpan(getLeadingEdgeSpan(), 0, content.length(), 33);
        this.replyText.setAlpha(alpha);
        this.replyText.setText(content);
        configureReplyLayoutDirection();
    }

    public static /* synthetic */ void configureReplyText$default(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage, Spannable spannable, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        widgetChatListAdapterItemMessage.configureReplyText(spannable, f);
    }

    private final void configureThreadSpine(Message message, boolean isThreadStarterMessage) {
        ImageView imageView = this.threadEmbedSpine;
        if (imageView != null) {
            ViewKt.setVisible(imageView, message.hasThread() && !isThreadStarterMessage);
        }
    }

    private final int getAuthorTextColor(GuildMember member) {
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        return GuildMember.INSTANCE.getColor(member, ColorCompat.getThemedColor(view.getContext(), C5419R.attr.colorHeaderPrimary));
    }

    private final LeadingMarginSpan getLeadingEdgeSpan() {
        int measuredWidth;
        View view = this.replyLeadingViewsHolder;
        if (view != null) {
            view.measure(0, 0);
            measuredWidth = this.replyLeadingViewsHolder.getMeasuredWidth();
        } else {
            measuredWidth = 0;
        }
        return new LeadingMarginSpan.Standard(measuredWidth, 0);
    }

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState.State messageState) {
        StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, true, (Integer) null);
    }

    private final MessageRenderContext getMessageRenderContext(Context context, MessageEntry messageEntry, Function1<? super SpoilerNode<?>, Unit> spoilerClickHandler) {
        return new MessageRenderContext(context, ((WidgetChatListAdapter) this.adapter).getData().getUserId(), messageEntry.getAnimateEmojis(), messageEntry.getNickOrUsernames(), ((WidgetChatListAdapter) this.adapter).getData().getChannelNames(), messageEntry.getRoles(), C5419R.attr.colorTextLink, C81011.INSTANCE, new C81022(), ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_spoiler_bg), ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_spoiler_bg_visible), spoilerClickHandler, new C81033(), new C81044(context));
    }

    private final Function1<SpoilerNode<?>, Unit> getSpoilerClickHandler(Message message) {
        if (((WidgetChatListAdapter) this.adapter).getData().getIsSpoilerClickAllowed()) {
            return new C81051(message);
        }
        return null;
    }

    private final void processMessageText(SimpleDraweeSpanTextView textView, MessageEntry messageEntry) {
        String content;
        DiscordParser.ParserOptions parserOptions;
        Integer type;
        Context context = textView.getContext();
        Message message = messageEntry.getMessage();
        boolean zIsWebhook = message.isWebhook();
        UtcDateTime editedTimestamp = message.getEditedTimestamp();
        boolean z2 = (editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) > 0;
        if (message.isSourceDeleted()) {
            C12238m.checkNotNullExpressionValue(context, "context");
            content = context.getResources().getString(C5419R.string.source_message_deleted);
        } else {
            content = message.getContent();
            if (content == null) {
                content = "";
            }
        }
        C12238m.checkNotNullExpressionValue(content, "if (message.isSourceDele…ssage.content ?: \"\"\n    }");
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(((WidgetChatListAdapter) this.adapter).getData().getUserId(), message, messageEntry.getMessageState());
        C12238m.checkNotNullExpressionValue(context, "context");
        MessageRenderContext messageRenderContext = getMessageRenderContext(context, messageEntry, getSpoilerClickHandler(message));
        if (messageEntry.isGuildForumPostFirstMessage()) {
            parserOptions = DiscordParser.ParserOptions.FORUM_POST_FIRST_MESSAGE;
        } else {
            parserOptions = zIsWebhook ? DiscordParser.ParserOptions.ALLOW_MASKED_LINKS : DiscordParser.ParserOptions.DEFAULT;
        }
        DraweeSpanStringBuilder channelMessage = DiscordParser.parseChannelMessage(context, content, messageRenderContext, messagePreprocessor, parserOptions, z2);
        textView.setAutoLinkMask((messagePreprocessor.isLinkifyConflicting() || !shouldLinkify(message.getContent())) ? 0 : 6);
        textView.setVisibility(channelMessage.length() > 0 ? 0 : 8);
        textView.setDraweeSpanStringBuilder(channelMessage);
        Integer type2 = messageEntry.getMessage().getType();
        textView.setAlpha(((type2 != null && type2.intValue() == -1) || ((type = messageEntry.getMessage().getType()) != null && type.intValue() == -6)) ? 0.5f : 1.0f);
    }

    private final boolean shouldLinkify(String content) {
        if (content == null) {
            return false;
        }
        if (content.length() < 200) {
            return true;
        }
        int length = content.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (content.charAt(i2) == '.' && (i = i + 1) >= 50) {
                return false;
            }
        }
        return true;
    }

    private final boolean shouldShowInteractionMessage(Message message) {
        return message.isLocalApplicationCommand() || message.isLoading();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:50:0x014e  */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        TextView textView;
        List<Long> listEmptyList;
        NullSerializable<String> nullSerializableM8288a;
        View view;
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MessageEntry messageEntry = (MessageEntry) data;
        if (((WidgetChatListAdapter) this.adapter).getData().getUserId() == 0) {
            return;
        }
        final Message message = messageEntry.getMessage();
        final boolean zIsThreadStarterMessage = messageEntry.isThreadStarterMessage();
        configureItemTag(message, messageEntry.isGuildForumPostAuthor());
        View view2 = this.backgroundHighlight;
        if (view2 != null && (view = this.gutterHighlight) != null) {
            configureCellHighlight(message, view2, view);
        }
        TextView textView2 = this.itemName;
        if (textView2 != null) {
            Map<Long, String> nickOrUsernames = messageEntry.getNickOrUsernames();
            User author = message.getAuthor();
            textView2.setText(nickOrUsernames.get(author != null ? Long.valueOf(author.getId()) : null));
            this.itemName.setTextColor(getAuthorTextColor(messageEntry.getAuthor()));
            this.itemName.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage.onConfigure.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageAuthorNameClicked(message, WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData().getGuildId());
                }
            });
            ViewExtensions.setOnLongClickListenerConsumeClick(this.itemName, new C81072(message));
        }
        TextView textView3 = this.itemTimestamp;
        if (textView3 != null) {
            Context contextM885x = C1643a.m885x(this.itemView, "itemView", "itemView.context");
            UtcDateTime timestamp = message.getTimestamp();
            textView3.setText(TimeUtils.toReadableTimeString$default(contextM885x, timestamp != null ? timestamp.getDateTimeMillis() : 0L, null, 4, null));
        }
        configureInteractionMessage(messageEntry);
        if (!shouldShowInteractionMessage(message) || (textView = this.itemLoadingText) == null) {
            processMessageText(this.itemText, messageEntry);
            textView = this.itemText;
        }
        ViewCompat.setAccessibilityDelegate(this.itemView, new ChatListItemMessageAccessibilityDelegate(textView, this.itemName, this.itemTag, this.itemTimestamp));
        View view3 = this.threadStarterMessageHeader;
        if (view3 != null) {
            ViewKt.setVisible(view3, zIsThreadStarterMessage);
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage.onConfigure.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageClicked(message, zIsThreadStarterMessage);
            }
        });
        View view4 = this.itemView;
        C12238m.checkNotNullExpressionValue(view4, "itemView");
        ViewExtensions.setOnLongClickListenerConsumeClick(view4, new C81094(message, zIsThreadStarterMessage));
        configureReplyPreview(messageEntry);
        ImageView imageView = this.itemAvatar;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage.onConfigure.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageAuthorAvatarClicked(message, WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData().getGuildId());
                }
            });
            ViewExtensions.setOnLongClickListenerConsumeClick(this.itemAvatar, new C81116(message));
            User author2 = message.getAuthor();
            String strMo8429a = (author2 == null || (nullSerializableM8288a = author2.m8288a()) == null) ? null : nullSerializableM8288a.mo8429a();
            if (message.getApplicationId() == null) {
                ImageView imageView2 = this.itemAvatar;
                User author3 = message.getAuthor();
                C12238m.checkNotNull(author3);
                IconUtils.setIcon$default(imageView2, new CoreUser(author3), C5419R.dimen.avatar_size_chat, null, null, messageEntry.getAuthor(), 24, null);
            } else {
                User author4 = message.getAuthor();
                if (!(!C12238m.areEqual(author4 != null ? author4.getBot() : null, Boolean.TRUE)) || strMo8429a == null) {
                    ImageView imageView3 = this.itemAvatar;
                    User author5 = message.getAuthor();
                    C12238m.checkNotNull(author5);
                    IconUtils.setIcon$default(imageView3, new CoreUser(author5), C5419R.dimen.avatar_size_chat, null, null, messageEntry.getAuthor(), 24, null);
                } else {
                    IconUtils.setIcon$default(this.itemAvatar, IconUtils.getApplicationIcon$default(message.getApplicationId().longValue(), strMo8429a, 0, 4, (Object) null), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
                }
            }
        }
        if (this.itemRoleIcon != null) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Channel channel = companion.getChannels().getChannel(messageEntry.getMessage().getChannelId());
            GuildMember.Companion companion2 = GuildMember.INSTANCE;
            GuildMember author6 = messageEntry.getAuthor();
            if (author6 == null || (listEmptyList = author6.getRoles()) == null) {
                listEmptyList = C12147n.emptyList();
            }
            this.itemRoleIcon.setRole(companion2.getHighestRoleIconRole(listEmptyList, companion.getGuilds().getRoles().get(channel != null ? Long.valueOf(channel.getGuildId()) : null)), channel != null ? Long.valueOf(channel.getGuildId()) : null);
        }
        if (this.failedUploadList != null) {
            List<LocalAttachment> localAttachments = message.getLocalAttachments();
            if (message.isFailed() && localAttachments != null && (!localAttachments.isEmpty())) {
                this.failedUploadList.setVisibility(0);
                this.failedUploadList.setUp(localAttachments);
            } else {
                this.failedUploadList.setVisibility(8);
            }
        }
        if (this.itemAlertText != null) {
            if (message.isFailed()) {
                this.itemAlertText.setVisibility(0);
                Integer type = message.getType();
                this.itemAlertText.setText(type != null && type.intValue() == -3 ? C5419R.string.invalid_attachments_failure : C5419R.string.send_message_failure);
            } else {
                this.itemAlertText.setVisibility(8);
            }
        }
        configureThreadSpine(message, zIsThreadStarterMessage);
        configureCommunicationDisabled(messageEntry.getAuthor(), messageEntry.getPermissionsForChannel());
    }
}
