package com.discord.widgets.contact_sync;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AddFriendsFailed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddFriendsFailed$Companion {
    private AddFriendsFailed$Companion() {
    }

    public final AddFriendsFailed show(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        AddFriendsFailed addFriendsFailed = new AddFriendsFailed();
        addFriendsFailed.show(fragmentManager, AddFriendsFailed.class.getSimpleName());
        return addFriendsFailed;
    }

    public /* synthetic */ AddFriendsFailed$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
