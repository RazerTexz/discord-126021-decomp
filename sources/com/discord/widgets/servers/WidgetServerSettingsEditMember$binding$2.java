package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetServerSettingsEditMemberBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEditMember$binding$2 extends k implements Function1<View, WidgetServerSettingsEditMemberBinding> {
    public static final WidgetServerSettingsEditMember$binding$2 INSTANCE = new WidgetServerSettingsEditMember$binding$2();

    public WidgetServerSettingsEditMember$binding$2() {
        super(1, WidgetServerSettingsEditMemberBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEditMemberBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEditMemberBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEditMemberBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.edit_member_administrative_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.edit_member_administrative_container);
        if (linearLayout != null) {
            i = R$id.edit_member_ban_button;
            TextView textView = (TextView) view.findViewById(R$id.edit_member_ban_button);
            if (textView != null) {
                i = R$id.edit_member_kick_button;
                TextView textView2 = (TextView) view.findViewById(R$id.edit_member_kick_button);
                if (textView2 != null) {
                    i = R$id.edit_member_nickname;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.edit_member_nickname);
                    if (textInputLayout != null) {
                        i = R$id.edit_member_roles_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.edit_member_roles_container);
                        if (linearLayout2 != null) {
                            i = R$id.edit_member_roles_recycler;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.edit_member_roles_recycler);
                            if (recyclerView != null) {
                                i = R$id.edit_member_save;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.edit_member_save);
                                if (floatingActionButton != null) {
                                    i = R$id.edit_member_timeout_button;
                                    TextView textView3 = (TextView) view.findViewById(R$id.edit_member_timeout_button);
                                    if (textView3 != null) {
                                        i = R$id.edit_member_transfer_ownership_button;
                                        TextView textView4 = (TextView) view.findViewById(R$id.edit_member_transfer_ownership_button);
                                        if (textView4 != null) {
                                            return new WidgetServerSettingsEditMemberBinding((CoordinatorLayout) view, linearLayout, textView, textView2, textInputLayout, linearLayout2, recyclerView, floatingActionButton, textView3, textView4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
