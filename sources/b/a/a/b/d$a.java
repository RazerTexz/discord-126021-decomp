package b.a.a.b;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import d0.z.d.m;
import java.util.Objects;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class d$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public d$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            ((d) this.k).dismiss();
            return;
        }
        if (i != 1) {
            throw null;
        }
        d dVar = (d) this.k;
        KProperty[] kPropertyArr = d.j;
        Objects.requireNonNull(dVar);
        WidgetSettingsPremium$Companion widgetSettingsPremium$Companion = WidgetSettingsPremium.Companion;
        Context contextRequireContext = dVar.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetSettingsPremium$Companion.launch$default(widgetSettingsPremium$Companion, contextRequireContext, null, null, 6, null);
        dVar.dismiss();
    }
}
