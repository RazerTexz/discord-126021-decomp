package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.widget.ListAdapter;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public interface AppCompatSpinner$SpinnerPopup {
    void dismiss();

    Drawable getBackground();

    CharSequence getHintText();

    int getHorizontalOffset();

    int getHorizontalOriginalOffset();

    int getVerticalOffset();

    boolean isShowing();

    void setAdapter(ListAdapter listAdapter);

    void setBackgroundDrawable(Drawable drawable);

    void setHorizontalOffset(int i);

    void setHorizontalOriginalOffset(int i);

    void setPromptText(CharSequence charSequence);

    void setVerticalOffset(int i);

    void show(int i, int i2);
}
