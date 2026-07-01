package com.discord.utilities.spans;

import android.text.TextPaint;
import android.view.View;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ClickableSpan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClickableSpan extends android.text.style.ClickableSpan {
    private final Integer color;
    private final Function1<View, Unit> onClickListener;
    private final Function1<View, Unit> onLongPress;
    private final boolean underline;

    public /* synthetic */ ClickableSpan(Integer num, boolean z2, Function1 function1, Function1 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, z2, (i & 4) != 0 ? null : function1, function2);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        m.checkNotNullParameter(view, "view");
        this.onClickListener.invoke(view);
    }

    public final Unit onLongPress(View view) {
        m.checkNotNullParameter(view, "view");
        Function1<View, Unit> function1 = this.onLongPress;
        if (function1 != null) {
            return function1.invoke(view);
        }
        return null;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint drawState) {
        m.checkNotNullParameter(drawState, "drawState");
        drawState.setUnderlineText(this.underline);
        Integer num = this.color;
        if (num != null) {
            drawState.setColor(num.intValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClickableSpan(Integer num, boolean z2, Function1<? super View, Unit> function1, Function1<? super View, Unit> function2) {
        m.checkNotNullParameter(function2, "onClickListener");
        this.color = num;
        this.underline = z2;
        this.onLongPress = function1;
        this.onClickListener = function2;
    }
}
