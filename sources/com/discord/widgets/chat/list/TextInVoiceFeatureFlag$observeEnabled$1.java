package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import rx.functions.Func2;

/* JADX INFO: compiled from: TextInVoiceFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextInVoiceFeatureFlag$observeEnabled$1<T1, T2, R> implements Func2<Experiment, Guild, Boolean> {
    public final /* synthetic */ TextInVoiceFeatureFlag this$0;

    public TextInVoiceFeatureFlag$observeEnabled$1(TextInVoiceFeatureFlag textInVoiceFeatureFlag) {
        this.this$0 = textInVoiceFeatureFlag;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Experiment experiment, Guild guild) {
        return call2(experiment, guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Experiment experiment, Guild guild) {
        return Boolean.valueOf(TextInVoiceFeatureFlag.access$isEnabled(this.this$0, experiment, guild));
    }
}
