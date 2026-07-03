package com.discord.utilities.stateful;

import android.view.View;
import com.discord.app.AppFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.utilities.stateful.StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2 */
/* JADX INFO: compiled from: StatefulViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6921x66d3a015 extends AbstractC12240o implements Function1<Boolean, Unit> {
    public final /* synthetic */ AppFragment $fragment$inlined;
    public final /* synthetic */ View $saveAction$inlined;
    public final /* synthetic */ View $view;
    public final /* synthetic */ StatefulViews this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6921x66d3a015(View view, StatefulViews statefulViews, View view2, AppFragment appFragment) {
        super(1);
        this.$view = view;
        this.this$0 = statefulViews;
        this.$saveAction$inlined = view2;
        this.$fragment$inlined = appFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.f27425a;
    }

    public final void invoke(boolean z2) {
        this.this$0.put(this.$view.getId(), Boolean.valueOf(z2));
        this.this$0.configureSaveActionView(this.$saveAction$inlined);
    }
}
