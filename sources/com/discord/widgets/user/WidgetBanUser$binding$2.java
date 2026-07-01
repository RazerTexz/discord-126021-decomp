package com.discord.widgets.user;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetBanUserBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetBanUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetBanUser$binding$2 extends k implements Function1<View, WidgetBanUserBinding> {
    public static final WidgetBanUser$binding$2 INSTANCE = new WidgetBanUser$binding$2();

    public WidgetBanUser$binding$2() {
        super(1, WidgetBanUserBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetBanUserBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetBanUserBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetBanUserBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.ban_user_body;
        TextView textView = (TextView) view.findViewById(R$id.ban_user_body);
        if (textView != null) {
            i = R$id.ban_user_button_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.ban_user_button_container);
            if (linearLayout != null) {
                i = R$id.ban_user_cancel;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.ban_user_cancel);
                if (materialButton != null) {
                    i = R$id.ban_user_confirm;
                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.ban_user_confirm);
                    if (materialButton2 != null) {
                        i = R$id.ban_user_delete_messages_1_day;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.ban_user_delete_messages_1_day);
                        if (checkedSetting != null) {
                            i = R$id.ban_user_delete_messages_7_days;
                            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.ban_user_delete_messages_7_days);
                            if (checkedSetting2 != null) {
                                i = R$id.ban_user_delete_messages_none;
                                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R$id.ban_user_delete_messages_none);
                                if (checkedSetting3 != null) {
                                    i = R$id.ban_user_reason;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.ban_user_reason);
                                    if (textInputLayout != null) {
                                        i = R$id.ban_user_title;
                                        TextView textView2 = (TextView) view.findViewById(R$id.ban_user_title);
                                        if (textView2 != null) {
                                            LinearLayout linearLayout2 = (LinearLayout) view;
                                            return new WidgetBanUserBinding(linearLayout2, textView, linearLayout, materialButton, materialButton2, checkedSetting, checkedSetting2, checkedSetting3, textInputLayout, textView2, linearLayout2);
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
