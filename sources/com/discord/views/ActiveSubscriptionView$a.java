package com.discord.views;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class ActiveSubscriptionView$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public ActiveSubscriptionView$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            Function0 function0 = (Function0) this.k;
            if (function0 != null) {
                return;
            }
            return;
        }
        if (i == 1) {
            Function0 function1 = (Function0) this.k;
            if (function1 != null) {
                return;
            }
            return;
        }
        if (i != 2) {
            throw null;
        }
        Function0 function2 = (Function0) this.k;
        if (function2 != null) {
        }
    }
}
