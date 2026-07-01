package androidx.core.view.inputmethod;

import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class EditorInfoCompat$Impl30 {
    private EditorInfoCompat$Impl30() {
    }

    public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i) {
        return editorInfo.getInitialSelectedText(i);
    }

    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i, int i2) {
        return editorInfo.getInitialTextAfterCursor(i, i2);
    }

    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i, int i2) {
        return editorInfo.getInitialTextBeforeCursor(i, i2);
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i) {
        editorInfo.setInitialSurroundingSubText(charSequence, i);
    }
}
