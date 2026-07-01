package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.input.models.AutocompleteInputSelectionModel;
import com.discord.widgets.chat.input.models.CommandOptionValue;
import com.discord.widgets.chat.input.models.InputSelectionModel;
import com.discord.widgets.chat.input.models.InputSelectionModel$CommandInputSelectionModel;
import j0.k.b;
import kotlin.Pair;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel$9<T, R> implements b<AutocompleteInputSelectionModel, Pair<? extends ApplicationCommandOption, ? extends String>> {
    public static final AutocompleteViewModel$9 INSTANCE = new AutocompleteViewModel$9();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Pair<? extends ApplicationCommandOption, ? extends String> call(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
        return call2(autocompleteInputSelectionModel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<ApplicationCommandOption, String> call2(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
        ApplicationCommandOption selectedCommandOption;
        InputSelectionModel inputSelectionModel = autocompleteInputSelectionModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel$CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel;
        if (inputSelectionModel$CommandInputSelectionModel == null || (selectedCommandOption = inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption()) == null || !selectedCommandOption.getAutocomplete()) {
            return null;
        }
        CommandOptionValue commandOptionValue = inputSelectionModel$CommandInputSelectionModel.getInputModel().getInputCommandOptionValues().get(selectedCommandOption);
        return new Pair<>(selectedCommandOption, String.valueOf(commandOptionValue != null ? commandOptionValue.getValue() : null));
    }
}
