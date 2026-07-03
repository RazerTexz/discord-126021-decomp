package com.discord.utilities.stateful;

import android.text.Editable;
import android.view.View;
import com.discord.app.AppFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.utilities.stateful.StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$1 */
/* JADX INFO: compiled from: StatefulViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6920x66d3a014 extends AbstractC12240o implements Function1<Editable, Unit> {
    public final /* synthetic */ AppFragment $fragment$inlined;
    public final /* synthetic */ View $saveAction$inlined;
    public final /* synthetic */ View $view;
    public final /* synthetic */ StatefulViews this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6920x66d3a014(View view, StatefulViews statefulViews, View view2, AppFragment appFragment) {
        super(1);
        this.$view = view;
        this.this$0 = statefulViews;
        this.$saveAction$inlined = view2;
        this.$fragment$inlined = appFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        C12238m.checkNotNullParameter(editable, "editable");
        this.this$0.put(this.$view.getId(), editable.toString());
        this.this$0.configureSaveActionView(this.$saveAction$inlined);
    }
}
