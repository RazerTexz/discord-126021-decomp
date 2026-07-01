package com.discord.utilities.view.text;

import android.text.Editable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.utilities.view.text.TextWatcher$Companion$addBindedTextWatcher$1, reason: use source file name */
/* JADX INFO: compiled from: TextWatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextWatcher3 extends Lambda implements Function1<Editable, Unit> {
    public final /* synthetic */ Action1 $onAfterTextChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextWatcher3(Action1 action1) {
        super(1);
        this.$onAfterTextChanged = action1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        Intrinsics3.checkNotNullParameter(editable, "it");
        this.$onAfterTextChanged.call(String.valueOf(editable));
    }
}
