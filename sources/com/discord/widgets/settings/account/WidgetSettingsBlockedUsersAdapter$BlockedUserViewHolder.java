package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsItemBlockedUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder extends MGRecyclerViewHolder<WidgetSettingsBlockedUsersAdapter, WidgetSettingsBlockedUsersViewModel$Item> {
    private final WidgetSettingsItemBlockedUserBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder(@LayoutRes int i, WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter) {
        super(i, widgetSettingsBlockedUsersAdapter);
        m.checkNotNullParameter(widgetSettingsBlockedUsersAdapter, "adapter");
        View view = this.itemView;
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i2 = R$id.blocked_user_item_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.blocked_user_item_avatar);
        if (simpleDraweeView != null) {
            i2 = R$id.blocked_user_item_name;
            TextView textView = (TextView) view.findViewById(R$id.blocked_user_item_name);
            if (textView != null) {
                i2 = R$id.unblock_user_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.unblock_user_button);
                if (materialButton != null) {
                    WidgetSettingsItemBlockedUserBinding widgetSettingsItemBlockedUserBinding = new WidgetSettingsItemBlockedUserBinding((RelativeLayout) view, relativeLayout, simpleDraweeView, textView, materialButton);
                    m.checkNotNullExpressionValue(widgetSettingsItemBlockedUserBinding, "WidgetSettingsItemBlocke…serBinding.bind(itemView)");
                    this.binding = widgetSettingsItemBlockedUserBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetSettingsBlockedUsersAdapter access$getAdapter$p(WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder widgetSettingsBlockedUsersAdapter$BlockedUserViewHolder) {
        return (WidgetSettingsBlockedUsersAdapter) widgetSettingsBlockedUsersAdapter$BlockedUserViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetSettingsBlockedUsersViewModel$Item widgetSettingsBlockedUsersViewModel$Item) {
        onConfigure2(i, widgetSettingsBlockedUsersViewModel$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetSettingsBlockedUsersViewModel$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.binding.a.setOnClickListener(new WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder$onConfigure$1(this, data));
        SimpleDraweeView simpleDraweeView = this.binding.f2625b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.blockedUserItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, data.getUser(), 2131165300, null, null, null, 56, null);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.blockedUserItemName");
        textView.setText(data.getUser().getUsername());
        this.binding.d.setOnClickListener(new WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder$onConfigure$2(this, data));
    }
}
