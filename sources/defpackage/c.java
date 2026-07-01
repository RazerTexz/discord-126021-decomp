package defpackage;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.TernaryCheckBox;
import com.discord.views.TernaryCheckBox$a;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class c implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public c(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            TernaryCheckBox ternaryCheckBox = (TernaryCheckBox) this.k;
            TernaryCheckBox$a ternaryCheckBox$a = TernaryCheckBox.j;
            TernaryCheckBox.a(ternaryCheckBox, 1);
        } else if (i == 1) {
            TernaryCheckBox ternaryCheckBox2 = (TernaryCheckBox) this.k;
            TernaryCheckBox$a ternaryCheckBox$a2 = TernaryCheckBox.j;
            TernaryCheckBox.a(ternaryCheckBox2, -1);
        } else {
            if (i != 2) {
                throw null;
            }
            TernaryCheckBox ternaryCheckBox3 = (TernaryCheckBox) this.k;
            TernaryCheckBox$a ternaryCheckBox$a3 = TernaryCheckBox.j;
            TernaryCheckBox.a(ternaryCheckBox3, 0);
        }
    }
}
