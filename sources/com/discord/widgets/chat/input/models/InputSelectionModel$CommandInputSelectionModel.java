package com.discord.widgets.chat.input.models;

import b.d.b.a.a;
import com.discord.models.commands.ApplicationCommandOption;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: InputSelectionModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InputSelectionModel$CommandInputSelectionModel extends InputSelectionModel {
    private final MentionInputModel$VerifiedCommandInputModel inputModel;
    private final ApplicationCommandOption selectedCommandOption;
    private final IntRange selection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputSelectionModel$CommandInputSelectionModel(MentionInputModel$VerifiedCommandInputModel mentionInputModel$VerifiedCommandInputModel, IntRange intRange, ApplicationCommandOption applicationCommandOption) {
        super(mentionInputModel$VerifiedCommandInputModel, intRange, null);
        m.checkNotNullParameter(mentionInputModel$VerifiedCommandInputModel, "inputModel");
        m.checkNotNullParameter(intRange, "selection");
        this.inputModel = mentionInputModel$VerifiedCommandInputModel;
        this.selection = intRange;
        this.selectedCommandOption = applicationCommandOption;
    }

    public static /* synthetic */ InputSelectionModel$CommandInputSelectionModel copy$default(InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel, MentionInputModel$VerifiedCommandInputModel mentionInputModel$VerifiedCommandInputModel, IntRange intRange, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
        if ((i & 1) != 0) {
            mentionInputModel$VerifiedCommandInputModel = inputSelectionModel$CommandInputSelectionModel.getInputModel();
        }
        if ((i & 2) != 0) {
            intRange = inputSelectionModel$CommandInputSelectionModel.getSelection();
        }
        if ((i & 4) != 0) {
            applicationCommandOption = inputSelectionModel$CommandInputSelectionModel.selectedCommandOption;
        }
        return inputSelectionModel$CommandInputSelectionModel.copy(mentionInputModel$VerifiedCommandInputModel, intRange, applicationCommandOption);
    }

    public final MentionInputModel$VerifiedCommandInputModel component1() {
        return getInputModel();
    }

    public final IntRange component2() {
        return getSelection();
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ApplicationCommandOption getSelectedCommandOption() {
        return this.selectedCommandOption;
    }

    public final InputSelectionModel$CommandInputSelectionModel copy(MentionInputModel$VerifiedCommandInputModel inputModel, IntRange selection, ApplicationCommandOption selectedCommandOption) {
        m.checkNotNullParameter(inputModel, "inputModel");
        m.checkNotNullParameter(selection, "selection");
        return new InputSelectionModel$CommandInputSelectionModel(inputModel, selection, selectedCommandOption);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputSelectionModel$CommandInputSelectionModel)) {
            return false;
        }
        InputSelectionModel$CommandInputSelectionModel inputSelectionModel$CommandInputSelectionModel = (InputSelectionModel$CommandInputSelectionModel) other;
        return m.areEqual(getInputModel(), inputSelectionModel$CommandInputSelectionModel.getInputModel()) && m.areEqual(getSelection(), inputSelectionModel$CommandInputSelectionModel.getSelection()) && m.areEqual(this.selectedCommandOption, inputSelectionModel$CommandInputSelectionModel.selectedCommandOption);
    }

    @Override // com.discord.widgets.chat.input.models.InputSelectionModel
    public /* bridge */ /* synthetic */ MentionInputModel getInputModel() {
        return getInputModel();
    }

    public final ApplicationCommandOption getSelectedCommandOption() {
        return this.selectedCommandOption;
    }

    @Override // com.discord.widgets.chat.input.models.InputSelectionModel
    public IntRange getSelection() {
        return this.selection;
    }

    public int hashCode() {
        MentionInputModel$VerifiedCommandInputModel inputModel = getInputModel();
        int iHashCode = (inputModel != null ? inputModel.hashCode() : 0) * 31;
        IntRange selection = getSelection();
        int iHashCode2 = (iHashCode + (selection != null ? selection.hashCode() : 0)) * 31;
        ApplicationCommandOption applicationCommandOption = this.selectedCommandOption;
        return iHashCode2 + (applicationCommandOption != null ? applicationCommandOption.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CommandInputSelectionModel(inputModel=");
        sbU.append(getInputModel());
        sbU.append(", selection=");
        sbU.append(getSelection());
        sbU.append(", selectedCommandOption=");
        sbU.append(this.selectedCommandOption);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // com.discord.widgets.chat.input.models.InputSelectionModel
    public MentionInputModel$VerifiedCommandInputModel getInputModel() {
        return this.inputModel;
    }
}
