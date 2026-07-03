package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemAutoModBlockedBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModBlocked.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModBlocked extends WidgetChatListItem {
    private final WidgetChatListAdapterItemAutoModBlockedBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModBlocked.kt */
    public static final class C80201 extends AbstractC12240o implements Function3<Context, String, String, Unit> {
        public static final C80201 INSTANCE = new C80201();

        public C80201() {
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

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModBlocked.kt */
    public static final class C80212 extends AbstractC12240o implements Function1<String, Unit> {
        public C80212() {
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
            WidgetChatListAdapterItemAutoModBlocked.access$getAdapter$p(WidgetChatListAdapterItemAutoModBlocked.this).getEventHandler().onUrlLongClicked(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$3 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModBlocked.kt */
    public static final class C80223 extends AbstractC12240o implements Function1<SpoilerNode<?>, Unit> {
        public static final C80223 INSTANCE = new C80223();

        public C80223() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            C12238m.checkNotNullParameter(spoilerNode, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$4 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModBlocked.kt */
    public static final class C80234 extends AbstractC12240o implements Function1<Long, Unit> {
        public C80234() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetChatListAdapter.Data data = WidgetChatListAdapterItemAutoModBlocked.access$getAdapter$p(WidgetChatListAdapterItemAutoModBlocked.this).getData();
            WidgetChatListAdapterItemAutoModBlocked.access$getAdapter$p(WidgetChatListAdapterItemAutoModBlocked.this).getEventHandler().onUserMentionClicked(j, data.getChannelId(), data.getGuildId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$5 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModBlocked.kt */
    public static final class C80245 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80245(Context context) {
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

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModBlocked$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModBlocked.kt */
    public static final class C80251 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ MessageEntry $messageEntry;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModBlocked$onConfigure$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModBlocked.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
                WidgetChatListAdapterItemAutoModBlocked.access$getAdapter$p(WidgetChatListAdapterItemAutoModBlocked.this).getEventHandler().onDismissLocalMessageClicked(C80251.this.$messageEntry.getMessage());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80251(MessageEntry messageEntry) {
            super(1);
            this.$messageEntry = messageEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("onClick", new AnonymousClass1());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAutoModBlocked(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_auto_mod_blocked, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_text_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.chat_list_adapter_item_text_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.dismiss_message;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.dismiss_message);
            if (linkifiedTextView != null) {
                i = C5419R.id.eye_icon;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.eye_icon);
                if (imageView != null) {
                    i = C5419R.id.message_content;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(C5419R.id.message_content);
                    if (simpleDraweeSpanTextView != null) {
                        i = C5419R.id.red_rectangle;
                        ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.red_rectangle);
                        if (imageView2 != null) {
                            i = C5419R.id.text_container;
                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.text_container);
                            if (constraintLayout != null) {
                                i = C5419R.id.timestamp;
                                TextView textView = (TextView) view.findViewById(C5419R.id.timestamp);
                                if (textView != null) {
                                    i = C5419R.id.username;
                                    TextView textView2 = (TextView) view.findViewById(C5419R.id.username);
                                    if (textView2 != null) {
                                        i = C5419R.id.username_container;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(C5419R.id.username_container);
                                        if (constraintLayout2 != null) {
                                            i = C5419R.id.visibility_notice_container;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(C5419R.id.visibility_notice_container);
                                            if (constraintLayout3 != null) {
                                                i = C5419R.id.warning_message;
                                                TextView textView3 = (TextView) view.findViewById(C5419R.id.warning_message);
                                                if (textView3 != null) {
                                                    WidgetChatListAdapterItemAutoModBlockedBinding widgetChatListAdapterItemAutoModBlockedBinding = new WidgetChatListAdapterItemAutoModBlockedBinding((ConstraintLayout) view, simpleDraweeView, linkifiedTextView, imageView, simpleDraweeSpanTextView, imageView2, constraintLayout, textView, textView2, constraintLayout2, constraintLayout3, textView3);
                                                    C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemAutoModBlockedBinding, "WidgetChatListAdapterIte…kedBinding.bind(itemView)");
                                                    this.binding = widgetChatListAdapterItemAutoModBlockedBinding;
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemAutoModBlocked widgetChatListAdapterItemAutoModBlocked) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemAutoModBlocked.adapter;
    }

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState.State messageState) {
        StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, true, (Integer) null);
    }

    private final MessageRenderContext getMessageRenderContext(Context context, MessageEntry messageEntry) {
        return new MessageRenderContext(context, ((WidgetChatListAdapter) this.adapter).getData().getUserId(), messageEntry.getAnimateEmojis(), messageEntry.getNickOrUsernames(), ((WidgetChatListAdapter) this.adapter).getData().getChannelNames(), messageEntry.getRoles(), C5419R.attr.colorTextLink, C80201.INSTANCE, new C80212(), ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_spoiler_bg), ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_spoiler_bg_visible), C80223.INSTANCE, new C80234(), new C80245(context));
    }

    private final void processMessageText(SimpleDraweeSpanTextView textView, MessageEntry messageEntry) {
        Context context = textView.getContext();
        Message message = messageEntry.getMessage();
        UtcDateTime editedTimestamp = message.getEditedTimestamp();
        boolean z2 = (editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) > 0;
        String content = message.getContent();
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(((WidgetChatListAdapter) this.adapter).getData().getUserId(), message, messageEntry.getMessageState());
        C12238m.checkNotNullExpressionValue(context, "context");
        DraweeSpanStringBuilder channelMessage = DiscordParser.parseChannelMessage(context, content, getMessageRenderContext(context, messageEntry), messagePreprocessor, DiscordParser.ParserOptions.DEFAULT, z2);
        textView.setVisibility(channelMessage.length() > 0 ? 0 : 8);
        textView.setDraweeSpanStringBuilder(channelMessage);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        String username;
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MessageEntry messageEntry = (MessageEntry) data;
        int color = GuildMember.INSTANCE.getColor(messageEntry.getAuthor(), ColorCompat.getThemedColor(((WidgetChatListAdapter) this.adapter).getContext(), C5419R.attr.colorHeaderPrimary));
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f16157d;
        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.messageContent");
        processMessageText(simpleDraweeSpanTextView, messageEntry);
        if (messageEntry.getMessage().getAuthor() != null) {
            SimpleDraweeView simpleDraweeView = this.binding.f16155b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListAdapterItemTextAvatar");
            IconUtils.setIcon$default(simpleDraweeView, new CoreUser(messageEntry.getMessage().getAuthor()), C5419R.dimen.avatar_size_chat, null, null, messageEntry.getAuthor(), 24, null);
        }
        TextView textView = this.binding.f16159f;
        C12238m.checkNotNullExpressionValue(textView, "binding.username");
        GuildMember author = messageEntry.getAuthor();
        if (author == null || (username = author.getNick()) == null) {
            User author2 = messageEntry.getMessage().getAuthor();
            username = author2 != null ? author2.getUsername() : null;
        }
        C1107b.m223o(textView, username, new Object[0], null, 4);
        this.binding.f16159f.setTextColor(color);
        TextView textView2 = this.binding.f16158e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.timestamp");
        Context context = ((WidgetChatListAdapter) this.adapter).getContext();
        UtcDateTime timestamp = messageEntry.getMessage().getTimestamp();
        textView2.setText(TimeUtils.toReadableTimeString$default(context, timestamp != null ? timestamp.getDateTimeMillis() : 0L, null, 4, null));
        LinkifiedTextView linkifiedTextView = this.binding.f16156c;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.dismissMessage");
        C1107b.m221m(linkifiedTextView, C5419R.string.guild_automod_visibility_message, new Object[0], new C80251(messageEntry));
        if (messageEntry.getMessage().getEditedTimestamp() != null) {
            TextView textView3 = this.binding.f16158e;
            C12238m.checkNotNullExpressionValue(textView3, "binding.timestamp");
            Context context2 = ((WidgetChatListAdapter) this.adapter).getContext();
            UtcDateTime timestamp2 = messageEntry.getMessage().getTimestamp();
            textView3.setText(TimeUtils.toReadableTimeString$default(context2, timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L, null, 4, null));
        }
    }
}
