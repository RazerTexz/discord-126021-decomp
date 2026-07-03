package p007b.p008a.p058v;

import android.view.View;
import com.discord.tooltips.DefaultTooltipCreator;
import com.discord.tooltips.TooltipManager;

/* JADX INFO: renamed from: b.a.v.b */
/* JADX INFO: compiled from: DefaultTooltipCreator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC1312b implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ DefaultTooltipCreator f2000j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ TooltipManager.C6648b f2001k;

    public ViewOnClickListenerC1312b(DefaultTooltipCreator defaultTooltipCreator, TooltipManager.C6648b c6648b) {
        this.f2000j = defaultTooltipCreator;
        this.f2001k = c6648b;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f2000j.tooltipManager.m8512a(this.f2001k);
        this.f2000j.tooltipManager.m8514c(this.f2001k);
    }
}
