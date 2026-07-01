package b.a.f;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.chips_view.ChipsView;

/* JADX INFO: compiled from: ChipsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g implements View$OnClickListener {
    public final /* synthetic */ ChipsView j;

    public g(ChipsView chipsView) {
        this.j = chipsView;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.j.mEditText.requestFocus();
        this.j.f(null);
    }
}
