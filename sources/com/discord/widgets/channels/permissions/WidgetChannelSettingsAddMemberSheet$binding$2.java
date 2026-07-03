package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelSettingsAddMemberSheetBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsAddMemberSheet$binding$2 extends C12236k implements Function1<View, WidgetChannelSettingsAddMemberSheetBinding> {
    public static final WidgetChannelSettingsAddMemberSheet$binding$2 INSTANCE = new WidgetChannelSettingsAddMemberSheet$binding$2();

    public WidgetChannelSettingsAddMemberSheet$binding$2() {
        super(1, WidgetChannelSettingsAddMemberSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsAddMemberSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelSettingsAddMemberSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.add_button;
        TextView textView = (TextView) view.findViewById(C5419R.id.add_button);
        if (textView != null) {
            i = C5419R.id.content;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(C5419R.id.content);
            if (fragmentContainerView != null) {
                i = C5419R.id.subtitle;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.subtitle);
                if (textView2 != null) {
                    i = C5419R.id.title;
                    TextView textView3 = (TextView) view.findViewById(C5419R.id.title);
                    if (textView3 != null) {
                        return new WidgetChannelSettingsAddMemberSheetBinding((LinearLayout) view, textView, fragmentContainerView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
