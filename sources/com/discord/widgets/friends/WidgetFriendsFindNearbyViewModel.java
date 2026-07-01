package com.discord.widgets.friends;

import b.a.d.AppViewModel;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetFriendsFindNearbyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearbyViewModel extends AppViewModel<Unit> {
    private Integer discriminator;
    private String username;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetFriendsFindNearbyViewModel() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        super(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    public final Integer getDiscriminator() {
        return this.discriminator;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setDiscriminator(Integer num) {
        this.discriminator = num;
    }

    public final void setUsername(String str) {
        this.username = str;
    }
}
