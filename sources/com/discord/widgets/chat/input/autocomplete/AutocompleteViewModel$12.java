package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.input.models.AutocompleteInputSelectionModel;
import com.discord.widgets.chat.input.models.MentionToken;
import j0.k.b;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel$12<T, R> implements b<AutocompleteInputSelectionModel, String> {
    public static final AutocompleteViewModel$12 INSTANCE = new AutocompleteViewModel$12();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ String call(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
        return call2(autocompleteInputSelectionModel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
        MentionToken autocompleteToken = autocompleteInputSelectionModel.getAutocompleteToken();
        if (autocompleteToken != null) {
            return autocompleteToken.getToken();
        }
        return null;
    }
}
