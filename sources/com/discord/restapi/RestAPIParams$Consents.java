package com.discord.restapi;

import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$Consents {
    private final List<String> grant;
    private final List<String> revoke;

    public RestAPIParams$Consents() {
        this(null, null, 3, null);
    }

    public RestAPIParams$Consents(List<String> list, List<String> list2) {
        m.checkNotNullParameter(list, "grant");
        m.checkNotNullParameter(list2, "revoke");
        this.grant = list;
        this.revoke = list2;
    }

    public /* synthetic */ RestAPIParams$Consents(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? n.emptyList() : list, (i & 2) != 0 ? n.emptyList() : list2);
    }
}
