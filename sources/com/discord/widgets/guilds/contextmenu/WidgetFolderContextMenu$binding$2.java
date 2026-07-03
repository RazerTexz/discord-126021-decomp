package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import com.discord.databinding.WidgetFolderContextMenuBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFolderContextMenu$binding$2 extends C12236k implements Function1<View, WidgetFolderContextMenuBinding> {
    public static final WidgetFolderContextMenu$binding$2 INSTANCE = new WidgetFolderContextMenu$binding$2();

    public WidgetFolderContextMenu$binding$2() {
        super(1, WidgetFolderContextMenuBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFolderContextMenuBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetFolderContextMenuBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        return WidgetFolderContextMenuBinding.m8414a(view);
    }
}
