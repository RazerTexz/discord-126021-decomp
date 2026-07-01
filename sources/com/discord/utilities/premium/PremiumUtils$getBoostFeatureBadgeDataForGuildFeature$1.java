package com.discord.utilities.premium;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.a.b.e;
import com.discord.models.guild.Guild;
import com.discord.utilities.analytics.Traits$Location;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PremiumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PremiumUtils$getBoostFeatureBadgeDataForGuildFeature$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ FragmentManager $fragmentManager;
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ Traits$Location $locationTrait;
    public final /* synthetic */ Integer $minimumBoostTier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PremiumUtils$getBoostFeatureBadgeDataForGuildFeature$1(Guild guild, FragmentManager fragmentManager, Integer num, Traits$Location traits$Location, Long l) {
        super(1);
        this.$guild = guild;
        this.$fragmentManager = fragmentManager;
        this.$minimumBoostTier = num;
        this.$locationTrait = traits$Location;
        this.$channelId = l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        Guild guild = this.$guild;
        if (guild != null) {
            e.k.a(this.$fragmentManager, guild.getId(), this.$channelId, this.$minimumBoostTier, this.$locationTrait);
        }
    }
}
