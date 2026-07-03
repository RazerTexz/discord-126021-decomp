package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemPrivateChannelStartBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.views.PileView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StartOfPrivateChatEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemPrivateChannelStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemPrivateChannelStart extends WidgetChatListItem {
    private final WidgetChatListAdapterItemPrivateChannelStartBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemPrivateChannelStart(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_private_channel_start, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_private_channel_start_header;
        TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_private_channel_start_header);
        if (textView != null) {
            i = C5419R.id.mutual_guild_pile;
            PileView pileView = (PileView) view.findViewById(C5419R.id.mutual_guild_pile);
            if (pileView != null) {
                i = C5419R.id.mutual_guilds;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.mutual_guilds);
                if (linearLayout != null) {
                    i = C5419R.id.mutual_guilds_text;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.mutual_guilds_text);
                    if (textView2 != null) {
                        i = C5419R.id.private_channel_start_image;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.private_channel_start_image);
                        if (simpleDraweeView != null) {
                            i = C5419R.id.private_channel_start_text;
                            TextView textView3 = (TextView) view.findViewById(C5419R.id.private_channel_start_text);
                            if (textView3 != null) {
                                WidgetChatListAdapterItemPrivateChannelStartBinding widgetChatListAdapterItemPrivateChannelStartBinding = new WidgetChatListAdapterItemPrivateChannelStartBinding((LinearLayout) view, textView, pileView, linearLayout, textView2, simpleDraweeView, textView3);
                                C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemPrivateChannelStartBinding, "WidgetChatListAdapterIte…artBinding.bind(itemView)");
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
        return (channelType == 1 || channelType != 3) ? C5419R.string.beginning_dm : C5419R.string.beginning_group_dm;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        CharSequence charSequenceM212d;
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StartOfPrivateChatEntry startOfPrivateChatEntry = (StartOfPrivateChatEntry) data;
        String strComponent2 = startOfPrivateChatEntry.getChannelName();
        int iComponent3 = startOfPrivateChatEntry.getChannelType();
        String strComponent4 = startOfPrivateChatEntry.getChannelIcon();
        boolean zComponent5 = startOfPrivateChatEntry.getIsSystemDM();
        List<Guild> listComponent6 = startOfPrivateChatEntry.component6();
        if (!(!C12103t.isBlank(strComponent2))) {
            TextView textView = this.binding.f16262b;
            C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterI…PrivateChannelStartHeader");
            strComponent2 = textView.getContext().getString(C5419R.string.unnamed);
            C12238m.checkNotNullExpressionValue(strComponent2, "binding.chatListAdapterI…tString(R.string.unnamed)");
        }
        TextView textView2 = this.binding.f16262b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterI…PrivateChannelStartHeader");
        textView2.setText(strComponent2);
        if (strComponent4 != null) {
            SimpleDraweeView simpleDraweeView = this.binding.f16266f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.privateChannelStartImage");
            IconUtils.setIcon$default(simpleDraweeView, strComponent4, C5419R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = this.binding.f16266f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.privateChannelStartImage");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON, C5419R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        }
        if (zComponent5) {
            this.binding.f16267g.setText(C5419R.string.system_dm_empty_message);
        } else {
            TextView textView3 = this.binding.f16267g;
            C12238m.checkNotNullExpressionValue(textView3, "binding.privateChannelStartText");
            C1107b.m221m(textView3, getStartResId(iComponent3), new Object[]{strComponent2}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
        boolean z2 = !zComponent5 && iComponent3 == 1;
        LinearLayout linearLayout = this.binding.f16264d;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.mutualGuilds");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            PileView pileView = this.binding.f16263c;
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listComponent6, 10));
            for (Guild guild : listComponent6) {
                arrayList.add(new PileView.C7089c(new WidgetChatListAdapterItemPrivateChannelStart$onConfigure$1$1(IconUtils.getForGuild$default(guild, null, false, Integer.valueOf(DimenUtils.dpToPixels(24)), 2, null)), new WidgetChatListAdapterItemPrivateChannelStart$onConfigure$1$2(guild)));
            }
            pileView.setItems(arrayList);
            TextView textView4 = this.binding.f16265e;
            C12238m.checkNotNullExpressionValue(textView4, "binding.mutualGuildsText");
            if (!listComponent6.isEmpty()) {
                charSequenceM212d = StringResourceUtilsKt.getI18nPluralString(C1643a.m821I(this.binding.f16265e, "binding.mutualGuildsText", "binding.mutualGuildsText.context"), C5419R.plurals.user_profile_mutual_guilds_count, listComponent6.size(), Integer.valueOf(listComponent6.size()));
            } else {
                TextView textView5 = this.binding.f16265e;
                C12238m.checkNotNullExpressionValue(textView5, "binding.mutualGuildsText");
                charSequenceM212d = C1107b.m212d(textView5, C5419R.string.no_mutual_guilds, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
            }
            textView4.setText(charSequenceM212d);
        }
    }
}
