package com.discord.widgets.chat.input.models;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: InputSelectionModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InputSelectionModel {
    private final MentionInputModel inputModel;
    private final IntRange selection;

    private InputSelectionModel(MentionInputModel mentionInputModel, IntRange intRange) {
        this.inputModel = mentionInputModel;
        this.selection = intRange;
    }

    public MentionInputModel getInputModel() {
        return this.inputModel;
    }

    public IntRange getSelection() {
        return this.selection;
    }

    public /* synthetic */ InputSelectionModel(MentionInputModel mentionInputModel, IntRange intRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(mentionInputModel, intRange);
    }
}
