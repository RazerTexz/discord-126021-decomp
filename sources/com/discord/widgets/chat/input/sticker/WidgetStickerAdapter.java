package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetStickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerAdapter extends WidgetExpressionPickerAdapter {
    public static final int DEFAULT_NUM_COLUMNS = 4;
    public static final int ITEM_TYPE_OWNED_HEADER = 0;
    public static final int ITEM_TYPE_STICKER = 1;
    public static final int ITEM_TYPE_STORE_HEADER = 2;
    private final AppComponent appComponent;
    private final GridLayoutManager layoutManager;
    private final int numColumns;
    private final Function1<StickerAdapterItems4, Unit> onStickerHeaderItemsClicked;
    private final Function1<StickerAdapterItems3, Unit> onStickerItemSelected;
    private final BehaviorSubject<Boolean> recyclerScrollingWithinThresholdSubject;
    private final boolean showStickerPackDescriptions;

    public /* synthetic */ WidgetStickerAdapter(RecyclerView recyclerView, Function1 function1, Function1 function2, BehaviorSubject behaviorSubject, AppComponent appComponent, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, function1, (i & 4) != 0 ? null : function2, (i & 8) != 0 ? null : behaviorSubject, appComponent, (i & 32) != 0 ? false : z2);
    }

    public final AppComponent getAppComponent() {
        return this.appComponent;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public GridLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public int getNumColumns() {
        return this.numColumns;
    }

    public final Function1<StickerAdapterItems4, Unit> getOnStickerHeaderItemsClicked() {
        return this.onStickerHeaderItemsClicked;
    }

    public final Function1<StickerAdapterItems3, Unit> getOnStickerItemSelected() {
        return this.onStickerItemSelected;
    }

    public final BehaviorSubject<Boolean> getRecyclerScrollingWithinThresholdSubject() {
        return this.recyclerScrollingWithinThresholdSubject;
    }

    public final boolean getShowStickerPackDescriptions() {
        return this.showStickerPackDescriptions;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public boolean isHeader(int position) {
        return ((MGRecyclerDataPayload) _Collections.getOrNull(getInternalData(), position)) instanceof StickerAdapterItems;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetStickerAdapter(RecyclerView recyclerView, Function1<? super StickerAdapterItems3, Unit> function1, Function1<? super StickerAdapterItems4, Unit> function2, BehaviorSubject<Boolean> behaviorSubject, AppComponent appComponent, boolean z2) {
        super(recyclerView, SetsJVM.setOf(0));
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function1, "onStickerItemSelected");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        this.onStickerItemSelected = function1;
        this.onStickerHeaderItemsClicked = function2;
        this.recyclerScrollingWithinThresholdSubject = behaviorSubject;
        this.appComponent = appComponent;
        this.showStickerPackDescriptions = z2;
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recycler.context");
        this.numColumns = WidgetExpressionPickerAdapter.INSTANCE.calculateNumOfColumns(recyclerView, context.getResources().getDimension(R.dimen.chat_input_sticker_size), 4);
        this.layoutManager = new GridLayoutManager(recyclerView.getContext(), getNumColumns());
        getLayoutManager().setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.discord.widgets.chat.input.sticker.WidgetStickerAdapter.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                int itemViewType = WidgetStickerAdapter.this.getItemViewType(position);
                if (itemViewType == 0 || itemViewType == 2) {
                    return WidgetStickerAdapter.this.getNumColumns();
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(this);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public StickerAdapterViewHolders createStickyHeaderViewHolder(WidgetExpressionPickerAdapter adapter) {
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        return new StickerAdapterViewHolders((WidgetStickerAdapter) adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new StickerAdapterViewHolders(this);
        }
        if (viewType == 1) {
            return new StickerAdapterViewHolders2(viewType, this, this.recyclerScrollingWithinThresholdSubject, this.appComponent);
        }
        if (viewType == 2) {
            return new StickerAdapterViewHolders3(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
