package androidx.browser.browseractions;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.widget.Toast;
import androidx.browser.R$string;

/* JADX INFO: loaded from: classes.dex */
public class BrowserActionsFallbackMenuUi$1 implements Runnable {
    public final /* synthetic */ BrowserActionsFallbackMenuUi this$0;

    public BrowserActionsFallbackMenuUi$1(BrowserActionsFallbackMenuUi browserActionsFallbackMenuUi) {
        this.this$0 = browserActionsFallbackMenuUi;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((ClipboardManager) this.this$0.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("url", this.this$0.mUri.toString()));
        Toast.makeText(this.this$0.mContext, this.this$0.mContext.getString(R$string.copy_toast_msg), 0).show();
    }
}
