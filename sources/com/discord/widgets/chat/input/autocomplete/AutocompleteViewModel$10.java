package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.models.commands.ApplicationCommandOption;
import kotlin.Pair;
import rx.functions.Action1;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel$10<T> implements Action1<Pair<? extends ApplicationCommandOption, ? extends String>> {
    public final /* synthetic */ AutocompleteViewModel this$0;

    public AutocompleteViewModel$10(AutocompleteViewModel autocompleteViewModel) {
        this.this$0 = autocompleteViewModel;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Pair<? extends ApplicationCommandOption, ? extends String> pair) {
        call2((Pair<ApplicationCommandOption, String>) pair);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Pair<ApplicationCommandOption, String> pair) {
        this.this$0.getStoreApplicationCommands().setAutocompleteLoading(pair.getFirst().getName(), pair.getSecond());
    }
}
