package com.discord.widgets.servers;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.user.User;
import com.discord.databinding.WidgetServerSettingsBanListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelBan;
import com.discord.models.user.CoreUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Adapter$BanListItem extends MGRecyclerViewHolder<WidgetServerSettingsBans$Adapter, WidgetServerSettingsBans$Model$BanItem> {
    private final WidgetServerSettingsBanListItemBinding binding;
    public final /* synthetic */ WidgetServerSettingsBans$Adapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsBans$Adapter$BanListItem(WidgetServerSettingsBans$Adapter widgetServerSettingsBans$Adapter, WidgetServerSettingsBans$Adapter widgetServerSettingsBans$Adapter2) {
        super(R$layout.widget_server_settings_ban_list_item, widgetServerSettingsBans$Adapter2);
        m.checkNotNullParameter(widgetServerSettingsBans$Adapter2, "adapter");
        this.this$0 = widgetServerSettingsBans$Adapter;
        View view = this.itemView;
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R$id.ban_list_item_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.ban_list_item_avatar);
        if (simpleDraweeView != null) {
            i = R$id.ban_list_item_name;
            TextView textView = (TextView) view.findViewById(R$id.ban_list_item_name);
            if (textView != null) {
                WidgetServerSettingsBanListItemBinding widgetServerSettingsBanListItemBinding = new WidgetServerSettingsBanListItemBinding((RelativeLayout) view, relativeLayout, simpleDraweeView, textView);
                m.checkNotNullExpressionValue(widgetServerSettingsBanListItemBinding, "WidgetServerSettingsBanL…temBinding.bind(itemView)");
                this.binding = widgetServerSettingsBanListItemBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetServerSettingsBans$Adapter access$getAdapter$p(WidgetServerSettingsBans$Adapter$BanListItem widgetServerSettingsBans$Adapter$BanListItem) {
        return (WidgetServerSettingsBans$Adapter) widgetServerSettingsBans$Adapter$BanListItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetServerSettingsBans$Model$BanItem widgetServerSettingsBans$Model$BanItem) {
        onConfigure2(i, widgetServerSettingsBans$Model$BanItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetServerSettingsBans$Model$BanItem data) {
        User user;
        User user2;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.banListItemName");
        ModelBan ban = data.getBan();
        CoreUser coreUser = null;
        textView.setText((ban == null || (user2 = ban.getUser()) == null) ? null : user2.getUsername());
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.banListItemAvatar");
        ModelBan ban2 = data.getBan();
        if (ban2 != null && (user = ban2.getUser()) != null) {
            coreUser = new CoreUser(user);
        }
        IconUtils.setIcon$default(simpleDraweeView, coreUser, 2131165300, null, null, null, 56, null);
        this.binding.f2543b.setOnClickListener(new WidgetServerSettingsBans$Adapter$BanListItem$onConfigure$2(this, data));
    }
}
