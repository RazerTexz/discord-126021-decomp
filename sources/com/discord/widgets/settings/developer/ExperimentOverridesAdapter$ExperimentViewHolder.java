package com.discord.widgets.settings.developer;

import android.content.Context;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.a.y.l0.b;
import b.d.b.a.a;
import com.discord.databinding.ExperimentOverridesListItemBinding;
import com.discord.views.experiments.ExperimentOverrideView;
import com.discord.views.experiments.ExperimentOverrideView$a;
import com.discord.views.experiments.ExperimentOverrideView$b;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ExperimentOverridesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExperimentOverridesAdapter$ExperimentViewHolder extends RecyclerView$ViewHolder {
    private final ExperimentOverridesListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperimentOverridesAdapter$ExperimentViewHolder(ExperimentOverridesListItemBinding experimentOverridesListItemBinding) {
        super(experimentOverridesListItemBinding.a);
        m.checkNotNullParameter(experimentOverridesListItemBinding, "binding");
        this.binding = experimentOverridesListItemBinding;
    }

    public final void bind(ExperimentOverridesAdapter$Item item) {
        m.checkNotNullParameter(item, "item");
        ExperimentOverrideView experimentOverrideView = this.binding.f2104b;
        String name = item.getName();
        String apiName = item.getApiName();
        Integer overrideBucket = item.getOverrideBucket();
        List<String> bucketDescriptions = item.getBucketDescriptions();
        Function1<Integer, Unit> onOverrideBucketSelected = item.getOnOverrideBucketSelected();
        Function0<Unit> onOverrideBucketCleared = item.getOnOverrideBucketCleared();
        Objects.requireNonNull(experimentOverrideView);
        m.checkNotNullParameter(name, "experimentName");
        m.checkNotNullParameter(apiName, "experimentApiName");
        m.checkNotNullParameter(bucketDescriptions, "bucketDescriptions");
        m.checkNotNullParameter(onOverrideBucketSelected, "onOverrideBucketSelected");
        m.checkNotNullParameter(onOverrideBucketCleared, "onOverrideBucketCleared");
        TextView textView = experimentOverrideView.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.experimentOverrideExperimentName");
        textView.setText(name);
        TextView textView2 = experimentOverrideView.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.experimentOverrideExperimentApiName");
        textView2.setText(apiName);
        TextView textView3 = experimentOverrideView.binding.f133b;
        m.checkNotNullExpressionValue(textView3, "binding.experimentOverrideBucketDescriptions");
        textView3.setText(u.joinToString$default(bucketDescriptions, "\n", null, null, 0, null, null, 62, null));
        ArrayList arrayList = new ArrayList();
        if (overrideBucket == null) {
            arrayList.add(new ExperimentOverrideView$b(null, "Select..."));
        }
        int size = bucketDescriptions.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new ExperimentOverrideView$b(Integer.valueOf(i), a.q("Bucket ", i)));
        }
        Spinner spinner = experimentOverrideView.binding.c;
        m.checkNotNullExpressionValue(spinner, "binding.experimentOverrideBucketsSpinner");
        Context context = experimentOverrideView.getContext();
        m.checkNotNullExpressionValue(context, "context");
        spinner.setAdapter((SpinnerAdapter) new ExperimentOverrideView$a(context, arrayList));
        if (overrideBucket != null) {
            experimentOverrideView.binding.c.setSelection(overrideBucket.intValue());
        }
        Spinner spinner2 = experimentOverrideView.binding.c;
        m.checkNotNullExpressionValue(spinner2, "binding.experimentOverrideBucketsSpinner");
        spinner2.setOnItemSelectedListener(new b.a.y.l0.a(onOverrideBucketSelected));
        experimentOverrideView.binding.d.setOnClickListener(new b(onOverrideBucketCleared));
        TextView textView4 = experimentOverrideView.binding.d;
        m.checkNotNullExpressionValue(textView4, "binding.experimentOverrideClear");
        textView4.setVisibility(overrideBucket != null ? 0 : 8);
    }
}
