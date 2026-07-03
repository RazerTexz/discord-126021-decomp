package com.discord.widgets.chat.input.applicationcommands;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.ViewAppcommandsOptionheadingListitemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SelectedApplicationCommandAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectedAppCommandSectionHeadingAdapterItem extends MGRecyclerViewHolder<SelectedApplicationCommandAdapter, SelectedApplicationCommandItem> {
    private final ViewAppcommandsOptionheadingListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedAppCommandSectionHeadingAdapterItem(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter) {
        super(C5419R.layout.view_appcommands_optionheading_listitem, selectedApplicationCommandAdapter);
        C12238m.checkNotNullParameter(selectedApplicationCommandAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.appcommands_optionheading_title;
        TextView textView = (TextView) view.findViewById(C5419R.id.appcommands_optionheading_title);
        if (textView != null) {
            i = C5419R.id.divider;
            View viewFindViewById = view.findViewById(C5419R.id.divider);
            if (viewFindViewById != null) {
                ViewAppcommandsOptionheadingListitemBinding viewAppcommandsOptionheadingListitemBinding = new ViewAppcommandsOptionheadingListitemBinding((ConstraintLayout) view, textView, viewFindViewById);
                C12238m.checkNotNullExpressionValue(viewAppcommandsOptionheadingListitemBinding, "ViewAppcommandsOptionhea…temBinding.bind(itemView)");
                this.binding = viewAppcommandsOptionheadingListitemBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, SelectedApplicationCommandItem data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f15368b;
        C12238m.checkNotNullExpressionValue(textView, "binding.appcommandsOptionheadingTitle");
        textView.setText(data.getHeading());
    }
}
