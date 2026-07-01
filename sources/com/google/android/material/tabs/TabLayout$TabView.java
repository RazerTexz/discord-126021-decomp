package com.google.android.material.tabs;

import android.R$id;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.ripple.RippleUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class TabLayout$TabView extends LinearLayout {

    @Nullable
    private View badgeAnchorView;

    @Nullable
    private BadgeDrawable badgeDrawable;

    @Nullable
    private Drawable baseBackgroundDrawable;

    @Nullable
    private ImageView customIconView;

    @Nullable
    private TextView customTextView;

    @Nullable
    private View customView;
    private int defaultMaxLines;
    private ImageView iconView;
    private TabLayout$Tab tab;
    private TextView textView;
    public final /* synthetic */ TabLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabLayout$TabView(@NonNull TabLayout tabLayout, Context context) {
        super(context);
        this.this$0 = tabLayout;
        this.defaultMaxLines = 2;
        updateBackgroundDrawable(context);
        ViewCompat.setPaddingRelative(this, tabLayout.tabPaddingStart, tabLayout.tabPaddingTop, tabLayout.tabPaddingEnd, tabLayout.tabPaddingBottom);
        setGravity(17);
        setOrientation(!tabLayout.inlineLabel ? 1 : 0);
        setClickable(true);
        ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
    }

    public static /* synthetic */ void access$100(TabLayout$TabView tabLayout$TabView, Context context) {
        tabLayout$TabView.updateBackgroundDrawable(context);
    }

    public static /* synthetic */ void access$1000(TabLayout$TabView tabLayout$TabView, View view) {
        tabLayout$TabView.tryUpdateBadgeDrawableBounds(view);
    }

    public static /* synthetic */ void access$400(TabLayout$TabView tabLayout$TabView, Canvas canvas) {
        tabLayout$TabView.drawBackground(canvas);
    }

    public static /* synthetic */ boolean access$500(TabLayout$TabView tabLayout$TabView) {
        return tabLayout$TabView.hasBadgeDrawable();
    }

    public static /* synthetic */ BadgeDrawable access$600(TabLayout$TabView tabLayout$TabView) {
        return tabLayout$TabView.badgeDrawable;
    }

    public static /* synthetic */ BadgeDrawable access$700(TabLayout$TabView tabLayout$TabView) {
        return tabLayout$TabView.getOrCreateBadge();
    }

    public static /* synthetic */ void access$800(TabLayout$TabView tabLayout$TabView) {
        tabLayout$TabView.removeBadge();
    }

    public static /* synthetic */ BadgeDrawable access$900(TabLayout$TabView tabLayout$TabView) {
        return tabLayout$TabView.getBadge();
    }

    private void addOnLayoutChangeListener(@Nullable View view) {
        if (view == null) {
            return;
        }
        view.addOnLayoutChangeListener(new TabLayout$TabView$a(this, view));
    }

    private float approximateLineWidth(@NonNull Layout layout, int i, float f) {
        return (f / layout.getPaint().getTextSize()) * layout.getLineWidth(i);
    }

    private void clipViewToPaddingForBadge(boolean z2) {
        setClipChildren(z2);
        setClipToPadding(z2);
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(z2);
            viewGroup.setClipToPadding(z2);
        }
    }

    @NonNull
    private FrameLayout createPreApi18BadgeAnchorRoot() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout$LayoutParams(-2, -2));
        return frameLayout;
    }

    private void drawBackground(@NonNull Canvas canvas) {
        Drawable drawable = this.baseBackgroundDrawable;
        if (drawable != null) {
            drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
            this.baseBackgroundDrawable.draw(canvas);
        }
    }

    @Nullable
    private BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    @Nullable
    private FrameLayout getCustomParentForBadge(@NonNull View view) {
        if ((view == this.iconView || view == this.textView) && BadgeUtils.USE_COMPAT_PARENT) {
            return (FrameLayout) view.getParent();
        }
        return null;
    }

    @NonNull
    private BadgeDrawable getOrCreateBadge() {
        if (this.badgeDrawable == null) {
            this.badgeDrawable = BadgeDrawable.create(getContext());
        }
        tryUpdateBadgeAnchor();
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        if (badgeDrawable != null) {
            return badgeDrawable;
        }
        throw new IllegalStateException("Unable to create badge");
    }

    private boolean hasBadgeDrawable() {
        return this.badgeDrawable != null;
    }

    private void inflateAndAddDefaultIconView() {
        ViewGroup viewGroup;
        if (BadgeUtils.USE_COMPAT_PARENT) {
            FrameLayout frameLayoutCreatePreApi18BadgeAnchorRoot = createPreApi18BadgeAnchorRoot();
            addView(frameLayoutCreatePreApi18BadgeAnchorRoot, 0);
            viewGroup = frameLayoutCreatePreApi18BadgeAnchorRoot;
        } else {
            viewGroup = this;
        }
        ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, viewGroup, false);
        this.iconView = imageView;
        viewGroup.addView(imageView, 0);
    }

    private void inflateAndAddDefaultTextView() {
        ViewGroup viewGroup;
        if (BadgeUtils.USE_COMPAT_PARENT) {
            FrameLayout frameLayoutCreatePreApi18BadgeAnchorRoot = createPreApi18BadgeAnchorRoot();
            addView(frameLayoutCreatePreApi18BadgeAnchorRoot);
            viewGroup = frameLayoutCreatePreApi18BadgeAnchorRoot;
        } else {
            viewGroup = this;
        }
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, viewGroup, false);
        this.textView = textView;
        viewGroup.addView(textView);
    }

    private void removeBadge() {
        if (this.badgeAnchorView != null) {
            tryRemoveBadgeFromAnchor();
        }
        this.badgeDrawable = null;
    }

    private void tryAttachBadgeToAnchor(@Nullable View view) {
        if (hasBadgeDrawable() && view != null) {
            clipViewToPaddingForBadge(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
            this.badgeAnchorView = view;
        }
    }

    private void tryRemoveBadgeFromAnchor() {
        if (hasBadgeDrawable()) {
            clipViewToPaddingForBadge(true);
            View view = this.badgeAnchorView;
            if (view != null) {
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
                this.badgeAnchorView = null;
            }
        }
    }

    private void tryUpdateBadgeAnchor() {
        TabLayout$Tab tabLayout$Tab;
        TabLayout$Tab tabLayout$Tab2;
        if (hasBadgeDrawable()) {
            if (this.customView != null) {
                tryRemoveBadgeFromAnchor();
                return;
            }
            if (this.iconView != null && (tabLayout$Tab2 = this.tab) != null && tabLayout$Tab2.getIcon() != null) {
                View view = this.badgeAnchorView;
                ImageView imageView = this.iconView;
                if (view == imageView) {
                    tryUpdateBadgeDrawableBounds(imageView);
                    return;
                } else {
                    tryRemoveBadgeFromAnchor();
                    tryAttachBadgeToAnchor(this.iconView);
                    return;
                }
            }
            if (this.textView == null || (tabLayout$Tab = this.tab) == null || tabLayout$Tab.getTabLabelVisibility() != 1) {
                tryRemoveBadgeFromAnchor();
                return;
            }
            View view2 = this.badgeAnchorView;
            TextView textView = this.textView;
            if (view2 == textView) {
                tryUpdateBadgeDrawableBounds(textView);
            } else {
                tryRemoveBadgeFromAnchor();
                tryAttachBadgeToAnchor(this.textView);
            }
        }
    }

    private void tryUpdateBadgeDrawableBounds(@NonNull View view) {
        if (hasBadgeDrawable() && view == this.badgeAnchorView) {
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void updateBackgroundDrawable(Context context) {
        GradientDrawable gradientDrawable;
        int i = this.this$0.tabBackgroundResId;
        if (i != 0) {
            Drawable drawable = AppCompatResources.getDrawable(context, i);
            this.baseBackgroundDrawable = drawable;
            if (drawable != null && drawable.isStateful()) {
                this.baseBackgroundDrawable.setState(getDrawableState());
            }
        } else {
            this.baseBackgroundDrawable = null;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(0);
        Drawable rippleDrawable = gradientDrawable2;
        if (this.this$0.tabRippleColorStateList != null) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setCornerRadius(1.0E-5f);
            gradientDrawable3.setColor(-1);
            ColorStateList colorStateListConvertToRippleDrawableColor = RippleUtils.convertToRippleDrawableColor(this.this$0.tabRippleColorStateList);
            boolean z2 = this.this$0.unboundedRipple;
            if (z2) {
                gradientDrawable = gradientDrawable2;
                gradientDrawable = null;
            }
            rippleDrawable = new RippleDrawable(colorStateListConvertToRippleDrawableColor, gradientDrawable, z2 ? null : gradientDrawable3);
        }
        ViewCompat.setBackground(this, rippleDrawable);
        this.this$0.invalidate();
    }

    private void updateTextAndIcon(@Nullable TextView textView, @Nullable ImageView imageView) {
        TabLayout$Tab tabLayout$Tab = this.tab;
        Drawable drawableMutate = (tabLayout$Tab == null || tabLayout$Tab.getIcon() == null) ? null : DrawableCompat.wrap(this.tab.getIcon()).mutate();
        TabLayout$Tab tabLayout$Tab2 = this.tab;
        CharSequence text = tabLayout$Tab2 != null ? tabLayout$Tab2.getText() : null;
        if (imageView != null) {
            if (drawableMutate != null) {
                imageView.setImageDrawable(drawableMutate);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
        }
        boolean z2 = !TextUtils.isEmpty(text);
        if (textView != null) {
            if (z2) {
                textView.setText(text);
                if (TabLayout$Tab.access$1100(this.tab) == 1) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                setVisibility(0);
            } else {
                textView.setVisibility(8);
                textView.setText((CharSequence) null);
            }
        }
        if (imageView != null) {
            ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) imageView.getLayoutParams();
            int iDpToPx = (z2 && imageView.getVisibility() == 0) ? (int) ViewUtils.dpToPx(getContext(), 8) : 0;
            if (this.this$0.inlineLabel) {
                if (iDpToPx != MarginLayoutParamsCompat.getMarginEnd(viewGroup$MarginLayoutParams)) {
                    MarginLayoutParamsCompat.setMarginEnd(viewGroup$MarginLayoutParams, iDpToPx);
                    viewGroup$MarginLayoutParams.bottomMargin = 0;
                    imageView.setLayoutParams(viewGroup$MarginLayoutParams);
                    imageView.requestLayout();
                }
            } else if (iDpToPx != viewGroup$MarginLayoutParams.bottomMargin) {
                viewGroup$MarginLayoutParams.bottomMargin = iDpToPx;
                MarginLayoutParamsCompat.setMarginEnd(viewGroup$MarginLayoutParams, 0);
                imageView.setLayoutParams(viewGroup$MarginLayoutParams);
                imageView.requestLayout();
            }
        }
        TabLayout$Tab tabLayout$Tab3 = this.tab;
        CharSequence charSequenceAccess$200 = tabLayout$Tab3 != null ? TabLayout$Tab.access$200(tabLayout$Tab3) : null;
        if (!z2) {
            text = charSequenceAccess$200;
        }
        TooltipCompat.setTooltipText(this, text);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.baseBackgroundDrawable;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | this.baseBackgroundDrawable.setState(drawableState);
        }
        if (state) {
            invalidate();
            this.this$0.invalidate();
        }
    }

    public int getContentHeight() {
        View[] viewArr = {this.textView, this.iconView, this.customView};
        int iMax = 0;
        int iMin = 0;
        boolean z2 = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z2 ? Math.min(iMin, view.getTop()) : view.getTop();
                iMax = z2 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                z2 = true;
            }
        }
        return iMax - iMin;
    }

    public int getContentWidth() {
        View[] viewArr = {this.textView, this.iconView, this.customView};
        int iMax = 0;
        int iMin = 0;
        boolean z2 = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z2 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                iMax = z2 ? Math.max(iMax, view.getRight()) : view.getRight();
                z2 = true;
            }
        }
        return iMax - iMin;
    }

    @Nullable
    public TabLayout$Tab getTab() {
        return this.tab;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.badgeDrawable.getContentDescription()));
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat$CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, isSelected()));
        if (isSelected()) {
            accessibilityNodeInfoCompatWrap.setClickable(false);
            accessibilityNodeInfoCompatWrap.removeAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_CLICK);
        }
        accessibilityNodeInfoCompatWrap.setRoleDescription(getResources().getString(R$string.item_view_role_description));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Layout layout;
        int size = View$MeasureSpec.getSize(i);
        int mode = View$MeasureSpec.getMode(i);
        int tabMaxWidth = this.this$0.getTabMaxWidth();
        if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
            i = View$MeasureSpec.makeMeasureSpec(this.this$0.tabMaxWidth, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.textView != null) {
            float f = this.this$0.tabTextSize;
            int i3 = this.defaultMaxLines;
            ImageView imageView = this.iconView;
            boolean z2 = true;
            if (imageView == null || imageView.getVisibility() != 0) {
                TextView textView = this.textView;
                if (textView != null && textView.getLineCount() > 1) {
                    f = this.this$0.tabTextMultiLineSize;
                }
            } else {
                i3 = 1;
            }
            float textSize = this.textView.getTextSize();
            int lineCount = this.textView.getLineCount();
            int maxLines = TextViewCompat.getMaxLines(this.textView);
            if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                if (this.this$0.mode == 1 && f > textSize && lineCount == 1 && ((layout = this.textView.getLayout()) == null || approximateLineWidth(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                    z2 = false;
                }
                if (z2) {
                    this.textView.setTextSize(0, f);
                    this.textView.setMaxLines(i3);
                    super.onMeasure(i, i2);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (this.tab == null) {
            return zPerformClick;
        }
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        this.tab.select();
        return true;
    }

    public void reset() {
        setTab(null);
        setSelected(false);
    }

    @Override // android.view.View
    public void setSelected(boolean z2) {
        if (isSelected() != z2) {
        }
        super.setSelected(z2);
        TextView textView = this.textView;
        if (textView != null) {
            textView.setSelected(z2);
        }
        ImageView imageView = this.iconView;
        if (imageView != null) {
            imageView.setSelected(z2);
        }
        View view = this.customView;
        if (view != null) {
            view.setSelected(z2);
        }
    }

    public void setTab(@Nullable TabLayout$Tab tabLayout$Tab) {
        if (tabLayout$Tab != this.tab) {
            this.tab = tabLayout$Tab;
            update();
        }
    }

    public final void update() {
        TabLayout$Tab tabLayout$Tab = this.tab;
        Drawable drawableMutate = null;
        View customView = tabLayout$Tab != null ? tabLayout$Tab.getCustomView() : null;
        if (customView != null) {
            ViewParent parent = customView.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((ViewGroup) parent).removeView(customView);
                }
                addView(customView);
            }
            this.customView = customView;
            TextView textView = this.textView;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.iconView.setImageDrawable(null);
            }
            TextView textView2 = (TextView) customView.findViewById(R$id.text1);
            this.customTextView = textView2;
            if (textView2 != null) {
                this.defaultMaxLines = TextViewCompat.getMaxLines(textView2);
            }
            this.customIconView = (ImageView) customView.findViewById(R$id.icon);
        } else {
            View view = this.customView;
            if (view != null) {
                removeView(view);
                this.customView = null;
            }
            this.customTextView = null;
            this.customIconView = null;
        }
        if (this.customView == null) {
            if (this.iconView == null) {
                inflateAndAddDefaultIconView();
            }
            if (tabLayout$Tab != null && tabLayout$Tab.getIcon() != null) {
                drawableMutate = DrawableCompat.wrap(tabLayout$Tab.getIcon()).mutate();
            }
            if (drawableMutate != null) {
                DrawableCompat.setTintList(drawableMutate, this.this$0.tabIconTint);
                PorterDuff$Mode porterDuff$Mode = this.this$0.tabIconTintMode;
                if (porterDuff$Mode != null) {
                    DrawableCompat.setTintMode(drawableMutate, porterDuff$Mode);
                }
            }
            if (this.textView == null) {
                inflateAndAddDefaultTextView();
                this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
            }
            TextViewCompat.setTextAppearance(this.textView, this.this$0.tabTextAppearance);
            ColorStateList colorStateList = this.this$0.tabTextColors;
            if (colorStateList != null) {
                this.textView.setTextColor(colorStateList);
            }
            updateTextAndIcon(this.textView, this.iconView);
            tryUpdateBadgeAnchor();
            addOnLayoutChangeListener(this.iconView);
            addOnLayoutChangeListener(this.textView);
        } else {
            TextView textView3 = this.customTextView;
            if (textView3 != null || this.customIconView != null) {
                updateTextAndIcon(textView3, this.customIconView);
            }
        }
        if (tabLayout$Tab != null && !TextUtils.isEmpty(TabLayout$Tab.access$200(tabLayout$Tab))) {
            setContentDescription(TabLayout$Tab.access$200(tabLayout$Tab));
        }
        setSelected(tabLayout$Tab != null && tabLayout$Tab.isSelected());
    }

    public final void updateOrientation() {
        setOrientation(!this.this$0.inlineLabel ? 1 : 0);
        TextView textView = this.customTextView;
        if (textView == null && this.customIconView == null) {
            updateTextAndIcon(this.textView, this.iconView);
        } else {
            updateTextAndIcon(textView, this.customIconView);
        }
    }
}
