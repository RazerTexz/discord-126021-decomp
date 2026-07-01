package androidx.core.widget;

import android.content.ClipData$Item;
import android.content.Context;
import android.text.Spanned;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class TextViewOnReceiveContentListener$ApiImpl {
    private TextViewOnReceiveContentListener$ApiImpl() {
    }

    public static CharSequence coerce(@NonNull Context context, @NonNull ClipData$Item clipData$Item, int i) {
        CharSequence charSequenceCoerceToText = clipData$Item.coerceToText(context);
        return ((i & 1) == 0 || !(charSequenceCoerceToText instanceof Spanned)) ? charSequenceCoerceToText : charSequenceCoerceToText.toString();
    }
}
