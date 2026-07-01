package com.discord.widgets.botuikit.views.select;

import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheet5 extends Lambda implements Function0<SelectComponentBottomSheetViewModel> {
    public final /* synthetic */ SelectComponentBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectComponentBottomSheet5(SelectComponentBottomSheet selectComponentBottomSheet) {
        super(0);
        this.this$0 = selectComponentBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SelectComponentBottomSheetViewModel invoke() {
        Serializable serializable = this.this$0.getArgumentsOrDefault().getSerializable(SelectComponentBottomSheet.EXTRA_COMPONENT_CONTEXT);
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.botuikit.views.select.ComponentContext");
        SelectComponentBottomSheet2 selectComponentBottomSheet2 = (SelectComponentBottomSheet2) serializable;
        int i = this.this$0.getArgumentsOrDefault().getInt(SelectComponentBottomSheet.EXTRA_COMPONENT_INDEX);
        String string = this.this$0.getArgumentsOrDefault().getString(SelectComponentBottomSheet.EXTRA_CUSTOM_ID, "");
        String string2 = this.this$0.getArgumentsOrDefault().getString(SelectComponentBottomSheet.EXTRA_PLACEHOLDER);
        int i2 = this.this$0.getArgumentsOrDefault().getInt(SelectComponentBottomSheet.EXTRA_MIN);
        int i3 = this.this$0.getArgumentsOrDefault().getInt(SelectComponentBottomSheet.EXTRA_MAX);
        Serializable serializable2 = this.this$0.getArgumentsOrDefault().getSerializable(SelectComponentBottomSheet.EXTRA_OPTIONS);
        if (!(serializable2 instanceof List)) {
            serializable2 = null;
        }
        List listEmptyList = (List) serializable2;
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        List list = listEmptyList;
        Serializable serializable3 = this.this$0.getArgumentsOrDefault().getSerializable(SelectComponentBottomSheet.EXTRA_SELECTED);
        List list2 = (List) (serializable3 instanceof List ? serializable3 : null);
        List listEmptyList2 = list2 != null ? list2 : Collections2.emptyList();
        boolean z2 = this.this$0.getArgumentsOrDefault().getBoolean(SelectComponentBottomSheet.EXTRA_EMOJI_ANIMATIONS_ENABLED);
        Intrinsics3.checkNotNullExpressionValue(string, "customId");
        return new SelectComponentBottomSheetViewModel(selectComponentBottomSheet2, i, string, string2, list, i2, i3, listEmptyList2, z2);
    }
}
