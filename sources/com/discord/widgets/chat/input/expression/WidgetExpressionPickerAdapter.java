package com.discord.widgets.chat.input.expression;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.LeadingEdgeThrottle;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.widgets.chat.input.ExpressionPickerItemDecoration;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12096m;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p643a.C12666r;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetExpressionPickerAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> implements StickyHeaderItemDecoration.StickyHeaderAdapter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int ITEM_TYPE_HEADER = 0;
    public List<Integer> headerIndices;
    private final Set<Integer> headerTypes;
    private ExpressionPickerItemDecoration itemDecoration;
    private RecyclerView.OnScrollListener onScrollListener;
    private Function1<? super Integer, Unit> onScrollPositionListener;
    public StickyHeadersManager stickyHeaderManager;

    /* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final int calculateNumOfColumns(int margin, float itemSize, int defaultNumColumns, Resources resources) {
            C12238m.checkNotNullParameter(resources, "resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            int i = (int) ((displayMetrics.widthPixels - margin) / itemSize);
            if (i != 0) {
                return i;
            }
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = C1643a.m833U("\n          invalid dimensions while calculating numColumns\n          displayMetrics.widthPixels: ");
            sbM833U.append(displayMetrics.widthPixels);
            sbM833U.append("\n          total margin marginStart: ");
            sbM833U.append(margin);
            sbM833U.append("\n          itemSize: ");
            sbM833U.append(itemSize);
            sbM833U.append("\n        ");
            Logger.e$default(appLog, C12096m.trimIndent(sbM833U.toString()), null, null, 6, null);
            return defaultNumColumns;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int calculateNumOfColumns(RecyclerView recyclerView, float itemSize, int defaultNumColumns) {
            C12238m.checkNotNullParameter(recyclerView, "recyclerView");
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            int marginStart = layoutParams instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams) : 0;
            ViewGroup.LayoutParams layoutParams2 = recyclerView.getLayoutParams();
            int marginEnd = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams2) : 0;
            Resources resources = recyclerView.getResources();
            C12238m.checkNotNullExpressionValue(resources, "recyclerView.resources");
            return calculateNumOfColumns(marginStart + marginEnd, itemSize, defaultNumColumns, resources);
        }
    }

    /* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
    public interface StickyHeaderViewHolder {
        void bind(int position, MGRecyclerDataPayload data);

        View getItemView();
    }

    /* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
    public static final class StickyHeadersManager {
        private final View currentStickyHeaderView;
        private final StickyHeaderViewHolder stickyHeaderHolder;

        public StickyHeadersManager(WidgetExpressionPickerAdapter widgetExpressionPickerAdapter) {
            C12238m.checkNotNullParameter(widgetExpressionPickerAdapter, "adapter");
            StickyHeaderViewHolder stickyHeaderViewHolderCreateStickyHeaderViewHolder = widgetExpressionPickerAdapter.createStickyHeaderViewHolder(widgetExpressionPickerAdapter);
            this.stickyHeaderHolder = stickyHeaderViewHolderCreateStickyHeaderViewHolder;
            this.currentStickyHeaderView = stickyHeaderViewHolderCreateStickyHeaderViewHolder.getItemView();
        }

        public final View getCurrentStickyHeaderView() {
            return this.currentStickyHeaderView;
        }

        public final StickyHeaderViewHolder getStickyHeaderHolder() {
            return this.stickyHeaderHolder;
        }

        public final void layoutViews(RecyclerView recyclerView) {
            C12238m.checkNotNullParameter(recyclerView, "recyclerView");
            View view = this.currentStickyHeaderView;
            if (view != null) {
                StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, view);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$setupScrollObservables$2 */
    /* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
    public static final class C78452 extends AbstractC12240o implements Function1<Unit, Unit> {
        public C78452() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetExpressionPickerAdapter.this.getOnScrollPositionListener().invoke(Integer.valueOf(WidgetExpressionPickerAdapter.this.getLayoutManager().findFirstVisibleItemPosition()));
        }
    }

    public /* synthetic */ WidgetExpressionPickerAdapter(RecyclerView recyclerView, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? C12146m0.setOf(0) : set);
    }

    private final void setupScrollObservables() {
        Observable observableM11080o = Observable.m11080o(new Action1<Emitter<Unit>>() { // from class: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.setupScrollObservables.1
            @Override // p658rx.functions.Action1
            public final void call(final Emitter<Unit> emitter) {
                C12238m.checkNotNullParameter(emitter, "emitter");
                WidgetExpressionPickerAdapter.this.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.setupScrollObservables.1.1
                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
                        super.onScrolled(recyclerView, dx, dy);
                        emitter.onNext(Unit.f27425a);
                    }
                });
            }
        }, Emitter.BackpressureMode.LATEST);
        Observable observableM11074h0 = Observable.m11074h0(new C12666r(observableM11080o.f27640j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS)));
        C12238m.checkNotNullExpressionValue(observableM11074h0, "Observable\n        .crea…, TimeUnit.MILLISECONDS))");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(observableM11074h0), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78452());
        RecyclerView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            getRecycler().addOnScrollListener(onScrollListener);
        }
    }

    public abstract StickyHeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter adapter);

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public View getAndBindHeaderView(int position) {
        MGRecyclerDataPayload mGRecyclerDataPayload = getInternalData().get(position);
        StickyHeadersManager stickyHeadersManager = this.stickyHeaderManager;
        if (stickyHeadersManager == null) {
            C12238m.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        stickyHeadersManager.getStickyHeaderHolder().bind(position, mGRecyclerDataPayload);
        StickyHeadersManager stickyHeadersManager2 = this.stickyHeaderManager;
        if (stickyHeadersManager2 == null) {
            C12238m.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        return stickyHeadersManager2.getCurrentStickyHeaderView();
    }

    public final List<Integer> getHeaderIndices() {
        List<Integer> list = this.headerIndices;
        if (list == null) {
            C12238m.throwUninitializedPropertyAccessException("headerIndices");
        }
        return list;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public Integer getHeaderPositionForItem(int itemPosition) {
        Integer numPrevious;
        List<Integer> list = this.headerIndices;
        if (list == null) {
            C12238m.throwUninitializedPropertyAccessException("headerIndices");
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
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = C1643a.m833U("failed to find header position for item in ");
            sbM833U.append(getClass().getName());
            Logger.w$default(appLog, sbM833U.toString(), null, 2, null);
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

    public final RecyclerView.OnScrollListener getOnScrollListener() {
        return this.onScrollListener;
    }

    public final Function1<Integer, Unit> getOnScrollPositionListener() {
        return this.onScrollPositionListener;
    }

    public final StickyHeadersManager getStickyHeaderManager() {
        StickyHeadersManager stickyHeadersManager = this.stickyHeaderManager;
        if (stickyHeadersManager == null) {
            C12238m.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        return stickyHeadersManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.stickyHeaderManager = new StickyHeadersManager(this);
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.onAttachedToRecyclerView.1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                WidgetExpressionPickerAdapter.this.getStickyHeaderManager().layoutViews(recyclerView);
            }
        });
    }

    public final void scrollToPosition(int position) {
        RecyclerView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            getRecycler().removeOnScrollListener(onScrollListener);
        }
        getLayoutManager().scrollToPositionWithOffset(position, 0);
        RecyclerView.OnScrollListener onScrollListener2 = this.onScrollListener;
        if (onScrollListener2 != null) {
            getRecycler().addOnScrollListener(onScrollListener2);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple
    public void setData(List<? extends MGRecyclerDataPayload> data) {
        C12238m.checkNotNullParameter(data, "data");
        super.setData(data);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : data) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
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
            C12238m.throwUninitializedPropertyAccessException("headerIndices");
        }
        ExpressionPickerItemDecoration expressionPickerItemDecoration2 = new ExpressionPickerItemDecoration(numColumns, list, DimenUtils.dpToPixels(8));
        getRecycler().addItemDecoration(expressionPickerItemDecoration2);
        this.itemDecoration = expressionPickerItemDecoration2;
    }

    public final void setHeaderIndices(List<Integer> list) {
        C12238m.checkNotNullParameter(list, "<set-?>");
        this.headerIndices = list;
    }

    public final void setItemDecoration(ExpressionPickerItemDecoration expressionPickerItemDecoration) {
        this.itemDecoration = expressionPickerItemDecoration;
    }

    public final void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public final void setOnScrollPositionListener(Function1<? super Integer, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onScrollPositionListener = function1;
    }

    public final void setStickyHeaderManager(StickyHeadersManager stickyHeadersManager) {
        C12238m.checkNotNullParameter(stickyHeadersManager, "<set-?>");
        this.stickyHeaderManager = stickyHeadersManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionPickerAdapter(RecyclerView recyclerView, Set<Integer> set) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
        C12238m.checkNotNullParameter(set, "headerTypes");
        this.headerTypes = set;
        this.onScrollPositionListener = WidgetExpressionPickerAdapter$onScrollPositionListener$1.INSTANCE;
        setupScrollObservables();
    }
}
