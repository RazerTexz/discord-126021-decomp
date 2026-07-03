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
import com.discord.C5419R;
import com.discord.databinding.ExperimentOverridesListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.experiments.ExperimentOverrideView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p062y.p065l0.C1357a;
import p007b.p008a.p062y.p065l0.ViewOnClickListenerC1358b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ExperimentOverridesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExperimentOverridesAdapter extends RecyclerView.Adapter<ExperimentViewHolder> {
    private List<? extends Item> items = C12147n.emptyList();

    /* JADX INFO: compiled from: ExperimentOverridesAdapter.kt */
    public static final class ExperimentViewHolder extends RecyclerView.ViewHolder {
        private final ExperimentOverridesListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExperimentViewHolder(ExperimentOverridesListItemBinding experimentOverridesListItemBinding) {
            super(experimentOverridesListItemBinding.f15063a);
            C12238m.checkNotNullParameter(experimentOverridesListItemBinding, "binding");
            this.binding = experimentOverridesListItemBinding;
        }

        public final void bind(Item item) {
            C12238m.checkNotNullParameter(item, "item");
            ExperimentOverrideView experimentOverrideView = this.binding.f15064b;
            String name = item.getName();
            String apiName = item.getApiName();
            Integer overrideBucket = item.getOverrideBucket();
            List<String> bucketDescriptions = item.getBucketDescriptions();
            Function1<Integer, Unit> onOverrideBucketSelected = item.getOnOverrideBucketSelected();
            Function0<Unit> onOverrideBucketCleared = item.getOnOverrideBucketCleared();
            Objects.requireNonNull(experimentOverrideView);
            C12238m.checkNotNullParameter(name, "experimentName");
            C12238m.checkNotNullParameter(apiName, "experimentApiName");
            C12238m.checkNotNullParameter(bucketDescriptions, "bucketDescriptions");
            C12238m.checkNotNullParameter(onOverrideBucketSelected, "onOverrideBucketSelected");
            C12238m.checkNotNullParameter(onOverrideBucketCleared, "onOverrideBucketCleared");
            TextView textView = experimentOverrideView.binding.f951f;
            C12238m.checkNotNullExpressionValue(textView, "binding.experimentOverrideExperimentName");
            textView.setText(name);
            TextView textView2 = experimentOverrideView.binding.f950e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.experimentOverrideExperimentApiName");
            textView2.setText(apiName);
            TextView textView3 = experimentOverrideView.binding.f947b;
            C12238m.checkNotNullExpressionValue(textView3, "binding.experimentOverrideBucketDescriptions");
            textView3.setText(C12163u.joinToString$default(bucketDescriptions, "\n", null, null, 0, null, null, 62, null));
            ArrayList arrayList = new ArrayList();
            if (overrideBucket == null) {
                arrayList.add(new ExperimentOverrideView.C7113b(null, "Select..."));
            }
            int size = bucketDescriptions.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new ExperimentOverrideView.C7113b(Integer.valueOf(i), C1643a.m871q("Bucket ", i)));
            }
            Spinner spinner = experimentOverrideView.binding.f948c;
            C12238m.checkNotNullExpressionValue(spinner, "binding.experimentOverrideBucketsSpinner");
            Context context = experimentOverrideView.getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            spinner.setAdapter((SpinnerAdapter) new ExperimentOverrideView.C7112a(context, arrayList));
            if (overrideBucket != null) {
                experimentOverrideView.binding.f948c.setSelection(overrideBucket.intValue());
            }
            Spinner spinner2 = experimentOverrideView.binding.f948c;
            C12238m.checkNotNullExpressionValue(spinner2, "binding.experimentOverrideBucketsSpinner");
            spinner2.setOnItemSelectedListener(new C1357a(onOverrideBucketSelected));
            experimentOverrideView.binding.f949d.setOnClickListener(new ViewOnClickListenerC1358b(onOverrideBucketCleared));
            TextView textView4 = experimentOverrideView.binding.f949d;
            C12238m.checkNotNullExpressionValue(textView4, "binding.experimentOverrideClear");
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
        C12238m.checkNotNullParameter(items, "items");
        this.items = items;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ExperimentViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ExperimentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.experiment_overrides_list_item, parent, false);
        ExperimentOverrideView experimentOverrideView = (ExperimentOverrideView) viewInflate.findViewById(C5419R.id.experiment_overrides_list_item_experiment_override_view);
        if (experimentOverrideView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(C5419R.id.experiment_overrides_list_item_experiment_override_view)));
        }
        ExperimentOverridesListItemBinding experimentOverridesListItemBinding = new ExperimentOverridesListItemBinding((CardView) viewInflate, experimentOverrideView);
        C12238m.checkNotNullExpressionValue(experimentOverridesListItemBinding, "ExperimentOverridesListI….context), parent, false)");
        return new ExperimentViewHolder(experimentOverridesListItemBinding);
    }
}
