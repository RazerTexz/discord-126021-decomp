package com.discord.widgets.friends;

import androidx.fragment.app.Fragment;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetFriendsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAdd$onViewBound$2 extends o implements Function0<Fragment> {
    public static final WidgetFriendsAdd$onViewBound$2 INSTANCE = new WidgetFriendsAdd$onViewBound$2();

    public WidgetFriendsAdd$onViewBound$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Fragment invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Fragment invoke() {
        return new WidgetFriendsFindNearby();
    }
}
