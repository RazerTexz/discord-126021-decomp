package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import com.discord.databinding.WidgetGuildContextMenuBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildContextMenu$binding$2 extends k implements Function1<View, WidgetGuildContextMenuBinding> {
    public static final WidgetGuildContextMenu$binding$2 INSTANCE = new WidgetGuildContextMenu$binding$2();

    public WidgetGuildContextMenu$binding$2() {
        super(1, WidgetGuildContextMenuBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildContextMenuBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildContextMenuBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildContextMenuBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        return WidgetGuildContextMenuBinding.a(view);
    }
}
