package b.a.a.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.PremiumUpgradeYearlyDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.text.NumberFormat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.a.b.b, reason: use source file name */
/* JADX INFO: compiled from: UpgradePremiumYearlyDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UpgradePremiumYearlyDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(UpgradePremiumYearlyDialog.class, "binding", "getBinding()Lcom/discord/databinding/PremiumUpgradeYearlyDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

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

    /* JADX INFO: renamed from: b.a.a.b.b$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                Function0<Unit> function0 = ((UpgradePremiumYearlyDialog) this.k).onMonthlyClickListener;
                if (function0 != null) {
                    function0.invoke();
                }
                ((UpgradePremiumYearlyDialog) this.k).dismiss();
                return;
            }
            if (i != 1) {
                throw null;
            }
            Function0<Unit> function1 = ((UpgradePremiumYearlyDialog) this.k).onYearlyClickListener;
            if (function1 != null) {
                function1.invoke();
            }
            ((UpgradePremiumYearlyDialog) this.k).dismiss();
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.b$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: UpgradePremiumYearlyDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.b$c */
    /* JADX INFO: compiled from: UpgradePremiumYearlyDialog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, PremiumUpgradeYearlyDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, PremiumUpgradeYearlyDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumUpgradeYearlyDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public PremiumUpgradeYearlyDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.premium_upsell_header;
            ImageView imageView = (ImageView) view2.findViewById(R.id.premium_upsell_header);
            if (imageView != null) {
                i = R.id.premium_upsell_yearly_description;
                TextView textView = (TextView) view2.findViewById(R.id.premium_upsell_yearly_description);
                if (textView != null) {
                    i = R.id.premium_upsell_yearly_title;
                    TextView textView2 = (TextView) view2.findViewById(R.id.premium_upsell_yearly_title);
                    if (textView2 != null) {
                        i = R.id.purchase_premium_monthly;
                        TextView textView3 = (TextView) view2.findViewById(R.id.purchase_premium_monthly);
                        if (textView3 != null) {
                            i = R.id.purchase_premium_yearly;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.purchase_premium_yearly);
                            if (materialButton != null) {
                                return new PremiumUpgradeYearlyDialogBinding((LinearLayout) view2, imageView, textView, textView2, textView3, materialButton);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.b$d */
    /* JADX INFO: compiled from: UpgradePremiumYearlyDialog.kt */
    public static final class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Function0<Unit> function0 = UpgradePremiumYearlyDialog.this.onDismissCallback;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public UpgradePremiumYearlyDialog() {
        super(R.layout.premium_upgrade_yearly_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final PremiumUpgradeYearlyDialogBinding g() {
        return (PremiumUpgradeYearlyDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics3.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
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
        requireDialog().setOnCancelListener(new d());
        boolean z2 = getArgumentsOrDefault().getBoolean("ARG_IS_TIER_1");
        CharSequence charSequenceE = FormatUtils.e(this, z2 ? R.string.premium_tier_1 : R.string.premium_tier_2, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
        TextView textView = g().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumUpsellYearlyTitle");
        FormatUtils.m(textView, R.string.premium_upsell_yearly_title, new Object[]{NumberFormat.getPercentInstance().format(Float.valueOf(0.16f)), charSequenceE}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView2 = g().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.premiumUpsellYearlyDescription");
        FormatUtils.m(textView2, R.string.premium_upsell_yearly_description, new Object[]{NumberFormat.getPercentInstance().format(Float.valueOf(0.16f))}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        MaterialButton materialButton = g().f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.purchasePremiumYearly");
        FormatUtils.m(materialButton, R.string.premium_upsell_yearly_cta, new Object[]{this.upgradePrice}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        g().f111b.setImageResource(z2 ? R.drawable.img_premium_guild_subscription_purchase_header_tier_1 : R.drawable.img_premium_guild_subscription_purchase_header_tier_2);
        TextView textView3 = g().e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.purchasePremiumMonthly");
        textView3.setVisibility(this.hasMonthlyPlan ^ true ? 0 : 8);
        g().e.setOnClickListener(new a(0, this));
        g().f.setOnClickListener(new a(1, this));
    }
}
