package com.discord.utilities.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.MutablePropertyReference0Impl;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ContentResizingCoordinatorLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContentResizingCoordinatorLayout extends CoordinatorLayout {
    private AppBarLayout appBarLayout;
    private View content;
    private int currentVerticalOffset;

    /* JADX INFO: renamed from: com.discord.utilities.views.ContentResizingCoordinatorLayout$onMeasure$1, reason: invalid class name */
    /* JADX INFO: compiled from: ContentResizingCoordinatorLayout.kt */
    public final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout) {
            super(contentResizingCoordinatorLayout, ContentResizingCoordinatorLayout.class, "appBarLayout", "getAppBarLayout()Lcom/google/android/material/appbar/AppBarLayout;", 0);
        }

        @Override // d0.z.d.MutablePropertyReference0Impl, kotlin.reflect.KProperty6
        public Object get() {
            return ContentResizingCoordinatorLayout.access$getAppBarLayout$p((ContentResizingCoordinatorLayout) this.receiver);
        }

        @Override // d0.z.d.MutablePropertyReference0Impl
        public void set(Object obj) {
            ((ContentResizingCoordinatorLayout) this.receiver).appBarLayout = (AppBarLayout) obj;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.views.ContentResizingCoordinatorLayout$onMeasure$3, reason: invalid class name */
    /* JADX INFO: compiled from: ContentResizingCoordinatorLayout.kt */
    public static final class AnonymousClass3 extends Lambda implements Function2<Integer, Integer, Unit> {
        public final /* synthetic */ int $heightMeasureSpec;
        public final /* synthetic */ int $widthMeasureSpec;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(int i, int i2) {
            super(2);
            this.$widthMeasureSpec = i;
            this.$heightMeasureSpec = i2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = ContentResizingCoordinatorLayout.this;
            contentResizingCoordinatorLayout.updateContentLayoutParams(contentResizingCoordinatorLayout.currentVerticalOffset, ContentResizingCoordinatorLayout.access$getAppBarLayout$p(ContentResizingCoordinatorLayout.this).getMeasuredHeight(), ContentResizingCoordinatorLayout.this.getMeasuredHeight(), this.$widthMeasureSpec, this.$heightMeasureSpec);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentResizingCoordinatorLayout(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public static final /* synthetic */ AppBarLayout access$getAppBarLayout$p(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout) {
        AppBarLayout appBarLayout = contentResizingCoordinatorLayout.appBarLayout;
        if (appBarLayout == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
        }
        return appBarLayout;
    }

    private final void updateContentLayoutParams(int appBarVerticalOffset, int measuredAppBarHeight, int measuredContainerHeight, int widthMeasureSpec, int heightMeasureSpec) {
        int i = measuredAppBarHeight + appBarVerticalOffset;
        View view = this.content;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("content");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = measuredContainerHeight - i;
        View view2 = this.content;
        if (view2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("content");
        }
        view2.setLayoutParams(layoutParams);
        View view3 = this.content;
        if (view3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("content");
        }
        measureChild(view3, widthMeasureSpec, heightMeasureSpec);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (this.appBarLayout == null && getChildCount() >= 2) {
            View childAt = getChildAt(0);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout");
            this.appBarLayout = (AppBarLayout) childAt;
            View childAt2 = getChildAt(1);
            Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.view.View");
            this.content = childAt2;
            AppBarLayout appBarLayout = this.appBarLayout;
            if (appBarLayout == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
            }
            measureChild(appBarLayout, widthMeasureSpec, heightMeasureSpec);
            AppBarLayout appBarLayout2 = this.appBarLayout;
            if (appBarLayout2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
            }
            appBarLayout2.offsetTopAndBottom(0);
            AppBarLayout appBarLayout3 = this.appBarLayout;
            if (appBarLayout3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
            }
            updateContentLayoutParams(0, appBarLayout3.getMeasuredHeight(), size, widthMeasureSpec, heightMeasureSpec);
            AppBarLayout appBarLayout4 = this.appBarLayout;
            if (appBarLayout4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
            }
            appBarLayout4.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.discord.utilities.views.ContentResizingCoordinatorLayout.onMeasure.2
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout5, int i) {
                    ContentResizingCoordinatorLayout.this.currentVerticalOffset = i;
                    ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = ContentResizingCoordinatorLayout.this;
                    contentResizingCoordinatorLayout.updateContentLayoutParams(i, ContentResizingCoordinatorLayout.access$getAppBarLayout$p(contentResizingCoordinatorLayout).getMeasuredHeight(), ContentResizingCoordinatorLayout.this.getMeasuredHeight(), widthMeasureSpec, heightMeasureSpec);
                }
            });
            AppBarLayout appBarLayout5 = this.appBarLayout;
            if (appBarLayout5 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appBarLayout");
            }
            ViewExtensions.addOnHeightChangedListener(appBarLayout5, new AnonymousClass3(widthMeasureSpec, heightMeasureSpec));
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
