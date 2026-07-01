package com.discord.utilities.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SimpleRecyclerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public class SimpleRecyclerAdapter<T, VH extends ViewHolder<T>> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function2<LayoutInflater, ViewGroup, VH> createViewHolder;
    private List<? extends T> data;

    /* JADX INFO: compiled from: SimpleRecyclerAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void addThemedDivider(RecyclerView recyclerView) {
            Intrinsics3.checkNotNullParameter(recyclerView, "$this$addThemedDivider");
            int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(recyclerView, R.attr.colorPrimaryDivider, 0, 2, (Object) null);
            Resources resources = recyclerView.getResources();
            Context context = recyclerView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            Drawable drawable = ResourcesCompat.getDrawable(resources, themedDrawableRes$default, context.getTheme());
            if (drawable != null) {
                Intrinsics3.checkNotNullExpressionValue(drawable, "ResourcesCompat.getDrawa… context.theme) ?: return");
                Context context2 = recyclerView.getContext();
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context2, ((LinearLayoutManager) layoutManager).getOrientation());
                dividerItemDecoration.setDrawable(drawable);
                recyclerView.addItemDecoration(dividerItemDecoration);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SimpleRecyclerAdapter.kt */
    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics3.checkNotNullParameter(view, "itemView");
        }

        public abstract void bind(T data);
    }

    public /* synthetic */ SimpleRecyclerAdapter(List list, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Collections2.emptyList() : list, function2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final void setData(List<? extends T> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleRecyclerAdapter(List<? extends T> list, Function2<? super LayoutInflater, ? super ViewGroup, ? extends VH> function2) {
        Intrinsics3.checkNotNullParameter(list, "data");
        Intrinsics3.checkNotNullParameter(function2, "createViewHolder");
        this.data = list;
        this.createViewHolder = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Function2<LayoutInflater, ViewGroup, VH> function2 = this.createViewHolder;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        Intrinsics3.checkNotNullExpressionValue(layoutInflaterFrom, "LayoutInflater.from(parent.context)");
        return function2.invoke(layoutInflaterFrom, parent);
    }
}
