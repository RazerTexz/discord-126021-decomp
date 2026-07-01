package com.discord.widgets.user;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetUserSetCustomStatusBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSetCustomStatus2 extends FunctionReferenceImpl implements Function1<View, WidgetUserSetCustomStatusBinding> {
    public static final WidgetUserSetCustomStatus2 INSTANCE = new WidgetUserSetCustomStatus2();

    public WidgetUserSetCustomStatus2() {
        super(1, WidgetUserSetCustomStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserSetCustomStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserSetCustomStatusBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.set_custom_status_emoji;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.set_custom_status_emoji);
        if (simpleDraweeView != null) {
            i = R.id.set_custom_status_emoji_button;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.set_custom_status_emoji_button);
            if (frameLayout != null) {
                i = R.id.set_custom_status_expiration;
                RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.set_custom_status_expiration);
                if (radioGroup != null) {
                    i = R.id.set_custom_status_expiration_1_hour;
                    MaterialRadioButton materialRadioButton = (MaterialRadioButton) view.findViewById(R.id.set_custom_status_expiration_1_hour);
                    if (materialRadioButton != null) {
                        i = R.id.set_custom_status_expiration_30_minutes;
                        MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view.findViewById(R.id.set_custom_status_expiration_30_minutes);
                        if (materialRadioButton2 != null) {
                            i = R.id.set_custom_status_expiration_4_hours;
                            MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) view.findViewById(R.id.set_custom_status_expiration_4_hours);
                            if (materialRadioButton3 != null) {
                                i = R.id.set_custom_status_expiration_never;
                                MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) view.findViewById(R.id.set_custom_status_expiration_never);
                                if (materialRadioButton4 != null) {
                                    i = R.id.set_custom_status_expiration_tomorrow;
                                    MaterialRadioButton materialRadioButton5 = (MaterialRadioButton) view.findViewById(R.id.set_custom_status_expiration_tomorrow);
                                    if (materialRadioButton5 != null) {
                                        i = R.id.set_custom_status_save;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.set_custom_status_save);
                                        if (floatingActionButton != null) {
                                            i = R.id.set_custom_status_text;
                                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.set_custom_status_text);
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
