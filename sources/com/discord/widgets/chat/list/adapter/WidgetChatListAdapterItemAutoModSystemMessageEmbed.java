package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guildautomod.AutoModUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.AutoModSystemMessageEmbedEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModSystemMessageEmbed extends WidgetChatListItem {
    private final WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding binding;
    private final ChannelSelector channelSelector;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    public static final class AnonymousClass1 extends Lambda implements Function3<Context, String, String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
            invoke2(context, str, str2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str, String str2) {
            Intrinsics3.checkNotNullParameter(context, "clickContext");
            Intrinsics3.checkNotNullParameter(str, "url");
            UriHandler.handleOrUntrusted(context, str, str2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "url");
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onUrlLongClicked(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<SpoilerNode<?>, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            Intrinsics3.checkNotNullParameter(spoilerNode, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetChatListAdapter.Data data = WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getData();
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onUserMentionClicked(j, data.getChannelId(), data.getGuildId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(this.$context, j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ int $channelNameLength;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(int i) {
            super(1);
            this.$channelNameLength = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("channelHook", new AnonymousClass1());
        }

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new SimpleRoundedBackgroundSpan(0, AnonymousClass3.this.$channelNameLength, DimenUtils.dpToPixels(4), 0, ColorCompat.getThemedColor(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getContext(), R.attr.colorBackgroundModifierSelected), DimenUtils.dpToPixels(4), Integer.valueOf(ColorCompat.getThemedColor(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getContext(), R.attr.colorHeaderPrimary)), false, null, 0, 896, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAutoModSystemMessageEmbed(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_auto_mod_system_message_embed, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.actions_button;
        TextView textView = (TextView) view.findViewById(R.id.actions_button);
        if (textView != null) {
            i = R.id.blocked_message_background;
            ImageView imageView = (ImageView) view.findViewById(R.id.blocked_message_background);
            if (imageView != null) {
                i = R.id.blue_shield;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.blue_shield);
                if (imageView2 != null) {
                    i = R.id.chat_list_adapter_item_text_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.chat_list_adapter_item_text_avatar);
                    if (simpleDraweeView != null) {
                        i = R.id.dot_separator;
                        TextView textView2 = (TextView) view.findViewById(R.id.dot_separator);
                        if (textView2 != null) {
                            i = R.id.footer_text;
                            TextView textView3 = (TextView) view.findViewById(R.id.footer_text);
                            if (textView3 != null) {
                                i = R.id.message_content;
                                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.message_content);
                                if (simpleDraweeSpanTextView != null) {
                                    i = R.id.report_button;
                                    TextView textView4 = (TextView) view.findViewById(R.id.report_button);
                                    if (textView4 != null) {
                                        i = R.id.username;
                                        TextView textView5 = (TextView) view.findViewById(R.id.username);
                                        if (textView5 != null) {
                                            WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding widgetChatListAdapterItemAutoModSystemMessageEmbedBinding = new WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding((ConstraintLayout) view, textView, imageView, imageView2, simpleDraweeView, textView2, textView3, simpleDraweeSpanTextView, textView4, textView5);
                                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemAutoModSystemMessageEmbedBinding, "WidgetChatListAdapterIte…bedBinding.bind(itemView)");
                                            this.binding = widgetChatListAdapterItemAutoModSystemMessageEmbedBinding;
                                            this.channelSelector = ChannelSelector.INSTANCE.getInstance();
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed widgetChatListAdapterItemAutoModSystemMessageEmbed) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemAutoModSystemMessageEmbed.adapter;
    }

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState.State messageState) {
        StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, true, (Integer) null);
    }

    private final MessageRenderContext getMessageRenderContext(Context context, AutoModSystemMessageEmbedEntry messageEntry) {
        return new MessageRenderContext(context, ((WidgetChatListAdapter) this.adapter).getData().getUserId(), messageEntry.getAnimateEmojis(), messageEntry.getNickOrUsernames(), ((WidgetChatListAdapter) this.adapter).getData().getChannelNames(), messageEntry.getRoles(), R.attr.colorTextLink, AnonymousClass1.INSTANCE, new AnonymousClass2(), ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_bg), ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_bg_visible), AnonymousClass3.INSTANCE, new AnonymousClass4(), new AnonymousClass5(context));
    }

    private final void processMessageText(SimpleDraweeSpanTextView textView, AutoModSystemMessageEmbedEntry messageEntry, MessageEmbed embed) {
        Context context = textView.getContext();
        Message message = messageEntry.getMessage();
        UtcDateTime editedTimestamp = message.getEditedTimestamp();
        boolean z2 = (editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) > 0;
        String description = embed.getDescription();
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(((WidgetChatListAdapter) this.adapter).getData().getUserId(), message, messageEntry.getMessageState());
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        DraweeSpanStringBuilder channelMessage = DiscordParser.parseChannelMessage(context, description, getMessageRenderContext(context, messageEntry), messagePreprocessor, DiscordParser.ParserOptions.DEFAULT, z2);
        textView.setVisibility(channelMessage.length() > 0 ? 0 : 8);
        textView.setDraweeSpanStringBuilder(channelMessage);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        final AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry = (AutoModSystemMessageEmbedEntry) data;
        int themedColor = ColorCompat.getThemedColor(((WidgetChatListAdapter) this.adapter).getContext(), R.attr.colorHeaderPrimary);
        GuildMember.Companion companion = GuildMember.INSTANCE;
        int color = companion.getColor(autoModSystemMessageEmbedEntry.getAuthor(), themedColor);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.messageContent");
        processMessageText(simpleDraweeSpanTextView, autoModSystemMessageEmbedEntry, autoModSystemMessageEmbedEntry.getEmbed());
        if (autoModSystemMessageEmbedEntry.getMessage().getAuthor() != null) {
            CoreUser coreUser = new CoreUser(autoModSystemMessageEmbedEntry.getMessage().getAuthor());
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListAdapterItemTextAvatar");
            IconUtils.setIcon$default(simpleDraweeView, new CoreUser(autoModSystemMessageEmbedEntry.getMessage().getAuthor()), R.dimen.avatar_size_chat, null, null, autoModSystemMessageEmbedEntry.getAuthor(), 24, null);
            TextView textView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.username");
            FormatUtils.o(textView, companion.getNickOrUsername(autoModSystemMessageEmbedEntry.getAuthor(), coreUser), new Object[0], null, 4);
            String nickOrUsername = companion.getNickOrUsername(autoModSystemMessageEmbedEntry.getAuthor(), coreUser);
            TextView textView2 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.username");
            FormatUtils.o(textView2, nickOrUsername, new Object[0], null, 4);
            this.binding.g.setTextColor(color);
        }
        this.binding.g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onMessageAuthorLongClicked(autoModSystemMessageEmbedEntry.getMessage(), autoModSystemMessageEmbedEntry.getMessage().getGuildId());
            }
        });
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed.onConfigure.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onMessageAuthorLongClicked(autoModSystemMessageEmbedEntry.getMessage(), autoModSystemMessageEmbedEntry.getMessage().getGuildId());
            }
        });
        AutoModUtils autoModUtils = AutoModUtils.INSTANCE;
        final Channel channel = StoreStream.INSTANCE.getChannels().getChannel(Long.parseLong(autoModUtils.getEmbedFieldValue(autoModSystemMessageEmbedEntry.getEmbed(), WidgetChatListAdapterItemAutoModSystemMessageEmbed2.getAUTOMOD_EMBED_FIELD_CHANNEL_ID())));
        String strE = channel != null ? ChannelUtils.e(channel, ((WidgetChatListAdapter) this.adapter).getContext(), false, 2) : null;
        int length = strE != null ? strE.length() : 0;
        TextView textView3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.footerText");
        FormatUtils.m(textView3, R.string.guild_automod_channel_rule_subtext, new Object[]{strE, autoModUtils.getEmbedFieldValue(autoModSystemMessageEmbedEntry.getEmbed(), WidgetChatListAdapterItemAutoModSystemMessageEmbed2.getAUTOMOD_EMBED_FIELD_RULE_NAME())}, new AnonymousClass3(length));
        this.binding.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed.onConfigure.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelSelector.selectChannel$default(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this.channelSelector, channel, null, StoreChannelsSelected3.THREAD_BROWSER, 2, null);
            }
        });
        this.binding.f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed.onConfigure.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onReportIssueWithAutoMod(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getContext(), autoModSystemMessageEmbedEntry.getMessage());
            }
        });
        this.binding.f2311b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed.onConfigure.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler();
                Message message = autoModSystemMessageEmbedEntry.getMessage();
                GuildMember author = autoModSystemMessageEmbedEntry.getAuthor();
                eventHandler.onMessageAuthorLongClicked(message, author != null ? Long.valueOf(author.getGuildId()) : null);
            }
        });
    }
}
