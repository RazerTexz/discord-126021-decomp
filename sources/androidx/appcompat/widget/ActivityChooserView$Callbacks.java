package androidx.appcompat.widget;

import android.content.Intent;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.View$OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.PopupWindow$OnDismissListener;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView$Callbacks implements AdapterView$OnItemClickListener, View$OnClickListener, View$OnLongClickListener, PopupWindow$OnDismissListener {
    public final /* synthetic */ ActivityChooserView this$0;

    public ActivityChooserView$Callbacks(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    private void notifyOnDismissListener() {
        PopupWindow$OnDismissListener popupWindow$OnDismissListener = this.this$0.mOnDismissListener;
        if (popupWindow$OnDismissListener != null) {
            popupWindow$OnDismissListener.onDismiss();
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        ActivityChooserView activityChooserView = this.this$0;
        if (view != activityChooserView.mDefaultActivityButton) {
            if (view != activityChooserView.mExpandActivityOverflowButton) {
                throw new IllegalArgumentException();
            }
            activityChooserView.mIsSelectingDefaultActivity = false;
            activityChooserView.showPopupUnchecked(activityChooserView.mInitialActivityCount);
            return;
        }
        activityChooserView.dismissPopup();
        Intent intentChooseActivity = this.this$0.mAdapter.getDataModel().chooseActivity(this.this$0.mAdapter.getDataModel().getActivityIndex(this.this$0.mAdapter.getDefaultActivity()));
        if (intentChooseActivity != null) {
            intentChooseActivity.addFlags(524288);
            this.this$0.getContext().startActivity(intentChooseActivity);
        }
    }

    @Override // android.widget.PopupWindow$OnDismissListener
    public void onDismiss() {
        notifyOnDismissListener();
        ActionProvider actionProvider = this.this$0.mProvider;
        if (actionProvider != null) {
            actionProvider.subUiVisibilityChanged(false);
        }
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int itemViewType = ((ActivityChooserView$ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i);
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                throw new IllegalArgumentException();
            }
            this.this$0.showPopupUnchecked(Integer.MAX_VALUE);
            return;
        }
        this.this$0.dismissPopup();
        ActivityChooserView activityChooserView = this.this$0;
        if (activityChooserView.mIsSelectingDefaultActivity) {
            if (i > 0) {
                activityChooserView.mAdapter.getDataModel().setDefaultActivity(i);
                return;
            }
            return;
        }
        if (!activityChooserView.mAdapter.getShowDefaultActivity()) {
            i++;
        }
        Intent intentChooseActivity = this.this$0.mAdapter.getDataModel().chooseActivity(i);
        if (intentChooseActivity != null) {
            intentChooseActivity.addFlags(524288);
            this.this$0.getContext().startActivity(intentChooseActivity);
        }
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(View view) {
        ActivityChooserView activityChooserView = this.this$0;
        if (view != activityChooserView.mDefaultActivityButton) {
            throw new IllegalArgumentException();
        }
        if (activityChooserView.mAdapter.getCount() > 0) {
            ActivityChooserView activityChooserView2 = this.this$0;
            activityChooserView2.mIsSelectingDefaultActivity = true;
            activityChooserView2.showPopupUnchecked(activityChooserView2.mInitialActivityCount);
        }
        return true;
    }
}
