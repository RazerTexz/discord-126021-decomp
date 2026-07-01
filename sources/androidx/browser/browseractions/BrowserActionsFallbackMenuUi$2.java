package androidx.browser.browseractions;

import android.content.DialogInterface;
import android.content.DialogInterface$OnShowListener;
import android.util.Log;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class BrowserActionsFallbackMenuUi$2 implements DialogInterface$OnShowListener {
    public final /* synthetic */ BrowserActionsFallbackMenuUi this$0;
    public final /* synthetic */ View val$view;

    public BrowserActionsFallbackMenuUi$2(BrowserActionsFallbackMenuUi browserActionsFallbackMenuUi, View view) {
        this.this$0 = browserActionsFallbackMenuUi;
        this.val$view = view;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        BrowserActionsFallbackMenuUi$BrowserActionsFallMenuUiListener browserActionsFallbackMenuUi$BrowserActionsFallMenuUiListener = this.this$0.mMenuUiListener;
        if (browserActionsFallbackMenuUi$BrowserActionsFallMenuUiListener == null) {
            Log.e("BrowserActionskMenuUi", "Cannot trigger menu item listener, it is null");
        } else {
            browserActionsFallbackMenuUi$BrowserActionsFallMenuUiListener.onMenuShown(this.val$view);
        }
    }
}
