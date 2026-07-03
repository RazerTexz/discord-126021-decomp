package com.discord.utilities.view.text;

import android.text.Editable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: TextWatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextWatcher$Companion$addBindedTextWatcher$1 extends AbstractC12240o implements Function1<Editable, Unit> {
    public final /* synthetic */ Action1 $onAfterTextChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextWatcher$Companion$addBindedTextWatcher$1(Action1 action1) {
        super(1);
        this.$onAfterTextChanged = action1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        C12238m.checkNotNullParameter(editable, "it");
        this.$onAfterTextChanged.call(String.valueOf(editable));
    }
}
