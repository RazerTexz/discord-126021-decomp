package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        super(C5419R.layout.widget_chat_list_adapter_item_guild_welcome, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        C12238m.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        View view = this.itemView;
        int i = C5419R.id.item_guild_welcome_header;
        TextView textView = (TextView) view.findViewById(C5419R.id.item_guild_welcome_header);
        if (textView != null) {
            i = C5419R.id.item_guild_welcome_subheader;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.item_guild_welcome_subheader);
            if (linkifiedTextView != null) {
                i = C5419R.id.item_guild_welcome_subheader_intro;
                LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(C5419R.id.item_guild_welcome_subheader_intro);
                if (linkifiedTextView2 != null) {
                    i = C5419R.id.welcome_card_invite_friends;
                    ChatActionItem chatActionItem = (ChatActionItem) view.findViewById(C5419R.id.welcome_card_invite_friends);
                    if (chatActionItem != null) {
                        i = C5419R.id.welcome_card_upload_icon;
                        ChatActionItem chatActionItem2 = (ChatActionItem) view.findViewById(C5419R.id.welcome_card_upload_icon);
                        if (chatActionItem2 != null) {
                            WidgetChatListAdapterItemGuildWelcomeBinding widgetChatListAdapterItemGuildWelcomeBinding = new WidgetChatListAdapterItemGuildWelcomeBinding((LinearLayout) view, textView, linkifiedTextView, linkifiedTextView2, chatActionItem, chatActionItem2);
                            C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemGuildWelcomeBinding, "WidgetChatListAdapterIte…omeBinding.bind(itemView)");
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
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof GuildWelcomeEntry) {
            TextView textView = this.binding.f16233b;
            C12238m.checkNotNullExpressionValue(textView, "binding.itemGuildWelcomeHeader");
            boolean z2 = true;
            GuildWelcomeEntry guildWelcomeEntry = (GuildWelcomeEntry) data;
            C1107b.m221m(textView, C5419R.string.welcome_cta_title_mobile, new Object[]{guildWelcomeEntry.getGuildName()}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
            boolean z3 = (guildWelcomeEntry.getGuildId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH < this.clock.currentTimeMillis() - WidgetChatListAdapterItemGuildWelcomeKt.OLD_GUILD_AGE_THRESHOLD;
            ChatActionItem chatActionItem = this.binding.f16237f;
            C12238m.checkNotNullExpressionValue(chatActionItem, "binding.welcomeCardUploadIcon");
            chatActionItem.setVisibility(!guildWelcomeEntry.getGuildHasIcon() && guildWelcomeEntry.isOwner() ? 0 : 8);
            this.binding.f16237f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome.onConfigure.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetServerSettingsOverview.INSTANCE.create(C1643a.m885x(view, "view", "view.context"), ((GuildWelcomeEntry) data).getGuildId(), true);
                }
            });
            ChatActionItem chatActionItem2 = this.binding.f16236e;
            C12238m.checkNotNullExpressionValue(chatActionItem2, "binding.welcomeCardInviteFriends");
            chatActionItem2.setVisibility(guildWelcomeEntry.getCanInvite() ? 0 : 8);
            this.binding.f16236e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome.onConfigure.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildInviteShare.INSTANCE.launch(C1643a.m885x(view, "view", "view.context"), WidgetChatListAdapterItemGuildWelcome.access$getAdapter$p(WidgetChatListAdapterItemGuildWelcome.this).getFragmentManager(), ((GuildWelcomeEntry) data).getGuildId(), (16 & 8) != 0 ? null : null, (16 & 16) != 0 ? false : false, (16 & 32) != 0 ? null : null, (16 & 64) != 0 ? null : null, "Welcome Message");
                }
            });
            String strM822J = C1643a.m822J(new StringBuilder(), C0862f.f507a.m149a(360045138571L, null), "?utm_source=discord&utm_medium=blog&utm_campaign=2020-06_help-new-user&utm_content=--t%3Apm");
            LinkifiedTextView linkifiedTextView = this.binding.f16235d;
            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.itemGuildWelcomeSubheaderIntro");
            C1107b.m221m(linkifiedTextView, C5419R.string.welcome_cta_subtitle_action_with_guide, new Object[]{strM822J}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
            LinkifiedTextView linkifiedTextView2 = this.binding.f16235d;
            C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.itemGuildWelcomeSubheaderIntro");
            ChatActionItem chatActionItem3 = this.binding.f16237f;
            C12238m.checkNotNullExpressionValue(chatActionItem3, "binding.welcomeCardUploadIcon");
            if (!(chatActionItem3.getVisibility() == 0)) {
                ChatActionItem chatActionItem4 = this.binding.f16236e;
                C12238m.checkNotNullExpressionValue(chatActionItem4, "binding.welcomeCardInviteFriends");
                if (!(chatActionItem4.getVisibility() == 0)) {
                    z2 = false;
                }
            }
            linkifiedTextView2.setVisibility(z2 ? 0 : 8);
            LinkifiedTextView linkifiedTextView3 = this.binding.f16234c;
            C12238m.checkNotNullExpressionValue(linkifiedTextView3, "binding.itemGuildWelcomeSubheader");
            if (z3) {
                i = C5419R.string.welcome_cta_subtitle_existing_server;
            } else {
                i = guildWelcomeEntry.isOwner() ? C5419R.string.welcome_cta_subtitle_owner : C5419R.string.welcome_cta_subtitle_member;
            }
            C1107b.m221m(linkifiedTextView3, i, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
    }
}
