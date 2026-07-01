package b.a.a.b;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.PremiumAndGuildBoostActivatedDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.a.b.g, reason: use source file name */
/* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PremiumAndGuildBoostActivatedDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(PremiumAndGuildBoostActivatedDialog.class, "binding", "getBinding()Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0)};

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
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, PremiumAndGuildBoostActivatedDialogBinding> {
        public static final b j = new b();

        public b() {
            super(1, PremiumAndGuildBoostActivatedDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public PremiumAndGuildBoostActivatedDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.premium_activated_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.premium_activated_confirm);
            if (materialButton != null) {
                i = R.id.premium_and_guild_boost_activated_text;
                TextView textView = (TextView) view2.findViewById(R.id.premium_and_guild_boost_activated_text);
                if (textView != null) {
                    return new PremiumAndGuildBoostActivatedDialogBinding((LinearLayout) view2, materialButton, textView);
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
            Function0<Unit> function0 = PremiumAndGuildBoostActivatedDialog.this.onDismiss;
            if (function0 != null) {
                function0.invoke();
            }
            PremiumAndGuildBoostActivatedDialog.this.dismiss();
        }
    }

    public PremiumAndGuildBoostActivatedDialog() {
        super(R.layout.premium_and_guild_boost_activated_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
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
        Intrinsics3.checkNotNullExpressionValue(string, "arguments?.getString(EXTRA_PLAN_NAME) ?: \"\"");
        FragmentViewBindingDelegate fragmentViewBindingDelegate = this.binding;
        KProperty<?>[] kPropertyArr = j;
        TextView textView = ((PremiumAndGuildBoostActivatedDialogBinding) fragmentViewBindingDelegate.getValue((Fragment) this, kPropertyArr[0])).c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumAndGuildBoostActivatedText");
        FormatUtils.m(textView, R.string.billing_premium_and_premium_guild_plan_activated, new Object[]{string}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        requireDialog().setCanceledOnTouchOutside(true);
        ((PremiumAndGuildBoostActivatedDialogBinding) this.binding.getValue((Fragment) this, kPropertyArr[0])).f103b.setOnClickListener(new c());
    }
}
