package com.discord.app;

import android.app.Dialog;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppBottomSheet$c$a extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ AppBottomSheet$c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBottomSheet$c$a(AppBottomSheet$c appBottomSheet$c) {
        super(1);
        this.this$0 = appBottomSheet$c;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Unit unit) {
        BottomSheetBehavior<FrameLayout> behavior;
        Dialog dialog = this.this$0.a;
        if (!(dialog instanceof BottomSheetDialog)) {
            dialog = null;
        }
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        if (bottomSheetDialog != null && (behavior = bottomSheetDialog.getBehavior()) != null) {
            behavior.setState(3);
        }
        return Unit.a;
    }
}
