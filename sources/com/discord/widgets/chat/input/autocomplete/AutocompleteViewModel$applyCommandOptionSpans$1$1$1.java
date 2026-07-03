package com.discord.widgets.chat.input.autocomplete;

import com.discord.widgets.chat.input.autocomplete.commands.AutocompleteCommandUtils;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel$applyCommandOptionSpans$1$1$1 extends AbstractC12240o implements Function1<String, String> {
    public static final AutocompleteViewModel$applyCommandOptionSpans$1$1$1 INSTANCE = new AutocompleteViewModel$applyCommandOptionSpans$1$1$1();

    public AutocompleteViewModel$applyCommandOptionSpans$1$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(String str) {
        return AutocompleteCommandUtils.INSTANCE.transformParameterSpannableString(str);
    }
}
