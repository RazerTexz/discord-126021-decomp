package androidx.core.provider;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class FontRequestWorker$1 implements Callable<FontRequestWorker$TypefaceResult> {
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ String val$id;
    public final /* synthetic */ FontRequest val$request;
    public final /* synthetic */ int val$style;

    public FontRequestWorker$1(String str, Context context, FontRequest fontRequest, int i) {
        this.val$id = str;
        this.val$context = context;
        this.val$request = fontRequest;
        this.val$style = i;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ FontRequestWorker$TypefaceResult call() throws Exception {
        return call();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public FontRequestWorker$TypefaceResult call() {
        return FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$request, this.val$style);
    }
}
