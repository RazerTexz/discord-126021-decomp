package com.discord.widgets.bugreports;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.bugreport.Feature;
import com.discord.databinding.WidgetBugReportFeatureHeaderListItemBinding;
import com.discord.databinding.WidgetBugReportFeatureListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportFeatureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_TYPE_FEATURE = 0;
    private static final int ITEM_TYPE_HEADER = 1;
    private List<? extends BugReportFeatureItem> data;
    private final Function1<Feature, Unit> onClickListener;

    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static abstract class BugReportFeatureItem {

        /* JADX INFO: compiled from: WidgetBugReport.kt */
        public static final class FeatureItem extends BugReportFeatureItem {
            private final Feature feature;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FeatureItem(Feature feature) {
                super(null);
                C12238m.checkNotNullParameter(feature, "feature");
                this.feature = feature;
            }

            public final Feature getFeature() {
                return this.feature;
            }
        }

        /* JADX INFO: compiled from: WidgetBugReport.kt */
        public static final class HeaderItem extends BugReportFeatureItem {
            private final Feature header;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HeaderItem(Feature feature) {
                super(null);
                C12238m.checkNotNullParameter(feature, "header");
                this.header = feature;
            }

            public final Feature getHeader() {
                return this.header;
            }
        }

        private BugReportFeatureItem() {
        }

        public /* synthetic */ BugReportFeatureItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BugReportFeatureAdapter(Function1<? super Feature, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "onClickListener");
        this.onClickListener = function1;
        this.data = C12147n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        BugReportFeatureItem bugReportFeatureItem = this.data.get(position);
        if (bugReportFeatureItem instanceof BugReportFeatureItem.FeatureItem) {
            return 0;
        }
        if (bugReportFeatureItem instanceof BugReportFeatureItem.HeaderItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Function1<Feature, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        if (holder instanceof BugReportFeatureViewHolder) {
            BugReportFeatureItem bugReportFeatureItem = this.data.get(position);
            Objects.requireNonNull(bugReportFeatureItem, "null cannot be cast to non-null type com.discord.widgets.bugreports.BugReportFeatureAdapter.BugReportFeatureItem.FeatureItem");
            ((BugReportFeatureViewHolder) holder).bind(((BugReportFeatureItem.FeatureItem) bugReportFeatureItem).getFeature());
        } else {
            if (!(holder instanceof BugReportFeatureHeaderViewHolder)) {
                throw new IllegalStateException("Unknown view type");
            }
            BugReportFeatureHeaderViewHolder bugReportFeatureHeaderViewHolder = (BugReportFeatureHeaderViewHolder) holder;
            boolean z2 = position == 0;
            BugReportFeatureItem bugReportFeatureItem2 = this.data.get(position);
            Objects.requireNonNull(bugReportFeatureItem2, "null cannot be cast to non-null type com.discord.widgets.bugreports.BugReportFeatureAdapter.BugReportFeatureItem.HeaderItem");
            bugReportFeatureHeaderViewHolder.bind(z2, ((BugReportFeatureItem.HeaderItem) bugReportFeatureItem2).getHeader());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.widget_bug_report_feature_list_item, parent, false);
            int i = C5419R.id.feature_list_item_feature;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.feature_list_item_feature);
            if (textView != null) {
                i = C5419R.id.feature_list_item_squad;
                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.feature_list_item_squad);
                if (textView2 != null) {
                    WidgetBugReportFeatureListItemBinding widgetBugReportFeatureListItemBinding = new WidgetBugReportFeatureListItemBinding((ConstraintLayout) viewInflate, textView, textView2);
                    C12238m.checkNotNullExpressionValue(widgetBugReportFeatureListItemBinding, "WidgetBugReportFeatureLi….context), parent, false)");
                    return new BugReportFeatureViewHolder(widgetBugReportFeatureListItemBinding, this.onClickListener);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType != 1) {
            throw new IllegalStateException("Unknown view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.widget_bug_report_feature_header_list_item, parent, false);
        int i2 = C5419R.id.gap;
        View viewFindViewById = viewInflate2.findViewById(C5419R.id.gap);
        if (viewFindViewById != null) {
            i2 = C5419R.id.header;
            TextView textView3 = (TextView) viewInflate2.findViewById(C5419R.id.header);
            if (textView3 != null) {
                WidgetBugReportFeatureHeaderListItemBinding widgetBugReportFeatureHeaderListItemBinding = new WidgetBugReportFeatureHeaderListItemBinding((ConstraintLayout) viewInflate2, viewFindViewById, textView3);
                C12238m.checkNotNullExpressionValue(widgetBugReportFeatureHeaderListItemBinding, "WidgetBugReportFeatureHe….context), parent, false)");
                return new BugReportFeatureHeaderViewHolder(widgetBugReportFeatureHeaderListItemBinding, this.onClickListener);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
    }

    public final void setData(List<Feature> data) {
        C12238m.checkNotNullParameter(data, "data");
        ArrayList arrayList = new ArrayList();
        String squad = null;
        for (Feature feature : data) {
            if (!C12238m.areEqual(feature.getSquad(), squad)) {
                arrayList.add(new BugReportFeatureItem.HeaderItem(new Feature(feature.getSquad(), feature.getSquad(), feature.getAsanaInboxId())));
                squad = feature.getSquad();
            }
            arrayList.add(new BugReportFeatureItem.FeatureItem(feature));
        }
        this.data = arrayList;
        notifyDataSetChanged();
    }
}
