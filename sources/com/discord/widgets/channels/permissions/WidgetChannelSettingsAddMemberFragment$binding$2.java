package com.discord.widgets.channels.permissions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelSettingsAddMemberBinding;
import com.discord.views.SearchInputView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsAddMemberFragment$binding$2 extends C12236k implements Function1<View, WidgetChannelSettingsAddMemberBinding> {
    public static final WidgetChannelSettingsAddMemberFragment$binding$2 INSTANCE = new WidgetChannelSettingsAddMemberFragment$binding$2();

    public WidgetChannelSettingsAddMemberFragment$binding$2() {
        super(1, WidgetChannelSettingsAddMemberBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelSettingsAddMemberBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler);
        if (recyclerView != null) {
            i = C5419R.id.search_input;
            SearchInputView searchInputView = (SearchInputView) view.findViewById(C5419R.id.search_input);
            if (searchInputView != null) {
                return new WidgetChannelSettingsAddMemberBinding((CoordinatorLayout) view, recyclerView, searchInputView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
