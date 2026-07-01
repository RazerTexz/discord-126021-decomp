package com.discord.widgets.friends;

import android.text.Editable;
import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsAddById.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddById$onViewBound$2 extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ WidgetFriendsAddById this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsAddById$onViewBound$2(WidgetFriendsAddById widgetFriendsAddById) {
        super(1);
        this.this$0 = widgetFriendsAddById;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        m.checkNotNullParameter(editable, "editable");
        try {
            boolean z2 = true;
            if (editable.length() == 0) {
                WidgetFriendsAddById.access$setInputEditError(this.this$0, null);
            }
            MaterialButton materialButton = WidgetFriendsAddById.access$getBinding$p(this.this$0).d;
            m.checkNotNullExpressionValue(materialButton, "binding.friendsAddSend");
            if (editable.length() <= 0) {
                z2 = false;
            }
            materialButton.setEnabled(z2);
        } catch (Exception unused) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = a.U("Detached: ");
            sbU.append(this.this$0.isDetached());
            sbU.append(" Visible: ");
            sbU.append(this.this$0.isVisible());
            Logger.e$default(appLog, "Failed to update views via TextWatcher", new Exception(sbU.toString()), null, 4, null);
        }
    }
}
