package p007b.p008a.p009a.p012b;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C1065v;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.b.a */
/* JADX INFO: compiled from: UpgradeGuildBoostDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0809a extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f242j = {C1643a.m846d0(C0809a.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostUpgradeDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

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

    /* JADX INFO: renamed from: b.a.a.b.a$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f249j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f250k;

        public a(int i, Object obj) {
            this.f249j = i;
            this.f250k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f249j;
            if (i == 0) {
                Function0<Unit> function0 = ((C0809a) this.f250k).onContinueClickListener;
                if (function0 != null) {
                    function0.invoke();
                }
                ((C0809a) this.f250k).dismiss();
                return;
            }
            if (i != 1) {
                if (i != 2) {
                    throw null;
                }
                ((C0809a) this.f250k).dismiss();
            } else {
                Function0<Unit> function1 = ((C0809a) this.f250k).onUpgradeClickListener;
                if (function1 != null) {
                    function1.invoke();
                }
                ((C0809a) this.f250k).dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.a$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: UpgradeGuildBoostDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.a$c */
    /* JADX INFO: compiled from: UpgradeGuildBoostDialog.kt */
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C1065v> {

        /* JADX INFO: renamed from: j */
        public static final c f251j = new c();

        public c() {
            super(1, C1065v.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostUpgradeDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1065v invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.continue_button;
            TextView textView = (TextView) view2.findViewById(C5419R.id.continue_button);
            if (textView != null) {
                i = C5419R.id.premium_upsell_close;
                ImageView imageView = (ImageView) view2.findViewById(C5419R.id.premium_upsell_close);
                if (imageView != null) {
                    i = C5419R.id.premium_upsell_description;
                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.premium_upsell_description);
                    if (textView2 != null) {
                        i = C5419R.id.premium_upsell_server_perk;
                        TextView textView3 = (TextView) view2.findViewById(C5419R.id.premium_upsell_server_perk);
                        if (textView3 != null) {
                            i = C5419R.id.upgrade_button;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.upgrade_button);
                            if (materialButton != null) {
                                return new C1065v((RelativeLayout) view2, textView, imageView, textView2, textView3, materialButton);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public C0809a() {
        super(C5419R.layout.guild_boost_upgrade_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f251j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C1065v m108g() {
        return (C1065v) this.binding.getValue((Fragment) this, f242j[0]);
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
        if (this.onContinueClickListener == null || this.onUpgradeClickListener == null) {
            dismiss();
        }
        requireDialog().setCanceledOnTouchOutside(true);
        TextView textView = m108g().f1303d;
        C12238m.checkNotNullExpressionValue(textView, "binding.premiumUpsellDescription");
        C1107b.m221m(textView, C5419R.string.premium_upsell_feature_pretext, new Object[]{this.upgradePrice}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = m108g().f1304e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.premiumUpsellServerPerk");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        C1107b.m221m(textView2, C5419R.string.premium_upsell_feature_free_guild_subscription, new Object[]{StringResourceUtilsKt.getI18nPluralString(contextRequireContext, C5419R.plurals.premium_upsell_feature_free_guild_subscription_numFreeGuildSubscriptions, 2, 2)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView3 = m108g().f1301b;
        C12238m.checkNotNullExpressionValue(textView3, "binding.continueButton");
        textView3.setVisibility(this.hasBoostPlan ^ true ? 0 : 8);
        m108g().f1301b.setOnClickListener(new a(0, this));
        m108g().f1305f.setOnClickListener(new a(1, this));
        m108g().f1302c.setOnClickListener(new a(2, this));
    }
}
