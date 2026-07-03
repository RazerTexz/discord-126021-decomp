package com.discord.widgets.user;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserStatusUpdateBinding;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C0948e4;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserStatusSheet$binding$2 extends C12236k implements Function1<View, WidgetUserStatusUpdateBinding> {
    public static final WidgetUserStatusSheet$binding$2 INSTANCE = new WidgetUserStatusSheet$binding$2();

    public WidgetUserStatusSheet$binding$2() {
        super(1, WidgetUserStatusUpdateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserStatusUpdateBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(C5419R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = C5419R.id.user_status_update_custom;
            UserStatusPresenceCustomView userStatusPresenceCustomView = (UserStatusPresenceCustomView) view.findViewById(C5419R.id.user_status_update_custom);
            if (userStatusPresenceCustomView != null) {
                i = C5419R.id.user_status_update_dnd;
                View viewFindViewById = view.findViewById(C5419R.id.user_status_update_dnd);
                if (viewFindViewById != null) {
                    C0948e4 c0948e4M198a = C0948e4.m198a(viewFindViewById);
                    i = C5419R.id.user_status_update_idle;
                    View viewFindViewById2 = view.findViewById(C5419R.id.user_status_update_idle);
                    if (viewFindViewById2 != null) {
                        C0948e4 c0948e4M198a2 = C0948e4.m198a(viewFindViewById2);
                        i = C5419R.id.user_status_update_invisible;
                        View viewFindViewById3 = view.findViewById(C5419R.id.user_status_update_invisible);
                        if (viewFindViewById3 != null) {
                            C0948e4 c0948e4M198a3 = C0948e4.m198a(viewFindViewById3);
                            i = C5419R.id.user_status_update_online;
                            View viewFindViewById4 = view.findViewById(C5419R.id.user_status_update_online);
                            if (viewFindViewById4 != null) {
                                return new WidgetUserStatusUpdateBinding((NestedScrollView) view, textView, userStatusPresenceCustomView, c0948e4M198a, c0948e4M198a2, c0948e4M198a3, C0948e4.m198a(viewFindViewById4));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
