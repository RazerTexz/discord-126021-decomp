package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.d.f;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetChatListAdapterItemGuildWelcomeBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.ChatActionItem;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildWelcomeEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildWelcome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildWelcome extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGuildWelcomeBinding binding;
    private final Clock clock;

    public /* synthetic */ WidgetChatListAdapterItemGuildWelcome(WidgetChatListAdapter widgetChatListAdapter, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetChatListAdapter, (i & 2) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGuildWelcome widgetChatListAdapterItemGuildWelcome) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGuildWelcome.adapter;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildWelcome(WidgetChatListAdapter widgetChatListAdapter, Clock clock) {
        super(R$layout.widget_chat_list_adapter_item_guild_welcome, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        m.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        View view = this.itemView;
        int i = R$id.item_guild_welcome_header;
        TextView textView = (TextView) view.findViewById(R$id.item_guild_welcome_header);
        if (textView != null) {
            i = R$id.item_guild_welcome_subheader;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.item_guild_welcome_subheader);
            if (linkifiedTextView != null) {
                i = R$id.item_guild_welcome_subheader_intro;
                LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(R$id.item_guild_welcome_subheader_intro);
                if (linkifiedTextView2 != null) {
                    i = R$id.welcome_card_invite_friends;
                    ChatActionItem chatActionItem = (ChatActionItem) view.findViewById(R$id.welcome_card_invite_friends);
                    if (chatActionItem != null) {
                        i = R$id.welcome_card_upload_icon;
                        ChatActionItem chatActionItem2 = (ChatActionItem) view.findViewById(R$id.welcome_card_upload_icon);
                        if (chatActionItem2 != null) {
                            WidgetChatListAdapterItemGuildWelcomeBinding widgetChatListAdapterItemGuildWelcomeBinding = new WidgetChatListAdapterItemGuildWelcomeBinding((LinearLayout) view, textView, linkifiedTextView, linkifiedTextView2, chatActionItem, chatActionItem2);
                            m.checkNotNullExpressionValue(widgetChatListAdapterItemGuildWelcomeBinding, "WidgetChatListAdapterIte…omeBinding.bind(itemView)");
                            this.binding = widgetChatListAdapterItemGuildWelcomeBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        int i;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof GuildWelcomeEntry) {
            TextView textView = this.binding.f2324b;
            m.checkNotNullExpressionValue(textView, "binding.itemGuildWelcomeHeader");
            boolean z2 = true;
            GuildWelcomeEntry guildWelcomeEntry = (GuildWelcomeEntry) data;
            b.n(textView, 2131897249, new Object[]{guildWelcomeEntry.getGuildName()}, null, 4);
            boolean z3 = (guildWelcomeEntry.getGuildId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH < this.clock.currentTimeMillis() - WidgetChatListAdapterItemGuildWelcomeKt.OLD_GUILD_AGE_THRESHOLD;
            ChatActionItem chatActionItem = this.binding.f;
            m.checkNotNullExpressionValue(chatActionItem, "binding.welcomeCardUploadIcon");
            chatActionItem.setVisibility(!guildWelcomeEntry.getGuildHasIcon() && guildWelcomeEntry.isOwner() ? 0 : 8);
            this.binding.f.setOnClickListener(new WidgetChatListAdapterItemGuildWelcome$onConfigure$1(data));
            ChatActionItem chatActionItem2 = this.binding.e;
            m.checkNotNullExpressionValue(chatActionItem2, "binding.welcomeCardInviteFriends");
            chatActionItem2.setVisibility(guildWelcomeEntry.getCanInvite() ? 0 : 8);
            this.binding.e.setOnClickListener(new WidgetChatListAdapterItemGuildWelcome$onConfigure$2(this, data));
            String strJ = a.J(new StringBuilder(), f.a.a(360045138571L, null), "?utm_source=discord&utm_medium=blog&utm_campaign=2020-06_help-new-user&utm_content=--t%3Apm");
            LinkifiedTextView linkifiedTextView = this.binding.d;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.itemGuildWelcomeSubheaderIntro");
            b.n(linkifiedTextView, 2131897244, new Object[]{strJ}, null, 4);
            LinkifiedTextView linkifiedTextView2 = this.binding.d;
            m.checkNotNullExpressionValue(linkifiedTextView2, "binding.itemGuildWelcomeSubheaderIntro");
            ChatActionItem chatActionItem3 = this.binding.f;
            m.checkNotNullExpressionValue(chatActionItem3, "binding.welcomeCardUploadIcon");
            if (!(chatActionItem3.getVisibility() == 0)) {
                ChatActionItem chatActionItem4 = this.binding.e;
                m.checkNotNullExpressionValue(chatActionItem4, "binding.welcomeCardInviteFriends");
                if (!(chatActionItem4.getVisibility() == 0)) {
                    z2 = false;
                }
            }
            linkifiedTextView2.setVisibility(z2 ? 0 : 8);
            LinkifiedTextView linkifiedTextView3 = this.binding.c;
            m.checkNotNullExpressionValue(linkifiedTextView3, "binding.itemGuildWelcomeSubheader");
            if (z3) {
                i = 2131897245;
            } else {
                i = guildWelcomeEntry.isOwner() ? 2131897247 : 2131897246;
            }
            b.n(linkifiedTextView3, i, new Object[0], null, 4);
        }
    }
}
