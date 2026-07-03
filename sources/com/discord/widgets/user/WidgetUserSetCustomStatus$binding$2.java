package com.discord.widgets.user;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserSetCustomStatusBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSetCustomStatus$binding$2 extends C12236k implements Function1<View, WidgetUserSetCustomStatusBinding> {
    public static final WidgetUserSetCustomStatus$binding$2 INSTANCE = new WidgetUserSetCustomStatus$binding$2();

    public WidgetUserSetCustomStatus$binding$2() {
        super(1, WidgetUserSetCustomStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserSetCustomStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserSetCustomStatusBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.set_custom_status_emoji;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.set_custom_status_emoji);
        if (simpleDraweeView != null) {
            i = C5419R.id.set_custom_status_emoji_button;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.set_custom_status_emoji_button);
            if (frameLayout != null) {
                i = C5419R.id.set_custom_status_expiration;
                RadioGroup radioGroup = (RadioGroup) view.findViewById(C5419R.id.set_custom_status_expiration);
                if (radioGroup != null) {
                    i = C5419R.id.set_custom_status_expiration_1_hour;
                    MaterialRadioButton materialRadioButton = (MaterialRadioButton) view.findViewById(C5419R.id.set_custom_status_expiration_1_hour);
                    if (materialRadioButton != null) {
                        i = C5419R.id.set_custom_status_expiration_30_minutes;
                        MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view.findViewById(C5419R.id.set_custom_status_expiration_30_minutes);
                        if (materialRadioButton2 != null) {
                            i = C5419R.id.set_custom_status_expiration_4_hours;
                            MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) view.findViewById(C5419R.id.set_custom_status_expiration_4_hours);
                            if (materialRadioButton3 != null) {
                                i = C5419R.id.set_custom_status_expiration_never;
                                MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) view.findViewById(C5419R.id.set_custom_status_expiration_never);
                                if (materialRadioButton4 != null) {
                                    i = C5419R.id.set_custom_status_expiration_tomorrow;
                                    MaterialRadioButton materialRadioButton5 = (MaterialRadioButton) view.findViewById(C5419R.id.set_custom_status_expiration_tomorrow);
                                    if (materialRadioButton5 != null) {
                                        i = C5419R.id.set_custom_status_save;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.set_custom_status_save);
                                        if (floatingActionButton != null) {
                                            i = C5419R.id.set_custom_status_text;
                                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.set_custom_status_text);
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
