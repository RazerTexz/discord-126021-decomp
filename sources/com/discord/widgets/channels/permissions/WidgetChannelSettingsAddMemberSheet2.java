package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelSettingsAddMemberSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsAddMemberSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetChannelSettingsAddMemberSheetBinding> {
    public static final WidgetChannelSettingsAddMemberSheet2 INSTANCE = new WidgetChannelSettingsAddMemberSheet2();

    public WidgetChannelSettingsAddMemberSheet2() {
        super(1, WidgetChannelSettingsAddMemberSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsAddMemberSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelSettingsAddMemberSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.add_button;
        TextView textView = (TextView) view.findViewById(R.id.add_button);
        if (textView != null) {
            i = R.id.content;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.content);
            if (fragmentContainerView != null) {
                i = R.id.subtitle;
                TextView textView2 = (TextView) view.findViewById(R.id.subtitle);
                if (textView2 != null) {
                    i = R.id.title;
                    TextView textView3 = (TextView) view.findViewById(R.id.title);
                    if (textView3 != null) {
                        return new WidgetChannelSettingsAddMemberSheetBinding((LinearLayout) view, textView, fragmentContainerView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
