package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetStageChannelPrestartDetailsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrestartDetailsViewHolder extends StageCallViewHolder {
    private final WidgetStageChannelPrestartDetailsBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrestartDetailsViewHolder(StageCallAdapter stageCallAdapter) {
        super(R$layout.widget_stage_channel_prestart_details, stageCallAdapter, null);
        m.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.subtitle;
        TextView textView = (TextView) view.findViewById(R$id.subtitle);
        if (textView != null) {
            i = 2131365869;
            TextView textView2 = (TextView) view.findViewById(2131365869);
            if (textView2 != null) {
                WidgetStageChannelPrestartDetailsBinding widgetStageChannelPrestartDetailsBinding = new WidgetStageChannelPrestartDetailsBinding((ConstraintLayout) view, textView, textView2);
                m.checkNotNullExpressionValue(widgetStageChannelPrestartDetailsBinding, "WidgetStageChannelPresta…ilsBinding.bind(itemView)");
                this.binding = widgetStageChannelPrestartDetailsBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) {
        onConfigure2(i, stageCallItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem$PreStartDetailsItem stageCallItem$PreStartDetailsItem = (StageCallItem$PreStartDetailsItem) data;
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(stageCallItem$PreStartDetailsItem.getTitle());
        TextView textView2 = this.binding.f2653b;
        m.checkNotNullExpressionValue(textView2, "binding.subtitle");
        textView2.setText(stageCallItem$PreStartDetailsItem.getSubtitle());
        boolean z2 = stageCallItem$PreStartDetailsItem.getNumSpeakers() > 0;
        boolean z3 = stageCallItem$PreStartDetailsItem.getNumAudience() > 0;
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewGroup$LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.bottomMargin = (z2 || !z3) ? DimenUtils.dpToPixels(0) : DimenUtils.dpToPixels(24);
        constraintLayout.setLayoutParams(viewGroup$MarginLayoutParams);
    }
}
