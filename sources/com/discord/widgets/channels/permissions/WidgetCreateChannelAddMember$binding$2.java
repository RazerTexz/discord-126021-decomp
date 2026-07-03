package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetCreateChannelAddMemberBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCreateChannelAddMember$binding$2 extends C12236k implements Function1<View, WidgetCreateChannelAddMemberBinding> {
    public static final WidgetCreateChannelAddMember$binding$2 INSTANCE = new WidgetCreateChannelAddMember$binding$2();

    public WidgetCreateChannelAddMember$binding$2() {
        super(1, WidgetCreateChannelAddMemberBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCreateChannelAddMemberBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetCreateChannelAddMemberBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(C5419R.id.content);
        if (fragmentContainerView != null) {
            return new WidgetCreateChannelAddMemberBinding((LinearLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.content)));
    }
}
