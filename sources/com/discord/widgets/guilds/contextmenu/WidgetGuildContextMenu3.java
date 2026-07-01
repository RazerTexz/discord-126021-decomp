package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import com.discord.databinding.WidgetGuildContextMenuBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildContextMenu3 extends FunctionReferenceImpl implements Function1<View, WidgetGuildContextMenuBinding> {
    public static final WidgetGuildContextMenu3 INSTANCE = new WidgetGuildContextMenu3();

    public WidgetGuildContextMenu3() {
        super(1, WidgetGuildContextMenuBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildContextMenuBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildContextMenuBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return WidgetGuildContextMenuBinding.a(view);
    }
}
