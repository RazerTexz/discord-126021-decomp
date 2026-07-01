package androidx.browser.browseractions;

import android.text.TextUtils$TruncateAt;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class BrowserActionsFallbackMenuUi$3 implements View$OnClickListener {
    public final /* synthetic */ BrowserActionsFallbackMenuUi this$0;
    public final /* synthetic */ TextView val$urlTextView;

    public BrowserActionsFallbackMenuUi$3(BrowserActionsFallbackMenuUi browserActionsFallbackMenuUi, TextView textView) {
        this.this$0 = browserActionsFallbackMenuUi;
        this.val$urlTextView = textView;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        if (TextViewCompat.getMaxLines(this.val$urlTextView) == Integer.MAX_VALUE) {
            this.val$urlTextView.setMaxLines(1);
            this.val$urlTextView.setEllipsize(TextUtils$TruncateAt.END);
        } else {
            this.val$urlTextView.setMaxLines(Integer.MAX_VALUE);
            this.val$urlTextView.setEllipsize(null);
        }
    }
}
