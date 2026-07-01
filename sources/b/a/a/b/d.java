package b.a.a.b;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import b.a.i.p1;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SingleValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(d.class, "binding", "getBinding()Lcom/discord/databinding/SingleValuePropPremiumUpsellDialogBinding;", 0)};
    public static final d$b k = new d$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public d() {
        super(R$layout.single_value_prop_premium_upsell_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, d$c.j, null, 2, null);
    }

    public final p1 g() {
        return (p1) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("extra_image_drawable_res")) : null;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("extra_header_text") : null;
        Bundle arguments3 = getArguments();
        String string2 = arguments3 != null ? arguments3.getString("extra_body_text") : null;
        if (numValueOf != null) {
            g().f.setImageDrawable(ContextCompat.getDrawable(requireContext(), numValueOf.intValue()));
        }
        if (string != null) {
            TextView textView = g().e;
            m.checkNotNullExpressionValue(textView, "binding.upsellHeaderText");
            textView.setText(string);
        }
        if (string2 != null) {
            TextView textView2 = g().d;
            m.checkNotNullExpressionValue(textView2, "binding.upsellBodyText");
            textView2.setText(string2);
        }
        g().f178b.setOnClickListener(new d$a(0, this));
        g().c.setOnClickListener(new d$a(1, this));
    }
}
