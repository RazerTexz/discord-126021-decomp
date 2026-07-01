package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$StickyHeaderViewHolder;
import d0.t.m0;
import d0.t.u;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetStickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerAdapter extends WidgetExpressionPickerAdapter {
    public static final WidgetStickerAdapter$Companion Companion = new WidgetStickerAdapter$Companion(null);
    public static final int DEFAULT_NUM_COLUMNS = 4;
    public static final int ITEM_TYPE_OWNED_HEADER = 0;
    public static final int ITEM_TYPE_STICKER = 1;
    public static final int ITEM_TYPE_STORE_HEADER = 2;
    private final AppComponent appComponent;
    private final GridLayoutManager layoutManager;
    private final int numColumns;
    private final Function1<StoreHeaderItem, Unit> onStickerHeaderItemsClicked;
    private final Function1<StickerItem, Unit> onStickerItemSelected;
    private final BehaviorSubject<Boolean> recyclerScrollingWithinThresholdSubject;
    private final boolean showStickerPackDescriptions;

    public /* synthetic */ WidgetStickerAdapter(RecyclerView recyclerView, Function1 function1, Function1 function2, BehaviorSubject behaviorSubject, AppComponent appComponent, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, function1, (i & 4) != 0 ? null : function2, (i & 8) != 0 ? null : behaviorSubject, appComponent, (i & 32) != 0 ? false : z2);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public /* bridge */ /* synthetic */ WidgetExpressionPickerAdapter$StickyHeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter widgetExpressionPickerAdapter) {
        return createStickyHeaderViewHolder(widgetExpressionPickerAdapter);
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

    public final Function1<StoreHeaderItem, Unit> getOnStickerHeaderItemsClicked() {
        return this.onStickerHeaderItemsClicked;
    }

    public final Function1<StickerItem, Unit> getOnStickerItemSelected() {
        return this.onStickerItemSelected;
    }

    public final BehaviorSubject<Boolean> getRecyclerScrollingWithinThresholdSubject() {
        return this.recyclerScrollingWithinThresholdSubject;
    }

    public final boolean getShowStickerPackDescriptions() {
        return this.showStickerPackDescriptions;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter
    public boolean isHeader(int position) {
        return ((MGRecyclerDataPayload) u.getOrNull(getInternalData(), position)) instanceof HeaderItem;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetStickerAdapter(RecyclerView recyclerView, Function1<? super StickerItem, Unit> function1, Function1<? super StoreHeaderItem, Unit> function2, BehaviorSubject<Boolean> behaviorSubject, AppComponent appComponent, boolean z2) {
        super(recyclerView, m0.setOf(0));
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(function1, "onStickerItemSelected");
        m.checkNotNullParameter(appComponent, "appComponent");
        this.onStickerItemSelected = function1;
        this.onStickerHeaderItemsClicked = function2;
        this.recyclerScrollingWithinThresholdSubject = behaviorSubject;
        this.appComponent = appComponent;
        this.showStickerPackDescriptions = z2;
        Context context = recyclerView.getContext();
        m.checkNotNullExpressionValue(context, "recycler.context");
        this.numColumns = WidgetExpressionPickerAdapter.Companion.calculateNumOfColumns(recyclerView, context.getResources().getDimension(2131165320), 4);
        this.layoutManager = new GridLayoutManager(recyclerView.getContext(), getNumColumns());
        getLayoutManager().setSpanSizeLookup(new WidgetStickerAdapter$1(this));
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(this);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public OwnedHeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter adapter) {
        m.checkNotNullParameter(adapter, "adapter");
        return new OwnedHeaderViewHolder((WidgetStickerAdapter) adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new OwnedHeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new StickerViewHolder(viewType, this, this.recyclerScrollingWithinThresholdSubject, this.appComponent);
        }
        if (viewType == 2) {
            return new StoreHeaderViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
