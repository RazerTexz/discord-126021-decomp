package androidx.core.text;

import androidx.annotation.NonNull;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
    private PrecomputedTextCompat$Params mParams;
    private CharSequence mText;

    public PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback(@NonNull PrecomputedTextCompat$Params precomputedTextCompat$Params, @NonNull CharSequence charSequence) {
        this.mParams = precomputedTextCompat$Params;
        this.mText = charSequence;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ PrecomputedTextCompat call() throws Exception {
        return call();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public PrecomputedTextCompat call() throws Exception {
        return PrecomputedTextCompat.create(this.mText, this.mParams);
    }
}
