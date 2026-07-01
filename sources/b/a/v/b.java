package b.a.v;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.tooltips.DefaultTooltipCreator;
import com.discord.tooltips.TooltipManager$b;

/* JADX INFO: compiled from: DefaultTooltipCreator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements View$OnClickListener {
    public final /* synthetic */ DefaultTooltipCreator j;
    public final /* synthetic */ TooltipManager$b k;

    public b(DefaultTooltipCreator defaultTooltipCreator, TooltipManager$b tooltipManager$b) {
        this.j = defaultTooltipCreator;
        this.k = tooltipManager$b;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.j.tooltipManager.a(this.k);
        this.j.tooltipManager.c(this.k);
    }
}
