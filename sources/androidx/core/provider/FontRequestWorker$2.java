package androidx.core.provider;

import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class FontRequestWorker$2 implements Consumer<FontRequestWorker$TypefaceResult> {
    public final /* synthetic */ CallbackWithHandler val$callback;

    public FontRequestWorker$2(CallbackWithHandler callbackWithHandler) {
        this.val$callback = callbackWithHandler;
    }

    @Override // androidx.core.util.Consumer
    public /* bridge */ /* synthetic */ void accept(FontRequestWorker$TypefaceResult fontRequestWorker$TypefaceResult) {
        accept2(fontRequestWorker$TypefaceResult);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(FontRequestWorker$TypefaceResult fontRequestWorker$TypefaceResult) {
        this.val$callback.onTypefaceResult(fontRequestWorker$TypefaceResult);
    }
}
