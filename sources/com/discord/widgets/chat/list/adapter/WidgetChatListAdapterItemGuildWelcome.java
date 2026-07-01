package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.d.AppHelpDesk;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemGuildWelcomeBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.ChatActionItem;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildWelcomeEntry;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import d0.z.d.Intrinsics3;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildWelcome(WidgetChatListAdapter widgetChatListAdapter, Clock clock) {
        super(R.layout.widget_chat_list_adapter_item_guild_welcome, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        View view = this.itemView;
        int i = R.id.item_guild_welcome_header;
        TextView textView = (TextView) view.findViewById(R.id.item_guild_welcome_header);
        if (textView != null) {
            i = R.id.item_guild_welcome_subheader;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.item_guild_welcome_subheader);
            if (linkifiedTextView != null) {
                i = R.id.item_guild_welcome_subheader_intro;
                LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(R.id.item_guild_welcome_subheader_intro);
                if (linkifiedTextView2 != null) {
                    i = R.id.welcome_card_invite_friends;
                    ChatActionItem chatActionItem = (ChatActionItem) view.findViewById(R.id.welcome_card_invite_friends);
                    if (chatActionItem != null) {
                        i = R.id.welcome_card_upload_icon;
                        ChatActionItem chatActionItem2 = (ChatActionItem) view.findViewById(R.id.welcome_card_upload_icon);
                        if (chatActionItem2 != null) {
                            WidgetChatListAdapterItemGuildWelcomeBinding widgetChatListAdapterItemGuildWelcomeBinding = new WidgetChatListAdapterItemGuildWelcomeBinding((LinearLayout) view, textView, linkifiedTextView, linkifiedTextView2, chatActionItem, chatActionItem2);
                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGuildWelcomeBinding, "WidgetChatListAdapterIte…omeBinding.bind(itemView)");
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
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, final ChatListEntry data) {
        int i;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof GuildWelcomeEntry) {
            TextView textView = this.binding.f2324b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildWelcomeHeader");
            boolean z2 = true;
            GuildWelcomeEntry guildWelcomeEntry = (GuildWelcomeEntry) data;
            FormatUtils.m(textView, R.string.welcome_cta_title_mobile, new Object[]{guildWelcomeEntry.getGuildName()}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            boolean z3 = (guildWelcomeEntry.getGuildId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH < this.clock.currentTimeMillis() - WidgetChatListAdapterItemGuildWelcome2.OLD_GUILD_AGE_THRESHOLD;
            ChatActionItem chatActionItem = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(chatActionItem, "binding.welcomeCardUploadIcon");
            chatActionItem.setVisibility(!guildWelcomeEntry.getGuildHasIcon() && guildWelcomeEntry.isOwner() ? 0 : 8);
            this.binding.f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome.onConfigure.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetServerSettingsOverview.INSTANCE.create(outline.x(view, "view", "view.context"), ((GuildWelcomeEntry) data).getGuildId(), true);
                }
            });
            ChatActionItem chatActionItem2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(chatActionItem2, "binding.welcomeCardInviteFriends");
            chatActionItem2.setVisibility(guildWelcomeEntry.getCanInvite() ? 0 : 8);
            this.binding.e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome.onConfigure.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildInviteShare.INSTANCE.launch(outline.x(view, "view", "view.context"), WidgetChatListAdapterItemGuildWelcome.access$getAdapter$p(WidgetChatListAdapterItemGuildWelcome.this).getFragmentManager(), ((GuildWelcomeEntry) data).getGuildId(), (16 & 8) != 0 ? null : null, (16 & 16) != 0 ? false : false, (16 & 32) != 0 ? null : null, (16 & 64) != 0 ? null : null, "Welcome Message");
                }
            });
            String strJ = outline.J(new StringBuilder(), AppHelpDesk.a.a(360045138571L, null), "?utm_source=discord&utm_medium=blog&utm_campaign=2020-06_help-new-user&utm_content=--t%3Apm");
            LinkifiedTextView linkifiedTextView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.itemGuildWelcomeSubheaderIntro");
            FormatUtils.m(linkifiedTextView, R.string.welcome_cta_subtitle_action_with_guide, new Object[]{strJ}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            LinkifiedTextView linkifiedTextView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.itemGuildWelcomeSubheaderIntro");
            ChatActionItem chatActionItem3 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(chatActionItem3, "binding.welcomeCardUploadIcon");
            if (!(chatActionItem3.getVisibility() == 0)) {
                ChatActionItem chatActionItem4 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(chatActionItem4, "binding.welcomeCardInviteFriends");
                if (!(chatActionItem4.getVisibility() == 0)) {
                    z2 = false;
                }
            }
            linkifiedTextView2.setVisibility(z2 ? 0 : 8);
            LinkifiedTextView linkifiedTextView3 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "binding.itemGuildWelcomeSubheader");
            if (z3) {
                i = R.string.welcome_cta_subtitle_existing_server;
            } else {
                i = guildWelcomeEntry.isOwner() ? R.string.welcome_cta_subtitle_owner : R.string.welcome_cta_subtitle_member;
            }
            FormatUtils.m(linkifiedTextView3, i, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        }
    }
}
