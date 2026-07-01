package b.a.a.b;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import b.a.i.d1;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: PremiumActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(f.class, "binding", "getBinding()Lcom/discord/databinding/PremiumActivatedDialogBinding;", 0)};
    public static final f$a k = new f$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onDismiss;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public f() {
        super(R$layout.premium_activated_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, f$b.j, null, 2, null);
    }

    public final d1 g() {
        return (d1) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        int themedDrawableRes$default;
        super.onResume();
        if (this.onDismiss == null) {
            dismiss();
        }
        boolean z2 = getArgumentsOrDefault().getBoolean("ARG_IS_TIER_1");
        int i = z2 ? 2131231020 : 2131231024;
        int i2 = z2 ? 2131232385 : 2131232379;
        int i3 = z2 ? 2131232465 : 2131232463;
        if (z2) {
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(contextRequireContext, 2130969611, 0, 2, (Object) null);
        } else {
            Context contextRequireContext2 = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(contextRequireContext2, 2130969612, 0, 2, (Object) null);
        }
        int i4 = z2 ? 2131887223 : 2131887225;
        g().d.setBackgroundResource(i);
        g().e.setImageDrawable(ContextCompat.getDrawable(requireContext(), i2));
        g().g.setImageDrawable(ContextCompat.getDrawable(requireContext(), i3));
        ImageView imageView = g().g;
        m.checkNotNullExpressionValue(imageView, "binding.premiumActivatedWumpus");
        imageView.setScaleX(z2 ? 1.0f : -1.0f);
        g().f.setImageDrawable(ContextCompat.getDrawable(requireContext(), themedDrawableRes$default));
        TextView textView = g().c;
        m.checkNotNullExpressionValue(textView, "binding.premiumActivatedDescription");
        textView.setText(getString(i4));
        requireDialog().setCanceledOnTouchOutside(true);
        g().f97b.setOnClickListener(new f$c(this));
    }
}
