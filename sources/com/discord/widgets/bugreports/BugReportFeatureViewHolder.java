package com.discord.widgets.bugreports;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.bugreport.Feature;
import com.discord.databinding.WidgetBugReportFeatureListItemBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportFeatureViewHolder extends RecyclerView.ViewHolder {
    private final WidgetBugReportFeatureListItemBinding binding;
    private final Function1<Feature, Unit> onClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BugReportFeatureViewHolder(WidgetBugReportFeatureListItemBinding widgetBugReportFeatureListItemBinding, Function1<? super Feature, Unit> function1) {
        super(widgetBugReportFeatureListItemBinding.f15755a);
        C12238m.checkNotNullParameter(widgetBugReportFeatureListItemBinding, "binding");
        C12238m.checkNotNullParameter(function1, "onClickListener");
        this.binding = widgetBugReportFeatureListItemBinding;
        this.onClickListener = function1;
    }

    public final void bind(final Feature data) {
        C12238m.checkNotNullParameter(data, "data");
        TextView textView = this.binding.f15756b;
        C12238m.checkNotNullExpressionValue(textView, "binding.featureListItemFeature");
        textView.setText(data.getName());
        TextView textView2 = this.binding.f15757c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.featureListItemSquad");
        textView2.setText(data.getSquad());
        this.binding.f15755a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.bugreports.BugReportFeatureViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BugReportFeatureViewHolder.this.getOnClickListener().invoke(data);
            }
        });
    }

    public final WidgetBugReportFeatureListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<Feature, Unit> getOnClickListener() {
        return this.onClickListener;
    }
}
