package b.a.a.b;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.e1;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(g.class, "binding", "getBinding()Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0)};
    public static final g$a k = new g$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onDismiss;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public g() {
        super(R$layout.premium_and_guild_boost_activated_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, g$b.j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        String string;
        super.onViewBoundOrOnResume();
        if (this.onDismiss == null) {
            dismiss();
        }
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("extra_plan_text")) == null) {
            string = "";
        }
        m.checkNotNullExpressionValue(string, "arguments?.getString(EXTRA_PLAN_NAME) ?: \"\"");
        FragmentViewBindingDelegate fragmentViewBindingDelegate = this.binding;
        KProperty<?>[] kPropertyArr = j;
        TextView textView = ((e1) fragmentViewBindingDelegate.getValue((Fragment) this, kPropertyArr[0])).c;
        m.checkNotNullExpressionValue(textView, "binding.premiumAndGuildBoostActivatedText");
        b.a.k.b.n(textView, 2131887132, new Object[]{string}, null, 4);
        requireDialog().setCanceledOnTouchOutside(true);
        ((e1) this.binding.getValue((Fragment) this, kPropertyArr[0])).f103b.setOnClickListener(new g$c(this));
    }
}
