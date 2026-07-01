package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.app.PendingIntent$CanceledException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.VisibleForTesting;
import androidx.browser.R$id;
import androidx.browser.R$layout;
import androidx.browser.R$string;
import com.discord.restapi.RestAPIBuilder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BrowserActionsFallbackMenuUi implements AdapterView$OnItemClickListener {
    private static final String TAG = "BrowserActionskMenuUi";

    @Nullable
    private BrowserActionsFallbackMenuDialog mBrowserActionsDialog;
    public final Context mContext;
    private final List<BrowserActionItem> mMenuItems;

    @Nullable
    public BrowserActionsFallbackMenuUi$BrowserActionsFallMenuUiListener mMenuUiListener;
    public final Uri mUri;

    public BrowserActionsFallbackMenuUi(@NonNull Context context, @NonNull Uri uri, @NonNull List<BrowserActionItem> list) {
        this.mContext = context;
        this.mUri = uri;
        this.mMenuItems = buildFallbackMenuItemList(list);
    }

    private Runnable buildCopyAction() {
        return new BrowserActionsFallbackMenuUi$1(this);
    }

    @NonNull
    private List<BrowserActionItem> buildFallbackMenuItemList(List<BrowserActionItem> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BrowserActionItem(this.mContext.getString(R$string.fallback_menu_item_open_in_browser), buildOpenInBrowserAction()));
        arrayList.add(new BrowserActionItem(this.mContext.getString(R$string.fallback_menu_item_copy_link), buildCopyAction()));
        arrayList.add(new BrowserActionItem(this.mContext.getString(R$string.fallback_menu_item_share_link), buildShareAction()));
        arrayList.addAll(list);
        return arrayList;
    }

    private PendingIntent buildOpenInBrowserAction() {
        return PendingIntent.getActivity(this.mContext, 0, new Intent("android.intent.action.VIEW", this.mUri), 0);
    }

    private PendingIntent buildShareAction() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", this.mUri.toString());
        intent.setType(RestAPIBuilder.CONTENT_TYPE_TEXT);
        return PendingIntent.getActivity(this.mContext, 0, intent, 0);
    }

    private BrowserActionsFallbackMenuView initMenuView(View view) {
        BrowserActionsFallbackMenuView browserActionsFallbackMenuView = (BrowserActionsFallbackMenuView) view.findViewById(R$id.browser_actions_menu_view);
        TextView textView = (TextView) view.findViewById(R$id.browser_actions_header_text);
        textView.setText(this.mUri.toString());
        textView.setOnClickListener(new BrowserActionsFallbackMenuUi$3(this, textView));
        ListView listView = (ListView) view.findViewById(R$id.browser_actions_menu_items);
        listView.setAdapter((ListAdapter) new BrowserActionsFallbackMenuAdapter(this.mMenuItems, this.mContext));
        listView.setOnItemClickListener(this);
        return browserActionsFallbackMenuView;
    }

    public void displayMenu() {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.browser_actions_context_menu_page, (ViewGroup) null);
        BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog = new BrowserActionsFallbackMenuDialog(this.mContext, initMenuView(viewInflate));
        this.mBrowserActionsDialog = browserActionsFallbackMenuDialog;
        browserActionsFallbackMenuDialog.setContentView(viewInflate);
        if (this.mMenuUiListener != null) {
            this.mBrowserActionsDialog.setOnShowListener(new BrowserActionsFallbackMenuUi$2(this, viewInflate));
        }
        this.mBrowserActionsDialog.show();
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BrowserActionItem browserActionItem = this.mMenuItems.get(i);
        if (browserActionItem.getAction() != null) {
            try {
                browserActionItem.getAction().send();
            } catch (PendingIntent$CanceledException e) {
                Log.e(TAG, "Failed to send custom item action", e);
            }
        } else if (browserActionItem.getRunnableAction() != null) {
            browserActionItem.getRunnableAction().run();
        }
        BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog = this.mBrowserActionsDialog;
        if (browserActionsFallbackMenuDialog == null) {
            Log.e(TAG, "Cannot dismiss dialog, it has already been dismissed.");
        } else {
            browserActionsFallbackMenuDialog.dismiss();
        }
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public void setMenuUiListener(@Nullable BrowserActionsFallbackMenuUi$BrowserActionsFallMenuUiListener browserActionsFallbackMenuUi$BrowserActionsFallMenuUiListener) {
        this.mMenuUiListener = browserActionsFallbackMenuUi$BrowserActionsFallMenuUiListener;
    }
}
