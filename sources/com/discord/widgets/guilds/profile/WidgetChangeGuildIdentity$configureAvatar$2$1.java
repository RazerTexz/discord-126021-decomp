package com.discord.widgets.guilds.profile;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$configureAvatar$2$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetChangeGuildIdentity$configureAvatar$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentity$configureAvatar$2$1(WidgetChangeGuildIdentity$configureAvatar$2 widgetChangeGuildIdentity$configureAvatar$2) {
        super(1);
        this.this$0 = widgetChangeGuildIdentity$configureAvatar$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        if (i != 0) {
            if (i != 1) {
                return;
            }
            WidgetChangeGuildIdentity.access$getViewModel$p(this.this$0.this$0).updateAvatar(null);
        } else {
            WidgetChangeGuildIdentity widgetChangeGuildIdentity = this.this$0.this$0;
            WidgetChangeGuildIdentity.access$setImageSelectedResult$p(widgetChangeGuildIdentity, WidgetChangeGuildIdentity.access$getAvatarSelectedResult$p(widgetChangeGuildIdentity));
            this.this$0.this$0.openMediaChooser();
        }
    }
}
