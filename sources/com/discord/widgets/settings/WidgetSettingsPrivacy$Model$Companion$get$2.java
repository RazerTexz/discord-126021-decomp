package com.discord.widgets.settings;

import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.widgets.settings.WidgetSettingsPrivacy;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function7;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsPrivacy$Model$Companion$get$2 extends FunctionReferenceImpl implements Function7<MeUser, Integer, Boolean, ModelUserSettings.FriendSourceFlags, ConnectedAccount, Experiment, Integer, WidgetSettingsPrivacy.LocalState> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$2 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$2();

    public WidgetSettingsPrivacy$Model$Companion$get$2() {
        super(7, WidgetSettingsPrivacy.LocalState.class, "<init>", "<init>(Lcom/discord/models/user/MeUser;IZLcom/discord/models/domain/ModelUserSettings$FriendSourceFlags;Lcom/discord/api/connectedaccounts/ConnectedAccount;Lcom/discord/models/experiments/domain/Experiment;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function7
    public /* bridge */ /* synthetic */ WidgetSettingsPrivacy.LocalState invoke(MeUser meUser, Integer num, Boolean bool, ModelUserSettings.FriendSourceFlags friendSourceFlags, ConnectedAccount connectedAccount, Experiment experiment, Integer num2) {
        return invoke(meUser, num.intValue(), bool.booleanValue(), friendSourceFlags, connectedAccount, experiment, num2.intValue());
    }

    public final WidgetSettingsPrivacy.LocalState invoke(MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, ConnectedAccount connectedAccount, Experiment experiment, int i2) {
        Intrinsics3.checkNotNullParameter(meUser, "p1");
        return new WidgetSettingsPrivacy.LocalState(meUser, i, z2, friendSourceFlags, connectedAccount, experiment, i2);
    }
}
