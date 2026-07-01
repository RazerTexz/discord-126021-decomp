package com.discord.widgets.chat.list.sheet;

import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreStream;
import d0.t.u;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel$3 extends o implements Function1<WidgetApplicationCommandBottomSheetViewModel$UserData, Unit> {
    public final /* synthetic */ WidgetApplicationCommandBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheetViewModel$3(WidgetApplicationCommandBottomSheetViewModel widgetApplicationCommandBottomSheetViewModel) {
        super(1);
        this.this$0 = widgetApplicationCommandBottomSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetApplicationCommandBottomSheetViewModel$UserData widgetApplicationCommandBottomSheetViewModel$UserData) {
        invoke2(widgetApplicationCommandBottomSheetViewModel$UserData);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetApplicationCommandBottomSheetViewModel$UserData widgetApplicationCommandBottomSheetViewModel$UserData) {
        if (this.this$0.getGuildId() != null) {
            StoreGatewayConnection.requestGuildMembers$default(StoreStream.Companion.getGatewaySocket(), this.this$0.getGuildId().longValue(), null, u.toList(widgetApplicationCommandBottomSheetViewModel$UserData.getMentionedUserIds()), null, 10, null);
        }
        if (widgetApplicationCommandBottomSheetViewModel$UserData.getUsers().size() != widgetApplicationCommandBottomSheetViewModel$UserData.getMentionedUserIds().size()) {
            StoreStream.Companion.getUsers().fetchUsers(u.toList(widgetApplicationCommandBottomSheetViewModel$UserData.getMentionedUserIds()));
        }
    }
}
