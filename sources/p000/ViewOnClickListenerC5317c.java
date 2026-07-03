package p000;

import android.view.View;
import com.discord.views.TernaryCheckBox;

/* JADX INFO: renamed from: c */
/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC5317c implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f14511j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f14512k;

    public ViewOnClickListenerC5317c(int i, Object obj) {
        this.f14511j = i;
        this.f14512k = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f14511j;
        if (i == 0) {
            TernaryCheckBox ternaryCheckBox = (TernaryCheckBox) this.f14512k;
            TernaryCheckBox.Companion companion = TernaryCheckBox.INSTANCE;
            ternaryCheckBox.setSwitchStatus(1);
        } else if (i == 1) {
            TernaryCheckBox ternaryCheckBox2 = (TernaryCheckBox) this.f14512k;
            TernaryCheckBox.Companion companion2 = TernaryCheckBox.INSTANCE;
            ternaryCheckBox2.setSwitchStatus(-1);
        } else {
            if (i != 2) {
                throw null;
            }
            TernaryCheckBox ternaryCheckBox3 = (TernaryCheckBox) this.f14512k;
            TernaryCheckBox.Companion companion3 = TernaryCheckBox.INSTANCE;
            ternaryCheckBox3.setSwitchStatus(0);
        }
    }
}
