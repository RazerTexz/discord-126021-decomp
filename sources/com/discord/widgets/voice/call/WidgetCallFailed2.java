package com.discord.widgets.voice.call;

import android.view.View;
import com.discord.databinding.ViewDialogConfirmationBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetCallFailed$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFailed2 extends FunctionReferenceImpl implements Function1<View, ViewDialogConfirmationBinding> {
    public static final WidgetCallFailed2 INSTANCE = new WidgetCallFailed2();

    public WidgetCallFailed2() {
        super(1, ViewDialogConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ViewDialogConfirmationBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return ViewDialogConfirmationBinding.a(view);
    }
}
