package androidx.core.text;

import androidx.annotation.NonNull;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class PrecomputedTextCompat$PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {
    public PrecomputedTextCompat$PrecomputedTextFutureTask(@NonNull PrecomputedTextCompat$Params precomputedTextCompat$Params, @NonNull CharSequence charSequence) {
        super(new PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback(precomputedTextCompat$Params, charSequence));
    }
}
