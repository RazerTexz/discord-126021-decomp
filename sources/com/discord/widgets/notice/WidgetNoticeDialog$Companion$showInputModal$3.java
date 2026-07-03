package com.discord.widgets.notice;

import android.view.View;
import com.discord.C5419R;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeDialog$Companion$showInputModal$3 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ CharSequence $hintText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeDialog$Companion$showInputModal$3(CharSequence charSequence) {
        super(1);
        this.$hintText = charSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "view");
        View viewFindViewById = view.findViewById(C5419R.id.view_input);
        C12238m.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<TextIn…tLayout>(R.id.view_input)");
        ((TextInputLayout) viewFindViewById).setHint(this.$hintText);
    }
}
