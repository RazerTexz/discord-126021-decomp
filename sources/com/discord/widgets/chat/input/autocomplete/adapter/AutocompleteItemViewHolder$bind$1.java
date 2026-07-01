package com.discord.widgets.chat.input.autocomplete.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;

/* JADX INFO: compiled from: AutocompleteItemViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteItemViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ Autocompletable $autocompletable;
    public final /* synthetic */ AutocompleteItemViewHolder this$0;

    public AutocompleteItemViewHolder$bind$1(AutocompleteItemViewHolder autocompleteItemViewHolder, Autocompletable autocompletable) {
        this.this$0 = autocompleteItemViewHolder;
        this.$autocompletable = autocompletable;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        AutocompleteItemViewHolder.access$getOnItemSelected$p(this.this$0).invoke(this.$autocompletable);
    }
}
