package androidx.appcompat.widget;

import android.text.StaticLayout$Builder;
import android.widget.TextView;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public class AppCompatTextViewAutoSizeHelper$Impl29 extends AppCompatTextViewAutoSizeHelper$Impl23 {
    @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper$Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper$Impl
    public void computeAndSetTextDirection(StaticLayout$Builder staticLayout$Builder, TextView textView) {
        staticLayout$Builder.setTextDirection(textView.getTextDirectionHeuristic());
    }

    @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper$Impl
    public boolean isHorizontallyScrollable(TextView textView) {
        return textView.isHorizontallyScrollable();
    }
}
