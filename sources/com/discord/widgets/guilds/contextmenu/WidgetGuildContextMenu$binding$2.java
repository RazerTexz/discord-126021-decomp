package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import com.discord.databinding.WidgetGuildContextMenuBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildContextMenu$binding$2 extends C12236k implements Function1<View, WidgetGuildContextMenuBinding> {
    public static final WidgetGuildContextMenu$binding$2 INSTANCE = new WidgetGuildContextMenu$binding$2();

    public WidgetGuildContextMenu$binding$2() {
        super(1, WidgetGuildContextMenuBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildContextMenuBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildContextMenuBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        return WidgetGuildContextMenuBinding.m8416a(view);
    }
}
