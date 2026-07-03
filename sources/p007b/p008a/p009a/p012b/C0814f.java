package p007b.p008a.p009a.p012b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C0937d1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.b.f */
/* JADX INFO: compiled from: PremiumActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0814f extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f295j = {C1643a.m846d0(C0814f.class, "binding", "getBinding()Lcom/discord/databinding/PremiumActivatedDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onDismiss;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.b.f$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: PremiumActivatedDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final void m121a(FragmentManager fragmentManager, Function0<Unit> function0, boolean z2) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(function0, "onDismiss");
            C0814f c0814f = new C0814f();
            c0814f.onDismiss = function0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("ARG_IS_TIER_1", z2);
            c0814f.setArguments(bundle);
            c0814f.show(fragmentManager, C0814f.class.getSimpleName());
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.f$b */
    /* JADX INFO: compiled from: PremiumActivatedDialog.kt */
    public static final /* synthetic */ class b extends C12236k implements Function1<View, C0937d1> {

        /* JADX INFO: renamed from: j */
        public static final b f299j = new b();

        public b() {
            super(1, C0937d1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumActivatedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0937d1 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.premium_activated_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.premium_activated_confirm);
            if (materialButton != null) {
                i = C5419R.id.premium_activated_description;
                TextView textView = (TextView) view2.findViewById(C5419R.id.premium_activated_description);
                if (textView != null) {
                    i = C5419R.id.premium_activated_header_background;
                    ImageView imageView = (ImageView) view2.findViewById(C5419R.id.premium_activated_header_background);
                    if (imageView != null) {
                        i = C5419R.id.premium_activated_logo;
                        ImageView imageView2 = (ImageView) view2.findViewById(C5419R.id.premium_activated_logo);
                        if (imageView2 != null) {
                            i = C5419R.id.premium_activated_title;
                            ImageView imageView3 = (ImageView) view2.findViewById(C5419R.id.premium_activated_title);
                            if (imageView3 != null) {
                                i = C5419R.id.premium_activated_wumpus;
                                ImageView imageView4 = (ImageView) view2.findViewById(C5419R.id.premium_activated_wumpus);
                                if (imageView4 != null) {
                                    return new C0937d1((LinearLayout) view2, materialButton, textView, imageView, imageView2, imageView3, imageView4);
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.f$c */
    /* JADX INFO: compiled from: PremiumActivatedDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> function0 = C0814f.this.onDismiss;
            if (function0 != null) {
                function0.invoke();
            }
            C0814f.this.dismiss();
        }
    }

    public C0814f() {
        super(C5419R.layout.premium_activated_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.f299j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C0937d1 m120g() {
        return (C0937d1) this.binding.getValue((Fragment) this, f295j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        int themedDrawableRes$default;
        super.onResume();
        if (this.onDismiss == null) {
            dismiss();
        }
        boolean z2 = getArgumentsOrDefault().getBoolean("ARG_IS_TIER_1");
        int i = z2 ? C5419R.drawable.bg_premium_classic_subscription_header : C5419R.drawable.bg_premium_subscription_header;
        int i2 = z2 ? C5419R.drawable.img_logo_nitro_classic : C5419R.drawable.img_logo_discord_nitro;
        int i3 = z2 ? C5419R.drawable.img_wumpus_riding_wheel : C5419R.drawable.img_wumpus_jetpack;
        if (z2) {
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C5419R.attr.img_premium_activated_tier_1, 0, 2, (Object) null);
        } else {
            Context contextRequireContext2 = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(contextRequireContext2, C5419R.attr.img_premium_activated_tier_2, 0, 2, (Object) null);
        }
        int i4 = z2 ? C5419R.string.billing_switch_plan_confirm_tier_1 : C5419R.string.billing_switch_plan_confirm_tier_2;
        m120g().f774d.setBackgroundResource(i);
        m120g().f775e.setImageDrawable(ContextCompat.getDrawable(requireContext(), i2));
        m120g().f777g.setImageDrawable(ContextCompat.getDrawable(requireContext(), i3));
        ImageView imageView = m120g().f777g;
        C12238m.checkNotNullExpressionValue(imageView, "binding.premiumActivatedWumpus");
        imageView.setScaleX(z2 ? 1.0f : -1.0f);
        m120g().f776f.setImageDrawable(ContextCompat.getDrawable(requireContext(), themedDrawableRes$default));
        TextView textView = m120g().f773c;
        C12238m.checkNotNullExpressionValue(textView, "binding.premiumActivatedDescription");
        textView.setText(getString(i4));
        requireDialog().setCanceledOnTouchOutside(true);
        m120g().f772b.setOnClickListener(new c());
    }
}
