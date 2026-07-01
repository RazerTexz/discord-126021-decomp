package com.discord.widgets.user.phone;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetUserPhoneManageBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneManage$binding$2 extends k implements Function1<View, WidgetUserPhoneManageBinding> {
    public static final WidgetUserPhoneManage$binding$2 INSTANCE = new WidgetUserPhoneManage$binding$2();

    public WidgetUserPhoneManage$binding$2() {
        super(1, WidgetUserPhoneManageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPhoneManageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserPhoneManageBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserPhoneManageBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131363051;
        DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
        if (dimmerView != null) {
            i = R$id.remove_phone;
            TextView textView = (TextView) view.findViewById(R$id.remove_phone);
            if (textView != null) {
                i = R$id.user_phone_add_description_note;
                TextView textView2 = (TextView) view.findViewById(R$id.user_phone_add_description_note);
                if (textView2 != null) {
                    i = R$id.user_phone_add_next;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.user_phone_add_next);
                    if (materialButton != null) {
                        i = R$id.user_phone_add_number;
                        PhoneOrEmailInputView phoneOrEmailInputView = (PhoneOrEmailInputView) view.findViewById(R$id.user_phone_add_number);
                        if (phoneOrEmailInputView != null) {
                            i = R$id.user_phone_title;
                            TextView textView3 = (TextView) view.findViewById(R$id.user_phone_title);
                            if (textView3 != null) {
                                return new WidgetUserPhoneManageBinding((FrameLayout) view, dimmerView, textView, textView2, materialButton, phoneOrEmailInputView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
