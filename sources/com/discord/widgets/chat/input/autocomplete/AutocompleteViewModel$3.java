package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.input.models.InputSelectionModel;
import com.discord.widgets.chat.input.models.MentionInputModel;
import d0.z.d.m;
import kotlin.ranges.IntRange;
import rx.functions.Func2;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel$3<T1, T2, R> implements Func2<AutocompleteViewModel$SelectionState, MentionInputModel, InputSelectionModel> {
    public final /* synthetic */ AutocompleteViewModel this$0;

    public AutocompleteViewModel$3(AutocompleteViewModel autocompleteViewModel) {
        this.this$0 = autocompleteViewModel;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ InputSelectionModel call(AutocompleteViewModel$SelectionState autocompleteViewModel$SelectionState, MentionInputModel mentionInputModel) {
        return call2(autocompleteViewModel$SelectionState, mentionInputModel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final InputSelectionModel call2(AutocompleteViewModel$SelectionState autocompleteViewModel$SelectionState, MentionInputModel mentionInputModel) {
        if (!m.areEqual(autocompleteViewModel$SelectionState.getInput(), mentionInputModel.getInput().toString())) {
            return null;
        }
        AutocompleteViewModel autocompleteViewModel = this.this$0;
        IntRange selection = autocompleteViewModel$SelectionState.getSelection();
        m.checkNotNullExpressionValue(mentionInputModel, "inputModel");
        return AutocompleteViewModel.access$handleSelectionWithInputModel(autocompleteViewModel, selection, mentionInputModel);
    }
}
