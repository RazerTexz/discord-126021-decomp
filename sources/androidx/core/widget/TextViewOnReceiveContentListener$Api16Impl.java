package androidx.core.widget;

import android.content.ClipData$Item;
import android.content.Context;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(16)
public final class TextViewOnReceiveContentListener$Api16Impl {
    private TextViewOnReceiveContentListener$Api16Impl() {
    }

    public static CharSequence coerce(@NonNull Context context, @NonNull ClipData$Item clipData$Item, int i) {
        if ((i & 1) == 0) {
            return clipData$Item.coerceToStyledText(context);
        }
        CharSequence charSequenceCoerceToText = clipData$Item.coerceToText(context);
        return charSequenceCoerceToText instanceof Spanned ? charSequenceCoerceToText.toString() : charSequenceCoerceToText;
    }
}
