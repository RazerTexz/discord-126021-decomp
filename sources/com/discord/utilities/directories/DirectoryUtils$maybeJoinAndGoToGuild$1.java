package com.discord.utilities.directories;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DirectoryUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryUtils$maybeJoinAndGoToGuild$1 extends o implements Function1<Guild, Unit> {
    public final /* synthetic */ AppBottomSheet $bottomSheet;
    public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;
    public final /* synthetic */ boolean $shouldToggleRsvp;
    public final /* synthetic */ Function0 $toggleRsvp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryUtils$maybeJoinAndGoToGuild$1(boolean z2, Function0 function0, GuildScheduledEvent guildScheduledEvent, AppBottomSheet appBottomSheet) {
        super(1);
        this.$shouldToggleRsvp = z2;
        this.$toggleRsvp = function0;
        this.$guildScheduledEvent = guildScheduledEvent;
        this.$bottomSheet = appBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        m.checkNotNullParameter(guild, "it");
        if (this.$shouldToggleRsvp) {
            this.$toggleRsvp.invoke();
        }
        StoreStream.Companion.getGuildSelected().set(this.$guildScheduledEvent.getGuildId());
        FragmentManager parentFragmentManager = this.$bottomSheet.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "bottomSheet.parentFragmentManager");
        List<Fragment> fragments = parentFragmentManager.getFragments();
        m.checkNotNullExpressionValue(fragments, "bottomSheet.parentFragmentManager.fragments");
        for (Fragment fragment : fragments) {
            if (fragment instanceof AppBottomSheet) {
                ((AppBottomSheet) fragment).dismiss();
            }
        }
    }
}
