package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.databinding.WidgetCreateChannelAddMemberBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCreateChannelAddMember$binding$2 extends k implements Function1<View, WidgetCreateChannelAddMemberBinding> {
    public static final WidgetCreateChannelAddMember$binding$2 INSTANCE = new WidgetCreateChannelAddMember$binding$2();

    public WidgetCreateChannelAddMember$binding$2() {
        super(1, WidgetCreateChannelAddMemberBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCreateChannelAddMemberBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCreateChannelAddMemberBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCreateChannelAddMemberBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(2131362884);
        if (fragmentContainerView != null) {
            return new WidgetCreateChannelAddMemberBinding((LinearLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131362884)));
    }
}
