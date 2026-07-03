package p007b.p008a.p021f;

import android.view.View;
import com.discord.chips_view.ChipsView;

/* JADX INFO: renamed from: b.a.f.f */
/* JADX INFO: compiled from: ChipsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnFocusChangeListenerC0900f implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ChipsView f621j;

    public ViewOnFocusChangeListenerC0900f(ChipsView chipsView) {
        this.f621j = chipsView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            ChipsView chipsView = this.f621j;
            int i = ChipsView.f14975j;
            chipsView.m8380f(null);
        }
    }
}
