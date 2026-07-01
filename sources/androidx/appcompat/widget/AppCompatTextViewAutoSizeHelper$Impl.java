package androidx.appcompat.widget;

import android.text.StaticLayout$Builder;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextViewAutoSizeHelper$Impl {
    public void computeAndSetTextDirection(StaticLayout$Builder staticLayout$Builder, TextView textView) {
    }

    public boolean isHorizontallyScrollable(TextView textView) {
        return ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
    }
}
