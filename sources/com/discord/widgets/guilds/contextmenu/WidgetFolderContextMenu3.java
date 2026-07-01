package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import com.discord.databinding.WidgetFolderContextMenuBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFolderContextMenu3 extends FunctionReferenceImpl implements Function1<View, WidgetFolderContextMenuBinding> {
    public static final WidgetFolderContextMenu3 INSTANCE = new WidgetFolderContextMenu3();

    public WidgetFolderContextMenu3() {
        super(1, WidgetFolderContextMenuBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFolderContextMenuBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetFolderContextMenuBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return WidgetFolderContextMenuBinding.a(view);
    }
}
