package com.discord.widgets.user.presence;

import com.discord.api.activity.Activity;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ViewHolderUserRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderUserRichPresence$configureUiTimestamp$2 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ Activity $model;
    public final /* synthetic */ ViewHolderUserRichPresence this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderUserRichPresence$configureUiTimestamp$2(ViewHolderUserRichPresence viewHolderUserRichPresence, Activity activity) {
        super(1);
        this.this$0 = viewHolderUserRichPresence;
        this.$model = activity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        this.this$0.setTimeTextViews(this.$model.getTimestamps());
    }
}
