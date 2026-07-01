package b.a.v;

import android.view.View;
import com.discord.tooltips.DefaultTooltipCreator;
import com.discord.tooltips.TooltipManager;

/* JADX INFO: renamed from: b.a.v.b, reason: use source file name */
/* JADX INFO: compiled from: DefaultTooltipCreator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DefaultTooltipCreator2 implements View.OnClickListener {
    public final /* synthetic */ DefaultTooltipCreator j;
    public final /* synthetic */ TooltipManager.b k;

    public DefaultTooltipCreator2(DefaultTooltipCreator defaultTooltipCreator, TooltipManager.b bVar) {
        this.j = defaultTooltipCreator;
        this.k = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.j.tooltipManager.a(this.k);
        this.j.tooltipManager.c(this.k);
    }
}
