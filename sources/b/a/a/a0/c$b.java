package b.a.a.a0;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.a.i.m4;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.rlottie.RLottieImageView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c$b extends k implements Function1<View, m4> {
    public static final c$b j = new c$b();

    public c$b() {
        super(1, m4.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAcceptGiftDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public m4 invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.accept_gift_body_container;
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R$id.accept_gift_body_container);
        if (linearLayout != null) {
            i = R$id.accept_gift_body_image;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R$id.accept_gift_body_image);
            if (simpleDraweeView != null) {
                i = R$id.accept_gift_body_lottie;
                RLottieImageView rLottieImageView = (RLottieImageView) view2.findViewById(R$id.accept_gift_body_lottie);
                if (rLottieImageView != null) {
                    i = R$id.accept_gift_body_text;
                    TextView textView = (TextView) view2.findViewById(R$id.accept_gift_body_text);
                    if (textView != null) {
                        i = R$id.accept_gift_confirm;
                        MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.accept_gift_confirm);
                        if (materialButton != null) {
                            i = R$id.accept_gift_disclaimer_container;
                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R$id.accept_gift_disclaimer_container);
                            if (linearLayout2 != null) {
                                i = R$id.accept_gift_disclaimer_text;
                                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(R$id.accept_gift_disclaimer_text);
                                if (linkifiedTextView != null) {
                                    i = R$id.accept_gift_flipper;
                                    AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(R$id.accept_gift_flipper);
                                    if (appViewFlipper != null) {
                                        i = R$id.accept_gift_header;
                                        TextView textView2 = (TextView) view2.findViewById(R$id.accept_gift_header);
                                        if (textView2 != null) {
                                            i = R$id.accept_gift_progress;
                                            ProgressBar progressBar = (ProgressBar) view2.findViewById(R$id.accept_gift_progress);
                                            if (progressBar != null) {
                                                return new m4((LinearLayout) view2, linearLayout, simpleDraweeView, rLottieImageView, textView, materialButton, linearLayout2, linkifiedTextView, appViewFlipper, textView2, progressBar);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
