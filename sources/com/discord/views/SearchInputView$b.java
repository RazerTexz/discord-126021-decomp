package com.discord.views;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: SearchInputView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchInputView$b implements View$OnClickListener {
    public final /* synthetic */ SearchInputView j;
    public final /* synthetic */ String k;

    public SearchInputView$b(SearchInputView searchInputView, boolean z2, String str) {
        this.j = searchInputView;
        this.k = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.k.length() > 0) {
            this.j.getOnClearClicked().invoke();
        }
    }
}
