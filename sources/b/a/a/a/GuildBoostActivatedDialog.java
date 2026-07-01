package b.a.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.GuildBoostActivatedDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.airbnb.lottie.LottieAnimationView;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.animations.LottieAnimationUtils2;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.a.a.c, reason: use source file name */
/* JADX INFO: compiled from: GuildBoostActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildBoostActivatedDialog extends AppDialog {

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public Function0<Unit> dismissListener;
    public static final /* synthetic */ KProperty[] j = {outline.d0(GuildBoostActivatedDialog.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostActivatedDialogBinding;", 0)};

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Ranges2 k = new Ranges2(540, 825);

    /* JADX INFO: renamed from: b.a.a.a.c$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: GuildBoostActivatedDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(FragmentManager fragmentManager, Context context, String str, int i, boolean z2, Function0<Unit> function0) {
            CharSequence charSequenceB;
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(function0, "dismissListener");
            CharSequence charSequenceB2 = z2 ? FormatUtils.b(context, R.string.guild_subscription_purchase_modal_transferred_description_mobile1, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(context, R.string.guild_subscription_purchase_modal_activated_description_mobile1, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
            if (str == null) {
                charSequenceB = FormatUtils.b(context, R.string.guild_subscription_purchase_modal_activated_description_no_application, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.guild_subscription_purchase_modal_activated_description_no_application_guildSubscriptionQuantity, i, Integer.valueOf(i))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            } else {
                charSequenceB = z2 ? FormatUtils.b(context, R.string.guild_subscription_purchase_modal_transferred_description_mobile2, new Object[]{str, StringResourceUtils.getI18nPluralString(context, R.plurals.guild_subscription_purchase_modal_transferred_description_mobile2_guildSubscriptionQuantity, i, Integer.valueOf(i))}, (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(context, R.string.guild_subscription_purchase_modal_activated_description_mobile2, new Object[]{str, StringResourceUtils.getI18nPluralString(context, R.plurals.guild_subscription_purchase_modal_activated_description_guildSubscriptionQuantity, i, Integer.valueOf(i))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            GuildBoostActivatedDialog guildBoostActivatedDialog = new GuildBoostActivatedDialog();
            guildBoostActivatedDialog.dismissListener = function0;
            Bundle bundle = new Bundle();
            bundle.putCharSequence("extra_body1_text", charSequenceB2);
            bundle.putCharSequence("extra_body2_text", charSequenceB);
            guildBoostActivatedDialog.setArguments(bundle);
            guildBoostActivatedDialog.show(fragmentManager, GuildBoostActivatedDialog.class.getName());
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.c$b */
    /* JADX INFO: compiled from: GuildBoostActivatedDialog.kt */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, GuildBoostActivatedDialogBinding> {
        public static final b j = new b();

        public b() {
            super(1, GuildBoostActivatedDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostActivatedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public GuildBoostActivatedDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.guild_boost_activated_body_1;
            TextView textView = (TextView) view2.findViewById(R.id.guild_boost_activated_body_1);
            if (textView != null) {
                i = R.id.guild_boost_activated_body_2;
                TextView textView2 = (TextView) view2.findViewById(R.id.guild_boost_activated_body_2);
                if (textView2 != null) {
                    i = R.id.guild_boost_activated_lottie;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.guild_boost_activated_lottie);
                    if (lottieAnimationView != null) {
                        i = R.id.guild_boost_activated_ok;
                        MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.guild_boost_activated_ok);
                        if (materialButton != null) {
                            return new GuildBoostActivatedDialogBinding((LinearLayout) view2, textView, textView2, lottieAnimationView, materialButton);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.c$c */
    /* JADX INFO: compiled from: GuildBoostActivatedDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildBoostActivatedDialog.this.dismiss();
        }
    }

    public GuildBoostActivatedDialog() {
        super(R.layout.guild_boost_activated_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
    }

    public final GuildBoostActivatedDialogBinding g() {
        return (GuildBoostActivatedDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        Function0<Unit> function0 = this.dismissListener;
        if (function0 != null) {
            function0.invoke();
        }
        super.onDismiss(dialog);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        TextView textView = g().f194b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostActivatedBody1");
        Bundle arguments = getArguments();
        textView.setText(arguments != null ? arguments.getCharSequence("extra_body1_text") : null);
        TextView textView2 = g().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildBoostActivatedBody2");
        Bundle arguments2 = getArguments();
        textView2.setText(arguments2 != null ? arguments2.getCharSequence("extra_body2_text") : null);
        g().e.setOnClickListener(new c());
        LottieAnimationView lottieAnimationView = g().d;
        Intrinsics3.checkNotNullExpressionValue(lottieAnimationView, "binding.guildBoostActivatedLottie");
        LottieAnimationUtils2.loopFrom$default(lottieAnimationView, 180, k, false, 4, null);
    }
}
