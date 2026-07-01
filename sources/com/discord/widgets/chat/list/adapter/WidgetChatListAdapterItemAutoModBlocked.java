package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemAutoModBlockedBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreMessageState$State;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.DiscordParser$ParserOptions;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModBlocked.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModBlocked extends WidgetChatListItem {
    private final WidgetChatListAdapterItemAutoModBlockedBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAutoModBlocked(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_auto_mod_blocked, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.chat_list_adapter_item_text_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.chat_list_adapter_item_text_avatar);
        if (simpleDraweeView != null) {
            i = R$id.dismiss_message;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.dismiss_message);
            if (linkifiedTextView != null) {
                i = R$id.eye_icon;
                ImageView imageView = (ImageView) view.findViewById(R$id.eye_icon);
                if (imageView != null) {
                    i = R$id.message_content;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R$id.message_content);
                    if (simpleDraweeSpanTextView != null) {
                        i = R$id.red_rectangle;
                        ImageView imageView2 = (ImageView) view.findViewById(R$id.red_rectangle);
                        if (imageView2 != null) {
                            i = R$id.text_container;
                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.text_container);
                            if (constraintLayout != null) {
                                i = R$id.timestamp;
                                TextView textView = (TextView) view.findViewById(R$id.timestamp);
                                if (textView != null) {
                                    i = R$id.username;
                                    TextView textView2 = (TextView) view.findViewById(R$id.username);
                                    if (textView2 != null) {
                                        i = R$id.username_container;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R$id.username_container);
                                        if (constraintLayout2 != null) {
                                            i = R$id.visibility_notice_container;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R$id.visibility_notice_container);
                                            if (constraintLayout3 != null) {
                                                i = R$id.warning_message;
                                                TextView textView3 = (TextView) view.findViewById(R$id.warning_message);
                                                if (textView3 != null) {
                                                    WidgetChatListAdapterItemAutoModBlockedBinding widgetChatListAdapterItemAutoModBlockedBinding = new WidgetChatListAdapterItemAutoModBlockedBinding((ConstraintLayout) view, simpleDraweeView, linkifiedTextView, imageView, simpleDraweeSpanTextView, imageView2, constraintLayout, textView, textView2, constraintLayout2, constraintLayout3, textView3);
                                                    m.checkNotNullExpressionValue(widgetChatListAdapterItemAutoModBlockedBinding, "WidgetChatListAdapterIte…kedBinding.bind(itemView)");
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

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState$State messageState) {
        StoreUserSettings userSettings = StoreStream.Companion.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, true, (Integer) null);
    }

    private final MessageRenderContext getMessageRenderContext(Context context, MessageEntry messageEntry) {
        return new MessageRenderContext(context, ((WidgetChatListAdapter) this.adapter).getData().getUserId(), messageEntry.getAnimateEmojis(), messageEntry.getNickOrUsernames(), ((WidgetChatListAdapter) this.adapter).getData().getChannelNames(), messageEntry.getRoles(), 2130969054, WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$1.INSTANCE, new WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$2(this), ColorCompat.getThemedColor(context, 2130970291), ColorCompat.getThemedColor(context, 2130970292), WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$3.INSTANCE, new WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$4(this), new WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$5(context));
    }

    private final void processMessageText(SimpleDraweeSpanTextView textView, MessageEntry messageEntry) {
        Context context = textView.getContext();
        Message message = messageEntry.getMessage();
        UtcDateTime editedTimestamp = message.getEditedTimestamp();
        boolean z2 = (editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) > 0;
        String content = message.getContent();
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(((WidgetChatListAdapter) this.adapter).getData().getUserId(), message, messageEntry.getMessageState());
        m.checkNotNullExpressionValue(context, "context");
        DraweeSpanStringBuilder channelMessage = DiscordParser.parseChannelMessage(context, content, getMessageRenderContext(context, messageEntry), messagePreprocessor, DiscordParser$ParserOptions.DEFAULT, z2);
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
        String username;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MessageEntry messageEntry = (MessageEntry) data;
        int color = GuildMember.Companion.getColor(messageEntry.getAuthor(), ColorCompat.getThemedColor(((WidgetChatListAdapter) this.adapter).getContext(), 2130968989));
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.messageContent");
        processMessageText(simpleDraweeSpanTextView, messageEntry);
        if (messageEntry.getMessage().getAuthor() != null) {
            SimpleDraweeView simpleDraweeView = this.binding.f2310b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListAdapterItemTextAvatar");
            IconUtils.setIcon$default(simpleDraweeView, new CoreUser(messageEntry.getMessage().getAuthor()), 2131165287, null, null, messageEntry.getAuthor(), 24, null);
        }
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.username");
        GuildMember author = messageEntry.getAuthor();
        if (author == null || (username = author.getNick()) == null) {
            User author2 = messageEntry.getMessage().getAuthor();
            username = author2 != null ? author2.getUsername() : null;
        }
        b.o(textView, username, new Object[0], null, 4);
        this.binding.f.setTextColor(color);
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.timestamp");
        Context context = ((WidgetChatListAdapter) this.adapter).getContext();
        UtcDateTime timestamp = messageEntry.getMessage().getTimestamp();
        textView2.setText(TimeUtils.toReadableTimeString$default(context, timestamp != null ? timestamp.getDateTimeMillis() : 0L, null, 4, null));
        LinkifiedTextView linkifiedTextView = this.binding.c;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.dismissMessage");
        b.m(linkifiedTextView, 2131889954, new Object[0], new WidgetChatListAdapterItemAutoModBlocked$onConfigure$1(this, messageEntry));
        if (messageEntry.getMessage().getEditedTimestamp() != null) {
            TextView textView3 = this.binding.e;
            m.checkNotNullExpressionValue(textView3, "binding.timestamp");
            Context context2 = ((WidgetChatListAdapter) this.adapter).getContext();
            UtcDateTime timestamp2 = messageEntry.getMessage().getTimestamp();
            textView3.setText(TimeUtils.toReadableTimeString$default(context2, timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L, null, 4, null));
        }
    }
}
