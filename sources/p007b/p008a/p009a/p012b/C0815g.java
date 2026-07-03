package p007b.p008a.p009a.p012b;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C0945e1;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.b.g */
/* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0815g extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f301j = {C1643a.m846d0(C0815g.class, "binding", "getBinding()Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onDismiss;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.b.g$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.g$b */
    /* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    public static final /* synthetic */ class b extends C12236k implements Function1<View, C0945e1> {

        /* JADX INFO: renamed from: j */
        public static final b f305j = new b();

        public b() {
            super(1, C0945e1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0945e1 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.premium_activated_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.premium_activated_confirm);
            if (materialButton != null) {
                i = C5419R.id.premium_and_guild_boost_activated_text;
                TextView textView = (TextView) view2.findViewById(C5419R.id.premium_and_guild_boost_activated_text);
                if (textView != null) {
                    return new C0945e1((LinearLayout) view2, materialButton, textView);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.g$c */
    /* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> function0 = C0815g.this.onDismiss;
            if (function0 != null) {
                function0.invoke();
            }
            C0815g.this.dismiss();
        }
    }

    public C0815g() {
        super(C5419R.layout.premium_and_guild_boost_activated_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.f305j, null, 2, null);
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
        C12238m.checkNotNullExpressionValue(string, "arguments?.getString(EXTRA_PLAN_NAME) ?: \"\"");
        FragmentViewBindingDelegate fragmentViewBindingDelegate = this.binding;
        KProperty<?>[] kPropertyArr = f301j;
        TextView textView = ((C0945e1) fragmentViewBindingDelegate.getValue((Fragment) this, kPropertyArr[0])).f807c;
        C12238m.checkNotNullExpressionValue(textView, "binding.premiumAndGuildBoostActivatedText");
        C1107b.m221m(textView, C5419R.string.billing_premium_and_premium_guild_plan_activated, new Object[]{string}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        requireDialog().setCanceledOnTouchOutside(true);
        ((C0945e1) this.binding.getValue((Fragment) this, kPropertyArr[0])).f806b.setOnClickListener(new c());
    }
}
