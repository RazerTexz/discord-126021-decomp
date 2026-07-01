package com.discord.widgets.chat.managereactions;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetManageReactionsResultErrorBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsResultsAdapter$ErrorViewHolder extends MGRecyclerViewHolder<ManageReactionsResultsAdapter, MGRecyclerDataPayload> {
    private final WidgetManageReactionsResultErrorBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsResultsAdapter$ErrorViewHolder(ManageReactionsResultsAdapter manageReactionsResultsAdapter) {
        super(R$layout.widget_manage_reactions_result_error, manageReactionsResultsAdapter);
        m.checkNotNullParameter(manageReactionsResultsAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.manage_reactions_result_error_img;
        ImageView imageView = (ImageView) view.findViewById(R$id.manage_reactions_result_error_img);
        if (imageView != null) {
            i = R$id.manage_reactions_result_error_text;
            TextView textView = (TextView) view.findViewById(R$id.manage_reactions_result_error_text);
            if (textView != null) {
                WidgetManageReactionsResultErrorBinding widgetManageReactionsResultErrorBinding = new WidgetManageReactionsResultErrorBinding((RelativeLayout) view, imageView, textView);
                m.checkNotNullExpressionValue(widgetManageReactionsResultErrorBinding, "WidgetManageReactionsRes…rorBinding.bind(itemView)");
                this.binding = widgetManageReactionsResultErrorBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.binding.f2484b.setOnClickListener(new ManageReactionsResultsAdapter$ErrorViewHolder$onConfigure$1(data));
    }
}
