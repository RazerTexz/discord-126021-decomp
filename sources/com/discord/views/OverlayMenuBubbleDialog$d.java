package com.discord.views;

import android.widget.TextView;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog$d extends o implements Function1<Pair<? extends List<? extends StoreVoiceParticipants$VoiceUser>, ? extends Integer>, Unit> {
    public final /* synthetic */ OverlayMenuBubbleDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuBubbleDialog$d(OverlayMenuBubbleDialog overlayMenuBubbleDialog) {
        super(1);
        this.this$0 = overlayMenuBubbleDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Pair<? extends List<? extends StoreVoiceParticipants$VoiceUser>, ? extends Integer> pair) {
        String string;
        Pair<? extends List<? extends StoreVoiceParticipants$VoiceUser>, ? extends Integer> pair2 = pair;
        List<? extends StoreVoiceParticipants$VoiceUser> listComponent1 = pair2.component1();
        int iIntValue = pair2.component2().intValue();
        OverlayMenuBubbleDialog overlayMenuBubbleDialog = this.this$0;
        overlayMenuBubbleDialog.adapter.setData(listComponent1);
        if (iIntValue == 0) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('+');
            sb.append(iIntValue);
            string = sb.toString();
        }
        TextView textView = overlayMenuBubbleDialog.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.overlayMembersOverflowTv");
        ViewExtensions.setTextAndVisibilityBy(textView, string);
        return Unit.a;
    }
}
