package com.discord.widgets.channels.list;

import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import b.i.a.f.e.o.f;
import com.discord.databinding.WidgetChannelsListUnreadsBinding;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.layoutparams.LayoutParamsExtensionsKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.google.android.material.appbar.AppBarLayout;
import d0.g;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListUnreads {
    private static final WidgetChannelListUnreads$Companion Companion = new WidgetChannelListUnreads$Companion(null);

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

    public WidgetChannelListUnreads(ViewStub viewStub, RecyclerView recyclerView, AppBarLayout appBarLayout, Function0<Integer> function0, int i, int i2, boolean z2) {
        m.checkNotNullParameter(viewStub, "unreadsStub");
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(function0, "getItemCount");
        this.unreadsStub = viewStub;
        this.recycler = recyclerView;
        this.appBarLayout = appBarLayout;
        this.getItemCount = function0;
        this.mentionResId = i;
        this.unreadsResId = i2;
        this.unreadsEnabled = z2;
        this.binding = g.lazy(new WidgetChannelListUnreads$binding$2(this));
        this.data = n.emptyList();
        recyclerView.addOnScrollListener(new WidgetChannelListUnreads$1(this));
    }

    public static final /* synthetic */ ViewStub access$getUnreadsStub$p(WidgetChannelListUnreads widgetChannelListUnreads) {
        return widgetChannelListUnreads.unreadsStub;
    }

    public static final /* synthetic */ void access$handleClick(WidgetChannelListUnreads widgetChannelListUnreads, WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator, boolean z2) {
        widgetChannelListUnreads.handleClick(widgetChannelListUnreads$Model$Indicator, z2);
    }

    public static final /* synthetic */ void access$handleVisibleRangeUpdate(WidgetChannelListUnreads widgetChannelListUnreads) {
        widgetChannelListUnreads.handleVisibleRangeUpdate();
    }

    private final WidgetChannelsListUnreadsBinding getBinding() {
        return (WidgetChannelsListUnreadsBinding) this.binding.getValue();
    }

    private final int getIcon(WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator) {
        return widgetChannelListUnreads$Model$Indicator.getType() != 0 ? 2131231160 : 2131231162;
    }

    private final int getText(WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator) {
        return widgetChannelListUnreads$Model$Indicator.getType() != 0 ? this.unreadsResId : this.mentionResId;
    }

    private final void handleClick(WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator, boolean z2) {
        AppBarLayout appBarLayout;
        int iMax = z2 ? Math.max(widgetChannelListUnreads$Model$Indicator.getIndex() - 3, 0) : Math.min(widgetChannelListUnreads$Model$Indicator.getIndex() + 3, this.getItemCount.invoke().intValue() - 1);
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
        RecyclerView$LayoutManager layoutManager = this.recycler.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            WidgetChannelListUnreads$Model widgetChannelListUnreads$Model = WidgetChannelListUnreads$Model.Companion.get(new IntRange(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()), this.data, this.unreadsEnabled);
            WidgetChannelListUnreads$Model$Indicator topIndicator = widgetChannelListUnreads$Model.getTopIndicator();
            if (topIndicator == null) {
                topIndicator = widgetChannelListUnreads$Model.getBottomIndicator();
            }
            boolean z2 = widgetChannelListUnreads$Model.getTopIndicator() != null;
            if (topIndicator == null && this.unreadsInitialized) {
                ViewExtensions.fadeOut$default(getBinding().a, 150L, null, null, 6, null);
            } else if (topIndicator != null) {
                ViewExtensions.fadeIn$default(getBinding().a, 150L, null, null, null, 14, null);
                getBinding().a.setOnClickListener(new WidgetChannelListUnreads$handleVisibleRangeUpdate$1(this, topIndicator, z2));
                this.unreadsInitialized = true;
                onConfigureView(topIndicator, z2);
            }
        }
    }

    private final void onConfigureView(WidgetChannelListUnreads$Model$Indicator indicator, boolean indicatorUpwards) {
        getBinding().c.setBackgroundResource(getIcon(indicator));
        getBinding().f2300b.setText(getText(indicator));
        TextView textView = getBinding().f2300b;
        m.checkNotNullExpressionValue(textView, "binding.channelsListUnreads");
        DrawableCompat.setCompoundDrawablesCompat$default(textView, 0, 0, indicatorUpwards ? 2131231533 : 2131231526, 0, 11, (Object) null);
        FrameLayout frameLayout = getBinding().a;
        m.checkNotNullExpressionValue(frameLayout, "it");
        ViewGroup$LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup$MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        if (viewGroup$MarginLayoutParams instanceof RelativeLayout$LayoutParams) {
            RelativeLayout$LayoutParams relativeLayout$LayoutParams = (RelativeLayout$LayoutParams) viewGroup$MarginLayoutParams;
            LayoutParamsExtensionsKt.removeRuleCompat(relativeLayout$LayoutParams, indicatorUpwards ? 8 : 6);
            relativeLayout$LayoutParams.addRule(indicatorUpwards ? 6 : 8, this.recycler.getId());
        } else {
            if (!(viewGroup$MarginLayoutParams instanceof CoordinatorLayout$LayoutParams)) {
                throw new IllegalStateException("Unread Layout Params unrecognized");
            }
            CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams) viewGroup$MarginLayoutParams;
            coordinatorLayout$LayoutParams.anchorGravity = indicatorUpwards ? 48 : 80;
            coordinatorLayout$LayoutParams.gravity = indicatorUpwards ? 80 : 48;
        }
        FrameLayout frameLayout2 = getBinding().a;
        m.checkNotNullExpressionValue(frameLayout2, "binding.root");
        frameLayout2.setLayoutParams(viewGroup$MarginLayoutParams);
        FrameLayout frameLayout3 = getBinding().a;
        m.checkNotNullExpressionValue(frameLayout3, "binding.root");
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
        m.checkNotNullParameter(data, "data");
        this.data = data;
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this.recycler);
        if (coroutineScope != null) {
            f.H0(coroutineScope, null, null, new WidgetChannelListUnreads$onDatasetChanged$1(this, null), 3, null);
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
        this(viewStub, recyclerView, (i3 & 4) != 0 ? null : appBarLayout, function0, (i3 & 16) != 0 ? 2131893191 : i, (i3 & 32) != 0 ? 2131893206 : i2, (i3 & 64) != 0 ? true : z2);
    }
}
