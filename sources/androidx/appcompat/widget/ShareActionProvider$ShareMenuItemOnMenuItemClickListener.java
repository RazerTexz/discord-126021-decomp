package androidx.appcompat.widget;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;

/* JADX INFO: loaded from: classes.dex */
public class ShareActionProvider$ShareMenuItemOnMenuItemClickListener implements MenuItem$OnMenuItemClickListener {
    public final /* synthetic */ ShareActionProvider this$0;

    public ShareActionProvider$ShareMenuItemOnMenuItemClickListener(ShareActionProvider shareActionProvider) {
        this.this$0 = shareActionProvider;
    }

    @Override // android.view.MenuItem$OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        ShareActionProvider shareActionProvider = this.this$0;
        Intent intentChooseActivity = ActivityChooserModel.get(shareActionProvider.mContext, shareActionProvider.mShareHistoryFileName).chooseActivity(menuItem.getItemId());
        if (intentChooseActivity == null) {
            return true;
        }
        String action = intentChooseActivity.getAction();
        if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
            this.this$0.updateIntent(intentChooseActivity);
        }
        this.this$0.mContext.startActivity(intentChooseActivity);
        return true;
    }
}
