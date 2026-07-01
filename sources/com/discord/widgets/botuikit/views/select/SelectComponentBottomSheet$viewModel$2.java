package com.discord.widgets.botuikit.views.select;

import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheet$viewModel$2 extends o implements Function0<SelectComponentBottomSheetViewModel> {
    public final /* synthetic */ SelectComponentBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectComponentBottomSheet$viewModel$2(SelectComponentBottomSheet selectComponentBottomSheet) {
        super(0);
        this.this$0 = selectComponentBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SelectComponentBottomSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SelectComponentBottomSheetViewModel invoke() {
        Serializable serializable = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable(SelectComponentBottomSheet.EXTRA_COMPONENT_CONTEXT);
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.botuikit.views.select.ComponentContext");
        ComponentContext componentContext = (ComponentContext) serializable;
        int i = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getInt(SelectComponentBottomSheet.EXTRA_COMPONENT_INDEX);
        String string = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString(SelectComponentBottomSheet.EXTRA_CUSTOM_ID, "");
        String string2 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString(SelectComponentBottomSheet.EXTRA_PLACEHOLDER);
        int i2 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getInt(SelectComponentBottomSheet.EXTRA_MIN);
        int i3 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getInt(SelectComponentBottomSheet.EXTRA_MAX);
        Serializable serializable2 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable(SelectComponentBottomSheet.EXTRA_OPTIONS);
        if (!(serializable2 instanceof List)) {
            serializable2 = null;
        }
        List listEmptyList = (List) serializable2;
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        List list = listEmptyList;
        Serializable serializable3 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable(SelectComponentBottomSheet.EXTRA_SELECTED);
        List list2 = (List) (serializable3 instanceof List ? serializable3 : null);
        List listEmptyList2 = list2 != null ? list2 : n.emptyList();
        boolean z2 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getBoolean(SelectComponentBottomSheet.EXTRA_EMOJI_ANIMATIONS_ENABLED);
        m.checkNotNullExpressionValue(string, "customId");
        return new SelectComponentBottomSheetViewModel(componentContext, i, string, string2, list, i2, i3, listEmptyList2, z2);
    }
}
