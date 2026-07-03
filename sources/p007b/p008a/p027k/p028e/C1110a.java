package p007b.p008a.p027k.p028e;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.ColorInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.k.e.a */
/* JADX INFO: compiled from: ClickableSpan.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1110a extends ClickableSpan {

    /* JADX INFO: renamed from: j */
    public final Function1<View, Unit> f1498j;

    /* JADX INFO: renamed from: k */
    public final Integer f1499k;

    /* JADX WARN: Multi-variable type inference failed */
    public C1110a(Function1<? super View, Unit> function1, @ColorInt Integer num) {
        C12238m.checkNotNullParameter(function1, "clickHandler");
        this.f1498j = function1;
        this.f1499k = num;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        C12238m.checkNotNullParameter(view, "widget");
        this.f1498j.invoke(view);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        C12238m.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        Integer num = this.f1499k;
        if (num != null) {
            textPaint.setColor(num.intValue());
        }
        textPaint.setUnderlineText(false);
    }
}
