package com.discord.widgets.chat.input.models;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: InputSelectionModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InputSelectionModel$MessageInputSelectionModel extends InputSelectionModel {
    private final MentionInputModel inputModel;
    private final IntRange selection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputSelectionModel$MessageInputSelectionModel(MentionInputModel mentionInputModel, IntRange intRange) {
        super(mentionInputModel, intRange, null);
        m.checkNotNullParameter(mentionInputModel, "inputModel");
        m.checkNotNullParameter(intRange, "selection");
        this.inputModel = mentionInputModel;
        this.selection = intRange;
    }

    public static /* synthetic */ InputSelectionModel$MessageInputSelectionModel copy$default(InputSelectionModel$MessageInputSelectionModel inputSelectionModel$MessageInputSelectionModel, MentionInputModel mentionInputModel, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            mentionInputModel = inputSelectionModel$MessageInputSelectionModel.getInputModel();
        }
        if ((i & 2) != 0) {
            intRange = inputSelectionModel$MessageInputSelectionModel.getSelection();
        }
        return inputSelectionModel$MessageInputSelectionModel.copy(mentionInputModel, intRange);
    }

    public final MentionInputModel component1() {
        return getInputModel();
    }

    public final IntRange component2() {
        return getSelection();
    }

    public final InputSelectionModel$MessageInputSelectionModel copy(MentionInputModel inputModel, IntRange selection) {
        m.checkNotNullParameter(inputModel, "inputModel");
        m.checkNotNullParameter(selection, "selection");
        return new InputSelectionModel$MessageInputSelectionModel(inputModel, selection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputSelectionModel$MessageInputSelectionModel)) {
            return false;
        }
        InputSelectionModel$MessageInputSelectionModel inputSelectionModel$MessageInputSelectionModel = (InputSelectionModel$MessageInputSelectionModel) other;
        return m.areEqual(getInputModel(), inputSelectionModel$MessageInputSelectionModel.getInputModel()) && m.areEqual(getSelection(), inputSelectionModel$MessageInputSelectionModel.getSelection());
    }

    @Override // com.discord.widgets.chat.input.models.InputSelectionModel
    public MentionInputModel getInputModel() {
        return this.inputModel;
    }

    @Override // com.discord.widgets.chat.input.models.InputSelectionModel
    public IntRange getSelection() {
        return this.selection;
    }

    public int hashCode() {
        MentionInputModel inputModel = getInputModel();
        int iHashCode = (inputModel != null ? inputModel.hashCode() : 0) * 31;
        IntRange selection = getSelection();
        return iHashCode + (selection != null ? selection.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("MessageInputSelectionModel(inputModel=");
        sbU.append(getInputModel());
        sbU.append(", selection=");
        sbU.append(getSelection());
        sbU.append(")");
        return sbU.toString();
    }
}
