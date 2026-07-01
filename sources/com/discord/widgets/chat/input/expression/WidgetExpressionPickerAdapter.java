package com.discord.widgets.chat.input.expression;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter;
import com.discord.widgets.chat.input.ExpressionPickerItemDecoration;
import d0.t.m0;
import d0.t.n;
import d0.z.d.m;
import j0.l.a.r;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Emitter$BackpressureMode;
import rx.Observable;

/* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetExpressionPickerAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> implements StickyHeaderItemDecoration$StickyHeaderAdapter {
    public static final WidgetExpressionPickerAdapter$Companion Companion = new WidgetExpressionPickerAdapter$Companion(null);
    public static final int ITEM_TYPE_HEADER = 0;
    public List<Integer> headerIndices;
    private final Set<Integer> headerTypes;
    private ExpressionPickerItemDecoration itemDecoration;
    private RecyclerView$OnScrollListener onScrollListener;
    private Function1<? super Integer, Unit> onScrollPositionListener;
    public WidgetExpressionPickerAdapter$StickyHeadersManager stickyHeaderManager;

    public /* synthetic */ WidgetExpressionPickerAdapter(RecyclerView recyclerView, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? m0.setOf(0) : set);
    }

    private final void setupScrollObservables() {
        Observable observableO = Observable.o(new WidgetExpressionPickerAdapter$setupScrollObservables$1(this), Emitter$BackpressureMode.LATEST);
        Observable observableH0 = Observable.h0(new r(observableO.j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS)));
        m.checkNotNullExpressionValue(observableH0, "Observable\n        .crea…, TimeUnit.MILLISECONDS))");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableH0), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetExpressionPickerAdapter$setupScrollObservables$2(this), 62, (Object) null);
        RecyclerView$OnScrollListener recyclerView$OnScrollListener = this.onScrollListener;
        if (recyclerView$OnScrollListener != null) {
            getRecycler().addOnScrollListener(recyclerView$OnScrollListener);
        }
    }

    public abstract WidgetExpressionPickerAdapter$StickyHeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter adapter);

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter
    public View getAndBindHeaderView(int position) {
        MGRecyclerDataPayload mGRecyclerDataPayload = getInternalData().get(position);
        WidgetExpressionPickerAdapter$StickyHeadersManager widgetExpressionPickerAdapter$StickyHeadersManager = this.stickyHeaderManager;
        if (widgetExpressionPickerAdapter$StickyHeadersManager == null) {
            m.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        widgetExpressionPickerAdapter$StickyHeadersManager.getStickyHeaderHolder().bind(position, mGRecyclerDataPayload);
        WidgetExpressionPickerAdapter$StickyHeadersManager widgetExpressionPickerAdapter$StickyHeadersManager2 = this.stickyHeaderManager;
        if (widgetExpressionPickerAdapter$StickyHeadersManager2 == null) {
            m.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        return widgetExpressionPickerAdapter$StickyHeadersManager2.getCurrentStickyHeaderView();
    }

    public final List<Integer> getHeaderIndices() {
        List<Integer> list = this.headerIndices;
        if (list == null) {
            m.throwUninitializedPropertyAccessException("headerIndices");
        }
        return list;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter
    public Integer getHeaderPositionForItem(int itemPosition) {
        Integer numPrevious;
        List<Integer> list = this.headerIndices;
        if (list == null) {
            m.throwUninitializedPropertyAccessException("headerIndices");
        }
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        do {
            if (!listIterator.hasPrevious()) {
                numPrevious = null;
                break;
            }
            numPrevious = listIterator.previous();
        } while (!(itemPosition >= numPrevious.intValue()));
        Integer num = numPrevious;
        if (num == null) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = a.U("failed to find header position for item in ");
            sbU.append(getClass().getName());
            Logger.w$default(appLog, sbU.toString(), null, 2, null);
        }
        return num;
    }

    public final Set<Integer> getHeaderTypes() {
        return this.headerTypes;
    }

    public final ExpressionPickerItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    public abstract GridLayoutManager getLayoutManager();

    public abstract int getNumColumns();

    public final RecyclerView$OnScrollListener getOnScrollListener() {
        return this.onScrollListener;
    }

    public final Function1<Integer, Unit> getOnScrollPositionListener() {
        return this.onScrollPositionListener;
    }

    public final WidgetExpressionPickerAdapter$StickyHeadersManager getStickyHeaderManager() {
        WidgetExpressionPickerAdapter$StickyHeadersManager widgetExpressionPickerAdapter$StickyHeadersManager = this.stickyHeaderManager;
        if (widgetExpressionPickerAdapter$StickyHeadersManager == null) {
            m.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        return widgetExpressionPickerAdapter$StickyHeadersManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.stickyHeaderManager = new WidgetExpressionPickerAdapter$StickyHeadersManager(this);
        recyclerView.addOnLayoutChangeListener(new WidgetExpressionPickerAdapter$onAttachedToRecyclerView$1(this, recyclerView));
    }

    public final void scrollToPosition(int position) {
        RecyclerView$OnScrollListener recyclerView$OnScrollListener = this.onScrollListener;
        if (recyclerView$OnScrollListener != null) {
            getRecycler().removeOnScrollListener(recyclerView$OnScrollListener);
        }
        getLayoutManager().scrollToPositionWithOffset(position, 0);
        RecyclerView$OnScrollListener recyclerView$OnScrollListener2 = this.onScrollListener;
        if (recyclerView$OnScrollListener2 != null) {
            getRecycler().addOnScrollListener(recyclerView$OnScrollListener2);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple
    public void setData(List<? extends MGRecyclerDataPayload> data) {
        m.checkNotNullParameter(data, "data");
        super.setData(data);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : data) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            Integer numValueOf = this.headerTypes.contains(Integer.valueOf(((MGRecyclerDataPayload) obj).getType())) ? Integer.valueOf(i) : null;
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
            i = i2;
        }
        this.headerIndices = arrayList;
        ExpressionPickerItemDecoration expressionPickerItemDecoration = this.itemDecoration;
        if (expressionPickerItemDecoration != null) {
            getRecycler().removeItemDecoration(expressionPickerItemDecoration);
        }
        int numColumns = getNumColumns();
        List<Integer> list = this.headerIndices;
        if (list == null) {
            m.throwUninitializedPropertyAccessException("headerIndices");
        }
        ExpressionPickerItemDecoration expressionPickerItemDecoration2 = new ExpressionPickerItemDecoration(numColumns, list, DimenUtils.dpToPixels(8));
        getRecycler().addItemDecoration(expressionPickerItemDecoration2);
        this.itemDecoration = expressionPickerItemDecoration2;
    }

    public final void setHeaderIndices(List<Integer> list) {
        m.checkNotNullParameter(list, "<set-?>");
        this.headerIndices = list;
    }

    public final void setItemDecoration(ExpressionPickerItemDecoration expressionPickerItemDecoration) {
        this.itemDecoration = expressionPickerItemDecoration;
    }

    public final void setOnScrollListener(RecyclerView$OnScrollListener recyclerView$OnScrollListener) {
        this.onScrollListener = recyclerView$OnScrollListener;
    }

    public final void setOnScrollPositionListener(Function1<? super Integer, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onScrollPositionListener = function1;
    }

    public final void setStickyHeaderManager(WidgetExpressionPickerAdapter$StickyHeadersManager widgetExpressionPickerAdapter$StickyHeadersManager) {
        m.checkNotNullParameter(widgetExpressionPickerAdapter$StickyHeadersManager, "<set-?>");
        this.stickyHeaderManager = widgetExpressionPickerAdapter$StickyHeadersManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionPickerAdapter(RecyclerView recyclerView, Set<Integer> set) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(set, "headerTypes");
        this.headerTypes = set;
        this.onScrollPositionListener = WidgetExpressionPickerAdapter$onScrollPositionListener$1.INSTANCE;
        setupScrollObservables();
    }
}
