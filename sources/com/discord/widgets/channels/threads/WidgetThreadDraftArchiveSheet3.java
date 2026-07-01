package com.discord.widgets.channels.threads;

import android.view.View;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadDraftArchiveSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetThreadArchiveActionsSheetBinding> {
    public static final WidgetThreadDraftArchiveSheet3 INSTANCE = new WidgetThreadDraftArchiveSheet3();

    public WidgetThreadDraftArchiveSheet3() {
        super(1, WidgetThreadArchiveActionsSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetThreadArchiveActionsSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return WidgetThreadArchiveActionsSheetBinding.a(view);
    }
}
