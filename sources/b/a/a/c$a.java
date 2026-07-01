package b.a.a;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class c$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public c$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            Function0<Unit> function0 = ((c) this.k).onResendCompressed;
            if (function0 != null) {
                function0.invoke();
            }
            ((c) this.k).dismiss();
            return;
        }
        if (i == 1) {
            ((c) this.k).dismiss();
            return;
        }
        if (i == 2) {
            ((c) this.k).dismiss();
            return;
        }
        if (i != 3) {
            if (i != 4) {
                throw null;
            }
            c cVar = (c) this.k;
            KProperty[] kPropertyArr = c.j;
            cVar.g().c.toggle();
            return;
        }
        AnalyticsTracker.INSTANCE.premiumSettingsOpened(new Traits$Location(null, "File Upload Popout (w/ Compression)", null, null, null, 29, null));
        WidgetSettingsPremium$Companion widgetSettingsPremium$Companion = WidgetSettingsPremium.Companion;
        d0.z.d.m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        d0.z.d.m.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsPremium$Companion.launch$default(widgetSettingsPremium$Companion, context, null, null, 6, null);
        ((c) this.k).dismiss();
    }
}
