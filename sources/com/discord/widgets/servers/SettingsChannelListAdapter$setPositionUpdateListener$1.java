package com.discord.widgets.servers;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsChannelListAdapter$setPositionUpdateListener$1 extends o implements Function1<Map<Long, ? extends SettingsChannelListAdapter$UpdatedPosition>, Unit> {
    public final /* synthetic */ Action1 $onPositionUpdateListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsChannelListAdapter$setPositionUpdateListener$1(Action1 action1) {
        super(1);
        this.$onPositionUpdateListener = action1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends SettingsChannelListAdapter$UpdatedPosition> map) {
        invoke2((Map<Long, SettingsChannelListAdapter$UpdatedPosition>) map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<Long, SettingsChannelListAdapter$UpdatedPosition> map) {
        m.checkNotNullParameter(map, "map");
        this.$onPositionUpdateListener.call(map);
    }
}
