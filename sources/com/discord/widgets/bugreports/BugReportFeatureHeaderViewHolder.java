package com.discord.widgets.bugreports;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.bugreport.BugReportConfig2;
import com.discord.databinding.WidgetBugReportFeatureHeaderListItemBinding;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportFeatureHeaderViewHolder extends RecyclerView.ViewHolder {
    private final WidgetBugReportFeatureHeaderListItemBinding binding;
    private final Function1<BugReportConfig2, Unit> onClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BugReportFeatureHeaderViewHolder(WidgetBugReportFeatureHeaderListItemBinding widgetBugReportFeatureHeaderListItemBinding, Function1<? super BugReportConfig2, Unit> function1) {
        super(widgetBugReportFeatureHeaderListItemBinding.a);
        Intrinsics3.checkNotNullParameter(widgetBugReportFeatureHeaderListItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        this.binding = widgetBugReportFeatureHeaderListItemBinding;
        this.onClickListener = function1;
    }

    public final void bind(boolean isTop, final BugReportConfig2 feature) {
        Intrinsics3.checkNotNullParameter(feature, "feature");
        View view = this.binding.f2243b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.gap");
        view.setVisibility(isTop ^ true ? 0 : 8);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.header");
        textView.setText(feature.getName());
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.bugreports.BugReportFeatureHeaderViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BugReportFeatureHeaderViewHolder.this.getOnClickListener().invoke(feature);
            }
        });
    }

    public final WidgetBugReportFeatureHeaderListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<BugReportConfig2, Unit> getOnClickListener() {
        return this.onClickListener;
    }
}
