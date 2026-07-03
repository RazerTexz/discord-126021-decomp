package com.discord.widgets.directories;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetDirectoryCategoryBinding;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDirectoryCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoryCategory$binding$2 extends C12236k implements Function1<View, WidgetDirectoryCategoryBinding> {
    public static final WidgetDirectoryCategory$binding$2 INSTANCE = new WidgetDirectoryCategory$binding$2();

    public WidgetDirectoryCategory$binding$2() {
        super(1, WidgetDirectoryCategoryBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDirectoryCategoryBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetDirectoryCategoryBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetDirectoryCategoryBinding(recyclerView, recyclerView);
    }
}
