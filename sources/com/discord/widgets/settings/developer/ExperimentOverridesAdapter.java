package com.discord.widgets.settings.developer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.y.l0.ExperimentOverrideView2;
import b.a.y.l0.ExperimentOverrideView3;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ExperimentOverridesListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.experiments.ExperimentOverrideView;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ExperimentOverridesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExperimentOverridesAdapter extends RecyclerView.Adapter<ExperimentViewHolder> {
    private List<? extends Item> items = Collections2.emptyList();

    /* JADX INFO: compiled from: ExperimentOverridesAdapter.kt */
    public static final class ExperimentViewHolder extends RecyclerView.ViewHolder {
        private final ExperimentOverridesListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExperimentViewHolder(ExperimentOverridesListItemBinding experimentOverridesListItemBinding) {
            super(experimentOverridesListItemBinding.a);
            Intrinsics3.checkNotNullParameter(experimentOverridesListItemBinding, "binding");
            this.binding = experimentOverridesListItemBinding;
        }

        public final void bind(Item item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            ExperimentOverrideView experimentOverrideView = this.binding.f2104b;
            String name = item.getName();
            String apiName = item.getApiName();
            Integer overrideBucket = item.getOverrideBucket();
            List<String> bucketDescriptions = item.getBucketDescriptions();
            Function1<Integer, Unit> onOverrideBucketSelected = item.getOnOverrideBucketSelected();
            Function0<Unit> onOverrideBucketCleared = item.getOnOverrideBucketCleared();
            Objects.requireNonNull(experimentOverrideView);
            Intrinsics3.checkNotNullParameter(name, "experimentName");
            Intrinsics3.checkNotNullParameter(apiName, "experimentApiName");
            Intrinsics3.checkNotNullParameter(bucketDescriptions, "bucketDescriptions");
            Intrinsics3.checkNotNullParameter(onOverrideBucketSelected, "onOverrideBucketSelected");
            Intrinsics3.checkNotNullParameter(onOverrideBucketCleared, "onOverrideBucketCleared");
            TextView textView = experimentOverrideView.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.experimentOverrideExperimentName");
            textView.setText(name);
            TextView textView2 = experimentOverrideView.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.experimentOverrideExperimentApiName");
            textView2.setText(apiName);
            TextView textView3 = experimentOverrideView.binding.f133b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.experimentOverrideBucketDescriptions");
            textView3.setText(_Collections.joinToString$default(bucketDescriptions, "\n", null, null, 0, null, null, 62, null));
            ArrayList arrayList = new ArrayList();
            if (overrideBucket == null) {
                arrayList.add(new ExperimentOverrideView.b(null, "Select..."));
            }
            int size = bucketDescriptions.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new ExperimentOverrideView.b(Integer.valueOf(i), outline.q("Bucket ", i)));
            }
            Spinner spinner = experimentOverrideView.binding.c;
            Intrinsics3.checkNotNullExpressionValue(spinner, "binding.experimentOverrideBucketsSpinner");
            Context context = experimentOverrideView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            spinner.setAdapter((SpinnerAdapter) new ExperimentOverrideView.a(context, arrayList));
            if (overrideBucket != null) {
                experimentOverrideView.binding.c.setSelection(overrideBucket.intValue());
            }
            Spinner spinner2 = experimentOverrideView.binding.c;
            Intrinsics3.checkNotNullExpressionValue(spinner2, "binding.experimentOverrideBucketsSpinner");
            spinner2.setOnItemSelectedListener(new ExperimentOverrideView2(onOverrideBucketSelected));
            experimentOverrideView.binding.d.setOnClickListener(new ExperimentOverrideView3(onOverrideBucketCleared));
            TextView textView4 = experimentOverrideView.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.experimentOverrideClear");
            textView4.setVisibility(overrideBucket != null ? 0 : 8);
        }
    }

    /* JADX INFO: compiled from: ExperimentOverridesAdapter.kt */
    public interface Item {
        String getApiName();

        List<String> getBucketDescriptions();

        String getName();

        Function0<Unit> getOnOverrideBucketCleared();

        Function1<Integer, Unit> getOnOverrideBucketSelected();

        Integer getOverrideBucket();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    public final void setData(List<? extends Item> items) {
        Intrinsics3.checkNotNullParameter(items, "items");
        this.items = items;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ExperimentViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ExperimentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.experiment_overrides_list_item, parent, false);
        ExperimentOverrideView experimentOverrideView = (ExperimentOverrideView) viewInflate.findViewById(R.id.experiment_overrides_list_item_experiment_override_view);
        if (experimentOverrideView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.experiment_overrides_list_item_experiment_override_view)));
        }
        ExperimentOverridesListItemBinding experimentOverridesListItemBinding = new ExperimentOverridesListItemBinding((CardView) viewInflate, experimentOverrideView);
        Intrinsics3.checkNotNullExpressionValue(experimentOverridesListItemBinding, "ExperimentOverridesListI….context), parent, false)");
        return new ExperimentViewHolder(experimentOverridesListItemBinding);
    }
}
