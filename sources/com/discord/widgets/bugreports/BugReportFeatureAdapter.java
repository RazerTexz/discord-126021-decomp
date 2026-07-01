package com.discord.widgets.bugreports;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.bugreport.Feature;
import com.discord.databinding.WidgetBugReportFeatureHeaderListItemBinding;
import com.discord.databinding.WidgetBugReportFeatureListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportFeatureAdapter extends RecyclerView$Adapter<RecyclerView$ViewHolder> {
    public static final BugReportFeatureAdapter$Companion Companion = new BugReportFeatureAdapter$Companion(null);
    private static final int ITEM_TYPE_FEATURE = 0;
    private static final int ITEM_TYPE_HEADER = 1;
    private List<? extends BugReportFeatureAdapter$BugReportFeatureItem> data;
    private final Function1<Feature, Unit> onClickListener;

    /* JADX WARN: Multi-variable type inference failed */
    public BugReportFeatureAdapter(Function1<? super Feature, Unit> function1) {
        m.checkNotNullParameter(function1, "onClickListener");
        this.onClickListener = function1;
        this.data = n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        BugReportFeatureAdapter$BugReportFeatureItem bugReportFeatureAdapter$BugReportFeatureItem = this.data.get(position);
        if (bugReportFeatureAdapter$BugReportFeatureItem instanceof BugReportFeatureAdapter$BugReportFeatureItem$FeatureItem) {
            return 0;
        }
        if (bugReportFeatureAdapter$BugReportFeatureItem instanceof BugReportFeatureAdapter$BugReportFeatureItem$HeaderItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Function1<Feature, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(RecyclerView$ViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        if (holder instanceof BugReportFeatureViewHolder) {
            BugReportFeatureAdapter$BugReportFeatureItem bugReportFeatureAdapter$BugReportFeatureItem = this.data.get(position);
            Objects.requireNonNull(bugReportFeatureAdapter$BugReportFeatureItem, "null cannot be cast to non-null type com.discord.widgets.bugreports.BugReportFeatureAdapter.BugReportFeatureItem.FeatureItem");
            ((BugReportFeatureViewHolder) holder).bind(((BugReportFeatureAdapter$BugReportFeatureItem$FeatureItem) bugReportFeatureAdapter$BugReportFeatureItem).getFeature());
        } else {
            if (!(holder instanceof BugReportFeatureHeaderViewHolder)) {
                throw new IllegalStateException("Unknown view type");
            }
            BugReportFeatureHeaderViewHolder bugReportFeatureHeaderViewHolder = (BugReportFeatureHeaderViewHolder) holder;
            boolean z2 = position == 0;
            BugReportFeatureAdapter$BugReportFeatureItem bugReportFeatureAdapter$BugReportFeatureItem2 = this.data.get(position);
            Objects.requireNonNull(bugReportFeatureAdapter$BugReportFeatureItem2, "null cannot be cast to non-null type com.discord.widgets.bugreports.BugReportFeatureAdapter.BugReportFeatureItem.HeaderItem");
            bugReportFeatureHeaderViewHolder.bind(z2, ((BugReportFeatureAdapter$BugReportFeatureItem$HeaderItem) bugReportFeatureAdapter$BugReportFeatureItem2).getHeader());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.widget_bug_report_feature_list_item, parent, false);
            int i = R$id.feature_list_item_feature;
            TextView textView = (TextView) viewInflate.findViewById(R$id.feature_list_item_feature);
            if (textView != null) {
                i = R$id.feature_list_item_squad;
                TextView textView2 = (TextView) viewInflate.findViewById(R$id.feature_list_item_squad);
                if (textView2 != null) {
                    WidgetBugReportFeatureListItemBinding widgetBugReportFeatureListItemBinding = new WidgetBugReportFeatureListItemBinding((ConstraintLayout) viewInflate, textView, textView2);
                    m.checkNotNullExpressionValue(widgetBugReportFeatureListItemBinding, "WidgetBugReportFeatureLi….context), parent, false)");
                    return new BugReportFeatureViewHolder(widgetBugReportFeatureListItemBinding, this.onClickListener);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType != 1) {
            throw new IllegalStateException("Unknown view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R$layout.widget_bug_report_feature_header_list_item, parent, false);
        int i2 = R$id.gap;
        View viewFindViewById = viewInflate2.findViewById(R$id.gap);
        if (viewFindViewById != null) {
            i2 = R$id.header;
            TextView textView3 = (TextView) viewInflate2.findViewById(R$id.header);
            if (textView3 != null) {
                WidgetBugReportFeatureHeaderListItemBinding widgetBugReportFeatureHeaderListItemBinding = new WidgetBugReportFeatureHeaderListItemBinding((ConstraintLayout) viewInflate2, viewFindViewById, textView3);
                m.checkNotNullExpressionValue(widgetBugReportFeatureHeaderListItemBinding, "WidgetBugReportFeatureHe….context), parent, false)");
                return new BugReportFeatureHeaderViewHolder(widgetBugReportFeatureHeaderListItemBinding, this.onClickListener);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
    }

    public final void setData(List<Feature> data) {
        m.checkNotNullParameter(data, "data");
        ArrayList arrayList = new ArrayList();
        String squad = null;
        for (Feature feature : data) {
            if (!m.areEqual(feature.getSquad(), squad)) {
                arrayList.add(new BugReportFeatureAdapter$BugReportFeatureItem$HeaderItem(new Feature(feature.getSquad(), feature.getSquad(), feature.getAsanaInboxId())));
                squad = feature.getSquad();
            }
            arrayList.add(new BugReportFeatureAdapter$BugReportFeatureItem$FeatureItem(feature));
        }
        this.data = arrayList;
        notifyDataSetChanged();
    }
}
