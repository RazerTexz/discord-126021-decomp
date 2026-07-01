package androidx.appcompat.widget;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class ShareActionProvider$ShareActivityChooserModelPolicy implements ActivityChooserModel$OnChooseActivityListener {
    public final /* synthetic */ ShareActionProvider this$0;

    public ShareActionProvider$ShareActivityChooserModelPolicy(ShareActionProvider shareActionProvider) {
        this.this$0 = shareActionProvider;
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel$OnChooseActivityListener
    public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
        ShareActionProvider shareActionProvider = this.this$0;
        ShareActionProvider$OnShareTargetSelectedListener shareActionProvider$OnShareTargetSelectedListener = shareActionProvider.mOnShareTargetSelectedListener;
        if (shareActionProvider$OnShareTargetSelectedListener == null) {
            return false;
        }
        shareActionProvider$OnShareTargetSelectedListener.onShareTargetSelected(shareActionProvider, intent);
        return false;
    }
}
