package b.a.a.b;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.a.i.w;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GuildBoostUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(e.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostUpsellDialogBinding;", 0)};
    public static final e$b k = new e$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public e() {
        super(R$layout.guild_boost_upsell_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, e$c.j, null, 2, null);
    }

    public final w g() {
        return (w) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        long j2 = getArgumentsOrDefault().getLong("extra_guild_id", -1L);
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("extra_channel_id")) : null;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("extra_object_type") : null;
        Bundle arguments3 = getArguments();
        Long l = lValueOf;
        String string2 = arguments3 != null ? arguments3.getString("extra_page") : null;
        String str = string;
        g().d.setOnClickListener(new e$a(0, j2, this, l, string2, str));
        g().f220b.setOnClickListener(new e$a(1, j2, this, l, string2, str));
        g().c.setOnClickListener(new e$a(2, j2, this, l, string2, str));
    }
}
