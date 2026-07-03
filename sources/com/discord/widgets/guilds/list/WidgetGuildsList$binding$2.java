package com.discord.widgets.guilds.list;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildsListBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildsList$binding$2 extends C12236k implements Function1<View, WidgetGuildsListBinding> {
    public static final WidgetGuildsList$binding$2 INSTANCE = new WidgetGuildsList$binding$2();

    public WidgetGuildsList$binding$2() {
        super(1, WidgetGuildsListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildsListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildsListBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.guild_list);
        if (recyclerView != null) {
            i = C5419R.id.guild_list_unreads_stub;
            ViewStub viewStub = (ViewStub) view.findViewById(C5419R.id.guild_list_unreads_stub);
            if (viewStub != null) {
                return new WidgetGuildsListBinding((RelativeLayout) view, recyclerView, viewStub);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
