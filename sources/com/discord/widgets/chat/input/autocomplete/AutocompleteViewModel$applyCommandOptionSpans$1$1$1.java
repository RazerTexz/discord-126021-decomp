package com.discord.widgets.chat.input.autocomplete;

import com.discord.widgets.chat.input.autocomplete.commands.AutocompleteCommandUtils;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel$applyCommandOptionSpans$1$1$1 extends o implements Function1<String, String> {
    public static final AutocompleteViewModel$applyCommandOptionSpans$1$1$1 INSTANCE = new AutocompleteViewModel$applyCommandOptionSpans$1$1$1();

    public AutocompleteViewModel$applyCommandOptionSpans$1$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String str) {
        return invoke2(str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str) {
        return AutocompleteCommandUtils.INSTANCE.transformParameterSpannableString(str);
    }
}
