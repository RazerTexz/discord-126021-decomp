package com.discord.widgets.bugreports;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.api.bugreport.Feature;
import com.discord.databinding.WidgetBugReportFeatureListItemBinding;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportFeatureViewHolder extends RecyclerView$ViewHolder {
    private final WidgetBugReportFeatureListItemBinding binding;
    private final Function1<Feature, Unit> onClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BugReportFeatureViewHolder(WidgetBugReportFeatureListItemBinding widgetBugReportFeatureListItemBinding, Function1<? super Feature, Unit> function1) {
        super(widgetBugReportFeatureListItemBinding.a);
        m.checkNotNullParameter(widgetBugReportFeatureListItemBinding, "binding");
        m.checkNotNullParameter(function1, "onClickListener");
        this.binding = widgetBugReportFeatureListItemBinding;
        this.onClickListener = function1;
    }

    public final void bind(Feature data) {
        m.checkNotNullParameter(data, "data");
        TextView textView = this.binding.f2244b;
        m.checkNotNullExpressionValue(textView, "binding.featureListItemFeature");
        textView.setText(data.getName());
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.featureListItemSquad");
        textView2.setText(data.getSquad());
        this.binding.a.setOnClickListener(new BugReportFeatureViewHolder$bind$1(this, data));
    }

    public final WidgetBugReportFeatureListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<Feature, Unit> getOnClickListener() {
        return this.onClickListener;
    }
}
