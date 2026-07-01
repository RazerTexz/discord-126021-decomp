package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadArchiveActions3 extends FunctionReferenceImpl implements Function1<View, WidgetThreadArchiveActionsSheetBinding> {
    public static final WidgetThreadArchiveActions3 INSTANCE = new WidgetThreadArchiveActions3();

    public WidgetThreadArchiveActions3() {
        super(1, WidgetThreadArchiveActionsSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetThreadArchiveActionsSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return WidgetThreadArchiveActionsSheetBinding.a(view);
    }
}
