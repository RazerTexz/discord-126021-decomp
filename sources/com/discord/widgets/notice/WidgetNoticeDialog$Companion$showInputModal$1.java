package com.discord.widgets.notice;

import android.content.Context;
import android.view.View;
import b.i.c.m.d.k.CommonUtils;
import com.discord.R;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeDialog$Companion$showInputModal$1 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ Function2 $onOKClicked;
    public final /* synthetic */ boolean $shouldHideKeyboard;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeDialog$Companion$showInputModal$1(Function2 function2, boolean z2) {
        super(1);
        this.$onOKClicked = function2;
        this.$shouldHideKeyboard = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Function2 function2 = this.$onOKClicked;
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "view.context");
        View viewFindViewById = view.findViewById(R.id.view_input);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<TextIn…tLayout>(R.id.view_input)");
        function2.invoke(context, ViewExtensions.getTextOrEmpty((TextInputLayout) viewFindViewById));
        if (this.$shouldHideKeyboard) {
            CommonUtils.r(view.getContext(), view);
        }
    }
}
