package b.a.f;

import android.view.View;
import android.view.View$OnFocusChangeListener;
import com.discord.chips_view.ChipsView;

/* JADX INFO: compiled from: ChipsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f implements View$OnFocusChangeListener {
    public final /* synthetic */ ChipsView j;

    public f(ChipsView chipsView) {
        this.j = chipsView;
    }

    @Override // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            ChipsView chipsView = this.j;
            int i = ChipsView.j;
            chipsView.f(null);
        }
    }
}
