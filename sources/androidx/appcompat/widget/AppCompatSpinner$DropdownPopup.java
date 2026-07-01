package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public class AppCompatSpinner$DropdownPopup extends ListPopupWindow implements AppCompatSpinner$SpinnerPopup {
    public ListAdapter mAdapter;
    private CharSequence mHintText;
    private int mOriginalHorizontalOffset;
    private final Rect mVisibleRect;
    public final /* synthetic */ AppCompatSpinner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatSpinner$DropdownPopup(AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.this$0 = appCompatSpinner;
        this.mVisibleRect = new Rect();
        setAnchorView(appCompatSpinner);
        setModal(true);
        setPromptPosition(0);
        setOnItemClickListener(new AppCompatSpinner$DropdownPopup$1(this, appCompatSpinner));
    }

    public static /* synthetic */ void access$001(AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup) {
        super.show();
    }

    public void computeContentWidth() {
        Drawable background = getBackground();
        int i = 0;
        if (background != null) {
            background.getPadding(this.this$0.mTempRect);
            i = ViewUtils.isLayoutRtl(this.this$0) ? this.this$0.mTempRect.right : -this.this$0.mTempRect.left;
        } else {
            Rect rect = this.this$0.mTempRect;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = this.this$0.getPaddingLeft();
        int paddingRight = this.this$0.getPaddingRight();
        int width = this.this$0.getWidth();
        AppCompatSpinner appCompatSpinner = this.this$0;
        int i2 = appCompatSpinner.mDropDownWidth;
        if (i2 == -2) {
            int iCompatMeasureContentWidth = appCompatSpinner.compatMeasureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
            int i3 = this.this$0.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.this$0.mTempRect;
            int i4 = (i3 - rect2.left) - rect2.right;
            if (iCompatMeasureContentWidth > i4) {
                iCompatMeasureContentWidth = i4;
            }
            setContentWidth(Math.max(iCompatMeasureContentWidth, (width - paddingLeft) - paddingRight));
        } else if (i2 == -1) {
            setContentWidth((width - paddingLeft) - paddingRight);
        } else {
            setContentWidth(i2);
        }
        setHorizontalOffset(ViewUtils.isLayoutRtl(this.this$0) ? (((width - paddingRight) - getWidth()) - getHorizontalOriginalOffset()) + i : getHorizontalOriginalOffset() + paddingLeft + i);
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public CharSequence getHintText() {
        return this.mHintText;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public int getHorizontalOriginalOffset() {
        return this.mOriginalHorizontalOffset;
    }

    public boolean isVisibleToUser(View view) {
        return ViewCompat.isAttachedToWindow(view) && view.getGlobalVisibleRect(this.mVisibleRect);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.mAdapter = listAdapter;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void setHorizontalOriginalOffset(int i) {
        this.mOriginalHorizontalOffset = i;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void setPromptText(CharSequence charSequence) {
        this.mHintText = charSequence;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void show(int i, int i2) {
        ViewTreeObserver viewTreeObserver;
        boolean zIsShowing = isShowing();
        computeContentWidth();
        setInputMethodMode(2);
        super.show();
        ListView listView = getListView();
        listView.setChoiceMode(1);
        listView.setTextDirection(i);
        listView.setTextAlignment(i2);
        setSelection(this.this$0.getSelectedItemPosition());
        if (zIsShowing || (viewTreeObserver = this.this$0.getViewTreeObserver()) == null) {
            return;
        }
        AppCompatSpinner$DropdownPopup$2 appCompatSpinner$DropdownPopup$2 = new AppCompatSpinner$DropdownPopup$2(this);
        viewTreeObserver.addOnGlobalLayoutListener(appCompatSpinner$DropdownPopup$2);
        setOnDismissListener(new AppCompatSpinner$DropdownPopup$3(this, appCompatSpinner$DropdownPopup$2));
    }
}
