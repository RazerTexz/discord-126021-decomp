package com.discord.widgets.stage.sheet;

import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet$onViewCreated$2 extends o implements Function1<StoreVoiceParticipants$VoiceUser, Unit> {
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheet$onViewCreated$2(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        super(1);
        this.this$0 = widgetStageRaisedHandsBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        invoke2(storeVoiceParticipants$VoiceUser);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "voiceUser");
        WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
        long id2 = storeVoiceParticipants$VoiceUser.getUser().getId();
        Long lValueOf = Long.valueOf(WidgetStageRaisedHandsBottomSheet.access$getChannelId$p(this.this$0));
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, id2, lValueOf, parentFragmentManager, null, null, null, null, 120, null);
    }
}
