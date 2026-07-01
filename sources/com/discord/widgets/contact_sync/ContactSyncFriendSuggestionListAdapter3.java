package com.discord.widgets.contact_sync;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncFriendSuggestionListAdapter$onClickFriendSuggestion$1, reason: use source file name */
/* JADX INFO: compiled from: ContactSyncFriendSuggestionListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncFriendSuggestionListAdapter3 extends Lambda implements Function2<Long, Boolean, Unit> {
    public static final ContactSyncFriendSuggestionListAdapter3 INSTANCE = new ContactSyncFriendSuggestionListAdapter3();

    public ContactSyncFriendSuggestionListAdapter3() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
        invoke(l.longValue(), bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(long j, boolean z2) {
    }
}
