package b.a.a.a;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.s;
import com.airbnb.lottie.LottieAnimationView;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.animations.LottieAnimationUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GuildBoostActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends AppDialog {

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public Function0<Unit> dismissListener;
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(c.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostActivatedDialogBinding;", 0)};
    public static final c$a l = new c$a(null);
    public static final IntRange k = new IntRange(540, 825);

    public c() {
        super(R$layout.guild_boost_activated_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c$b.j, null, 2, null);
    }

    public final s g() {
        return (s) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
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
        m.checkNotNullExpressionValue(textView, "binding.guildBoostActivatedBody1");
        Bundle arguments = getArguments();
        textView.setText(arguments != null ? arguments.getCharSequence("extra_body1_text") : null);
        TextView textView2 = g().c;
        m.checkNotNullExpressionValue(textView2, "binding.guildBoostActivatedBody2");
        Bundle arguments2 = getArguments();
        textView2.setText(arguments2 != null ? arguments2.getCharSequence("extra_body2_text") : null);
        g().e.setOnClickListener(new c$c(this));
        LottieAnimationView lottieAnimationView = g().d;
        m.checkNotNullExpressionValue(lottieAnimationView, "binding.guildBoostActivatedLottie");
        LottieAnimationUtilsKt.loopFrom$default(lottieAnimationView, 180, k, false, 4, null);
    }
}
