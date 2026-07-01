package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils$TruncateAt;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar$Tab;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes.dex */
public class ScrollingTabContainerView$TabView extends LinearLayout {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
    private final int[] BG_ATTRS;
    private View mCustomView;
    private ImageView mIconView;
    private ActionBar$Tab mTab;
    private TextView mTextView;
    public final /* synthetic */ ScrollingTabContainerView this$0;

    /* JADX WARN: Illegal instructions before constructor call */
    public ScrollingTabContainerView$TabView(ScrollingTabContainerView scrollingTabContainerView, Context context, ActionBar$Tab actionBar$Tab, boolean z2) {
        this.this$0 = scrollingTabContainerView;
        int i = R$attr.actionBarTabStyle;
        super(context, null, i);
        int[] iArr = {android.R$attr.background};
        this.BG_ATTRS = iArr;
        this.mTab = actionBar$Tab;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, null, iArr, i, 0);
        if (tintTypedArrayObtainStyledAttributes.hasValue(0)) {
            setBackgroundDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(0));
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        if (z2) {
            setGravity(8388627);
        }
        update();
    }

    public void bindTab(ActionBar$Tab actionBar$Tab) {
        this.mTab = actionBar$Tab;
        update();
    }

    public ActionBar$Tab getTab() {
        return this.mTab;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.this$0.mMaxTabWidth > 0) {
            int measuredWidth = getMeasuredWidth();
            int i3 = this.this$0.mMaxTabWidth;
            if (measuredWidth > i3) {
                super.onMeasure(View$MeasureSpec.makeMeasureSpec(i3, BasicMeasure.EXACTLY), i2);
            }
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z2) {
        boolean z3 = isSelected() != z2;
        super.setSelected(z2);
        if (z3 && z2) {
            sendAccessibilityEvent(4);
        }
    }

    public void update() {
        ActionBar$Tab actionBar$Tab = this.mTab;
        View customView = actionBar$Tab.getCustomView();
        if (customView != null) {
            ViewParent parent = customView.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((ViewGroup) parent).removeView(customView);
                }
                addView(customView);
            }
            this.mCustomView = customView;
            TextView textView = this.mTextView;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.mIconView;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.mIconView.setImageDrawable(null);
                return;
            }
            return;
        }
        View view = this.mCustomView;
        if (view != null) {
            removeView(view);
            this.mCustomView = null;
        }
        Drawable icon = actionBar$Tab.getIcon();
        CharSequence text = actionBar$Tab.getText();
        if (icon != null) {
            if (this.mIconView == null) {
                AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, -2);
                linearLayout$LayoutParams.gravity = 16;
                appCompatImageView.setLayoutParams(linearLayout$LayoutParams);
                addView(appCompatImageView, 0);
                this.mIconView = appCompatImageView;
            }
            this.mIconView.setImageDrawable(icon);
            this.mIconView.setVisibility(0);
        } else {
            ImageView imageView2 = this.mIconView;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                this.mIconView.setImageDrawable(null);
            }
        }
        boolean z2 = !TextUtils.isEmpty(text);
        if (z2) {
            if (this.mTextView == null) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R$attr.actionBarTabTextStyle);
                appCompatTextView.setEllipsize(TextUtils$TruncateAt.END);
                LinearLayout$LayoutParams linearLayout$LayoutParams2 = new LinearLayout$LayoutParams(-2, -2);
                linearLayout$LayoutParams2.gravity = 16;
                appCompatTextView.setLayoutParams(linearLayout$LayoutParams2);
                addView(appCompatTextView);
                this.mTextView = appCompatTextView;
            }
            this.mTextView.setText(text);
            this.mTextView.setVisibility(0);
        } else {
            TextView textView2 = this.mTextView;
            if (textView2 != null) {
                textView2.setVisibility(8);
                this.mTextView.setText((CharSequence) null);
            }
        }
        ImageView imageView3 = this.mIconView;
        if (imageView3 != null) {
            imageView3.setContentDescription(actionBar$Tab.getContentDescription());
        }
        TooltipCompat.setTooltipText(this, z2 ? null : actionBar$Tab.getContentDescription());
    }
}
