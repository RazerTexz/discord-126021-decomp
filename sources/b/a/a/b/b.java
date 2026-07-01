package b.a.a.b;

import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.f1;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import java.text.NumberFormat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: UpgradePremiumYearlyDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(b.class, "binding", "getBinding()Lcom/discord/databinding/PremiumUpgradeYearlyDialogBinding;", 0)};
    public static final b$b k = new b$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onMonthlyClickListener;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onYearlyClickListener;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public Function0<Unit> onDismissCallback;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public String upgradePrice;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public boolean hasMonthlyPlan;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public b() {
        super(R$layout.premium_upgrade_yearly_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b$c.j, null, 2, null);
    }

    public final f1 g() {
        return (f1) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        m.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        if (this.onMonthlyClickListener == null || this.onYearlyClickListener == null) {
            dismiss();
        }
        requireDialog().setCanceledOnTouchOutside(true);
        requireDialog().setOnCancelListener(new b$d(this));
        boolean z2 = getArgumentsOrDefault().getBoolean("ARG_IS_TIER_1");
        CharSequence charSequenceK = b.a.k.b.k(this, z2 ? 2131894441 : 2131894444, new Object[0], null, 4);
        TextView textView = g().d;
        m.checkNotNullExpressionValue(textView, "binding.premiumUpsellYearlyTitle");
        b.a.k.b.n(textView, 2131894524, new Object[]{NumberFormat.getPercentInstance().format(Float.valueOf(0.16f)), charSequenceK}, null, 4);
        TextView textView2 = g().c;
        m.checkNotNullExpressionValue(textView2, "binding.premiumUpsellYearlyDescription");
        b.a.k.b.n(textView2, 2131894523, new Object[]{NumberFormat.getPercentInstance().format(Float.valueOf(0.16f))}, null, 4);
        MaterialButton materialButton = g().f;
        m.checkNotNullExpressionValue(materialButton, "binding.purchasePremiumYearly");
        b.a.k.b.n(materialButton, 2131894522, new Object[]{this.upgradePrice}, null, 4);
        g().f111b.setImageResource(z2 ? 2131232431 : 2131232432);
        TextView textView3 = g().e;
        m.checkNotNullExpressionValue(textView3, "binding.purchasePremiumMonthly");
        textView3.setVisibility(this.hasMonthlyPlan ^ true ? 0 : 8);
        g().e.setOnClickListener(new b$a(0, this));
        g().f.setOnClickListener(new b$a(1, this));
    }
}
