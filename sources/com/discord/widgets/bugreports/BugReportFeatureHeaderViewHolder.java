package com.discord.widgets.bugreports;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.bugreport.Feature;
import com.discord.databinding.WidgetBugReportFeatureHeaderListItemBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportFeatureHeaderViewHolder extends RecyclerView.ViewHolder {
    private final WidgetBugReportFeatureHeaderListItemBinding binding;
    private final Function1<Feature, Unit> onClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BugReportFeatureHeaderViewHolder(WidgetBugReportFeatureHeaderListItemBinding widgetBugReportFeatureHeaderListItemBinding, Function1<? super Feature, Unit> function1) {
        super(widgetBugReportFeatureHeaderListItemBinding.f15752a);
        C12238m.checkNotNullParameter(widgetBugReportFeatureHeaderListItemBinding, "binding");
        C12238m.checkNotNullParameter(function1, "onClickListener");
        this.binding = widgetBugReportFeatureHeaderListItemBinding;
        this.onClickListener = function1;
    }

    public final void bind(boolean isTop, final Feature feature) {
        C12238m.checkNotNullParameter(feature, "feature");
        View view = this.binding.f15753b;
        C12238m.checkNotNullExpressionValue(view, "binding.gap");
        view.setVisibility(isTop ^ true ? 0 : 8);
        TextView textView = this.binding.f15754c;
        C12238m.checkNotNullExpressionValue(textView, "binding.header");
        textView.setText(feature.getName());
        this.binding.f15754c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.bugreports.BugReportFeatureHeaderViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BugReportFeatureHeaderViewHolder.this.getOnClickListener().invoke(feature);
            }
        });
    }

    public final WidgetBugReportFeatureHeaderListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<Feature, Unit> getOnClickListener() {
        return this.onClickListener;
    }
}
