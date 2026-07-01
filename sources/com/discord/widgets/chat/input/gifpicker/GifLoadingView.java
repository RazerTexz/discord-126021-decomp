package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.discord.R;
import com.discord.databinding.LoadingGifItemViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.recycler.GridColumnSpaceItemDecoration;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: GifLoadingView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifLoadingView extends RecyclerView {
    private boolean isStaggered;
    private final LoadingGifAdapter loadingGifAdapter;

    /* JADX INFO: compiled from: GifLoadingView.kt */
    public static final class LoadingGifAdapter extends RecyclerView.Adapter<LoadingGifViewHolder> {
        private List<Integer> heightsDp = Collections2.emptyList();

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.heightsDp.size();
        }

        public final void setData(List<Integer> heightsDp) {
            Intrinsics3.checkNotNullParameter(heightsDp, "heightsDp");
            this.heightsDp = heightsDp;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(LoadingGifViewHolder holder, int position) {
            Intrinsics3.checkNotNullParameter(holder, "holder");
            holder.configure(this.heightsDp.get(position).intValue());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public LoadingGifViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.loading_gif_item_view, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            LoadingGifItemViewBinding loadingGifItemViewBinding = new LoadingGifItemViewBinding((CardView) viewInflate);
            Intrinsics3.checkNotNullExpressionValue(loadingGifItemViewBinding, "LoadingGifItemViewBindin….context), parent, false)");
            return new LoadingGifViewHolder(loadingGifItemViewBinding);
        }
    }

    /* JADX INFO: compiled from: GifLoadingView.kt */
    public static final class LoadingGifViewHolder extends RecyclerView.ViewHolder {
        private final LoadingGifItemViewBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingGifViewHolder(LoadingGifItemViewBinding loadingGifItemViewBinding) {
            super(loadingGifItemViewBinding.a);
            Intrinsics3.checkNotNullParameter(loadingGifItemViewBinding, "binding");
            this.binding = loadingGifItemViewBinding;
        }

        public final void configure(int heightDp) {
            CardView cardView = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(cardView, "binding.root");
            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            CardView cardView2 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.root");
            Resources resources = cardView2.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "binding.root.resources");
            layoutParams.height = (int) (heightDp * resources.getDisplayMetrics().density);
            CardView cardView3 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.root");
            cardView3.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifLoadingView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.loadingGifAdapter = new LoadingGifAdapter();
    }

    private final void initialize(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.a.GifLoadingView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ble.GifLoadingView, 0, 0)");
        try {
            this.isStaggered = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
            setAdapter(this.loadingGifAdapter);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public static /* synthetic */ void updateView$default(GifLoadingView gifLoadingView, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 4;
        }
        gifLoadingView.updateView(i, i2);
    }

    public final void updateView(int numColumns, int numRows) {
        int i = 1;
        setLayoutManager(new StaggeredGridLayoutManager(numColumns, 1));
        addItemDecoration(new GridColumnSpaceItemDecoration(DimenUtils.dpToPixels(8), numColumns));
        int i2 = numRows * numColumns;
        ArrayList arrayList = new ArrayList();
        if (this.isStaggered) {
            arrayList.add(96);
            int i3 = i2 - 1;
            while (i < i3) {
                arrayList.add(Integer.valueOf((i % 2 != 0 || i >= numColumns) ? Opcodes.IF_ICMPNE : 96));
                i++;
            }
            arrayList.add(96);
        } else {
            for (int i4 = 0; i4 < i2; i4++) {
                arrayList.add(96);
            }
        }
        this.loadingGifAdapter.setData(arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.loadingGifAdapter = new LoadingGifAdapter();
        initialize(attributeSet);
    }

    public /* synthetic */ GifLoadingView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.loadingGifAdapter = new LoadingGifAdapter();
        initialize(attributeSet);
    }

    public /* synthetic */ GifLoadingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
