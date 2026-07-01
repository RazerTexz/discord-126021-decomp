package b.a.a.b;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.u5;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$d extends AppFragment {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(c$d.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPremiumUpsellBinding;", 0)};
    public static final c$d$a k = new c$d$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public c$d() {
        super(R$layout.widget_premium_upsell);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c$d$b.j, null, 2, null);
    }

    public final u5 g() {
        return (u5) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        String string;
        super.onViewBoundOrOnResume();
        ImageView imageView = g().d;
        Bundle arguments = getArguments();
        imageView.setImageResource(arguments != null ? arguments.getInt("extra_image_id") : 0);
        TextView textView = g().c;
        m.checkNotNullExpressionValue(textView, "binding.premiumUpsellHeader");
        Bundle arguments2 = getArguments();
        textView.setText(arguments2 != null ? arguments2.getString("extra_header_string") : null);
        TextView textView2 = g().f212b;
        m.checkNotNullExpressionValue(textView2, "binding.premiumUpsellBody");
        Bundle arguments3 = getArguments();
        textView2.setText((arguments3 == null || (string = arguments3.getString("extra_body_text")) == null) ? "" : b.a.k.b.l(string, new Object[0], null, 2));
    }
}
