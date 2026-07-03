package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetRemoteAuthBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C1071v5;
import p007b.p008a.p025i.C1078w5;
import p007b.p008a.p025i.C1085x5;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetRemoteAuth$binding$2 extends C12236k implements Function1<View, WidgetRemoteAuthBinding> {
    public static final WidgetRemoteAuth$binding$2 INSTANCE = new WidgetRemoteAuth$binding$2();

    public WidgetRemoteAuth$binding$2() {
        super(1, WidgetRemoteAuthBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetRemoteAuthBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetRemoteAuthBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_success;
        View viewFindViewById = view.findViewById(C5419R.id.auth_success);
        if (viewFindViewById != null) {
            MaterialButton materialButton = (MaterialButton) viewFindViewById.findViewById(C5419R.id.remote_auth_finish_button);
            if (materialButton == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(C5419R.id.remote_auth_finish_button)));
            }
            C1085x5 c1085x5 = new C1085x5((LinearLayout) viewFindViewById, materialButton);
            i = C5419R.id.not_found;
            View viewFindViewById2 = view.findViewById(C5419R.id.not_found);
            if (viewFindViewById2 != null) {
                MaterialButton materialButton2 = (MaterialButton) viewFindViewById2.findViewById(C5419R.id.remote_auth_not_found_cancel_button);
                if (materialButton2 == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(C5419R.id.remote_auth_not_found_cancel_button)));
                }
                C1071v5 c1071v5 = new C1071v5((LinearLayout) viewFindViewById2, materialButton2);
                i = C5419R.id.pending_login;
                View viewFindViewById3 = view.findViewById(C5419R.id.pending_login);
                if (viewFindViewById3 != null) {
                    int i2 = C5419R.id.remote_auth_cancel_button;
                    MaterialButton materialButton3 = (MaterialButton) viewFindViewById3.findViewById(C5419R.id.remote_auth_cancel_button);
                    if (materialButton3 != null) {
                        i2 = C5419R.id.remote_auth_login_button;
                        MaterialButton materialButton4 = (MaterialButton) viewFindViewById3.findViewById(C5419R.id.remote_auth_login_button);
                        if (materialButton4 != null) {
                            i2 = C5419R.id.remote_auth_temporary_switch;
                            SwitchMaterial switchMaterial = (SwitchMaterial) viewFindViewById3.findViewById(C5419R.id.remote_auth_temporary_switch);
                            if (switchMaterial != null) {
                                C1078w5 c1078w5 = new C1078w5((LinearLayout) viewFindViewById3, materialButton3, materialButton4, switchMaterial);
                                i = C5419R.id.remote_auth_view_flipper;
                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.remote_auth_view_flipper);
                                if (appViewFlipper != null) {
                                    return new WidgetRemoteAuthBinding((RelativeLayout) view, c1085x5, c1071v5, c1078w5, appViewFlipper);
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i2)));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
