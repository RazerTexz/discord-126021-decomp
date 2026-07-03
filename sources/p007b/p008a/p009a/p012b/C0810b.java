package p007b.p008a.p009a.p012b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import java.text.NumberFormat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C0953f1;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.b.b */
/* JADX INFO: compiled from: UpgradePremiumYearlyDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0810b extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f252j = {C1643a.m846d0(C0810b.class, "binding", "getBinding()Lcom/discord/databinding/PremiumUpgradeYearlyDialogBinding;", 0)};

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

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f260j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f261k;

        public a(int i, Object obj) {
            this.f260j = i;
            this.f261k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f260j;
            if (i == 0) {
                Function0<Unit> function0 = ((C0810b) this.f261k).onMonthlyClickListener;
                if (function0 != null) {
                    function0.invoke();
                }
                ((C0810b) this.f261k).dismiss();
                return;
            }
            if (i != 1) {
                throw null;
            }
            Function0<Unit> function1 = ((C0810b) this.f261k).onYearlyClickListener;
            if (function1 != null) {
                function1.invoke();
            }
            ((C0810b) this.f261k).dismiss();
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
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C0953f1> {

        /* JADX INFO: renamed from: j */
        public static final c f262j = new c();

        public c() {
            super(1, C0953f1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumUpgradeYearlyDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0953f1 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.premium_upsell_header;
            ImageView imageView = (ImageView) view2.findViewById(C5419R.id.premium_upsell_header);
            if (imageView != null) {
                i = C5419R.id.premium_upsell_yearly_description;
                TextView textView = (TextView) view2.findViewById(C5419R.id.premium_upsell_yearly_description);
                if (textView != null) {
                    i = C5419R.id.premium_upsell_yearly_title;
                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.premium_upsell_yearly_title);
                    if (textView2 != null) {
                        i = C5419R.id.purchase_premium_monthly;
                        TextView textView3 = (TextView) view2.findViewById(C5419R.id.purchase_premium_monthly);
                        if (textView3 != null) {
                            i = C5419R.id.purchase_premium_yearly;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.purchase_premium_yearly);
                            if (materialButton != null) {
                                return new C0953f1((LinearLayout) view2, imageView, textView, textView2, textView3, materialButton);
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
            Function0<Unit> function0 = C0810b.this.onDismissCallback;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public C0810b() {
        super(C5419R.layout.premium_upgrade_yearly_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f262j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C0953f1 m109g() {
        return (C0953f1) this.binding.getValue((Fragment) this, f252j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        C12238m.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
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
        CharSequence charSequenceM213e = C1107b.m213e(this, z2 ? C5419R.string.premium_tier_1 : C5419R.string.premium_tier_2, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
        TextView textView = m109g().f837d;
        C12238m.checkNotNullExpressionValue(textView, "binding.premiumUpsellYearlyTitle");
        C1107b.m221m(textView, C5419R.string.premium_upsell_yearly_title, new Object[]{NumberFormat.getPercentInstance().format(Float.valueOf(0.16f)), charSequenceM213e}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = m109g().f836c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.premiumUpsellYearlyDescription");
        C1107b.m221m(textView2, C5419R.string.premium_upsell_yearly_description, new Object[]{NumberFormat.getPercentInstance().format(Float.valueOf(0.16f))}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        MaterialButton materialButton = m109g().f839f;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.purchasePremiumYearly");
        C1107b.m221m(materialButton, C5419R.string.premium_upsell_yearly_cta, new Object[]{this.upgradePrice}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        m109g().f835b.setImageResource(z2 ? C5419R.drawable.img_premium_guild_subscription_purchase_header_tier_1 : C5419R.drawable.img_premium_guild_subscription_purchase_header_tier_2);
        TextView textView3 = m109g().f838e;
        C12238m.checkNotNullExpressionValue(textView3, "binding.purchasePremiumMonthly");
        textView3.setVisibility(this.hasMonthlyPlan ^ true ? 0 : 8);
        m109g().f838e.setOnClickListener(new a(0, this));
        m109g().f839f.setOnClickListener(new a(1, this));
    }
}
