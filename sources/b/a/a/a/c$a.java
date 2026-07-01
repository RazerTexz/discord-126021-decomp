package b.a.a.a;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.R$plurals;
import com.discord.utilities.resources.StringResourceUtilsKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildBoostActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$a {
    public c$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final void a(FragmentManager fragmentManager, Context context, String str, int i, boolean z2, Function0<Unit> function0) {
        CharSequence charSequenceH;
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(function0, "dismissListener");
        CharSequence charSequenceH2 = z2 ? b.a.k.b.h(context, 2131891543, new Object[0], null, 4) : b.a.k.b.h(context, 2131891527, new Object[0], null, 4);
        if (str == null) {
            charSequenceH = b.a.k.b.h(context, 2131891529, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, R$plurals.guild_subscription_purchase_modal_activated_description_no_application_guildSubscriptionQuantity, i, Integer.valueOf(i))}, null, 4);
        } else {
            charSequenceH = z2 ? b.a.k.b.h(context, 2131891544, new Object[]{str, StringResourceUtilsKt.getI18nPluralString(context, R$plurals.guild_subscription_purchase_modal_transferred_description_mobile2_guildSubscriptionQuantity, i, Integer.valueOf(i))}, null, 4) : b.a.k.b.h(context, 2131891528, new Object[]{str, StringResourceUtilsKt.getI18nPluralString(context, R$plurals.guild_subscription_purchase_modal_activated_description_guildSubscriptionQuantity, i, Integer.valueOf(i))}, null, 4);
        }
        c cVar = new c();
        cVar.dismissListener = function0;
        Bundle bundle = new Bundle();
        bundle.putCharSequence("extra_body1_text", charSequenceH2);
        bundle.putCharSequence("extra_body2_text", charSequenceH);
        cVar.setArguments(bundle);
        cVar.show(fragmentManager, c.class.getName());
    }
}
