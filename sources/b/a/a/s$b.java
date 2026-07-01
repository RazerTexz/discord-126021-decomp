package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.h5;
import com.discord.R$id;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s$b extends d0.z.d.k implements Function1<View, h5> {
    public static final s$b j = new s$b();

    public s$b() {
        super(1, h5.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public h5 invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.enable_two_factor_password_body_container;
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R$id.enable_two_factor_password_body_container);
        if (linearLayout != null) {
            i = R$id.enable_two_factor_password_body_text;
            TextView textView = (TextView) view2.findViewById(R$id.enable_two_factor_password_body_text);
            if (textView != null) {
                i = R$id.enable_two_factor_password_cancel;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.enable_two_factor_password_cancel);
                if (materialButton != null) {
                    i = R$id.enable_two_factor_password_header;
                    TextView textView2 = (TextView) view2.findViewById(R$id.enable_two_factor_password_header);
                    if (textView2 != null) {
                        i = R$id.enable_two_factor_password_header_container;
                        LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R$id.enable_two_factor_password_header_container);
                        if (linearLayout2 != null) {
                            i = R$id.enable_two_factor_password_ok;
                            LoadingButton loadingButton = (LoadingButton) view2.findViewById(R$id.enable_two_factor_password_ok);
                            if (loadingButton != null) {
                                i = R$id.enable_two_factor_password_view_input;
                                TextInputLayout textInputLayout = (TextInputLayout) view2.findViewById(R$id.enable_two_factor_password_view_input);
                                if (textInputLayout != null) {
                                    return new h5((LinearLayout) view2, linearLayout, textView, materialButton, textView2, linearLayout2, loadingButton, textInputLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
