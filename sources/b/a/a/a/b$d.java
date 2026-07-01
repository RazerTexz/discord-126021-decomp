package b.a.a.a;

import android.content.Context;
import android.widget.TextView;
import com.discord.R$attr;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import d0.z.d.o;
import java.text.DateFormat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$d extends o implements Function1<f$c, Unit> {
    public final /* synthetic */ b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$d(b bVar) {
        super(1);
        this.this$0 = bVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(f$c f_c) {
        f$c f_c2 = f_c;
        b bVar = this.this$0;
        m.checkNotNullExpressionValue(f_c2, "it");
        KProperty[] kPropertyArr = b.j;
        TextView textView = bVar.g().d;
        m.checkNotNullExpressionValue(textView, "binding.guildBoostCancelError");
        textView.setVisibility(f_c2.a ? 0 : 8);
        MaterialButton materialButton = bVar.g().g;
        m.checkNotNullExpressionValue(materialButton, "binding.guildBoostCancelNevermind");
        materialButton.setVisibility(f_c2.f42b ? 0 : 8);
        MaterialButton materialButton2 = bVar.g().g;
        m.checkNotNullExpressionValue(materialButton2, "binding.guildBoostCancelNevermind");
        ViewExtensions.setEnabledAndAlpha$default(materialButton2, f_c2.c, 0.0f, 2, null);
        bVar.setCancelable(f_c2.e);
        bVar.g().c.setIsLoading(f_c2.d);
        AppViewFlipper appViewFlipper = bVar.g().e;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.guildBoostCancelFlipper");
        appViewFlipper.setDisplayedChild(!(f_c2 instanceof f$c$f) ? 1 : 0);
        if (f_c2 instanceof f$c$e) {
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            f$c$e f_c_e = (f$c$e) f_c2;
            String currentPeriodEnd = f_c_e.f.getCurrentPeriodEnd();
            Context contextRequireContext = bVar.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(timeUtils, currentPeriodEnd, contextRequireContext, (String) null, (DateFormat) null, 0, 28, (Object) null);
            if (f_c_e.g) {
                TextView textView2 = bVar.g().f201b;
                m.checkNotNullExpressionValue(textView2, "binding.guildBoostCancelBody");
                b.a.k.b.n(textView2, 2131894086, new Object[]{strRenderUtcDate$default}, null, 4);
            } else {
                TextView textView3 = bVar.g().f201b;
                m.checkNotNullExpressionValue(textView3, "binding.guildBoostCancelBody");
                b.a.k.b.n(textView3, 2131894085, new Object[]{strRenderUtcDate$default}, null, 4);
            }
            bVar.g().c.setBackgroundColor(ColorCompat.getColor(bVar, 2131100382));
        } else if (f_c2 instanceof f$c$b) {
            TextView textView4 = bVar.g().f;
            m.checkNotNullExpressionValue(textView4, "binding.guildBoostCancelHeader");
            textView4.setText(bVar.getString(2131894097));
            TextView textView5 = bVar.g().f201b;
            m.checkNotNullExpressionValue(textView5, "binding.guildBoostCancelBody");
            TimeUtils timeUtils2 = TimeUtils.INSTANCE;
            String currentPeriodEnd2 = ((f$c$b) f_c2).f.getCurrentPeriodEnd();
            Context contextRequireContext2 = bVar.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            b.a.k.b.n(textView5, 2131894098, new Object[]{TimeUtils.renderUtcDate$default(timeUtils2, currentPeriodEnd2, contextRequireContext2, (String) null, (DateFormat) null, 0, 28, (Object) null)}, null, 4);
            bVar.g().c.setText(bVar.getString(2131893499));
            bVar.g().c.setBackgroundColor(ColorCompat.getThemedColor(bVar, R$attr.color_brand_500));
        } else if (f_c2 instanceof f$c$c) {
            Integer num = ((f$c$c) f_c2).f;
            if (num != null) {
                b.a.d.m.g(bVar.requireContext(), num.intValue(), 0, null, 12);
            }
            bVar.dismiss();
        }
        return Unit.a;
    }
}
