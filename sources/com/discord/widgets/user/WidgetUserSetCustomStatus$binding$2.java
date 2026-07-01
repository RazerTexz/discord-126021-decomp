package com.discord.widgets.user;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetUserSetCustomStatusBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSetCustomStatus$binding$2 extends k implements Function1<View, WidgetUserSetCustomStatusBinding> {
    public static final WidgetUserSetCustomStatus$binding$2 INSTANCE = new WidgetUserSetCustomStatus$binding$2();

    public WidgetUserSetCustomStatus$binding$2() {
        super(1, WidgetUserSetCustomStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserSetCustomStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserSetCustomStatusBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserSetCustomStatusBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.set_custom_status_emoji;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.set_custom_status_emoji);
        if (simpleDraweeView != null) {
            i = R$id.set_custom_status_emoji_button;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.set_custom_status_emoji_button);
            if (frameLayout != null) {
                i = R$id.set_custom_status_expiration;
                RadioGroup radioGroup = (RadioGroup) view.findViewById(R$id.set_custom_status_expiration);
                if (radioGroup != null) {
                    i = R$id.set_custom_status_expiration_1_hour;
                    MaterialRadioButton materialRadioButton = (MaterialRadioButton) view.findViewById(R$id.set_custom_status_expiration_1_hour);
                    if (materialRadioButton != null) {
                        i = R$id.set_custom_status_expiration_30_minutes;
                        MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view.findViewById(R$id.set_custom_status_expiration_30_minutes);
                        if (materialRadioButton2 != null) {
                            i = R$id.set_custom_status_expiration_4_hours;
                            MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) view.findViewById(R$id.set_custom_status_expiration_4_hours);
                            if (materialRadioButton3 != null) {
                                i = R$id.set_custom_status_expiration_never;
                                MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) view.findViewById(R$id.set_custom_status_expiration_never);
                                if (materialRadioButton4 != null) {
                                    i = R$id.set_custom_status_expiration_tomorrow;
                                    MaterialRadioButton materialRadioButton5 = (MaterialRadioButton) view.findViewById(R$id.set_custom_status_expiration_tomorrow);
                                    if (materialRadioButton5 != null) {
                                        i = R$id.set_custom_status_save;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.set_custom_status_save);
                                        if (floatingActionButton != null) {
                                            i = R$id.set_custom_status_text;
                                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.set_custom_status_text);
                                            if (textInputLayout != null) {
                                                return new WidgetUserSetCustomStatusBinding((CoordinatorLayout) view, simpleDraweeView, frameLayout, radioGroup, materialRadioButton, materialRadioButton2, materialRadioButton3, materialRadioButton4, materialRadioButton5, floatingActionButton, textInputLayout);
                                            }
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
