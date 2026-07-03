package com.discord.widgets.home;

import android.view.View;
import com.discord.databinding.ViewDialogConfirmationBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetMainSurveyDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMainSurveyDialog$binding$2 extends C12236k implements Function1<View, ViewDialogConfirmationBinding> {
    public static final WidgetMainSurveyDialog$binding$2 INSTANCE = new WidgetMainSurveyDialog$binding$2();

    public WidgetMainSurveyDialog$binding$2() {
        super(1, ViewDialogConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ViewDialogConfirmationBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        return ViewDialogConfirmationBinding.m8393a(view);
    }
}
