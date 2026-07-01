package b.a.a.b;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.v;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppDialog;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: UpgradeGuildBoostDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(a.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostUpgradeDialogBinding;", 0)};
    public static final a$b k = new a$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onContinueClickListener;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onUpgradeClickListener;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public String upgradePrice;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public boolean hasBoostPlan;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public a() {
        super(R$layout.guild_boost_upgrade_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, a$c.j, null, 2, null);
    }

    public final v g() {
        return (v) this.binding.getValue((Fragment) this, j[0]);
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
        if (this.onContinueClickListener == null || this.onUpgradeClickListener == null) {
            dismiss();
        }
        requireDialog().setCanceledOnTouchOutside(true);
        TextView textView = g().d;
        m.checkNotNullExpressionValue(textView, "binding.premiumUpsellDescription");
        b.a.k.b.n(textView, 2131894507, new Object[]{this.upgradePrice}, null, 4);
        TextView textView2 = g().e;
        m.checkNotNullExpressionValue(textView2, "binding.premiumUpsellServerPerk");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        b.a.k.b.n(textView2, 2131894505, new Object[]{StringResourceUtilsKt.getI18nPluralString(contextRequireContext, R$plurals.premium_upsell_feature_free_guild_subscription_numFreeGuildSubscriptions, 2, 2)}, null, 4);
        TextView textView3 = g().f213b;
        m.checkNotNullExpressionValue(textView3, "binding.continueButton");
        textView3.setVisibility(this.hasBoostPlan ^ true ? 0 : 8);
        g().f213b.setOnClickListener(new a$a(0, this));
        g().f.setOnClickListener(new a$a(1, this));
        g().c.setOnClickListener(new a$a(2, this));
    }
}
