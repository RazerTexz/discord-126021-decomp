package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.commands.ApplicationCommandOption;
import d0.z.d.o;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel$11 extends o implements Function1<Pair<? extends ApplicationCommandOption, ? extends String>, Unit> {
    public final /* synthetic */ AutocompleteViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutocompleteViewModel$11(AutocompleteViewModel autocompleteViewModel) {
        super(1);
        this.this$0 = autocompleteViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends ApplicationCommandOption, ? extends String> pair) {
        invoke2((Pair<ApplicationCommandOption, String>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<ApplicationCommandOption, String> pair) {
        AutocompleteViewModel.access$getEvents$p(this.this$0).onNext(new Event$RequestAutocompleteData(pair.getFirst()));
    }
}
