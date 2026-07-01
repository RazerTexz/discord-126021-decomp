package com.discord.widgets.home;

import android.view.View;
import com.discord.databinding.ViewDialogConfirmationBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.home.WidgetMainSurveyDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetMainSurveyDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMainSurveyDialog2 extends FunctionReferenceImpl implements Function1<View, ViewDialogConfirmationBinding> {
    public static final WidgetMainSurveyDialog2 INSTANCE = new WidgetMainSurveyDialog2();

    public WidgetMainSurveyDialog2() {
        super(1, ViewDialogConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ViewDialogConfirmationBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return ViewDialogConfirmationBinding.a(view);
    }
}
