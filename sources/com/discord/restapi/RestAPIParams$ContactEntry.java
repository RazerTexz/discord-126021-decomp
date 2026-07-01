package com.discord.restapi;

import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$ContactEntry {
    private final String friend_id;
    private final Map<String, String> metadata;
    private final String mutual_id_hash;

    public RestAPIParams$ContactEntry(String str, String str2, Map<String, String> map) {
        m.checkNotNullParameter(str, "mutual_id_hash");
        m.checkNotNullParameter(str2, "friend_id");
        m.checkNotNullParameter(map, "metadata");
        this.mutual_id_hash = str;
        this.friend_id = str2;
        this.metadata = map;
    }
}
