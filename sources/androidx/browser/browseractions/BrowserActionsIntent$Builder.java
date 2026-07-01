package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BrowserActionsIntent$Builder {
    private Context mContext;
    private Uri mUri;
    private final Intent mIntent = new Intent(BrowserActionsIntent.ACTION_BROWSER_ACTIONS_OPEN);
    private int mType = 0;
    private ArrayList<Bundle> mMenuItems = new ArrayList<>();

    @Nullable
    private PendingIntent mOnItemSelectedPendingIntent = null;
    private List<Uri> mImageUris = new ArrayList();

    public BrowserActionsIntent$Builder(@NonNull Context context, @NonNull Uri uri) {
        this.mContext = context;
        this.mUri = uri;
    }

    @NonNull
    private Bundle getBundleFromItem(@NonNull BrowserActionItem browserActionItem) {
        Bundle bundle = new Bundle();
        bundle.putString(BrowserActionsIntent.KEY_TITLE, browserActionItem.getTitle());
        bundle.putParcelable(BrowserActionsIntent.KEY_ACTION, browserActionItem.getAction());
        if (browserActionItem.getIconId() != 0) {
            bundle.putInt(BrowserActionsIntent.KEY_ICON_ID, browserActionItem.getIconId());
        }
        if (browserActionItem.getIconUri() != null) {
            bundle.putParcelable("androidx.browser.browseractions.ICON_URI", browserActionItem.getIconUri());
        }
        return bundle;
    }

    @NonNull
    public BrowserActionsIntent build() {
        this.mIntent.setData(this.mUri);
        this.mIntent.putExtra(BrowserActionsIntent.EXTRA_TYPE, this.mType);
        this.mIntent.putParcelableArrayListExtra(BrowserActionsIntent.EXTRA_MENU_ITEMS, this.mMenuItems);
        this.mIntent.putExtra(BrowserActionsIntent.EXTRA_APP_ID, PendingIntent.getActivity(this.mContext, 0, new Intent(), 0));
        PendingIntent pendingIntent = this.mOnItemSelectedPendingIntent;
        if (pendingIntent != null) {
            this.mIntent.putExtra(BrowserActionsIntent.EXTRA_SELECTED_ACTION_PENDING_INTENT, pendingIntent);
        }
        BrowserServiceFileProvider.grantReadPermission(this.mIntent, this.mImageUris, this.mContext);
        return new BrowserActionsIntent(this.mIntent);
    }

    @NonNull
    public BrowserActionsIntent$Builder setCustomItems(@NonNull ArrayList<BrowserActionItem> arrayList) {
        if (arrayList.size() > 5) {
            throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (TextUtils.isEmpty(arrayList.get(i).getTitle()) || arrayList.get(i).getAction() == null) {
                throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
            }
            this.mMenuItems.add(getBundleFromItem(arrayList.get(i)));
            if (arrayList.get(i).getIconUri() != null) {
                this.mImageUris.add(arrayList.get(i).getIconUri());
            }
        }
        return this;
    }

    @NonNull
    public BrowserActionsIntent$Builder setOnItemSelectedAction(@NonNull PendingIntent pendingIntent) {
        this.mOnItemSelectedPendingIntent = pendingIntent;
        return this;
    }

    @NonNull
    public BrowserActionsIntent$Builder setUrlType(int i) {
        this.mType = i;
        return this;
    }

    @NonNull
    public BrowserActionsIntent$Builder setCustomItems(@NonNull BrowserActionItem... browserActionItemArr) {
        return setCustomItems(new ArrayList<>(Arrays.asList(browserActionItemArr)));
    }
}
