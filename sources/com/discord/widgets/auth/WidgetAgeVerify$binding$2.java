package com.discord.widgets.auth;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetAgeVerifyBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C0960g0;
import p007b.p008a.p025i.C0968h0;
import p007b.p008a.p025i.C0975i0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAgeVerify$binding$2 extends C12236k implements Function1<View, WidgetAgeVerifyBinding> {
    public static final WidgetAgeVerify$binding$2 INSTANCE = new WidgetAgeVerify$binding$2();

    public WidgetAgeVerify$binding$2() {
        super(1, WidgetAgeVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAgeVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAgeVerifyBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.age_verify_view_flipper;
        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.age_verify_view_flipper);
        if (appViewFlipper != null) {
            i = C5419R.id.confirm;
            View viewFindViewById = view.findViewById(C5419R.id.confirm);
            if (viewFindViewById != null) {
                int i2 = C5419R.id.age_verify_confirm_back_button;
                MaterialButton materialButton = (MaterialButton) viewFindViewById.findViewById(C5419R.id.age_verify_confirm_back_button);
                if (materialButton != null) {
                    i2 = C5419R.id.age_verify_confirm_button;
                    LoadingButton loadingButton = (LoadingButton) viewFindViewById.findViewById(C5419R.id.age_verify_confirm_button);
                    if (loadingButton != null) {
                        i2 = C5419R.id.age_verify_confirm_description;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewFindViewById.findViewById(C5419R.id.age_verify_confirm_description);
                        if (linkifiedTextView != null) {
                            i2 = C5419R.id.age_verify_confirm_title;
                            TextView textView = (TextView) viewFindViewById.findViewById(C5419R.id.age_verify_confirm_title);
                            if (textView != null) {
                                C0968h0 c0968h0 = new C0968h0((ConstraintLayout) viewFindViewById, materialButton, loadingButton, linkifiedTextView, textView);
                                View viewFindViewById2 = view.findViewById(C5419R.id.underage);
                                if (viewFindViewById2 != null) {
                                    int i3 = C5419R.id.age_verify_return_to_login_button;
                                    MaterialButton materialButton2 = (MaterialButton) viewFindViewById2.findViewById(C5419R.id.age_verify_return_to_login_button);
                                    if (materialButton2 != null) {
                                        i3 = C5419R.id.age_verify_underage_description;
                                        LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) viewFindViewById2.findViewById(C5419R.id.age_verify_underage_description);
                                        if (linkifiedTextView2 != null) {
                                            i3 = C5419R.id.age_verify_underage_title;
                                            TextView textView2 = (TextView) viewFindViewById2.findViewById(C5419R.id.age_verify_underage_title);
                                            if (textView2 != null) {
                                                i3 = C5419R.id.underage_warning;
                                                TextView textView3 = (TextView) viewFindViewById2.findViewById(C5419R.id.underage_warning);
                                                if (textView3 != null) {
                                                    C0975i0 c0975i0 = new C0975i0((ConstraintLayout) viewFindViewById2, materialButton2, linkifiedTextView2, textView2, textView3);
                                                    View viewFindViewById3 = view.findViewById(C5419R.id.verify);
                                                    if (viewFindViewById3 != null) {
                                                        int i4 = C5419R.id.age_verify_description;
                                                        LinkifiedTextView linkifiedTextView3 = (LinkifiedTextView) viewFindViewById3.findViewById(C5419R.id.age_verify_description);
                                                        if (linkifiedTextView3 != null) {
                                                            i4 = C5419R.id.age_verify_input_wrapper;
                                                            TextInputLayout textInputLayout = (TextInputLayout) viewFindViewById3.findViewById(C5419R.id.age_verify_input_wrapper);
                                                            if (textInputLayout != null) {
                                                                i4 = C5419R.id.age_verify_next_button;
                                                                LoadingButton loadingButton2 = (LoadingButton) viewFindViewById3.findViewById(C5419R.id.age_verify_next_button);
                                                                if (loadingButton2 != null) {
                                                                    i4 = C5419R.id.age_verify_title;
                                                                    TextView textView4 = (TextView) viewFindViewById3.findViewById(C5419R.id.age_verify_title);
                                                                    if (textView4 != null) {
                                                                        return new WidgetAgeVerifyBinding((CoordinatorLayout) view, appViewFlipper, c0968h0, c0975i0, new C0960g0((ConstraintLayout) viewFindViewById3, linkifiedTextView3, textInputLayout, loadingButton2, textView4));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i4)));
                                                    }
                                                    i = C5419R.id.verify;
                                                }
                                            }
                                        }
                                    }
                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(i3)));
                                }
                                i = C5419R.id.underage;
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
