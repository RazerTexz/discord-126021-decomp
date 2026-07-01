package androidx.browser.browseractions;

import android.graphics.Bitmap;
import android.text.TextUtils;
import b.i.b.d.a.a;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class BrowserActionsFallbackMenuAdapter$1 implements Runnable {
    public final /* synthetic */ BrowserActionsFallbackMenuAdapter this$0;
    public final /* synthetic */ a val$bitmapFuture;
    public final /* synthetic */ String val$titleText;
    public final /* synthetic */ BrowserActionsFallbackMenuAdapter$ViewHolderItem val$viewHolder;

    public BrowserActionsFallbackMenuAdapter$1(BrowserActionsFallbackMenuAdapter browserActionsFallbackMenuAdapter, String str, BrowserActionsFallbackMenuAdapter$ViewHolderItem browserActionsFallbackMenuAdapter$ViewHolderItem, a aVar) {
        this.this$0 = browserActionsFallbackMenuAdapter;
        this.val$titleText = str;
        this.val$viewHolder = browserActionsFallbackMenuAdapter$ViewHolderItem;
        this.val$bitmapFuture = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        if (TextUtils.equals(this.val$titleText, this.val$viewHolder.mText.getText())) {
            try {
                bitmap = (Bitmap) this.val$bitmapFuture.get();
            } catch (InterruptedException | ExecutionException unused) {
                bitmap = null;
            }
            if (bitmap != null) {
                this.val$viewHolder.mIcon.setVisibility(0);
                this.val$viewHolder.mIcon.setImageBitmap(bitmap);
            } else {
                this.val$viewHolder.mIcon.setVisibility(4);
                this.val$viewHolder.mIcon.setImageBitmap(null);
            }
        }
    }
}
