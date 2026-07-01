package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelSettingsAddMemberSheetBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsAddMemberSheet$binding$2 extends k implements Function1<View, WidgetChannelSettingsAddMemberSheetBinding> {
    public static final WidgetChannelSettingsAddMemberSheet$binding$2 INSTANCE = new WidgetChannelSettingsAddMemberSheet$binding$2();

    public WidgetChannelSettingsAddMemberSheet$binding$2() {
        super(1, WidgetChannelSettingsAddMemberSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsAddMemberSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSettingsAddMemberSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsAddMemberSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.add_button;
        TextView textView = (TextView) view.findViewById(R$id.add_button);
        if (textView != null) {
            i = 2131362884;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(2131362884);
            if (fragmentContainerView != null) {
                i = R$id.subtitle;
                TextView textView2 = (TextView) view.findViewById(R$id.subtitle);
                if (textView2 != null) {
                    i = 2131365869;
                    TextView textView3 = (TextView) view.findViewById(2131365869);
                    if (textView3 != null) {
                        return new WidgetChannelSettingsAddMemberSheetBinding((LinearLayout) view, textView, fragmentContainerView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
