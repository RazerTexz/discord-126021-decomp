package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import com.discord.databinding.WidgetFolderContextMenuBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFolderContextMenu$binding$2 extends k implements Function1<View, WidgetFolderContextMenuBinding> {
    public static final WidgetFolderContextMenu$binding$2 INSTANCE = new WidgetFolderContextMenu$binding$2();

    public WidgetFolderContextMenu$binding$2() {
        super(1, WidgetFolderContextMenuBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFolderContextMenuBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetFolderContextMenuBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetFolderContextMenuBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        return WidgetFolderContextMenuBinding.a(view);
    }
}
