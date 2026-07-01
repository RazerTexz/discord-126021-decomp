package b.a.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.a.i.t;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b$c extends d0.z.d.k implements Function1<View, t> {
    public static final b$c j = new b$c();

    public b$c() {
        super(1, t.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostCancelDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public t invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.active_subscription_progress;
        ProgressBar progressBar = (ProgressBar) view2.findViewById(R$id.active_subscription_progress);
        if (progressBar != null) {
            i = R$id.guild_boost_cancel_body;
            TextView textView = (TextView) view2.findViewById(R$id.guild_boost_cancel_body);
            if (textView != null) {
                i = R$id.guild_boost_cancel_confirm;
                LoadingButton loadingButton = (LoadingButton) view2.findViewById(R$id.guild_boost_cancel_confirm);
                if (loadingButton != null) {
                    i = R$id.guild_boost_cancel_error;
                    TextView textView2 = (TextView) view2.findViewById(R$id.guild_boost_cancel_error);
                    if (textView2 != null) {
                        i = R$id.guild_boost_cancel_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(R$id.guild_boost_cancel_flipper);
                        if (appViewFlipper != null) {
                            i = R$id.guild_boost_cancel_header;
                            TextView textView3 = (TextView) view2.findViewById(R$id.guild_boost_cancel_header);
                            if (textView3 != null) {
                                i = R$id.guild_boost_cancel_nevermind;
                                MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.guild_boost_cancel_nevermind);
                                if (materialButton != null) {
                                    i = R$id.notice_header_container;
                                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R$id.notice_header_container);
                                    if (linearLayout != null) {
                                        return new t((LinearLayout) view2, progressBar, textView, loadingButton, textView2, appViewFlipper, textView3, materialButton, linearLayout);
                                    }
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
