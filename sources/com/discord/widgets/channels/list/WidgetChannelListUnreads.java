package com.discord.widgets.channels.list;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelsListUnreadsBinding;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.layoutparams.LayoutParamsExtensionsKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12083g;
import p507d0.C12113l;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListUnreads {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long FADE_DURATION_MS = 150;

    @Deprecated
    private static final int ITEM_OVER_SCROLL_COUNT = 3;
    private final AppBarLayout appBarLayout;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final Lazy binding;
    private List<? extends Object> data;
    private final Function0<Integer> getItemCount;
    private int mentionResId;
    private final RecyclerView recycler;
    private boolean unreadsEnabled;
    private boolean unreadsInitialized;
    private int unreadsResId;
    private final ViewStub unreadsStub;

    /* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int INVALID_INDEX = -1;
        public static final int TYPE_MENTION = 0;
        public static final int TYPE_UNREAD = 1;
        private final Indicator bottomIndicator;
        private final Indicator topIndicator;

        /* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
        public static final class Companion {
            private Companion() {
            }

            private final Indicator findIndicator(List<? extends Object> list, IntProgression intProgression, boolean z2, boolean z3) {
                int i;
                int first = intProgression.getFirst();
                int last = intProgression.getLast();
                int step = intProgression.getStep();
                if (step < 0 ? first < last : first > last) {
                    i = -1;
                } else {
                    i = -1;
                    while (true) {
                        Object obj = list.get(first);
                        if (!(obj instanceof UnreadItem)) {
                            obj = null;
                        }
                        UnreadItem unreadItem = (UnreadItem) obj;
                        if (unreadItem != null) {
                            if (unreadItem.getMentionCount() > 0) {
                                return new Indicator(0, first);
                            }
                            if (z3 && !z2 && i == -1 && unreadItem.isUnread()) {
                                i = first;
                            }
                        }
                        if (first != last) {
                            first += step;
                        }
                    }
                }
                if (i != -1) {
                    return new Indicator(1, i);
                }
                return null;
            }

            public static /* synthetic */ Model get$default(Companion companion, IntRange intRange, List list, boolean z2, int i, Object obj) {
                if ((i & 4) != 0) {
                    z2 = true;
                }
                return companion.get(intRange, list, z2);
            }

            private final boolean hasUnread(List<? extends Object> list, IntRange intRange) {
                List listSlice = C12163u.slice(list, intRange);
                if (!(listSlice instanceof Collection) || !listSlice.isEmpty()) {
                    for (Object obj : listSlice) {
                        if (!(obj instanceof UnreadItem)) {
                            obj = null;
                        }
                        UnreadItem unreadItem = (UnreadItem) obj;
                        if (unreadItem != null && unreadItem.isUnread()) {
                            return true;
                        }
                    }
                }
                return false;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0017  */
            /* JADX WARN: Multi-variable type inference failed */
            public final Model get(IntRange visibleRange, List<? extends Object> items, boolean unreadsEnabled) {
                boolean z2;
                C12238m.checkNotNullParameter(visibleRange, "visibleRange");
                C12238m.checkNotNullParameter(items, "items");
                if (unreadsEnabled) {
                    try {
                        if (hasUnread(items, visibleRange)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } catch (IndexOutOfBoundsException unused) {
                        return new Model(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                    }
                } else {
                    z2 = false;
                }
                return new Model(findIndicator(items, C11226f.until(0, visibleRange.getFirst()), z2, unreadsEnabled), findIndicator(items, C11226f.downTo(C12147n.getLastIndex(items), visibleRange.getLast() + 1), z2, unreadsEnabled));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
        public static final /* data */ class Indicator {
            private final int index;
            private final int type;

            public Indicator(int i, int i2) {
                this.type = i;
                this.index = i2;
            }

            public static /* synthetic */ Indicator copy$default(Indicator indicator, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = indicator.type;
                }
                if ((i3 & 2) != 0) {
                    i2 = indicator.index;
                }
                return indicator.copy(i, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getType() {
                return this.type;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            public final Indicator copy(int type, int index) {
                return new Indicator(type, index);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Indicator)) {
                    return false;
                }
                Indicator indicator = (Indicator) other;
                return this.type == indicator.type && this.index == indicator.index;
            }

            public final int getIndex() {
                return this.index;
            }

            public final int getType() {
                return this.type;
            }

            public int hashCode() {
                return (this.type * 31) + this.index;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Indicator(type=");
                sbM833U.append(this.type);
                sbM833U.append(", index=");
                return C1643a.m814B(sbM833U, this.index, ")");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public Model(Indicator indicator, Indicator indicator2) {
            this.topIndicator = indicator;
            this.bottomIndicator = indicator2;
        }

        public static /* synthetic */ Model copy$default(Model model, Indicator indicator, Indicator indicator2, int i, Object obj) {
            if ((i & 1) != 0) {
                indicator = model.topIndicator;
            }
            if ((i & 2) != 0) {
                indicator2 = model.bottomIndicator;
            }
            return model.copy(indicator, indicator2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Indicator getTopIndicator() {
            return this.topIndicator;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Indicator getBottomIndicator() {
            return this.bottomIndicator;
        }

        public final Model copy(Indicator topIndicator, Indicator bottomIndicator) {
            return new Model(topIndicator, bottomIndicator);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.topIndicator, model.topIndicator) && C12238m.areEqual(this.bottomIndicator, model.bottomIndicator);
        }

        public final Indicator getBottomIndicator() {
            return this.bottomIndicator;
        }

        public final Indicator getTopIndicator() {
            return this.topIndicator;
        }

        public int hashCode() {
            Indicator indicator = this.topIndicator;
            int iHashCode = (indicator != null ? indicator.hashCode() : 0) * 31;
            Indicator indicator2 = this.bottomIndicator;
            return iHashCode + (indicator2 != null ? indicator2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(topIndicator=");
            sbM833U.append(this.topIndicator);
            sbM833U.append(", bottomIndicator=");
            sbM833U.append(this.bottomIndicator);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ Model(Indicator indicator, Indicator indicator2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : indicator, (i & 2) != 0 ? null : indicator2);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
    public interface UnreadItem {
        int getMentionCount();

        boolean isUnread();
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelListUnreads$onDatasetChanged$1 */
    /* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
    @InterfaceC12188e(m10084c = "com.discord.widgets.channels.list.WidgetChannelListUnreads$onDatasetChanged$1", m10085f = "WidgetChannelListUnreads.kt", m10086l = {74}, m10087m = "invokeSuspend")
    public static final class C74231 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C74231(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return WidgetChannelListUnreads.this.new C74231(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C74231) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                this.label = 1;
                if (C3404f.m4234P(50L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            WidgetChannelListUnreads.this.handleVisibleRangeUpdate();
            return Unit.f27425a;
        }
    }

    public WidgetChannelListUnreads(ViewStub viewStub, RecyclerView recyclerView, AppBarLayout appBarLayout, Function0<Integer> function0, int i, int i2, boolean z2) {
        C12238m.checkNotNullParameter(viewStub, "unreadsStub");
        C12238m.checkNotNullParameter(recyclerView, "recycler");
        C12238m.checkNotNullParameter(function0, "getItemCount");
        this.unreadsStub = viewStub;
        this.recycler = recyclerView;
        this.appBarLayout = appBarLayout;
        this.getItemCount = function0;
        this.mentionResId = i;
        this.unreadsResId = i2;
        this.unreadsEnabled = z2;
        this.binding = C12083g.lazy(new WidgetChannelListUnreads$binding$2(this));
        this.data = C12147n.emptyList();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.channels.list.WidgetChannelListUnreads.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                C12238m.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, newState);
                if (newState == 0 || newState == 2) {
                    WidgetChannelListUnreads.this.handleVisibleRangeUpdate();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                C12238m.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, dx, dy);
                if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
                    WidgetChannelListUnreads.this.handleVisibleRangeUpdate();
                }
            }
        });
    }

    private final WidgetChannelsListUnreadsBinding getBinding() {
        return (WidgetChannelsListUnreadsBinding) this.binding.getValue();
    }

    private final int getIcon(Model.Indicator indicator) {
        return indicator.getType() != 0 ? C5419R.drawable.drawable_button_grey : C5419R.drawable.drawable_button_red;
    }

    private final int getText(Model.Indicator indicator) {
        return indicator.getType() != 0 ? this.unreadsResId : this.mentionResId;
    }

    private final void handleClick(Model.Indicator indicator, boolean z2) {
        AppBarLayout appBarLayout;
        int iMax = z2 ? Math.max(indicator.getIndex() - 3, 0) : Math.min(indicator.getIndex() + 3, this.getItemCount.invoke().intValue() - 1);
        if (!z2 && (appBarLayout = this.appBarLayout) != null) {
            appBarLayout.setExpanded(false);
        }
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            this.recycler.scrollToPosition(iMax);
        } else {
            this.recycler.smoothScrollToPosition(iMax);
        }
    }

    private final void handleVisibleRangeUpdate() {
        RecyclerView.LayoutManager layoutManager = this.recycler.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            Model model = Model.INSTANCE.get(new IntRange(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()), this.data, this.unreadsEnabled);
            final Model.Indicator topIndicator = model.getTopIndicator();
            if (topIndicator == null) {
                topIndicator = model.getBottomIndicator();
            }
            final boolean z2 = model.getTopIndicator() != null;
            if (topIndicator == null && this.unreadsInitialized) {
                ViewExtensions.fadeOut$default(getBinding().f16081a, 150L, null, null, 6, null);
            } else if (topIndicator != null) {
                ViewExtensions.fadeIn$default(getBinding().f16081a, 150L, null, null, null, 14, null);
                getBinding().f16081a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelListUnreads.handleVisibleRangeUpdate.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetChannelListUnreads.this.handleClick(topIndicator, z2);
                    }
                });
                this.unreadsInitialized = true;
                onConfigureView(topIndicator, z2);
            }
        }
    }

    private final void onConfigureView(Model.Indicator indicator, boolean indicatorUpwards) {
        getBinding().f16083c.setBackgroundResource(getIcon(indicator));
        getBinding().f16082b.setText(getText(indicator));
        TextView textView = getBinding().f16082b;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelsListUnreads");
        DrawableCompat.setCompoundDrawablesCompat$default(textView, 0, 0, indicatorUpwards ? C5419R.drawable.ic_arrow_upward_white_16dp : C5419R.drawable.ic_arrow_downward_white_16dp, 0, 11, (Object) null);
        FrameLayout frameLayout = getBinding().f16081a;
        C12238m.checkNotNullExpressionValue(frameLayout, "it");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) marginLayoutParams;
            LayoutParamsExtensionsKt.removeRuleCompat(layoutParams2, indicatorUpwards ? 8 : 6);
            layoutParams2.addRule(indicatorUpwards ? 6 : 8, this.recycler.getId());
        } else {
            if (!(marginLayoutParams instanceof CoordinatorLayout.LayoutParams)) {
                throw new IllegalStateException("Unread Layout Params unrecognized");
            }
            CoordinatorLayout.LayoutParams layoutParams3 = (CoordinatorLayout.LayoutParams) marginLayoutParams;
            layoutParams3.anchorGravity = indicatorUpwards ? 48 : 80;
            layoutParams3.gravity = indicatorUpwards ? 80 : 48;
        }
        FrameLayout frameLayout2 = getBinding().f16081a;
        C12238m.checkNotNullExpressionValue(frameLayout2, "binding.root");
        frameLayout2.setLayoutParams(marginLayoutParams);
        FrameLayout frameLayout3 = getBinding().f16081a;
        C12238m.checkNotNullExpressionValue(frameLayout3, "binding.root");
        frameLayout3.setImportantForAccessibility(4);
    }

    public final int getMentionResId() {
        return this.mentionResId;
    }

    public final boolean getUnreadsEnabled() {
        return this.unreadsEnabled;
    }

    public final int getUnreadsResId() {
        return this.unreadsResId;
    }

    public final void onDatasetChanged(List<? extends Object> data) {
        C12238m.checkNotNullParameter(data, "data");
        this.data = data;
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this.recycler);
        if (coroutineScope != null) {
            C3404f.m4211H0(coroutineScope, null, null, new C74231(null), 3, null);
        }
    }

    public final void setMentionResId(int i) {
        this.mentionResId = i;
    }

    public final void setUnreadsEnabled(boolean z2) {
        this.unreadsEnabled = z2;
    }

    public final void setUnreadsResId(int i) {
        this.unreadsResId = i;
    }

    public /* synthetic */ WidgetChannelListUnreads(ViewStub viewStub, RecyclerView recyclerView, AppBarLayout appBarLayout, Function0 function0, int i, int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewStub, recyclerView, (i3 & 4) != 0 ? null : appBarLayout, function0, (i3 & 16) != 0 ? C5419R.string.new_mentions : i, (i3 & 32) != 0 ? C5419R.string.new_unreads : i2, (i3 & 64) != 0 ? true : z2);
    }
}
