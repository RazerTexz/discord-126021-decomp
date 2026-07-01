package com.discord.widgets.guilds.list;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGuildsListBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildsList6 extends FunctionReferenceImpl implements Function1<View, WidgetGuildsListBinding> {
    public static final WidgetGuildsList6 INSTANCE = new WidgetGuildsList6();

    public WidgetGuildsList6() {
        super(1, WidgetGuildsListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildsListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildsListBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.guild_list);
        if (recyclerView != null) {
            i = R.id.guild_list_unreads_stub;
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.guild_list_unreads_stub);
            if (viewStub != null) {
                return new WidgetGuildsListBinding((RelativeLayout) view, recyclerView, viewStub);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
