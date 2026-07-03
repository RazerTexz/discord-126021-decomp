package com.discord.widgets.chat.input.models;

import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.input.models.InputSelectionModel;
import com.discord.widgets.chat.input.models.MentionInputModel;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InputSelectionModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputSelectionModelKt {
    public static final ApplicationCommand getSelectedCommand(InputSelectionModel inputSelectionModel) {
        InputCommandContext inputCommandContext;
        C12238m.checkNotNullParameter(inputSelectionModel, "$this$getSelectedCommand");
        MentionInputModel inputModel = inputSelectionModel.getInputModel();
        if (!(inputModel instanceof MentionInputModel.VerifiedCommandInputModel)) {
            inputModel = null;
        }
        MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel = (MentionInputModel.VerifiedCommandInputModel) inputModel;
        if (verifiedCommandInputModel == null || (inputCommandContext = verifiedCommandInputModel.getInputCommandContext()) == null) {
            return null;
        }
        return inputCommandContext.getSelectedCommand();
    }

    public static final boolean hasSelectedCommandOptionWithChoices(InputSelectionModel inputSelectionModel) {
        C12238m.checkNotNullParameter(inputSelectionModel, "$this$hasSelectedCommandOptionWithChoices");
        if (inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel) {
            InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
            ApplicationCommandOption selectedCommandOption = commandInputSelectionModel.getSelectedCommandOption();
            List<CommandChoice> choices = selectedCommandOption != null ? selectedCommandOption.getChoices() : null;
            if (!(choices == null || choices.isEmpty())) {
                return true;
            }
            ApplicationCommandOption selectedCommandOption2 = commandInputSelectionModel.getSelectedCommandOption();
            if ((selectedCommandOption2 != null ? selectedCommandOption2.getType() : null) == ApplicationCommandType.BOOLEAN) {
                return true;
            }
        }
        return false;
    }

    public static final boolean hasSelectedFreeformInput(InputSelectionModel inputSelectionModel) {
        C12238m.checkNotNullParameter(inputSelectionModel, "$this$hasSelectedFreeformInput");
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            if (inputSelectionModel instanceof InputSelectionModel.MessageInputSelectionModel) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        if (commandInputSelectionModel.getSelectedCommandOption() == null) {
            return true;
        }
        List<CommandChoice> choices = commandInputSelectionModel.getSelectedCommandOption().getChoices();
        boolean z2 = choices != null && (choices.isEmpty() ^ true);
        ApplicationCommandType type = commandInputSelectionModel.getSelectedCommandOption().getType();
        return (commandInputSelectionModel.getSelectedCommandOption().getAutocomplete() || z2 || (type != ApplicationCommandType.INTEGER && type != ApplicationCommandType.STRING)) ? false : true;
    }
}
