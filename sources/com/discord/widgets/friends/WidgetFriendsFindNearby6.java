package com.discord.widgets.friends;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby6 extends Lambda implements Function0<WidgetFriendsFindNearbyViewModel> {
    public static final WidgetFriendsFindNearby6 INSTANCE = new WidgetFriendsFindNearby6();

    public WidgetFriendsFindNearby6() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetFriendsFindNearbyViewModel invoke() {
        return new WidgetFriendsFindNearbyViewModel();
    }
}
