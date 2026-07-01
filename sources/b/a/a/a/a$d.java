package b.a.a.a;

import android.widget.ImageView;
import android.widget.TextView;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GuildBoostUncancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$d extends o implements Function1<k$c, Unit> {
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$d(a aVar) {
        super(1);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(k$c k_c) {
        k$c k_c2 = k_c;
        a aVar = this.this$0;
        m.checkNotNullExpressionValue(k_c2, "it");
        KProperty[] kPropertyArr = a.j;
        AppViewFlipper appViewFlipper = aVar.g().e;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.guildBoostUncancelFlipper");
        appViewFlipper.setDisplayedChild(!(k_c2 instanceof k$c$c) ? 1 : 0);
        TextView textView = aVar.g().d;
        m.checkNotNullExpressionValue(textView, "binding.guildBoostUncancelError");
        boolean z2 = k_c2 instanceof k$c$b;
        textView.setVisibility(z2 && ((k$c$b) k_c2).c ? 0 : 8);
        MaterialButton materialButton = aVar.g().h;
        m.checkNotNullExpressionValue(materialButton, "binding.guildBoostUncancelNevermind");
        materialButton.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton2 = aVar.g().h;
        m.checkNotNullExpressionValue(materialButton2, "binding.guildBoostUncancelNevermind");
        ViewExtensions.setEnabledAndAlpha$default(materialButton2, z2 && !((k$c$b) k_c2).f43b, 0.0f, 2, null);
        aVar.g().c.setIsLoading(z2 && ((k$c$b) k_c2).f43b);
        k$c$c k_c_c = k$c$c.a;
        aVar.setCancelable((m.areEqual(k_c2, k_c_c) ^ true) && z2 && !((k$c$b) k_c2).f43b);
        if (!m.areEqual(k_c2, k_c_c)) {
            if (z2) {
                TextView textView2 = aVar.g().f;
                m.checkNotNullExpressionValue(textView2, "binding.guildBoostUncancelHeader");
                textView2.setText(aVar.getString(2131894121));
                TextView textView3 = aVar.g().f207b;
                m.checkNotNullExpressionValue(textView3, "binding.guildBoostUncancelBody");
                textView3.setText(aVar.getString(2131894118));
            } else if (m.areEqual(k_c2, k$c$d.a)) {
                TextView textView4 = aVar.g().f;
                m.checkNotNullExpressionValue(textView4, "binding.guildBoostUncancelHeader");
                textView4.setText(aVar.getString(2131894117));
                ImageView imageView = aVar.g().g;
                m.checkNotNullExpressionValue(imageView, "binding.guildBoostUncancelImage");
                imageView.setVisibility(0);
                TextView textView5 = aVar.g().f207b;
                m.checkNotNullExpressionValue(textView5, "binding.guildBoostUncancelBody");
                textView5.setText(aVar.getString(2131894116));
                aVar.g().c.setText(aVar.getString(2131893499));
            } else if (k_c2 instanceof k$c$a) {
                Integer num = ((k$c$a) k_c2).a;
                if (num != null) {
                    b.a.d.m.i(aVar, num.intValue(), 0, 4);
                }
                aVar.dismiss();
            }
        }
        return Unit.a;
    }
}
