package b.a.a.b;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class e$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ long k;
    public final /* synthetic */ Object l;
    public final /* synthetic */ Object m;
    public final /* synthetic */ Object n;
    public final /* synthetic */ Object o;

    public e$a(int i, long j, Object obj, Object obj2, Object obj3, Object obj4) {
        this.j = i;
        this.k = j;
        this.l = obj;
        this.m = obj2;
        this.n = obj3;
        this.o = obj4;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            AnalyticsTracker.INSTANCE.guildBoostPromotionOpened(this.k, new Traits$Location((String) this.n, Traits$Location$Section.PREMIUM_GUILD_UPSELL_MODAL, Traits$Location$Obj.BUTTON_CTA, (String) this.o, null, 16, null), (Long) this.m);
            WidgetGuildBoost$Companion widgetGuildBoost$Companion = WidgetGuildBoost.Companion;
            Context contextRequireContext = ((e) this.l).requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            widgetGuildBoost$Companion.create(contextRequireContext, this.k);
            ((e) this.l).dismiss();
            return;
        }
        if (i == 1) {
            AnalyticsTracker.INSTANCE.guildBoostPromotionClosed(this.k, new Traits$Location((String) this.n, Traits$Location$Section.PREMIUM_GUILD_UPSELL_MODAL, Traits$Location$Obj.BUTTON_CTA, (String) this.o, null, 16, null), (Long) this.m);
            ((e) this.l).dismiss();
            return;
        }
        if (i != 2) {
            throw null;
        }
        AnalyticsTracker.INSTANCE.guildBoostPromotionClosed(this.k, new Traits$Location((String) this.n, Traits$Location$Section.PREMIUM_GUILD_UPSELL_MODAL, Traits$Location$Obj.BUTTON_CTA, (String) this.o, null, 16, null), (Long) this.m);
        ((e) this.l).dismiss();
    }
}
