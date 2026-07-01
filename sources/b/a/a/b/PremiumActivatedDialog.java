package b.a.a.b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.PremiumActivatedDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.drawable.DrawableCompat;
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

/* JADX INFO: renamed from: b.a.a.b.f, reason: use source file name */
/* JADX INFO: compiled from: PremiumActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PremiumActivatedDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(PremiumActivatedDialog.class, "binding", "getBinding()Lcom/discord/databinding/PremiumActivatedDialogBinding;", 0)};

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

        public final void a(FragmentManager fragmentManager, Function0<Unit> function0, boolean z2) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(function0, "onDismiss");
            PremiumActivatedDialog premiumActivatedDialog = new PremiumActivatedDialog();
            premiumActivatedDialog.onDismiss = function0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("ARG_IS_TIER_1", z2);
            premiumActivatedDialog.setArguments(bundle);
            premiumActivatedDialog.show(fragmentManager, PremiumActivatedDialog.class.getSimpleName());
        }
    }

    /* JADX INFO: renamed from: b.a.a.b.f$b */
    /* JADX INFO: compiled from: PremiumActivatedDialog.kt */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, PremiumActivatedDialogBinding> {
        public static final b j = new b();

        public b() {
            super(1, PremiumActivatedDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumActivatedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public PremiumActivatedDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.premium_activated_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.premium_activated_confirm);
            if (materialButton != null) {
                i = R.id.premium_activated_description;
                TextView textView = (TextView) view2.findViewById(R.id.premium_activated_description);
                if (textView != null) {
                    i = R.id.premium_activated_header_background;
                    ImageView imageView = (ImageView) view2.findViewById(R.id.premium_activated_header_background);
                    if (imageView != null) {
                        i = R.id.premium_activated_logo;
                        ImageView imageView2 = (ImageView) view2.findViewById(R.id.premium_activated_logo);
                        if (imageView2 != null) {
                            i = R.id.premium_activated_title;
                            ImageView imageView3 = (ImageView) view2.findViewById(R.id.premium_activated_title);
                            if (imageView3 != null) {
                                i = R.id.premium_activated_wumpus;
                                ImageView imageView4 = (ImageView) view2.findViewById(R.id.premium_activated_wumpus);
                                if (imageView4 != null) {
                                    return new PremiumActivatedDialogBinding((LinearLayout) view2, materialButton, textView, imageView, imageView2, imageView3, imageView4);
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
            Function0<Unit> function0 = PremiumActivatedDialog.this.onDismiss;
            if (function0 != null) {
                function0.invoke();
            }
            PremiumActivatedDialog.this.dismiss();
        }
    }

    public PremiumActivatedDialog() {
        super(R.layout.premium_activated_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
    }

    public final PremiumActivatedDialogBinding g() {
        return (PremiumActivatedDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        int themedDrawableRes$default;
        super.onResume();
        if (this.onDismiss == null) {
            dismiss();
        }
        boolean z2 = getArgumentsOrDefault().getBoolean("ARG_IS_TIER_1");
        int i = z2 ? R.drawable.bg_premium_classic_subscription_header : R.drawable.bg_premium_subscription_header;
        int i2 = z2 ? R.drawable.img_logo_nitro_classic : R.drawable.img_logo_discord_nitro;
        int i3 = z2 ? R.drawable.img_wumpus_riding_wheel : R.drawable.img_wumpus_jetpack;
        if (z2) {
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.attr.img_premium_activated_tier_1, 0, 2, (Object) null);
        } else {
            Context contextRequireContext2 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(contextRequireContext2, R.attr.img_premium_activated_tier_2, 0, 2, (Object) null);
        }
        int i4 = z2 ? R.string.billing_switch_plan_confirm_tier_1 : R.string.billing_switch_plan_confirm_tier_2;
        g().d.setBackgroundResource(i);
        g().e.setImageDrawable(ContextCompat.getDrawable(requireContext(), i2));
        g().g.setImageDrawable(ContextCompat.getDrawable(requireContext(), i3));
        ImageView imageView = g().g;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.premiumActivatedWumpus");
        imageView.setScaleX(z2 ? 1.0f : -1.0f);
        g().f.setImageDrawable(ContextCompat.getDrawable(requireContext(), themedDrawableRes$default));
        TextView textView = g().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumActivatedDescription");
        textView.setText(getString(i4));
        requireDialog().setCanceledOnTouchOutside(true);
        g().f97b.setOnClickListener(new c());
    }
}
