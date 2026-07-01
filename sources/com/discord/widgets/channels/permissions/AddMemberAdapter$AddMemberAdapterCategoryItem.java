package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetChannelSettingsAddMemberCategoryBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: AddMemberAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddMemberAdapter$AddMemberAdapterCategoryItem extends MGRecyclerViewHolder<AddMemberAdapter, AddMemberAdapter$Item> {
    private final WidgetChannelSettingsAddMemberCategoryBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddMemberAdapter$AddMemberAdapterCategoryItem(AddMemberAdapter addMemberAdapter) {
        super(R$layout.widget_channel_settings_add_member_category, addMemberAdapter);
        m.checkNotNullParameter(addMemberAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.label);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.label)));
        }
        WidgetChannelSettingsAddMemberCategoryBinding widgetChannelSettingsAddMemberCategoryBinding = new WidgetChannelSettingsAddMemberCategoryBinding((LinearLayout) view, textView);
        m.checkNotNullExpressionValue(widgetChannelSettingsAddMemberCategoryBinding, "WidgetChannelSettingsAdd…oryBinding.bind(itemView)");
        this.binding = widgetChannelSettingsAddMemberCategoryBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, AddMemberAdapter$Item addMemberAdapter$Item) {
        onConfigure2(i, addMemberAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, AddMemberAdapter$Item data) {
        String string;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f2270b;
        m.checkNotNullExpressionValue(textView, "binding.label");
        int iOrdinal = ((AddMemberAdapter$Item$CategoryItem) data).getCategoryType().ordinal();
        if (iOrdinal == 0) {
            string = ((AddMemberAdapter) this.adapter).getRecycler().getContext().getString(2131895161);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            string = ((AddMemberAdapter) this.adapter).getRecycler().getContext().getString(2131892934);
        }
        textView.setText(string);
    }
}
