package b.a.a.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.u;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostUncancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a$c extends d0.z.d.k implements Function1<View, u> {
    public static final a$c j = new a$c();

    public a$c() {
        super(1, u.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostUncancelDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public u invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.guild_boost_uncancel_body;
        TextView textView = (TextView) view2.findViewById(R$id.guild_boost_uncancel_body);
        if (textView != null) {
            i = R$id.guild_boost_uncancel_confirm;
            LoadingButton loadingButton = (LoadingButton) view2.findViewById(R$id.guild_boost_uncancel_confirm);
            if (loadingButton != null) {
                i = R$id.guild_boost_uncancel_error;
                TextView textView2 = (TextView) view2.findViewById(R$id.guild_boost_uncancel_error);
                if (textView2 != null) {
                    i = R$id.guild_boost_uncancel_flipper;
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(R$id.guild_boost_uncancel_flipper);
                    if (appViewFlipper != null) {
                        i = R$id.guild_boost_uncancel_header;
                        TextView textView3 = (TextView) view2.findViewById(R$id.guild_boost_uncancel_header);
                        if (textView3 != null) {
                            i = R$id.guild_boost_uncancel_image;
                            ImageView imageView = (ImageView) view2.findViewById(R$id.guild_boost_uncancel_image);
                            if (imageView != null) {
                                i = R$id.guild_boost_uncancel_nevermind;
                                MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.guild_boost_uncancel_nevermind);
                                if (materialButton != null) {
                                    i = R$id.notice_header_container;
                                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R$id.notice_header_container);
                                    if (linearLayout != null) {
                                        return new u((LinearLayout) view2, textView, loadingButton, textView2, appViewFlipper, textView3, imageView, materialButton, linearLayout);
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
