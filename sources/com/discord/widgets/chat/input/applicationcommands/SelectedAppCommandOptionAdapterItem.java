package com.discord.widgets.chat.input.applicationcommands;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ViewAppcommandsOptionparamListitemBinding;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: SelectedApplicationCommandAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectedAppCommandOptionAdapterItem extends MGRecyclerViewHolder<SelectedApplicationCommandAdapter, SelectedApplicationCommandItem> {
    private final ViewAppcommandsOptionparamListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedAppCommandOptionAdapterItem(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter) {
        super(R$layout.view_appcommands_optionparam_listitem, selectedApplicationCommandAdapter);
        m.checkNotNullParameter(selectedApplicationCommandAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.appcommands_optiontitle_title);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.appcommands_optiontitle_title)));
        }
        ViewAppcommandsOptionparamListitemBinding viewAppcommandsOptionparamListitemBinding = new ViewAppcommandsOptionparamListitemBinding((FrameLayout) view, textView);
        m.checkNotNullExpressionValue(viewAppcommandsOptionparamListitemBinding, "ViewAppcommandsOptionpar…temBinding.bind(itemView)");
        this.binding = viewAppcommandsOptionparamListitemBinding;
    }

    public static final /* synthetic */ SelectedApplicationCommandAdapter access$getAdapter$p(SelectedAppCommandOptionAdapterItem selectedAppCommandOptionAdapterItem) {
        return (SelectedApplicationCommandAdapter) selectedAppCommandOptionAdapterItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, SelectedApplicationCommandItem selectedApplicationCommandItem) {
        onConfigure2(i, selectedApplicationCommandItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, SelectedApplicationCommandItem data) {
        int themedColor;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ApplicationCommandOption option = data.getOption();
        if (option != null) {
            TextView textView = this.binding.f2172b;
            m.checkNotNullExpressionValue(textView, "binding.appcommandsOptiontitleTitle");
            textView.setText(option.getName());
            int i = data.getHighlighted() ? 2131231107 : 2131231108;
            if (data.getHighlighted()) {
                TextView textView2 = this.binding.f2172b;
                m.checkNotNullExpressionValue(textView2, "binding.appcommandsOptiontitleTitle");
                themedColor = ColorCompat.getThemedColor(textView2, 2130968989);
            } else if (data.getError()) {
                TextView textView3 = this.binding.f2172b;
                m.checkNotNullExpressionValue(textView3, "binding.appcommandsOptiontitleTitle");
                themedColor = ColorCompat.getColor(textView3, 2131100382);
            } else {
                TextView textView4 = this.binding.f2172b;
                m.checkNotNullExpressionValue(textView4, "binding.appcommandsOptiontitleTitle");
                themedColor = ColorCompat.getThemedColor(textView4, 2130968989);
            }
            if (!data.getCompleted() || data.getHighlighted()) {
                TextView textView5 = this.binding.f2172b;
                m.checkNotNullExpressionValue(textView5, "binding.appcommandsOptiontitleTitle");
                textView5.setAlpha(1.0f);
            } else {
                TextView textView6 = this.binding.f2172b;
                m.checkNotNullExpressionValue(textView6, "binding.appcommandsOptiontitleTitle");
                textView6.setAlpha(0.5f);
            }
            this.binding.f2172b.setBackgroundResource(i);
            this.binding.f2172b.setTextColor(themedColor);
            this.itemView.setOnClickListener(new SelectedAppCommandOptionAdapterItem$onConfigure$$inlined$let$lambda$1(option, this, data));
        }
    }
}
