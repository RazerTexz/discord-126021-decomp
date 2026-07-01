package androidx.appcompat.widget;

import android.text.StaticLayout$Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.widget.TextView;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class AppCompatTextViewAutoSizeHelper$Impl23 extends AppCompatTextViewAutoSizeHelper$Impl {
    @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper$Impl
    public void computeAndSetTextDirection(StaticLayout$Builder staticLayout$Builder, TextView textView) {
        staticLayout$Builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
    }
}
