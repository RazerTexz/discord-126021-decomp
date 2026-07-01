package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.WidgetChatListAdapterItemPrivateChannelStartBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.views.PileView;
import com.discord.views.PileView$c;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StartOfPrivateChatEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemPrivateChannelStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemPrivateChannelStart extends WidgetChatListItem {
    private final WidgetChatListAdapterItemPrivateChannelStartBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemPrivateChannelStart(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_private_channel_start, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.chat_list_adapter_item_private_channel_start_header;
        TextView textView = (TextView) view.findViewById(R$id.chat_list_adapter_item_private_channel_start_header);
        if (textView != null) {
            i = R$id.mutual_guild_pile;
            PileView pileView = (PileView) view.findViewById(R$id.mutual_guild_pile);
            if (pileView != null) {
                i = R$id.mutual_guilds;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.mutual_guilds);
                if (linearLayout != null) {
                    i = R$id.mutual_guilds_text;
                    TextView textView2 = (TextView) view.findViewById(R$id.mutual_guilds_text);
                    if (textView2 != null) {
                        i = R$id.private_channel_start_image;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.private_channel_start_image);
                        if (simpleDraweeView != null) {
                            i = R$id.private_channel_start_text;
                            TextView textView3 = (TextView) view.findViewById(R$id.private_channel_start_text);
                            if (textView3 != null) {
                                WidgetChatListAdapterItemPrivateChannelStartBinding widgetChatListAdapterItemPrivateChannelStartBinding = new WidgetChatListAdapterItemPrivateChannelStartBinding((LinearLayout) view, textView, pileView, linearLayout, textView2, simpleDraweeView, textView3);
                                m.checkNotNullExpressionValue(widgetChatListAdapterItemPrivateChannelStartBinding, "WidgetChatListAdapterIte…artBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemPrivateChannelStartBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @StringRes
    private final int getStartResId(int channelType) {
        return (channelType == 1 || channelType != 3) ? 2131887021 : 2131887022;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        CharSequence charSequenceJ;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StartOfPrivateChatEntry startOfPrivateChatEntry = (StartOfPrivateChatEntry) data;
        String channelName = startOfPrivateChatEntry.getChannelName();
        int channelType = startOfPrivateChatEntry.getChannelType();
        String channelIcon = startOfPrivateChatEntry.getChannelIcon();
        boolean isSystemDM = startOfPrivateChatEntry.getIsSystemDM();
        List<Guild> listComponent6 = startOfPrivateChatEntry.component6();
        if (!(!t.isBlank(channelName))) {
            TextView textView = this.binding.f2328b;
            m.checkNotNullExpressionValue(textView, "binding.chatListAdapterI…PrivateChannelStartHeader");
            channelName = textView.getContext().getString(2131896595);
            m.checkNotNullExpressionValue(channelName, "binding.chatListAdapterI…tString(R.string.unnamed)");
        }
        TextView textView2 = this.binding.f2328b;
        m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterI…PrivateChannelStartHeader");
        textView2.setText(channelName);
        if (channelIcon != null) {
            SimpleDraweeView simpleDraweeView = this.binding.f;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.privateChannelStartImage");
            IconUtils.setIcon$default(simpleDraweeView, channelIcon, 2131165302, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = this.binding.f;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.privateChannelStartImage");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON, 2131165302, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
        }
        if (isSystemDM) {
            this.binding.g.setText(2131896164);
        } else {
            TextView textView3 = this.binding.g;
            m.checkNotNullExpressionValue(textView3, "binding.privateChannelStartText");
            b.n(textView3, getStartResId(channelType), new Object[]{channelName}, null, 4);
        }
        boolean z2 = !isSystemDM && channelType == 1;
        LinearLayout linearLayout = this.binding.d;
        m.checkNotNullExpressionValue(linearLayout, "binding.mutualGuilds");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            PileView pileView = this.binding.c;
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listComponent6, 10));
            for (Guild guild : listComponent6) {
                arrayList.add(new PileView$c(new WidgetChatListAdapterItemPrivateChannelStart$onConfigure$1$1(IconUtils.getForGuild$default(guild, null, false, Integer.valueOf(DimenUtils.dpToPixels(24)), 2, null)), new WidgetChatListAdapterItemPrivateChannelStart$onConfigure$1$2(guild)));
            }
            pileView.setItems(arrayList);
            TextView textView4 = this.binding.e;
            m.checkNotNullExpressionValue(textView4, "binding.mutualGuildsText");
            if (!listComponent6.isEmpty()) {
                charSequenceJ = StringResourceUtilsKt.getI18nPluralString(a.I(this.binding.e, "binding.mutualGuildsText", "binding.mutualGuildsText.context"), R$plurals.user_profile_mutual_guilds_count, listComponent6.size(), Integer.valueOf(listComponent6.size()));
            } else {
                TextView textView5 = this.binding.e;
                m.checkNotNullExpressionValue(textView5, "binding.mutualGuildsText");
                charSequenceJ = b.j(textView5, 2131893269, new Object[0], null, 4);
            }
            textView4.setText(charSequenceJ);
        }
    }
}
