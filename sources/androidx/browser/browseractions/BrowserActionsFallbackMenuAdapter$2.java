package androidx.browser.browseractions;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class BrowserActionsFallbackMenuAdapter$2 implements Executor {
    public final /* synthetic */ BrowserActionsFallbackMenuAdapter this$0;

    public BrowserActionsFallbackMenuAdapter$2(BrowserActionsFallbackMenuAdapter browserActionsFallbackMenuAdapter) {
        this.this$0 = browserActionsFallbackMenuAdapter;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        runnable.run();
    }
}
