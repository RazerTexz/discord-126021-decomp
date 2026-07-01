package com.discord.widgets.guilds.profile;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import b.a.y.b0;
import b.a.y.b0$a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$configureAvatar$2 implements View$OnClickListener {
    public final /* synthetic */ List $avatarSheetOptions;
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    public WidgetChangeGuildIdentity$configureAvatar$2(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded, List list) {
        this.this$0 = widgetChangeGuildIdentity;
        this.$viewState = widgetChangeGuildIdentityViewModel$ViewState$Loaded;
        this.$avatarSheetOptions = list;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$viewState.getShouldUpsell()) {
            WidgetChangeGuildIdentity.access$navigateToUpsellModal(this.this$0);
            return;
        }
        b0$a b0_a = b0.k;
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        b0_a.a(childFragmentManager, "", this.$avatarSheetOptions, false, new WidgetChangeGuildIdentity$configureAvatar$2$1(this));
    }
}
