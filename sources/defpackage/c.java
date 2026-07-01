package defpackage;

import android.view.View;
import com.discord.views.TernaryCheckBox;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public c(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            TernaryCheckBox ternaryCheckBox = (TernaryCheckBox) this.k;
            TernaryCheckBox.Companion companion = TernaryCheckBox.INSTANCE;
            ternaryCheckBox.setSwitchStatus(1);
        } else if (i == 1) {
            TernaryCheckBox ternaryCheckBox2 = (TernaryCheckBox) this.k;
            TernaryCheckBox.Companion companion2 = TernaryCheckBox.INSTANCE;
            ternaryCheckBox2.setSwitchStatus(-1);
        } else {
            if (i != 2) {
                throw null;
            }
            TernaryCheckBox ternaryCheckBox3 = (TernaryCheckBox) this.k;
            TernaryCheckBox.Companion companion3 = TernaryCheckBox.INSTANCE;
            ternaryCheckBox3.setSwitchStatus(0);
        }
    }
}
