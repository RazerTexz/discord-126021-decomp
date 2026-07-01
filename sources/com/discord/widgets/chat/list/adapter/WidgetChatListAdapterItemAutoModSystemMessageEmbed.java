package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.member.GuildMember$Companion;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreMessageState$State;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guildautomod.AutoModUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.DiscordParser$ParserOptions;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.entries.AutoModSystemMessageEmbedEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModSystemMessageEmbed extends WidgetChatListItem {
    private final WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding binding;
    private final ChannelSelector channelSelector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAutoModSystemMessageEmbed(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_auto_mod_system_message_embed, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.actions_button;
        TextView textView = (TextView) view.findViewById(R$id.actions_button);
        if (textView != null) {
            i = R$id.blocked_message_background;
            ImageView imageView = (ImageView) view.findViewById(R$id.blocked_message_background);
            if (imageView != null) {
                i = R$id.blue_shield;
                ImageView imageView2 = (ImageView) view.findViewById(R$id.blue_shield);
                if (imageView2 != null) {
                    i = R$id.chat_list_adapter_item_text_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.chat_list_adapter_item_text_avatar);
                    if (simpleDraweeView != null) {
                        i = R$id.dot_separator;
                        TextView textView2 = (TextView) view.findViewById(R$id.dot_separator);
                        if (textView2 != null) {
                            i = R$id.footer_text;
                            TextView textView3 = (TextView) view.findViewById(R$id.footer_text);
                            if (textView3 != null) {
                                i = R$id.message_content;
                                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R$id.message_content);
                                if (simpleDraweeSpanTextView != null) {
                                    i = R$id.report_button;
                                    TextView textView4 = (TextView) view.findViewById(R$id.report_button);
                                    if (textView4 != null) {
                                        i = R$id.username;
                                        TextView textView5 = (TextView) view.findViewById(R$id.username);
                                        if (textView5 != null) {
                                            WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding widgetChatListAdapterItemAutoModSystemMessageEmbedBinding = new WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding((ConstraintLayout) view, textView, imageView, imageView2, simpleDraweeView, textView2, textView3, simpleDraweeSpanTextView, textView4, textView5);
                                            m.checkNotNullExpressionValue(widgetChatListAdapterItemAutoModSystemMessageEmbedBinding, "WidgetChatListAdapterIte…bedBinding.bind(itemView)");
                                            this.binding = widgetChatListAdapterItemAutoModSystemMessageEmbedBinding;
                                            this.channelSelector = ChannelSelector.Companion.getInstance();
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

    public static final /* synthetic */ ChannelSelector access$getChannelSelector$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed widgetChatListAdapterItemAutoModSystemMessageEmbed) {
        return widgetChatListAdapterItemAutoModSystemMessageEmbed.channelSelector;
    }

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState$State messageState) {
        StoreUserSettings userSettings = StoreStream.Companion.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, true, (Integer) null);
    }

    private final MessageRenderContext getMessageRenderContext(Context context, AutoModSystemMessageEmbedEntry messageEntry) {
        return new MessageRenderContext(context, ((WidgetChatListAdapter) this.adapter).getData().getUserId(), messageEntry.getAnimateEmojis(), messageEntry.getNickOrUsernames(), ((WidgetChatListAdapter) this.adapter).getData().getChannelNames(), messageEntry.getRoles(), 2130969054, WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$1.INSTANCE, new WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$2(this), ColorCompat.getThemedColor(context, 2130970291), ColorCompat.getThemedColor(context, 2130970292), WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$3.INSTANCE, new WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$4(this), new WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$5(context));
    }

    private final void processMessageText(SimpleDraweeSpanTextView textView, AutoModSystemMessageEmbedEntry messageEntry, MessageEmbed embed) {
        Context context = textView.getContext();
        Message message = messageEntry.getMessage();
        UtcDateTime editedTimestamp = message.getEditedTimestamp();
        boolean z2 = (editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) > 0;
        String description = embed.getDescription();
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(((WidgetChatListAdapter) this.adapter).getData().getUserId(), message, messageEntry.getMessageState());
        m.checkNotNullExpressionValue(context, "context");
        DraweeSpanStringBuilder channelMessage = DiscordParser.parseChannelMessage(context, description, getMessageRenderContext(context, messageEntry), messagePreprocessor, DiscordParser$ParserOptions.DEFAULT, z2);
        textView.setVisibility(channelMessage.length() > 0 ? 0 : 8);
        textView.setDraweeSpanStringBuilder(channelMessage);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry = (AutoModSystemMessageEmbedEntry) data;
        int themedColor = ColorCompat.getThemedColor(((WidgetChatListAdapter) this.adapter).getContext(), 2130968989);
        GuildMember$Companion guildMember$Companion = GuildMember.Companion;
        int color = guildMember$Companion.getColor(autoModSystemMessageEmbedEntry.getAuthor(), themedColor);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.e;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.messageContent");
        processMessageText(simpleDraweeSpanTextView, autoModSystemMessageEmbedEntry, autoModSystemMessageEmbedEntry.getEmbed());
        if (autoModSystemMessageEmbedEntry.getMessage().getAuthor() != null) {
            CoreUser coreUser = new CoreUser(autoModSystemMessageEmbedEntry.getMessage().getAuthor());
            SimpleDraweeView simpleDraweeView = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListAdapterItemTextAvatar");
            IconUtils.setIcon$default(simpleDraweeView, new CoreUser(autoModSystemMessageEmbedEntry.getMessage().getAuthor()), 2131165287, null, null, autoModSystemMessageEmbedEntry.getAuthor(), 24, null);
            TextView textView = this.binding.g;
            m.checkNotNullExpressionValue(textView, "binding.username");
            b.o(textView, guildMember$Companion.getNickOrUsername(autoModSystemMessageEmbedEntry.getAuthor(), coreUser), new Object[0], null, 4);
            String nickOrUsername = guildMember$Companion.getNickOrUsername(autoModSystemMessageEmbedEntry.getAuthor(), coreUser);
            TextView textView2 = this.binding.g;
            m.checkNotNullExpressionValue(textView2, "binding.username");
            b.o(textView2, nickOrUsername, new Object[0], null, 4);
            this.binding.g.setTextColor(color);
        }
        this.binding.g.setOnClickListener(new WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$1(this, autoModSystemMessageEmbedEntry));
        this.binding.c.setOnClickListener(new WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$2(this, autoModSystemMessageEmbedEntry));
        AutoModUtils autoModUtils = AutoModUtils.INSTANCE;
        Channel channel = StoreStream.Companion.getChannels().getChannel(Long.parseLong(autoModUtils.getEmbedFieldValue(autoModSystemMessageEmbedEntry.getEmbed(), WidgetChatListAdapterItemAutoModSystemMessageEmbedKt.getAUTOMOD_EMBED_FIELD_CHANNEL_ID())));
        String strE = channel != null ? ChannelUtils.e(channel, ((WidgetChatListAdapter) this.adapter).getContext(), false, 2) : null;
        int length = strE != null ? strE.length() : 0;
        TextView textView3 = this.binding.d;
        m.checkNotNullExpressionValue(textView3, "binding.footerText");
        b.m(textView3, 2131889867, new Object[]{strE, autoModUtils.getEmbedFieldValue(autoModSystemMessageEmbedEntry.getEmbed(), WidgetChatListAdapterItemAutoModSystemMessageEmbedKt.getAUTOMOD_EMBED_FIELD_RULE_NAME())}, new WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3(this, length));
        this.binding.d.setOnClickListener(new WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$4(this, channel));
        this.binding.f.setOnClickListener(new WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$5(this, autoModSystemMessageEmbedEntry));
        this.binding.f2311b.setOnClickListener(new WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$6(this, autoModSystemMessageEmbedEntry));
    }
}
