package com.discord.widgets.voice.fullscreen.stage;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageChannelAudienceRoleBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.locale.LocaleManager;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import java.text.NumberFormat;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudienceHeaderViewHolder extends StageCallViewHolder {
    private final WidgetStageChannelAudienceRoleBinding binding;
    private final NumberFormat numberFormatter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudienceHeaderViewHolder(StageCallAdapter stageCallAdapter) {
        super(C5419R.layout.widget_stage_channel_audience_role, stageCallAdapter, null);
        C12238m.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C5419R.id.stage_channel_audience_role_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.stage_channel_audience_role_text)));
        }
        WidgetStageChannelAudienceRoleBinding widgetStageChannelAudienceRoleBinding = new WidgetStageChannelAudienceRoleBinding((ConstraintLayout) view, textView);
        C12238m.checkNotNullExpressionValue(widgetStageChannelAudienceRoleBinding, "WidgetStageChannelAudien…oleBinding.bind(itemView)");
        this.binding = widgetStageChannelAudienceRoleBinding;
        LocaleManager localeManager = new LocaleManager();
        View view2 = this.itemView;
        C12238m.checkNotNullExpressionValue(view2, "itemView");
        this.numberFormatter = NumberFormat.getNumberInstance(localeManager.getPrimaryLocale(view2.getContext()));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    @SuppressLint({"SetTextI18n"})
    public void onConfigure(int position, StageCallItem data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        String str = this.numberFormatter.format(Integer.valueOf(((StageCallItem.AudienceHeaderItem) data).getAudienceSize()));
        TextView textView = this.binding.f18138b;
        C12238m.checkNotNullExpressionValue(textView, "binding.stageChannelAudienceRoleText");
        C1107b.m221m(textView, C5419R.string.audience_section_header, new Object[]{str}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }
}
