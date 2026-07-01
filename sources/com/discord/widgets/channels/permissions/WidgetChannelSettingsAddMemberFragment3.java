package com.discord.widgets.channels.permissions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelSettingsAddMemberBinding;
import com.discord.views.SearchInputView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsAddMemberFragment3 extends FunctionReferenceImpl implements Function1<View, WidgetChannelSettingsAddMemberBinding> {
    public static final WidgetChannelSettingsAddMemberFragment3 INSTANCE = new WidgetChannelSettingsAddMemberFragment3();

    public WidgetChannelSettingsAddMemberFragment3() {
        super(1, WidgetChannelSettingsAddMemberBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelSettingsAddMemberBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        if (recyclerView != null) {
            i = R.id.search_input;
            SearchInputView searchInputView = (SearchInputView) view.findViewById(R.id.search_input);
            if (searchInputView != null) {
                return new WidgetChannelSettingsAddMemberBinding((CoordinatorLayout) view, recyclerView, searchInputView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
