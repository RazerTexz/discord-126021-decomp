package com.discord.widgets.channels.threads;

import android.view.View;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadDraftArchiveSheet$binding$2 extends C12236k implements Function1<View, WidgetThreadArchiveActionsSheetBinding> {
    public static final WidgetThreadDraftArchiveSheet$binding$2 INSTANCE = new WidgetThreadDraftArchiveSheet$binding$2();

    public WidgetThreadDraftArchiveSheet$binding$2() {
        super(1, WidgetThreadArchiveActionsSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetThreadArchiveActionsSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        return WidgetThreadArchiveActionsSheetBinding.m8420a(view);
    }
}
