package com.discord.widgets.chat.input.models;

import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: InputSelectionModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputSelectionModelKt {
    public static final ApplicationCommand getSelectedCommand(InputSelectionModel inputSelectionModel) {
        InputCommandContext inputCommandContext;
        m.checkNotNullParameter(inputSelectionModel, "$this$getSelectedCommand");
        MentionInputModel inputModel = inputSelectionModel.getInputModel();
        if (!(inputModel instanceof MentionInputModel$VerifiedCommandInputModel)) {
            inputModel = null;
        }
        MentionInputModel$VerifiedCommandInputModel mentionInputModel$VerifiedCommandInputModel = (MentionInputModel$VerifiedCommandInputModel) inputModel;
        if (mentionInputModel$VerifiedCommandInputModel == null || (inputCommandContext = mentionInputModel$VerifiedCommandInputModel.getInputCommandContext()) == null) {
            return null;
        }
        return inputCommandContext.getSelectedCommand();
    }

    public static final boolean hasSelectedCommandOptionWithChoices(InputSelectionModel inputSelectionModel) {
        m.checkNotNullParameter(inputSelectionModel, "$this$hasSelectedCommandOptionWithChoices");
        if (inputSelectionModel instanceof InputSelectionModel$CommandInputSelectionModel) {
            InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel;
            ApplicationCommandOption selectedCommandOption = inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption();
            List<CommandChoice> choices = selectedCommandOption != null ? selectedCommandOption.getChoices() : null;
            if (!(choices == null || choices.isEmpty())) {
                return true;
            }
            ApplicationCommandOption selectedCommandOption2 = inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption();
            if ((selectedCommandOption2 != null ? selectedCommandOption2.getType() : null) == ApplicationCommandType.BOOLEAN) {
                return true;
            }
        }
        return false;
    }

    public static final boolean hasSelectedFreeformInput(InputSelectionModel inputSelectionModel) {
        m.checkNotNullParameter(inputSelectionModel, "$this$hasSelectedFreeformInput");
        if (!(inputSelectionModel instanceof InputSelectionModel$CommandInputSelectionModel)) {
            if (inputSelectionModel instanceof InputSelectionModel$MessageInputSelectionModel) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) inputSelectionModel;
        if (inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption() == null) {
            return true;
        }
        List<CommandChoice> choices = inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption().getChoices();
        boolean z2 = choices != null && (choices.isEmpty() ^ true);
        ApplicationCommandType type = inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption().getType();
        return (inputSelectionModel$CommandInputSelectionModel.getSelectedCommandOption().getAutocomplete() || z2 || (type != ApplicationCommandType.INTEGER && type != ApplicationCommandType.STRING)) ? false : true;
    }
}
