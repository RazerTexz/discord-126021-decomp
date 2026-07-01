package com.discord.widgets.servers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ViewCategoryOverrideItemBinding;
import com.discord.databinding.ViewChannelOverrideItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.j;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: NotificationsOverridesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationsOverridesAdapter extends RecyclerView$Adapter<NotificationsOverridesAdapter$ViewHolder> {
    private List<NotificationsOverridesAdapter$Item> data;
    private final Function2<View, NotificationsOverridesAdapter$Item, Unit> onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public NotificationsOverridesAdapter(Function2<? super View, ? super NotificationsOverridesAdapter$Item, Unit> function2) {
        m.checkNotNullParameter(function2, "onClick");
        this.onClick = function2;
        this.data = n.emptyList();
    }

    public final List<NotificationsOverridesAdapter$Item> getData() {
        return this.data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        return this.data.get(position).getChannel().getType();
    }

    public final Function2<View, NotificationsOverridesAdapter$Item, Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((NotificationsOverridesAdapter$ViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @MainThread
    public final void setData(List<NotificationsOverridesAdapter$Item> list) {
        m.checkNotNullParameter(list, "value");
        DiffUtil$DiffResult diffUtil$DiffResultCalculateDiff = DiffUtil.calculateDiff(new NotificationsOverridesAdapter$DiffCallback(list, this.data), true);
        m.checkNotNullExpressionValue(diffUtil$DiffResultCalculateDiff, "DiffUtil.calculateDiff(D…back(value, field), true)");
        this.data = list;
        diffUtil$DiffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    public void onBindViewHolder(NotificationsOverridesAdapter$ViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.onBind(this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public NotificationsOverridesAdapter$ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        int i = R$id.navigation_indicator;
        if (viewType != 0 && viewType != 15) {
            if (viewType == 4) {
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.view_category_override_item, parent, false);
                TextView textView = (TextView) viewInflate.findViewById(R$id.category_override_name);
                if (textView != null) {
                    TextView textView2 = (TextView) viewInflate.findViewById(R$id.category_override_status);
                    if (textView2 != null) {
                        Guideline guideline = (Guideline) viewInflate.findViewById(2131363590);
                        if (guideline != null) {
                            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.navigation_indicator);
                            if (imageView != null) {
                                ViewCategoryOverrideItemBinding viewCategoryOverrideItemBinding = new ViewCategoryOverrideItemBinding((ConstraintLayout) viewInflate, textView, textView2, guideline, imageView);
                                m.checkNotNullExpressionValue(viewCategoryOverrideItemBinding, "ViewCategoryOverrideItem….context), parent, false)");
                                return new NotificationsOverridesAdapter$ViewHolder$CategoryOverridesViewHolder(viewCategoryOverrideItemBinding, this.onClick);
                            }
                        } else {
                            i = 2131363590;
                        }
                    } else {
                        i = R$id.category_override_status;
                    }
                } else {
                    i = R$id.category_override_name;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
            }
            if (viewType != 5) {
                throw new j(a.w("An operation is not implemented: ", a.r("Type[", viewType, "] not implemented")));
            }
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R$layout.view_channel_override_item, parent, false);
        TextView textView3 = (TextView) viewInflate2.findViewById(R$id.channel_override_category_name);
        if (textView3 != null) {
            TextView textView4 = (TextView) viewInflate2.findViewById(R$id.channel_override_name);
            if (textView4 != null) {
                TextView textView5 = (TextView) viewInflate2.findViewById(R$id.channel_override_status);
                if (textView5 != null) {
                    Guideline guideline2 = (Guideline) viewInflate2.findViewById(2131363590);
                    if (guideline2 != null) {
                        ImageView imageView2 = (ImageView) viewInflate2.findViewById(R$id.navigation_indicator);
                        if (imageView2 != null) {
                            ViewChannelOverrideItemBinding viewChannelOverrideItemBinding = new ViewChannelOverrideItemBinding((ConstraintLayout) viewInflate2, textView3, textView4, textView5, guideline2, imageView2);
                            m.checkNotNullExpressionValue(viewChannelOverrideItemBinding, "ViewChannelOverrideItemB….context), parent, false)");
                            return new NotificationsOverridesAdapter$ViewHolder$ChannelOverridesViewHolder(viewChannelOverrideItemBinding, this.onClick);
                        }
                    } else {
                        i = 2131363590;
                    }
                } else {
                    i = R$id.channel_override_status;
                }
            } else {
                i = R$id.channel_override_name;
            }
        } else {
            i = R$id.channel_override_category_name;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
    }
}
