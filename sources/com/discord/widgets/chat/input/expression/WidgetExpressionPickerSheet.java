package com.discord.widgets.chat.input.expression;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.discord.app.AppBottomSheet;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetExpressionPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetExpressionPickerSheet extends AppBottomSheet {
    private Function0<Unit> onCancel;

    public WidgetExpressionPickerSheet() {
        super(false, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnCancel$default(WidgetExpressionPickerSheet widgetExpressionPickerSheet, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOnCancel");
        }
        if ((i & 1) != 0) {
            function0 = null;
        }
        widgetExpressionPickerSheet.setOnCancel(function0);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        Function0<Unit> function0 = this.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
    }

    public final void setOnCancel(Function0<Unit> onCancel) {
        this.onCancel = onCancel;
    }
}
