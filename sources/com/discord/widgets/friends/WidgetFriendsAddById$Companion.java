package com.discord.widgets.friends;

import d0.g0.s;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;

/* JADX INFO: compiled from: WidgetFriendsAddById.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddById$Companion {
    private WidgetFriendsAddById$Companion() {
    }

    public static final /* synthetic */ WidgetFriendsAddById$Companion$UserNameDiscriminator access$extractUsernameAndDiscriminator(WidgetFriendsAddById$Companion widgetFriendsAddById$Companion, CharSequence charSequence) {
        return widgetFriendsAddById$Companion.extractUsernameAndDiscriminator(charSequence);
    }

    private final WidgetFriendsAddById$Companion$UserNameDiscriminator extractUsernameAndDiscriminator(CharSequence source) {
        List<String> groupValues;
        MatchResult matchResultMatchEntire = WidgetFriendsAddById.access$getPATTERN_USERNAME$cp().matchEntire(source);
        return (matchResultMatchEntire == null || (groupValues = matchResultMatchEntire.getGroupValues()) == null || !(groupValues.isEmpty() ^ true)) ? new WidgetFriendsAddById$Companion$UserNameDiscriminator(source.toString(), null) : new WidgetFriendsAddById$Companion$UserNameDiscriminator(matchResultMatchEntire.getGroupValues().get(1), s.toIntOrNull(matchResultMatchEntire.getGroupValues().get(2)));
    }

    public /* synthetic */ WidgetFriendsAddById$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
