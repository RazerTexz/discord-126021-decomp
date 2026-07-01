package com.discord.widgets.botuikit;

import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.discord.stores.StoreApplicationInteractions$SentInteraction;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent$onViewBoundOrOnResume$1 extends o implements Function1<Map<String, ? extends StoreApplicationInteractions$SentInteraction>, Unit> {
    public final /* synthetic */ ModalComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalComponent$onViewBoundOrOnResume$1(ModalComponent modalComponent) {
        super(1);
        this.this$0 = modalComponent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends StoreApplicationInteractions$SentInteraction> map) {
        invoke2((Map<String, StoreApplicationInteractions$SentInteraction>) map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, StoreApplicationInteractions$SentInteraction> map) {
        StoreApplicationInteractions$SentInteraction storeApplicationInteractions$SentInteraction;
        FragmentActivity activity;
        m.checkNotNullParameter(map, "sentInteractions");
        String strAccess$getSentNonce$p = ModalComponent.access$getSentNonce$p(this.this$0);
        if (strAccess$getSentNonce$p == null || (storeApplicationInteractions$SentInteraction = map.get(strAccess$getSentNonce$p)) == null) {
            return;
        }
        int iOrdinal = storeApplicationInteractions$SentInteraction.getState().ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2 && (activity = this.this$0.getActivity()) != null) {
                activity.finish();
                return;
            }
            return;
        }
        ModalComponent.access$setSentNonce$p(this.this$0, null);
        LinearLayout linearLayout = ModalComponent.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(linearLayout, "binding.error");
        linearLayout.setVisibility(0);
        MaterialButton materialButton = ModalComponent.access$getBinding$p(this.this$0).f;
        m.checkNotNullExpressionValue(materialButton, "binding.submit");
        materialButton.setEnabled(true);
    }
}
